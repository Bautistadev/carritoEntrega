package com.spring.entregaFinal.carrito.Entity;

import java.util.Date;
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
@Table(name = "Ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha", nullable = false)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name= "userId")
	private User user;
	
	@OneToMany(mappedBy = "venta")
	private List<Detalle> detalles;

	public Venta(Long id, Date fecha, User user) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Float getMonto() {
		Float monto = null;
		
		for (Detalle d: detalles) {
			monto = monto + d.getMonto();
		}
		
		return monto;
		
	}
	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha=" + fecha + ", user=" + user + "]";
	}
	
	
	
}
