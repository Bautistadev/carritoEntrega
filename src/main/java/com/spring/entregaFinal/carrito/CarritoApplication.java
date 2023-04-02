package com.spring.entregaFinal.carrito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.entregaFinal.carrito.Entity.Categoria;
import com.spring.entregaFinal.carrito.Entity.Marca;
import com.spring.entregaFinal.carrito.Entity.Producto;
import com.spring.entregaFinal.carrito.Entity.User;
import com.spring.entregaFinal.carrito.repositories.CategoriaRepository;
import com.spring.entregaFinal.carrito.repositories.MarcaRepository;
import com.spring.entregaFinal.carrito.repositories.ProductoRepository;
import com.spring.entregaFinal.carrito.security.services.RoleService;
import com.spring.entregaFinal.carrito.security.services.UserService;
import com.spring.entregaFinal.carrito.services.MarcaServices;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring.entregaFinal"})
@EnableAutoConfiguration
public class CarritoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(CarritoApplication.class, args);
		
		System.out.println(ctx.getBean(UserService.class).findPalabraClave("ad"));
	}

}
