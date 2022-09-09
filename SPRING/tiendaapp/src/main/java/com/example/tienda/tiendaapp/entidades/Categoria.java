package com.example.tienda.tiendaapp.entidades;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.*;

import lombok.*;

@Entity
@Table(name="categorias")
@Data
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	@NotNull
	@NotBlank
	private String nombre;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "categoria")
	@JsonIgnore
	private Set<Producto> productos;
}
