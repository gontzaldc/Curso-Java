package com.example.tienda.tiendaapp.repositorios;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tienda.tiendaapp.entidades.*;

@SpringBootTest
class ProductoRepositoryTest {

	@Autowired
	private ProductoRepositorio repo;
	@Test
	void insertarProducto() {
		Producto producto = new Producto(null,"ordenador",new BigDecimal("2.30"),3,new Categoria());
		
		repo.save(producto);
		
		Producto recibido =repo.findById(1L).orElse(null);
		assertNotNull(recibido);
		assertEquals(producto,recibido);
	}

}