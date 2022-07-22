package com.gontzal.mf0492.uf1844.ejemplo.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.gontzal.mf0492.uf1844.ejemplo.bibliotecas.Validaciones;

public class Empleado {

	private Long id;
	private String nif;
	private String nombre;
	private LocalDate fechaNacimiento;
	private BigDecimal sueldo;

	public Long getId() {
		return id;
	}

	// Constructors

	// getter and setters
	public void setId(Long id) {
		if (id != null && id < 0) {
			throw new EntidadesException("El id debe ser mayor o igual que 0");
		}

		this.id = id;
	}

	public Empleado(Long id, String nif, String nombre, LocalDate fechaNacimiento, BigDecimal sueldo) {
		setId(id);
		setNif(nif);
		setNombre(nombre);
		setfechaNacimiento(fechaNacimiento);
		setSueldo(sueldo);
	}

	public Empleado() {
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		if (!Validaciones.validarNif(nif)) {
			throw new EntidadesException("El NIF introducido debe ser válido");
		}
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() <= 2) {
			throw new EntidadesException("El nombre debe estar rellenado y tener al menos 2 caracteres");
		}
		this.nombre = nombre;
	}

	public LocalDate getfechaNacimiento() {
		return fechaNacimiento;
	}

	public void setfechaNacimiento(LocalDate fechaNacimiento) {

		if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now().minusYears(18))
				|| fechaNacimiento.isBefore(LocalDate.of(1900, 1, 1))) {
			throw new EntidadesException("La fecha de nacimiento debe estar comprendida entre 1900 y la fecha actual");
		}

		this.fechaNacimiento = fechaNacimiento;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		if (sueldo == null || sueldo.compareTo(BigDecimal.ZERO) < 0) {

			throw new EntidadesException("El sueldo debe estar rellenado y ser mayor o igual a 0");
		}
		this.sueldo = sueldo;
	}

	// Hascode & Equals
	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, id, nif, nombre, sueldo);
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
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(id, other.id)
				&& Objects.equals(nif, other.nif) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(sueldo, other.sueldo);
	}

	// metodo toString
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nif=" + nif + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", sueldo=" + sueldo + "]";
	}

}
