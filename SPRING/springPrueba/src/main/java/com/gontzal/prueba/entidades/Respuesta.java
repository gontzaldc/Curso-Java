package com.gontzal.prueba.entidades;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Data;

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

	@ManyToOne
	private Pregunta pregunta;
}
