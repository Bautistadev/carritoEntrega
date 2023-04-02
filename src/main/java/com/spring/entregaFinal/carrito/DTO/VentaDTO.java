package com.spring.entregaFinal.carrito.DTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.spring.entregaFinal.carrito.Entity.User;

public class VentaDTO {
		

	private User user;
	
	public VentaDTO(User user) {
		this.user = user;
	}
	
	
	public VentaDTO() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
