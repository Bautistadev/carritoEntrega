package com.spring.entregaFinal.carrito.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entregaFinal.carrito.Entity.Categoria;
import com.spring.entregaFinal.carrito.Entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	

	
}
