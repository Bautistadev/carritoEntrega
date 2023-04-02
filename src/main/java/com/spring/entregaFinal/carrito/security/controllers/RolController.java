package com.spring.entregaFinal.carrito.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entregaFinal.carrito.Entity.Role;
import com.spring.entregaFinal.carrito.security.services.RoleService;


@RestController
@RequestMapping("/rol")
public class RolController {
	
	@Autowired()
	private RoleService roleService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("allRoles")
	public List<Role> getAllRoles(){
		return roleService.getAllRoles();
	}
    
}
