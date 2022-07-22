package com.gontzal.ipartek.uf1844.poo.ej2;

import java.util.Scanner;

public class contadorPrueba {
	public static void main(String[] args) {
		Contador cont = new Contador(5);

		System.out.println("El contador comienza en 5");

		cont.decrementar();
		System.out.println("Decrementar contador: " + cont.getContador());

		cont.incrementar();
		System.out.println("incrementar contador: " + cont.getContador());

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un valor apara un contador");
		int cantidad = Integer.valueOf(sc.nextLine());

		Contador cont2 = new Contador(cantidad);

		System.out.println("EL contador se inicializa en " + cont2.getContador());

		int opcion;

		do {
			System.out.println("1-. Incrementar");
			System.out.println("2-. Decrementar");

			opcion = Integer.valueOf(sc.nextLine());

			switch (opcion) {
			case 1:
				cont2.incrementar();
				break;

			case 2:
				cont2.decrementar();
				break;
				
			case 0:
				opcion=0;
				break;
				
			default:
				System.out.println("Número mal introducido");
				break;
			}
			

			System.out.println("El contador va en " + cont2.getContador());
		} while (opcion != 0);
		
		sc.close();
	}
}
