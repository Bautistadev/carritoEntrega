package com.spring.entregaFinal.carrito.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.entregaFinal.carrito.Entity.Categoria;
import com.spring.entregaFinal.carrito.Entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	@Query(value="SELECT c FROM Producto c WHERE c.nombre like ?1% ")
	public List<Producto> getByPalabraClave(String pClave);
	
	@Query(value="SELECT c FROM Producto c WHERE c.nombre = ?1 ")
	public Producto getByNombre(String pClave);
	
}
