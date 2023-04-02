package com.spring.entregaFinal.carrito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entregaFinal.carrito.DTO.ProductoDTO;
import com.spring.entregaFinal.carrito.Entity.Producto;
import com.spring.entregaFinal.carrito.repositories.ProductoRepository;

@Service
public class ProductoService {
	
	private ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	public Producto save(ProductoDTO productoDTO) {
		
		Producto producto = new Producto();
		
		producto.setNombre(productoDTO.getNombre().toUpperCase());
		producto.setPrecio(productoDTO.getPrecio());
		
		if(productoDTO.getCategoria() !=null)
			producto.setCategoria(productoDTO.getCategoria());
		if(productoDTO.getMarca() != null)
			producto.setMarca(productoDTO.getMarca());
		
		return productoRepository.save(producto);
	}
	
	public boolean removeProducto(Producto producto) {
		if (producto == null)
			return false;
		
		productoRepository.delete(producto);

		return true;
	}
	
	public boolean updateProducto(Producto producto) {
		if(producto == null)
			return false;
		productoRepository.save(producto);
		
		return true;
	}

	
	public List<Producto>getAllProductos(){
		return productoRepository.findAll();
	}
	
	public List<Producto>getByPalabraClave(String pClave){
		return productoRepository.getByPalabraClave(pClave);
	}
	public Producto getProductoByNombre(String nombre){
		return productoRepository.getByNombre(nombre);
	
	}
	public Optional<Producto> getProductoById(Long id){
		return productoRepository.findById(id);
	
	}
}
