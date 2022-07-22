package com.gontzal.ipartek.uf1844.poo.ej5;

public class ComplejoPrueba {

	public static void main(String[] args) {

		Complejos c1 = new Complejos(2, 6);
		Complejos c2 = new Complejos(3, 2);

		System.out.println(c1 + " + " + c2 + " = " + c1.sumar(c2));

		System.out.println(c1 + " - " + c2 + " = " + c1.restar(c2));

		System.out.println(c1 + " * " + c2 + " = " + c1.multiplicar(c2));

		System.out.println(c1 + " / " + c2 + " = " + c1.dividir(c2));

	}
}
