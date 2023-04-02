package com.spring.entregaFinal.carrito.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalles")
public class Detalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@ManyToOne
	@JoinColumn(name = "productoId")
	private Producto producto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ventaId")
	private Venta venta;

	public Detalle(Long id, Integer cantidad, Producto producto, Venta venta) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
		this.venta = venta;
	}

	public Detalle() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Detalle [id=" + id + ", cantidad=" + cantidad + ", producto=" + producto + ", venta=" + venta + "]";
	}
	
	
	
	
}
