package com.spring.entregaFinal.carrito.Entity;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
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
import javax.persistence.Transient;

@Entity
@Table(name = "Ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name= "userId")
	private User user;
	
	//ES CALCULABLE, POR LO CUAL NO ES NECESARIO SU PERSISTENCIA
	@Transient
	private float monto;
	
	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;
	
	@OneToMany(mappedBy = "venta")
	private List<Detalle> detalles;

	public Venta(Long id, LocalDate fecha, User user) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.user = user;
		this.monto = this.getMonto();
	}
	
	public Venta() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
	public float getMonto() {
		
		float monto = 0;
		
		for (Detalle d: detalles) {
			monto = monto + d.getMonto();
		}
		
		monto = (float) (Math.round(monto*100d)/100d);
		
		//LUEGO DE TODAS LA ITERACIONES, REDONDEAMOS A DOS DIGITOS
		return monto;
		
	}
	
	
	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public boolean addDetalle(Detalle detalle) {
		this.detalles.add(detalle);
		return true;
	}
	
	public boolean removeDetalle(Detalle detalle) {
		this.detalles.remove(detalle);
		return true;
	}
	
	
	
}
