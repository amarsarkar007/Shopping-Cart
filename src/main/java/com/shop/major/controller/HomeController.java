package com.shop.major.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shop.major.global.GlobalData;
import com.shop.major.service.CategoryService;
import com.shop.major.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService cService;
	@Autowired
	ProductService pService;
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		
		model.addAttribute("cartCount", GlobalData.cart.size());
		
		return "index";
	}
	@GetMapping("/shop")
	public String shop(Model model) {
		
		model.addAttribute("categories",cService.getAllCategory());
		model.addAttribute("products",pService.getAllProducts());
		
		model.addAttribute("cartCount", GlobalData.cart.size());
		
		return "shop";
		
	}
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id) {
		
		model.addAttribute("categories",cService.getAllCategory());
		model.addAttribute("products",pService.getAllProductsByCategoryId(id));
		
		model.addAttribute("cartCount", GlobalData.cart.size());
		
		return "shop";
		
	}
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model, @PathVariable int id) {
		
		model.addAttribute("product", pService.getProductById(id).get()); // returns optional
		
		model.addAttribute("cartCount", GlobalData.cart.size());
		
		return "viewProduct";
		
	}
	
	

}










