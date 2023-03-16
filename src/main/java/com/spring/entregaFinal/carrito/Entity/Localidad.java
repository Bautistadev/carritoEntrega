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

@Entity
@Table(name = "localidades")
public class Localidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	
	@Column(name = "codPostal", nullable = false)
	private String codPostal;
	
	
	@ManyToOne
	@JoinColumn(name = "ProvinciaId")
	private Provincia provincia;
	
	@OneToMany(mappedBy = "localidad")
	private List<Domicilio> domicilios;

	public Localidad() {
		
	}
	
	public Localidad(Long id, String nombre, String codPostal, Provincia provincia, List<Domicilio> domicilios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codPostal = codPostal;
		this.provincia = provincia;
		this.domicilios = domicilios;
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

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Domicilio> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}

	@Override
	public String toString() {
		return "Localidad [id=" + id + ", nombre=" + nombre + ", codPostal=" + codPostal + ", provincia=" + provincia
				+ ", domicilios=" + domicilios + "]";
	}
	
	
	
	
	
}
