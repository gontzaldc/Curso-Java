package com.gontzal.ipartek.uf1844.poo.ejercicios;

public class cuentaPruebas {
	public static void main(String[] args) {
		
		Cuenta cuenta= new Cuenta("cuenta1");
		
		cuenta.ingresar(200);
		
		System.out.println(cuenta);
		
		cuenta.retirar(150);
		
		System.out.println(cuenta);
	}
}
