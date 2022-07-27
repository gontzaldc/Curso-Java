package com.gontzal.prueba.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gontzal.prueba.entidades.Pregunta;

public interface Preguntarepository extends CrudRepository<Pregunta,Long>{

	@Query("select p from Pregunta p join fetch p.respuestas respuestas")
	Set<Pregunta> obtenerPreguntasConRespuestas();
}
