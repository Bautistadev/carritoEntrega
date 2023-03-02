package com.spring.entregaFinal.carrito.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userName",nullable = false)
	private String userName;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellido", nullable = false)
	private String apellido;
	
	@Column(name = "email",nullable = false)
	private String email;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "fechaAlta",nullable = false)
	private String fechaAlta;
	
	@Column(name = "fechaBaja",nullable = false)
	private String fechaBaja;
	
	@OneToMany(mappedBy = "user")
	private List<Venta> ventas;
	
	//PUEDE QUE EL USUARIO POSEA MAS DE UN DOMICILIO
	@OneToMany(mappedBy = "user")
	private List<Domicilio> domicilios;

	public User(Long id, String userName, String nombre, String apellido, String email, String password,
			String fechaAlta, String fechaBaja) {
		super();
		this.id = id;
		this.userName = userName;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}
	
	
	public User() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public String getFechaBaja() {
		return fechaBaja;
	}


	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	
	

	public List<Venta> getVentas() {
		return ventas;
	}


	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}


	public List<Domicilio> getDomicilios() {
		return domicilios;
	}


	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", password=" + password + ", fechaAlta=" + fechaAlta + ", fechaBaja="
				+ fechaBaja + "]";
	}
	
	
	
}
