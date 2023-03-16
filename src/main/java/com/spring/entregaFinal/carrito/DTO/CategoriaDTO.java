package com.spring.entregaFinal.carrito.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.spring.entregaFinal.carrito.Entity.Categoria;
import com.spring.entregaFinal.carrito.Entity.Producto;

public class CategoriaDTO {
	
	@NotBlank
	private String nombre;
	
	
	private Categoria padreCategoria;
	

	private List<Categoria> hijos;


	private List<Producto> productos;


	public CategoriaDTO(@NotBlank String nombre, Categoria padreCategoria, List<Categoria> hijos,
			List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.padreCategoria = padreCategoria;
		this.hijos = hijos;
		this.productos = productos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Categoria getPadreCategoria() {
		return padreCategoria;
	}


	public void setPadreCategoria(Categoria padreCategoria) {
		this.padreCategoria = padreCategoria;
	}


	public List<Categoria> getHijos() {
		return hijos;
	}


	public void setHijos(List<Categoria> hijos) {
		this.hijos = hijos;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	
}
