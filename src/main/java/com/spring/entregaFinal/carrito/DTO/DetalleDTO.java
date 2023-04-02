package com.spring.entregaFinal.carrito.DTO;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.entregaFinal.carrito.Entity.Producto;
import com.spring.entregaFinal.carrito.Entity.Venta;

public class DetalleDTO {
	
	@NotEmpty
	private Integer cantidad;
	
	private Producto producto;
	
	private Venta venta;
	

	public DetalleDTO(@NotEmpty Integer cantidad, Producto producto, Venta venta) {

		this.cantidad = cantidad;
		this.producto = producto;
		this.venta = venta;
	}

	public DetalleDTO() {
		super();
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	public Float getMonto() {
		return this.cantidad * this.producto.getPrecio();
	}

	@Override
	public String toString() {
		return "DetalleDTO [cantidad=" + cantidad + ", producto=" + producto + ", venta=" + venta + 
				 "]";
	}

	
}
