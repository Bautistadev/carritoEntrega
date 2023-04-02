package com.spring.entregaFinal.carrito.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entregaFinal.carrito.DTO.DetalleDTO;
import com.spring.entregaFinal.carrito.DTO.VentaDTO;
import com.spring.entregaFinal.carrito.Entity.Detalle;
import com.spring.entregaFinal.carrito.Entity.Venta;
import com.spring.entregaFinal.carrito.repositories.DetalleRespository;
import com.spring.entregaFinal.carrito.repositories.VentaRepository;

@Service
public class VentaService {
	
	private VentaRepository ventaRepository;
	private DetalleRespository detalleRespository;
	
	@Autowired
	public VentaService(VentaRepository ventaRepository, DetalleRespository detalleRespository) {
		this.ventaRepository = ventaRepository;
		this.detalleRespository = detalleRespository;
	}
	
	
	public Long altaVenta(VentaDTO ventaDTO) {
		
		Venta ven = new Venta();	
		ven.setFecha(LocalDate.now());
		ven.setUser(ventaDTO.getUser());	
		Long id = ventaRepository.save(ven).getId();
		return id;
	}
	
	public List<Venta>getAllVentas(){
		return this.ventaRepository.findAll();
	}
	
	public List<Venta>getVentaUser(Long id){
		return ventaRepository.getVentaUser(id);
	}
	
	public Optional<Venta> addDetalle(DetalleDTO detalleDTO) {
		
		Detalle detalle = new Detalle();
		detalle.setVenta(detalleDTO.getVenta());
		detalle.setCantidad(detalleDTO.getCantidad());
		detalle.setProducto(detalleDTO.getProducto());
		
		this.detalleRespository.save(detalle);
		
		return this.ventaRepository.findById(detalle.getVenta().getId());
	}
	
	public void removeDetalle(Detalle detalle) {	
		this.detalleRespository.delete(detalle);
	}
	

}
