package com.gontzal.ipartek.uf1844;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ficheros {
	private static final boolean APPEND = true;
	private static final String CARPETA = "ficheros/";
	private static final String FICHERO = CARPETA + "fichero.txt";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion;
		boolean menu = true;
		do {

			System.out.println("Menú\n" + "1-. Crear fichero (fichero.txt)\n"
					+ "2-. Escribir en fichero (fichero.txt)\n" + "3-. Leer fichero (fichero.txt)\n"
					+ "4-. Crear fichero desde consola\n" + "5-. Borrar fichero\n" + "0-. Terminar programa");

			opcion = Integer.valueOf(sc.nextLine());

			switch (opcion) {

			case 0:
				menu = false;
				break;
				
			case 1:
				crearFichero();
				break;

			case 2:
				escribirEnFicheroConsola();
				break;

			case 3:
				leerFichero();
				break;

			case 4:
				crearficheroConsola();
				break;

			case 5:
				borrarFichero();
				break;
			}

		} while (menu);

		sc.close();
//		NO FUNCIONA
//		borrarFichero();

//		crearFichero();
//		escribirEnFicheroConsola();
//		leerFichero();
//		crearficheroConsola();

	}

	private static void borrarFichero() {
		Scanner sc = new Scanner(System.in);

		// No funciona borrar fichero
		System.out.print("Indica el nombre del fichero que quieres borrar");

		String nombreFichero = CARPETA + sc.nextLine() + ".txt";

		File fichero = new File(nombreFichero);

		if (fichero.exists()) {
			fichero.deleteOnExit();
			System.out.println("El fichero " + nombreFichero + " se ha borrado con exito");
		} else {
			System.out.println("No existe un fichero con el nombre: " + nombreFichero);
		}
		sc.close();
	}

	private static void crearficheroConsola() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nombre del archivo que quieres crear: ");

		String nombreFichero = sc.nextLine();

		try (FileWriter fw = new FileWriter(CARPETA + nombreFichero + ".txt", APPEND)) {
			fw.close();
		} catch (IOException e) {
			System.out.println("Ha habido un error al crear el archivo");
		}

		sc.close();
	}

	private static void escribirEnFicheroConsola() {
		try (FileWriter fw = new FileWriter(FICHERO, APPEND);
				PrintWriter pw = new PrintWriter(fw);
				Scanner sc = new Scanner(System.in)) {
			System.out.println("Escribe aquí para añadir en el fichero: ");

			pw.println(sc.nextLine());

		} catch (IOException e) {
			System.out.println("error");
		}
	}

	private static void leerFichero() {
		try (FileReader fr = new FileReader(FICHERO); Scanner sc = new Scanner(fr)) {
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
		} catch (IOException e) {
			System.out.println("Ha habido un error al leer el archivo");
		}
	}

	private static void crearFichero() {

		File carpeta = new File(CARPETA);

		// Si la carpeta no existe crearla
		if (!carpeta.exists()) {
			carpeta.mkdir();
		}

		try (// Si el archivo existe añade debajo , si no lo crea (APPEND es una constante
				// que es true)
				FileWriter fw = new FileWriter(FICHERO, APPEND);
				PrintWriter pw = new PrintWriter(fw)) {
			pw.println("Este es un texto creado desde el programa");

		} catch (IOException e) {
			System.out.println("ha habido un error al crear el fichero");
		}
	}
}
