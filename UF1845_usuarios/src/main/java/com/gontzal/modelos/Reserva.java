package com.gontzal.modelos;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva {

	private Long id;
	private LocalDateTime fecha;
	private String email;
	private Libro libro;


	public Reserva() {
		
	}
	public Reserva(Long id, LocalDateTime fecha, String email, Libro libro) {
		setId(id);
		setLibro(libro);
		setemail(email);
		setFecha(fecha);
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fecha, id, libro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(email, other.email) && Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id)
				&& Objects.equals(libro, other.libro);
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fecha=" + fecha + ", email=" + email + ", libro=" + libro + "]";
	}

}
