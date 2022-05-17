package com.gontzal.ipartek.uf1844;

import java.math.BigDecimal;

public class sintaxis {
	/**
	 * Método de entrada de la aplicación
	 * 
	 * @param args Argumentos de linea de comandos
	 */

	public static void main(String[] args) {
		tipos();

		
	}


	private static void tipos() {
		System.out.println("Sintaxis");

		// Big decimal para usar números con coma, siempre new BigDecimal("") -> con
		// comillas

		BigDecimal num1 = new BigDecimal("1.4");
		BigDecimal num2 = new BigDecimal("4.2");

		BigDecimal resultado = num1.add(num2);
		System.out.println(resultado);
		
		
	}
	
	
}
