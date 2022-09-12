package com.gontzal.inmobiliaria.mf0493_gontzal.controladores;

import java.math.BigDecimal;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gontzal.inmobiliaria.mf0493_gontzal.entidades.Inmueble;
import com.gontzal.inmobiliaria.mf0493_gontzal.servicios.InmuebleService;
import com.gontzal.inmobiliaria.mf0493_gontzal.servicios.TipoService;

@Controller
@RequestMapping("/inmuebles")
public class InmuebleController {

	@Autowired
	private InmuebleService servicioInmueble;

	@Autowired
	private TipoService servicioTipo;

	// Listar todos los elementos
	@GetMapping
	public String listar(Model modelo, Inmueble inmueble) {
		modelo.addAttribute("inmuebles", servicioInmueble.listar());
		listarTipos(modelo);
		return "inmuebles";
	}

	// Get para mostrar el detalle de inmueble
	@GetMapping("/detalle/{id}")
	public String mostrarDetalle(@PathVariable Long id, Model modelo) {
		listarTipos(modelo);
		modelo.addAttribute("inmuebles", servicioInmueble.listar());
		modelo.addAttribute("inmueble", servicioInmueble.buscarPorId(id));
		return "inmuebles";
	}

	
	//Get para filtrar por tipo(venta/alquiler)
	@GetMapping("/tipo")
	public String buscarPorTipo(@RequestParam Long tipoId, Model modelo, Inmueble inmueble) {
		listarTipos(modelo);
		modelo.addAttribute("inmuebles", servicioInmueble.listarPorTipo(tipoId));
		return "inmuebles";
	}

	private void listarTipos(Model modelo) {
		modelo.addAttribute("tipos", servicioTipo.listar());
	}

	
	//Get para filtrar en rango minimo y máximo
	@GetMapping("/rango")
	public String buscarPorTipo(@RequestParam BigDecimal min, @RequestParam BigDecimal max, Model modelo,
			Inmueble inmueble) {
		
		listarTipos(modelo);
		Iterable<Inmueble> listarPorRangoPrecio = servicioInmueble.listarPorRangoPrecio(min, max);

		if (comprobarIterableVacio(listarPorRangoPrecio)) {
			modelo.addAttribute("alerta", "No se han encontrado Inmuebles en el rango entre " + min + "€ - " + max +"€");
		}

		modelo.addAttribute("inmuebles", listarPorRangoPrecio);
		return "inmuebles";
	}

	// Get para buscar por nombre o dirección
	@GetMapping("/busqueda")
	public String buscarPorTipo(@RequestParam String busqueda, Inmueble inmueble, Model modelo) {

		listarTipos(modelo);
		Iterable<Inmueble> listarPorNombreDireccion = servicioInmueble.listarPorNombreDireccion(busqueda);

		// LLamamos al metodo para saber si el iterable esta vacio
		if (comprobarIterableVacio(listarPorNombreDireccion)) {
			modelo.addAttribute("alerta", "No se han encontrado Inmuebles con la busqueda " + busqueda);
		}

		modelo.addAttribute("inmuebles", listarPorNombreDireccion);
		return "inmuebles";
	}

	// Redireccionar al formulario para añadir inmueble
	@GetMapping("/admin/formulario")
	public String cargarFormulario(Model modelo, Inmueble inmueble) {
		listarTipos(modelo);
		return "formulario";
	}

	// recibir datos del formulario
	@PostMapping("/admin/formulario")
	public String guardarInmueble(@Valid Inmueble inmueble, BindingResult bindingResult, Model modelo) {
		if (bindingResult.hasErrors()) {
			listarTipos(modelo);
			return "formulario";
		}

		servicioInmueble.crear(inmueble);

		return "redirect:/inmuebles";
	}

	// Metodo creado para comprobar si un Iterable está vacio
	private boolean comprobarIterableVacio(Iterable<?> iterable) {
		if (iterable instanceof Collection) {
			if (((Collection<?>) iterable).size() == 0) {
				return true;
			}
		}
		return false;
	}
}
