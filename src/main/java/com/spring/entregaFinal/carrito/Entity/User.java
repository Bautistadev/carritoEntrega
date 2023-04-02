package com.spring.entregaFinal.carrito.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.entregaFinal.carrito.enums.*;


@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NaturalId
	@Column(name = "userName",unique = true,nullable = false)
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
	
	@Column(name = "fechaBaja",nullable = true)
	private String fechaBaja;
	
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role_relate", joinColumns = @JoinColumn(name="user_id"),
     inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();
	
    @JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Venta> ventas;
	
	//PUEDE QUE EL USUARIO POSEA MAS DE UN DOMICILIO
	@OneToMany(mappedBy = "user")
	private List<Domicilio> domicilios;

	public User(String userName, String nombre, String apellido, String email, String password,
			String fechaAlta) {
		super();
		this.userName = userName;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.fechaAlta = fechaAlta;
		
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

	
	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", password=" + password + ", fechaAlta=" + fechaAlta + ", fechaBaja="
				+ fechaBaja + "]";
	}
	
	
	
}
