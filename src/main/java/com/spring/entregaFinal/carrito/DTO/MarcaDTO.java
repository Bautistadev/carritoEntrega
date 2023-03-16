package com.spring.entregaFinal.carrito.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.spring.entregaFinal.carrito.Entity.Producto;

public class MarcaDTO {

	
	@NotBlank
	private String nombre;
	

	private List<Producto> productos;

	public MarcaDTO(@NotBlank String nombre) {
		this.nombre = nombre;
		this.productos = productos;
	}

	public MarcaDTO() {
		super();
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Marca [ nombre=" + nombre + ", productos=" + productos + "]";
	}
	
	
	

}
