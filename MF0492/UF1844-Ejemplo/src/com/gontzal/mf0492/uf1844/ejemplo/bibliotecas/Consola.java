package com.gontzal.mf0492.uf1844.ejemplo.bibliotecas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

	public static Integer pedirInt(String mensaje) {

		boolean repetir = true;
		Integer i = null;
		String texto;
		do {

			try {
				texto = pedirString(mensaje);
				i = Integer.parseInt(texto);
				repetir = false;
			} catch (NumberFormatException ex) { // handle your exception
				errorPl("No es un número");
			}

		} while (repetir);

		return i;

	}

	public static Long pedirLong(String mensaje) {

		boolean repetir = true;
		Long l = null;
		String texto;
		do {

			try {
				texto = pedirString(mensaje);
				l = Long.parseLong(texto);
				repetir = false;
			} catch (NumberFormatException ex) { // handle your exception
				errorPl("No es un número");
			}

		} while (repetir);

		return l;

	}

	public static String pedirString(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine();
	}

	public static BigDecimal pedirBigDecimal(String mensaje) {

		boolean repetir = true;
		BigDecimal bg = null;
		String texto;
		do {

			try {
				texto = pedirString(mensaje);
				bg = new BigDecimal(texto);
				repetir = false;
			} catch (NumberFormatException ex) { // handle your exception
				errorPl("No es un número");
			}

		} while (repetir);

		return bg;

	}

	public static LocalDate pedirLocalDate(String mensaje) {

		boolean repetir = true;
		String texto;
		LocalDate ld = null;

		do {
			try {
				texto = pedirString(mensaje);

				if (texto == null || texto.trim().length() == 0) {
					return null;
				}

				ld = LocalDate.parse(texto);
				repetir = false;
			} catch (DateTimeParseException e) {
				pl("No es una fecha válida");
			}
		} while (repetir);

		return ld;
	}
}
