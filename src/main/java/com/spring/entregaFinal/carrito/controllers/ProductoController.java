package com.spring.entregaFinal.carrito.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entregaFinal.carrito.DTO.ProductoDTO;
import com.spring.entregaFinal.carrito.Entity.Message;
import com.spring.entregaFinal.carrito.Entity.Producto;
import com.spring.entregaFinal.carrito.services.ProductoService;


@RestController
@RequestMapping("/producto")
public class ProductoController {

	private ProductoService productoService;
	
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	

	//-------------ACCIONES DE ADMINISTRADOR----------------//
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/producto")
	public ResponseEntity<Object> altaProducto(@Valid @RequestBody ProductoDTO productoDTO) {
		
		if(productoDTO == null)
			return new ResponseEntity<>(new Message("Error en el alta, objeto vacio"),HttpStatus.BAD_REQUEST);
	
		System.out.println(productoDTO);
		
		productoService.save(productoDTO);
		
		return new ResponseEntity<>(new Message("Producto guardado exitoso"),HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/updateProducto")
	public ResponseEntity<Object> updateProducto(@Valid @RequestBody Producto producto){
		if(productoService.updateProducto(producto))
			return new ResponseEntity<>(new Message("Producto actualizado con exito"),HttpStatus.OK);
		
		return new ResponseEntity<>(new Message("Error en la actualizacion"),HttpStatus.BAD_REQUEST);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/removeProducto")
	public ResponseEntity<Object> removeProducto(@Valid @RequestBody Producto producto){
		if(productoService.removeProducto(producto))
			return new ResponseEntity<>(new Message("Producto borrado con exito"),HttpStatus.OK);
		
		return new ResponseEntity<>(new Message("Error en la eliminacion"),HttpStatus.BAD_REQUEST);
		
	}
	
	//-----------------ACCIONES DE USUARIO COMUN ---------------------//
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/getAllProducto")
	public List<Producto> getAllProductos(){
		System.out.println(productoService.getAllProductos());
		return productoService.getAllProductos();
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/getProductoById/{id}")
	public Optional<Producto> getProductosById(@PathVariable Long id){
		return productoService.getProductoById(id);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/producto/pclave")
	public List<Producto> getProductosBypClave(@Valid @RequestBody String pClave){
		return productoService.getByPalabraClave(pClave);
	}
	
	
	
}
