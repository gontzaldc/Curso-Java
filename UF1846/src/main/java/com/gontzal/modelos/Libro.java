package com.gontzal.modelos;

import java.util.Objects;

public class Libro {
	private Long id;
	private String nombre;
	private String categoria;
	private Boolean disponible;
	
	public Libro(Long id, String nombre, String categoria, Boolean disponible) {
		setId(id);
		setNombre(nombre);
		setCategoria(categoria);
		setDisponible(disponible);
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, disponible, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(disponible, other.disponible)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", disponible=" + disponible
				+ "]";
	}
	
	

}
