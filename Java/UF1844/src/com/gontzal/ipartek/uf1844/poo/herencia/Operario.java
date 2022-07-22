package com.gontzal.ipartek.uf1844.poo.herencia;

public class Operario extends Empleado{
	
	public Operario(String nombre) {
		super(nombre);
	}
	
	public Operario() {
		
	}

	@Override
	public String toString() {
		return super.toString() + "-> Operario";
	}
	
	
}
