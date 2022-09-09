package com.example.tienda.tiendaapp.controladoresrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.tienda.tiendaapp.entidades.Empleado;
import com.example.tienda.tiendaapp.repositorios.EmpleadoRepository;

@RestController
@RequestMapping("api/v1/empleados")
public class EmpleadoRestController {

	@Autowired
	private EmpleadoRepository repo;

	@GetMapping
	public Iterable<Empleado> get() {
		return repo.findAll();
	}

	@GetMapping("{id}")
	public Empleado get(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado post(@RequestBody Empleado empleado) {
		return repo.save(empleado);
	}

	@PutMapping("{id}")
	public Empleado put(@RequestBody Empleado empleado, @PathVariable Long id) {
		if (empleado.getId() != id) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return repo.save(empleado);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
