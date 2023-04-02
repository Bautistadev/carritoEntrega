package com.spring.entregaFinal.carrito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entregaFinal.carrito.Entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{
	@Query(value = "SELECT * FROM ventas WHERE user_id = ?1",nativeQuery = true)
	public List<Venta> getVentaUser(Long id);
}
