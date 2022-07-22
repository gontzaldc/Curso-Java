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
		if (id != null && id < 0) {
			throw new EntidadesException("El id debe ser mayor o igual que 0");
		}

		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 2) {
			throw new EntidadesException("El nombre tiene que estar rellenado y tener 2 o más caracteres.");
		}
		this.nombre = nombre;
	}

	public BigInteger getStock() {
		return stock;
	}

	public void setStock(BigInteger stock) {
		if (stock == null || stock.signum() < 0) {
			throw new EntidadesException("El númer de stock tiene que ser mayor a 0");
		}
		this.stock = stock;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		if (descripcion == null || descripcion.length() < 10 || descripcion.length() > 100) {
			throw new EntidadesException("La descripción tiene que tener mínimo 10 caracteres máximo 100");
		}
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
