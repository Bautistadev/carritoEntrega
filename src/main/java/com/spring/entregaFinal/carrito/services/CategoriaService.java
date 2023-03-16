package com.spring.entregaFinal.carrito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entregaFinal.carrito.DTO.CategoriaDTO;
import com.spring.entregaFinal.carrito.Entity.Categoria;
import com.spring.entregaFinal.carrito.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	
	private final CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public Categoria save(CategoriaDTO categoriaDTO){
		 Categoria categoria = new Categoria();
		 
		 categoria.setNombre(categoriaDTO.getNombre());
		 
		 if(categoriaDTO.getPadreCategoria() != null)
			 categoria.setPadreCategoria(categoriaDTO.getPadreCategoria());
		 
		 return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> getAllCategoria(){
		
		return categoriaRepository.findAll();
		
	}
	
	public boolean removeCategoria(Categoria categoria) {
		
		if(categoria == null)
			return false;
		
		categoriaRepository.deleteById(categoria.getId());
		return true;
	}
}
