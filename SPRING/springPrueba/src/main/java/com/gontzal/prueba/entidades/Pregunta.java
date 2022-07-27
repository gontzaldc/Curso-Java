package com.gontzal.prueba.entidades;


import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@Table(name="preguntas")
@Data
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(1)
	private Long id;
	
	@NotBlank
	@Size(min=10,max=255)
	private String texto;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "pregunta")
	private Set<Respuesta> respuestas;
}
