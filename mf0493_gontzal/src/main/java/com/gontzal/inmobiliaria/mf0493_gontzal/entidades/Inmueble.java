package com.gontzal.inmobiliaria.mf0493_gontzal.entidades;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Data;

@Entity
@Table(name="inmuebles")
@Data
public class Inmueble {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min=3,max=100)
	private String nombre;
	
	@NotNull
	@NotBlank
	@Size(min=3, max =250)
	private String direccion;

	
	@NotNull
	@Min(1)
	private BigDecimal precio;
	
	@NotNull
	private String imagen="https://placeimg.com/640/480/arch?";
	
	
	@NotNull
	@ManyToOne
	private Tipo tipo;
}
