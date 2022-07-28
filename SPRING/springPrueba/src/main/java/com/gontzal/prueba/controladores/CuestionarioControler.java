package com.gontzal.prueba.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gontzal.prueba.entidades.*;
import com.gontzal.prueba.repositorios.Preguntarepository;

@Controller
@RequestMapping("/preguntas")
public class CuestionarioControler {

	@Autowired
	private Preguntarepository repo;

	@GetMapping
	public String mostrarListado(Model modelo) {
		modelo.addAttribute("preguntas", repo.obtenerPreguntasConRespuestas());
		return "cuestionario";
	}

	@PostMapping("/enviar")
	public String comprobarPreguntas(@ModelAttribute ArrayList<Respuesta> respuestas) {
		System.out.println(respuestas);
		return "cuestionario";
	}

}
