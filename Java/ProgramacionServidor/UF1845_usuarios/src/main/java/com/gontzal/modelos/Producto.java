package com.gontzal.modelos;

import java.math.BigDecimal;
import java.util.Objects;

public class Producto {

	private Long id;
	private String nombre;
	private String descripcion;
	private Integer stock;
	private String categoria;
	private Integer descuento;
	private BigDecimal precio;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public Producto() {

	}

	public Producto(Long id, String nombre, String descripcion, Integer stock,String categoria, Integer descuento,BigDecimal precio) {

		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
		setStock(stock);
		setCategoria(categoria);
		setDescuento(descuento);
		setPrecio(precio);
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, descripcion, descuento, id, nombre, precio, stock);
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
		return Objects.equals(categoria, other.categoria) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(descuento, other.descuento) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio)
				&& Objects.equals(stock, other.stock);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock=" + stock
				+ ", categoria=" + categoria + ", descuento=" + descuento + ", precio=" + precio + "]";
	}

}
