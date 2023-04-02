package com.spring.entregaFinal.carrito.repositories;

import java.util.List;
import java.util.Optional;

import com.spring.entregaFinal.carrito.Entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String userName);
    
    @Query(value = "SELECT c FROM User c WHERE c.userName LIKE ?1%")
    List<User>findPalabraClave(String palabra);

    
}
