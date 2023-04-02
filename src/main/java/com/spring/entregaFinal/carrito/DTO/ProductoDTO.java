package com.spring.entregaFinal.carrito.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.spring.entregaFinal.carrito.Entity.Categoria;
import com.spring.entregaFinal.carrito.Entity.Marca;

public class ProductoDTO {
    
	@NotBlank
	private String nombre;
	
	@NotNull
	private Float precio;
	

	private Categoria categoria;
	

	private Marca marca;


	public ProductoDTO(String nombre, Float precio, Categoria categoria, Marca marca) {
		super();

		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.marca = marca;
	}


	public ProductoDTO() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Float getPrecio() {
		return precio;
	}


	public void setPrecio(Float precio) {
		this.precio = precio;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	@Override
	public String toString() {
		return "Producto [" + ", nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria
				+ ", marca=" + marca + "]";
	}
	
}
