package com.spring.entregaFinal.carrito.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entregaFinal.carrito.DTO.DetalleDTO;
import com.spring.entregaFinal.carrito.DTO.VentaDTO;
import com.spring.entregaFinal.carrito.Entity.Detalle;
import com.spring.entregaFinal.carrito.Entity.Message;
import com.spring.entregaFinal.carrito.Entity.Venta;
import com.spring.entregaFinal.carrito.services.VentaService;

@RestController
@RequestMapping("/venta")
public class VentaController {
	
	
	private VentaService ventaService;

	@Autowired
	public VentaController(VentaService ventaService) {
		super();
		this.ventaService = ventaService;
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/venta")
	public Long altaVenta(@RequestBody VentaDTO ventaDTO){
		return ventaService.altaVenta(ventaDTO);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/getAllVentas")
	public List<Venta> altaVenta(){
		return ventaService.getAllVentas();
	}
	
	@GetMapping("/{id}/getAllVentas")
	public List<Venta> altaVentaUser(@PathVariable Long id){
		return ventaService.getVentaUser(id);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addDetalle")
	public Optional<Venta> addDetalle(@RequestBody DetalleDTO detalleDTO){
		return this.ventaService.addDetalle(detalleDTO);
	}
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/removeDetalle")
	public void removeDetalle(@RequestBody Detalle detalle){
		System.out.println(detalle.getVenta());
		this.ventaService.removeDetalle(detalle);
	}
	

}
