package com.gontzal.ipartek.uf1844.poo.herencia;

public class Tecnico extends Operario{
	
	public Tecnico() {
		
	}
	
	public Tecnico(String nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return super.toString()+" -> Tecnico";
	}
	
	
}
