package com.shop.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.major.model.Role;
//import com.nimbusds.oauth2.sdk.Role;     //perfect example of mistake

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
