package com.gontzal.ipartek.uf1844;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ahorcado {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce una palabra para adivinar: ");

		List<String> palabra = new ArrayList<String>();

		for (String letra : sc.nextLine().split("")) {

			palabra.add(letra);
		}

		String intento;

		for (int i = 0; i < palabra.size(); i++) {
			System.out.print("_ ");
		}

		do {
			System.out.println("Introduce palabra para adivinar: ");
			intento = sc.nextLine();

		} while (comprobarpalabra(intento, palabra));

		sc.close();

	}

	private static Boolean comprobarpalabra(String intento, List<String> palabra) {

		String[] Arr = intento.split("");

		System.out.println();
		if (intento.length() == palabra.size()) {
			for (int i = 0; i < palabra.size(); i++) {

				if (Arr[i].equals(palabra.get(i))) {
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
