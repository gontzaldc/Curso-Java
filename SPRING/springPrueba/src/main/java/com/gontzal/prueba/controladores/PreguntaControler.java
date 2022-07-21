package com.gontzal.prueba.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gontzal.prueba.entidades.Pregunta;
import com.gontzal.prueba.repositorios.Preguntarepository;

@Controller
@RequestMapping("/admin/preguntas")
public class PreguntaControler {

	@Autowired
	private Preguntarepository repo;
	
	@GetMapping
	public String mostrarListado(Model modelo) {
		modelo.addAttribute("preguntas", repo.findAll());
		return "preguntas";
	}
	
	@GetMapping("/insertar")
	public String mostrarFormulario(Pregunta pregunta) {
		return "pregunta";
	}
	
	@PostMapping("/insertar")
	public String insertarPregunta(@Valid Pregunta pregunta , BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "pregunta";
		}
		
		repo.save(pregunta);
		
		return "redirect:/admin/preguntas";
	}
	
	@GetMapping("/borrar/{id}")
	public String mostrarFormulario(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		
		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			redirectAttributes.addFlashAttribute("error", "No se ha podido borrar el elemento porque no existía");
		}
		
		return "redirect:/admin/preguntas";
	}
}
