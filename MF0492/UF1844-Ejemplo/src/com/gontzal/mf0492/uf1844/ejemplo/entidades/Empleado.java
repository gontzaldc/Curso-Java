package com.gontzal.mf0492.uf1844.ejemplo.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Empleado {

	private Long id;
	private String nif;
	private String nombre;
	private LocalDate fechanacimiento;
	private BigDecimal sueldo;

	public Long getId() {
		return id;
	}

	// Constructors

	// getter and setters
	public void setId(Long id) {
		this.id = id;
	}

	public Empleado(Long id, String nif, String nombre, LocalDate fechanacimiento, BigDecimal sueldo) {
		setId(id);
		setNif(nif);
		setNombre(nombre);
		setFechanacimiento(fechanacimiento);
		setSueldo(sueldo);
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(LocalDate fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	// Hascode & Equals
	@Override
	public int hashCode() {
		return Objects.hash(fechanacimiento, id, nif, nombre, sueldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(fechanacimiento, other.fechanacimiento) && Objects.equals(id, other.id)
				&& Objects.equals(nif, other.nif) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(sueldo, other.sueldo);
	}

	// metodo toString
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nif=" + nif + ", nombre=" + nombre + ", fechanacimiento=" + fechanacimiento
				+ ", sueldo=" + sueldo + "]";
	}

}
