package com.gontzal.ipartek.uf1844.poo.ej4;

public class fraccionPrueba {
	public static void main(String[] args) {
		
		Fraccion fr1 = new Fraccion(1,4);
		Fraccion fr2 = new Fraccion(1,2);
		
		System.out.print("Suma 1/4 + 1/2 = ");
		System.out.println(fr1.sumar(fr2));
		
		System.out.print("Resta 1/4 - 1/2 = ");
		System.out.println(fr1.restar(fr2));
		
		System.out.print("Multiplicar 1/4 * 1/2 = ");
		System.out.println(fr1.multiplicar(fr2));
		
		System.out.print("Dividir 1/4 / 1/2 = ");
		System.out.println(fr1.dividir(fr2));
	}
}
