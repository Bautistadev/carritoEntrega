package com.spring.entregaFinal.carrito.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "marcas")
public class Marca  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre",nullable = false)
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "marca")
	private List<Producto> productos;

	public Marca(Long id,String nombre,List<Producto>productos) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.productos = productos;
	}

	public Marca() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Marca [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
}
