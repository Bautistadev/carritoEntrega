package com.spring.entregaFinal.carrito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entregaFinal.carrito.Entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
	
	@Query(value = "SELECT c.id, c.nombre FROM Categoria c")
	public List<Categoria> getAllCategoria();
	
   
	
}
