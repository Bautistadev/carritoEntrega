package com.spring.entregaFinal.carrito.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entregaFinal.carrito.Entity.Detalle;

@Repository
public interface DetalleRespository extends JpaRepository<Detalle, Long> {
	
	/*@Query(value =("delete from Carrito.detalles where venta_id = ?1"), nativeQuery = true)
	public Optional<Detalle> removeDetalle(Long id);*/
}
