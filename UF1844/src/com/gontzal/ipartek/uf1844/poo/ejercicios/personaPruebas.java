package com.gontzal.ipartek.uf1844.poo.ejercicios;

import java.util.Scanner;

public class personaPruebas {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String nombre;
		char sexo;
		int edad;
		Double peso, altura;

		System.out.print("Nombre: ");
		nombre = sc.nextLine();

		System.out.print("Edad: ");
		edad = Integer.parseInt(sc.nextLine());

		System.out.print("Sexo (H o M): ");
		sexo = sc.nextLine().trim().charAt(0);

		System.out.print("Peso(Kg): ");
		peso = Double.parseDouble(sc.nextLine());

		System.out.print("Altura(m): ");
		altura = Double.parseDouble(sc.nextLine());

		Persona per1 = new Persona(nombre, edad, sexo, peso, altura);

		Persona per2 = new Persona(nombre, edad, sexo);

		Persona per3 = new Persona();

		int imc = per1.calcularIMC();
		boolean mayor= per1.esMayorDeEdad();

		System.out.println("--- " + per1.getNombre().toUpperCase() + " ---");
		System.out.println("Tú peso esta en: " + (imc > 0 ? "SOBREPESO" : imc < 0 ? "PESO BAJO" : "PESO IDEAL"));
		System.out.println(mayor?"Mayor de edad":"Menor de edad");
		System.out.println(per1);
	}
}
