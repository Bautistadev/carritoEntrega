package com.spring.entregaFinal.carrito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entregaFinal.carrito.Entity.Categoria;
import com.spring.entregaFinal.carrito.Entity.Marca;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
	
	
	@Query(value="SELECT * FROM categorias WHERE padre_id = ?1", nativeQuery = true)
	public List<Categoria> ListChild(Long id);
   
	
	@Query(value = "SELECT c FROM Categoria c where c.nombre = ?1")
	public Categoria findByNombre(String nombre);
	
	@Query(value = "SELECT c FROM Categoria c where c.nombre like ?1%")
	public List<Categoria> findByWordName(String word);
	
}
