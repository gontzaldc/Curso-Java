package com.gontzal.ipartek.uf1844.poo.herencia;

public class Empleado {
	
	private String nombre;
	
	public Empleado() {
		
	}
	
	public Empleado(String nombre) {
		this.nombre=nombre;	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado " + nombre;
	}
	
	
}
