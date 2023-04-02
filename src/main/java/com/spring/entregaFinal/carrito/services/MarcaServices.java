package com.spring.entregaFinal.carrito.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entregaFinal.carrito.DTO.MarcaDTO;
import com.spring.entregaFinal.carrito.Entity.Marca;
import com.spring.entregaFinal.carrito.repositories.MarcaRepository;



@Service
@Transactional
public class MarcaServices {
	

	private MarcaRepository marcaRepository;
	
	@Autowired
	public MarcaServices(MarcaRepository marcaRepository) {
		super();
		this.marcaRepository = marcaRepository;
	}

	public Marca getMarca(Long id){
		Marca marca = new Marca();
		
		marca.setId(marcaRepository.findById(id).get().getId());
		marca.setNombre(marcaRepository.findById(id).get().getNombre().toUpperCase());
		marca.setProductos(marcaRepository.findById(id).get().getProductos());
		
		
		return marcaRepository.getById(id);
	}
	
	public Marca save(MarcaDTO marcaDTO) {
		
		Marca marca = new Marca();
		marca.setNombre(marcaDTO.getNombre().toUpperCase());
		
		return this.marcaRepository.save(marca);
	}
	
	public Marca saveActualizar(Marca marca) {		
		return this.marcaRepository.save(marca);
	}
	
	public List<Marca>getAllMarcas(){
		return marcaRepository.findAll();
	}
	
	public Marca getMarcaByNombre(String nombre) {
		return marcaRepository.findByNombre(nombre);
	}
	
	public List<Marca> getMarcaByPalabraClave(String nombre) {
		return marcaRepository.findByWordName(nombre);
	}
	
	public boolean removeMarca(Marca marca) {
		
		if(marca == null)
			return false;
					
		marcaRepository.delete(getMarca(marca.getId()));
		return true;
	}
	
	
}
