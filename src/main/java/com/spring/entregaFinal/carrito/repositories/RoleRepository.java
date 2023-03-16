package com.spring.entregaFinal.carrito.repositories;

import java.util.Optional;

import com.spring.entregaFinal.carrito.Entity.*;
import com.spring.entregaFinal.carrito.enums.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Integer> {
    Optional<Role> findByRoleName(RoleList roleName);
    
}
