package com.gontzal.inmobiliaria.mf0493_gontzal.controladores;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gontzal.inmobiliaria.mf0493_gontzal.entidades.Inmueble;
import com.gontzal.inmobiliaria.mf0493_gontzal.servicios.*;

@Controller
@RequestMapping("/inmuebles")
public class InmuebleController {

	@Autowired
	private InmuebleService servicioInmueble;
	
	@Autowired
	private TipoService servicioTipo;

	@GetMapping
	public String listar(Model modelo, Inmueble inmueble) {
		modelo.addAttribute("inmuebles", servicioInmueble.listar());
		modelo.addAttribute("tipos", servicioTipo.listar());
		return "inmuebles";
	}

	@GetMapping("/detalle/{id}")
	public String mostrarDetalle(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("inmuebles", servicioInmueble.listar());
		modelo.addAttribute("inmueble", servicioInmueble.buscarPorId(id));
		return "inmuebles";
	}

	@GetMapping("/tipo/{id}")
	public String buscarPorTipo(@PathVariable Long id, Model modelo, Inmueble inmueble) {
		modelo.addAttribute("tipos", servicioTipo.listar());
		modelo.addAttribute("inmuebles", servicioInmueble.listarPorTipo(id));
		return "inmuebles";
	}
	
	@GetMapping("/rango")
	public String buscarPorTipo(@RequestParam BigDecimal min,@RequestParam BigDecimal max, Model modelo,  Inmueble inmueble ) {
		
		modelo.addAttribute("inmuebles", servicioInmueble.listarPorRangoPrecio(min, max));
		return "inmuebles";
	}
	
	@GetMapping("/busqueda")
	public String buscarPorTipo(@RequestParam String busqueda,  Inmueble inmueble, Model modelo ) {
		
		modelo.addAttribute("inmuebles", servicioInmueble.listarPorNombreDireccion(busqueda));
		return "inmuebles";
	}
	
	@GetMapping("/admin/formulario")
	public String cargarFormulario( Model modelo , Inmueble inmueble) {
		modelo.addAttribute("tipos",servicioTipo.listar());
		return "formulario";
	}
	
	@PostMapping("/admin/formulario")
	public String guardarInmueble(@Valid Inmueble inmueble, BindingResult bindingResult, Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("tipos",servicioTipo.listar());
			return "formulario";
		}
		
		servicioInmueble.crear(inmueble);
		
		return "redirect:/inmuebles";
	}
}
