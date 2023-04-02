package com.spring.entregaFinal.carrito.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entregaFinal.carrito.DTO.MarcaDTO;
import com.spring.entregaFinal.carrito.Entity.Marca;
import com.spring.entregaFinal.carrito.Entity.Message;
import com.spring.entregaFinal.carrito.Entity.User;
import com.spring.entregaFinal.carrito.security.services.UserService;
import com.spring.entregaFinal.carrito.services.MarcaServices;


 
@RestController
@RequestMapping("/marca")
public class MarcaController {

	private final MarcaServices marcaServices;
	
	@Autowired
	public MarcaController(MarcaServices marcaServices) {
		super();
		this.marcaServices = marcaServices;
	}
	
	
	//-------------ACCIONES DE ADMINISTRADOR----------------//
	
	
	//CREACION DE UNA NUEVA MARCA
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/marca")
	public ResponseEntity<Object> saveMarca(@Valid @RequestBody MarcaDTO marcaDTO){

		marcaServices.save(marcaDTO);
		
		return new ResponseEntity<>(new Message("guardado esitoso"),HttpStatus.CREATED);
		
	}
	
	//ACTUALIZACION
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/updateMarca")
	public ResponseEntity<Object>updateMarca(@Valid @RequestBody Marca marca) {
		//System.out.println(marca.getId());
		marcaServices.saveActualizar(marca);
		return new ResponseEntity<>(new Message("Actualizacion exitosa"),HttpStatus.CREATED);
	}
	
	
	//ELIMINACION
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/remove")
	public ResponseEntity<Object>removeMarca(@Valid @RequestBody Marca marca){
		if(marcaServices.removeMarca(marca))
			return new ResponseEntity<>(new Message("La marca fue eliminada de forma correcta"),HttpStatus.OK);
		
		return new ResponseEntity<>(new Message("La marca fue eliminada eliminado de forma correcta"),HttpStatus.BAD_REQUEST);
		
	}
	
	
	//-----------------ACCIONES DE USUARIO COMUN ---------------------//
	
	//LISTADO DE MARCA
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/getAllMarcas")
	public List<Marca> getAllMarcas(){
		
		return marcaServices.getAllMarcas();
	}
	
	//BUSQUEDA POR ID
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/marca/{id}")
	public Marca getMarcaById(@PathVariable Long id){
		return marcaServices.getMarca(id);	
	}
	
	//BUSQUEDA POR PALABRA CLAVE
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/marca/pClave/{pClave}")
	public List<Marca> getMarcaByPalablaClave(@PathVariable String pClave){
		return marcaServices.getMarcaByPalabraClave(pClave);
	}
	

	
}
