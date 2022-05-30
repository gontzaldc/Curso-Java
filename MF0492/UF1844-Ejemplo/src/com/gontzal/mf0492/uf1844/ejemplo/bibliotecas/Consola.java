package com.gontzal.mf0492.uf1844.ejemplo.bibliotecas;

import java.math.BigDecimal;
import java.util.Scanner;

public class Consola {
	
	private final static Scanner sc = new Scanner(System.in);

	public static void p(Object o) {
		System.out.print(o);
	}
	
	public static void pl(Object o) {
		System.out.println(o);
	}
	
	public static void errorPl(Object o) {
		System.err.println(o);
	}
	
	public static int pedirInt(String mensaje) {
		p(mensaje + ": ");
		return sc.nextInt();
	}
	
	public static Long pedirLong(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLong();
	}
	
	public static String pedirString(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine();
	}
	
	public static BigDecimal pedirBigDecimal(String mensaje) {
		p(mensaje + ": ");
		return sc.nextBigDecimal();
	}
}
