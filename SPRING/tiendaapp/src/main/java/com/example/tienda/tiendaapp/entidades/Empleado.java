package com.example.tienda.tiendaapp.entidades;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Data;

@Entity
@Table(name="empleados")
@Data
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nombre;
	
	@Min(0)
	private BigDecimal Sueldo;
	
	@NotNull
	@NotBlank
	private String puesto;
}
