package com.gontzal.ipartek.uf1844;

import java.math.BigDecimal;
import java.util.Scanner;

public class ejerciciospruebas {
	public static void main(String[] args) {

//		parimpar();
//		calculadora();
//		areas();

	}

	@SuppressWarnings("unused")
	private static void parimpar() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un número: ");
		
		int num= Integer.parseInt(sc.nextLine());
		
		System.out.println(num % 2 == 0 ? "EL NÚMERO "+num+" ES PAR":"EL NÚMERO "+num+" ES IMPAR");
		
		sc.close();
		
	}

	//Ejercicio AREAS
	
	@SuppressWarnings("unused")
	private static void areas() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el poligono");
		System.out.println("1. Triangulo");
		System.out.println("2. Cuadrado");
		System.out.println("3. Rectangulo");
		System.out.println("4. Circulo");

		int opcionPoligono = Integer.parseInt(sc.nextLine());
		switch (opcionPoligono) {

		case 1:

			System.out.print("Introduce la base del triangulo: ");
			BigDecimal base = new BigDecimal(sc.nextLine());

			System.out.print("Introduce la altura del triangulo: ");
			BigDecimal altura = new BigDecimal(sc.nextLine());

			System.out.println("Area de Triangulo: " + base.multiply(altura).divide(BigDecimal.valueOf(2)));

			break;

		case 2:

			System.out.print("Introduce el lado del Cuadrado: ");
			BigDecimal lado = new BigDecimal(sc.nextLine());

			System.out.println("Area del Cuadrado: " + lado.multiply(lado));

			break;

		case 3:

			System.out.print("Introduce la base del Rectangulo: ");
			BigDecimal baseRectangulo = new BigDecimal(sc.nextLine());

			System.out.print("Introduce la altura del Rectangulo: ");
			BigDecimal alturaRectangulo = new BigDecimal(sc.nextLine());

			System.out.println("Area del rectangulo: " + baseRectangulo.multiply(alturaRectangulo));

			break;

		case 4:

			System.out.print("Introduce el radio del Circulo: ");
			BigDecimal radio = new BigDecimal(sc.nextLine());

			System.out.println(Math.pow(Math.PI, 2));
			System.out.println("El area del Circulo: " + BigDecimal.valueOf(Math.PI).multiply(radio.pow(2)));
			break;
		}
		
		sc.close();

	}
	
	// Ejercicio CALCULADORA

	@SuppressWarnings("unused")
	private static void calculadora() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Escribe un número ");

		int num1 = Integer.parseInt(sc.nextLine());

		System.out.println("1. Sumar");
		System.out.println("2. Restar");
		System.out.println("3. Multiplicar");
		System.out.println("4. Dividir");

		int opcion = Integer.parseInt(sc.nextLine());
		String operador = "";
		switch (opcion) {
		case 1:
			operador = "Sumar";
			break;

		case 2:
			operador = "Restar";
			break;

		case 3:
			operador = "Multiplicar";
			break;

		case 4:
			operador = "Dividir";
			break;

		default:
			System.out.println("Opción no valida");
		}

		System.out.print("Escribe otro número");

		int num2 = Integer.parseInt(sc.nextLine());

		int resultado = 0;
		switch (operador) {
		case "Sumar":
			resultado = num1 + num2;
			break;

		case "Restar":
			resultado = num1 - num2;
			break;

		case "Multiplicar":
			resultado = num1 * num2;
			break;

		case "Dividir":
			resultado = num1 / num2;
			break;

		default:
			System.out.println("No reconocida");
		}

		System.out.println("Resultado = " + resultado);
		sc.close();
	}
}
