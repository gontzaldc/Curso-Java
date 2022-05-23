package com.gontzal.ipartek.uf1844.poo.ej1;

public class cuentaPrueba {
	public static void main(String[] args) {
		Cuenta c1= new Cuenta("Gontzal","123456789",1.45,200);
		Cuenta c2= new Cuenta("Alfredo","21345678965432",1.55,400);
		
		
		//Ingreso de 150.45 en la ceunta 1
		c1.ingreso(150.45);
		System.out.println(c1.getSaldo());
		
		//reintegro de 20 en la cuenta 2
		c2.reintegro(20);
		System.out.println(c2.getSaldo());
		
		//Hacer una transferencia de la cuenta 2 a la cuenta 1
		c2.transferencia(c1, 50);
		System.out.println("Saldo c1= "+c1.getSaldo());
		System.out.println("Saldo c2= "+c2.getSaldo());
	}
}
