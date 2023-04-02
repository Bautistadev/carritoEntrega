package com.spring.entregaFinal.carrito.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre",nullable = false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "padreId")
	private Categoria padreCategoria;
	
	@JsonIgnore
	@OneToMany(mappedBy = "padreCategoria")
	private List<Categoria> hijos;

	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<Producto> productos;

	public Categoria(Long id, String nombre,Categoria padreCategoria,List<Categoria> hijos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.padreCategoria = padreCategoria;
		this.hijos = hijos;
	}
	
	public Categoria(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Categoria() {
		
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

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre 
				+ "padreCategoria= "+"]";
	}
	
}
