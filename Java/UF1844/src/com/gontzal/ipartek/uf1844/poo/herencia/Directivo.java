package com.gontzal.ipartek.uf1844.poo.herencia;

public class Directivo extends Empleado{
	
	public Directivo() {
		
	}
	
	public Directivo(String nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return super.toString()+" -> Directivo";
	}
	
	
}
