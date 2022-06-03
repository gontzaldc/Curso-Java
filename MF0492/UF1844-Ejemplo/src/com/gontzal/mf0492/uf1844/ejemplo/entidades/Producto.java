package com.gontzal.mf0492.uf1844.ejemplo.entidades;

import java.math.BigInteger;
import java.util.Objects;

public class Producto {

	private Long id;
	private String nombre;
	private BigInteger stock;
	private String descripcion;

	public Producto(Long id, String nombre, BigInteger stock, String descripcion) {
		setId(id);
		setNombre(nombre);
		setStock(stock);
		setDescripcion(descripcion);
	}
	
	public Producto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigInteger getStock() {
		return stock;
	}

	public void setStock(BigInteger stock) {
		this.stock = stock;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, nombre, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(stock, other.stock);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", stock=" + stock + ", descripcion=" + descripcion + "]";
	}
	
	

}
