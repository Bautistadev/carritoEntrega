package com.spring.entregaFinal.carrito.security.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.spring.entregaFinal.carrito.Entity.*;
import com.spring.entregaFinal.carrito.enums.*;
import com.spring.entregaFinal.carrito.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Optional<Role> getByRoleName(RoleList roleName){
        return roleRepository.findByRoleName(roleName);
    }
    public List<Role>getAllRoles(){
    	return roleRepository.findAll();
    }
    
}
