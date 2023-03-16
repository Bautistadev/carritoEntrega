package com.spring.entregaFinal.carrito.security.dtos;



import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank
    private String userName;
    @Email
    private String email;
    @NotBlank
    private String password;
    
    @NotBlank
	private String nombre;
	
	@NotBlank
	private String apellido;
    
	
    
    private Set<String> roles = new HashSet<>();
    public UserDTO() {
    }
    

	public UserDTO(@NotBlank String userName, @Email String email, @NotBlank String password, @NotBlank String nombre,
			@NotBlank String apellido, Set<String> roles) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.roles = roles;
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


	public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    
}
