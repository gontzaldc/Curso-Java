package com.gontzal.ipartek.uf1844;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class ahorcado {
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce una palabra para adivinar: ");

		String[] palabra = sc.nextLine().split("");
		String intento;

		for (int i = 0; i < palabra.length; i++) {
			System.out.print("_ ");
		}

		do {
			System.out.println("Introduce palabra para adivinar: ");
			intento = sc.nextLine();

		} while (comprobarpalabra(intento, palabra));

		sc.close();

	}

	private static Boolean comprobarpalabra(String intento, String[] palabra) {

		String[] Arr = intento.split("");

		System.out.println();
		if (intento.length() == palabra.length) {
			for (int i = 0; i < palabra.length; i++) {

				if (Arr[i].equals(palabra[i])) {
					System.out.print(Arr[i] + " ");
				} else {
					System.out.print("_ ");
				}
			}
		}

		System.out.println();
		if (intento.equals(String.join("", palabra))) {
			System.out.println("¡¡¡Has acertado!!!");
			return false;
		}

		System.out.println();
		return true;
	}
}
