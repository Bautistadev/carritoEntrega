package com.spring.entregaFinal.carrito.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "domicilio")
public class Domicilio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "calle", nullable = false)
	private String calle;
	
	@Column(name = "altura",nullable = false)
	private Integer altura;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "localidadId")
	private Localidad localidad;

	public Domicilio(String calle, Integer altura, User user) {
		super();
		this.calle = calle;
		this.altura = altura;
		this.user = user;
	}

	public Domicilio() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Domicilio [id=" + id + ", calle=" + calle + ", altura=" + altura + ", user=" + user + "]";
	}
	
	
	
}
