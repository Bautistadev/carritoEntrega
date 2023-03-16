package com.spring.entregaFinal.carrito.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entregaFinal.carrito.DTO.CategoriaDTO;
import com.spring.entregaFinal.carrito.Entity.Categoria;
import com.spring.entregaFinal.carrito.Entity.Message;
import com.spring.entregaFinal.carrito.services.CategoriaService;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	private final CategoriaService categoriaService;
	
	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	
	//-------------ACCIONES DE ADMINISTRADOR----------------//
	
	
	//ALTA DE UNA CATEGORIA
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/categoria")
	public ResponseEntity<Object> save(@Valid @RequestBody CategoriaDTO categoriaDTO){
		
		categoriaService.save(categoriaDTO);
		
		System.out.println(categoriaDTO.getPadreCategoria());
		
		return new ResponseEntity<>(new Message("Guardado exitoso"),HttpStatus.CREATED);
	}
	
	//BAJA DE UNA CATEGORIA
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/remove")
	public ResponseEntity<Object>removeMarca(@Valid @RequestBody Categoria categoria){
		
		if(!categoriaService.removeCategoria(categoria))
			return new ResponseEntity<>(new Message("Error en la eliminacion de la categoria"),HttpStatus.OK);
		
		return new ResponseEntity<>(new Message("La categoria fue eliminada de forma exitosa"),HttpStatus.OK);
	}
	
	
	
	//-----------------ACCIONES DE USUARIO COMUN ---------------------//
	
	
	//LISTADO DE CATEGORIAS
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/getAllCategorias")
	public List<Categoria> getAllCategorias(){		
		
		return categoriaService.getAllCategoria();
	}
	
}
