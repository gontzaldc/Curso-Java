package com.gontzal.prueba.entidades;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@Table(name = "respuestas")
@Data
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(1)
	private Long id;

	@NotBlank
	@Size(min = 10, max = 255)
	private String texto;

	@NotNull
	private Boolean correcta;
	

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne
	private Pregunta pregunta;
	
	
}
