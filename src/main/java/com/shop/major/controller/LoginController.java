package com.shop.major.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.major.global.GlobalData;
import com.shop.major.model.Role;
import com.shop.major.model.User;
import com.shop.major.repository.RoleRepository;
import com.shop.major.repository.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository uRepository;
	
	@Autowired
	RoleRepository rRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@GetMapping("/login")
	public String login() {
		
		GlobalData.cart.clear();
		return "login";
	}
	
	@GetMapping("/register")
	public String registerGet() {
		return "register";
	}
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException{
		
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		
		List<Role> roles = new ArrayList<>();
		roles.add(rRepository.findById(2).get());
		
		user.setRoles(roles);
		uRepository.save(user);
		
		request.login(user.getEmail(), password);
		
		return "redirect:/";
		
	}
	

}






