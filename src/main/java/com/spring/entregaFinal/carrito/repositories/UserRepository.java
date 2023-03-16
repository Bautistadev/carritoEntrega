package com.spring.entregaFinal.carrito.repositories;

import java.util.Optional;

import com.spring.entregaFinal.carrito.Entity.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String userName);
    
}
