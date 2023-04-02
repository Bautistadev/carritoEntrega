package com.spring.entregaFinal.carrito.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.entregaFinal.carrito.Entity.*;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{
	@Query(value = "SELECT c FROM Marca c where c.nombre = ?1")
	Marca findByNombre(String nombre);
	
	@Query(value = "SELECT c FROM Marca c where c.nombre like ?1%")
	List<Marca> findByWordName(String word);
	
	
	
	
}
