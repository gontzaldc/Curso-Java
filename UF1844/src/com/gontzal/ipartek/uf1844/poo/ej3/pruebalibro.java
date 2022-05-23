package com.gontzal.ipartek.uf1844.poo.ej3;

import java.util.Scanner;

public class pruebalibro {
	public static void main(String[] args) {
	
		Scanner sc= new Scanner(System.in);
		
		String titulo, autor;
		int ejemplares;
		
		System.out.print("introduce el título del libro: ");
		titulo=sc.nextLine();
		System.out.println();
		
		System.out.print("Introduce el autor del libro: ");
		autor= sc.nextLine();
		System.out.println();
		
		System.out.print("Introduce la cantidad de ejemplares: ");
		ejemplares= Integer.valueOf(sc.nextLine());
		System.out.println();
		
		Libro lib1 = new Libro(titulo,autor,ejemplares,0);
		
		System.out.println("Título: "+lib1.getTitulo());
		System.out.println("Autor: "+lib1.getAutor());
		System.out.println("Ejemplares: "+lib1.getEjemplares());
		
		System.out.println("prestar un libro");
		 if (lib1.prestamo()) {
	            System.out.println("Se ha prestado el libro " + lib1.getTitulo());
	        } else {
	            System.out.println("No quedan ejemplares del libro " + lib1.getTitulo() + " para prestar");         
	        }
		
		
		
		System.out.println("Devolver un libro");
		if (lib1.devolucion()) {
            System.out.println("Se ha devuelto el libro " + lib1.getTitulo());
        } else {
            System.out.println("No hay ejemplares del libro " + lib1.getTitulo() + " prestados");
        }
		
		
		System.out.println("Devolver un libro sin ejemplares prestados");
		if (lib1.devolucion()) {
            System.out.println("Se ha devuelto el libro " + lib1.getTitulo());
        } else {
            System.out.println("No hay ejemplares del libro " + lib1.getTitulo() + " prestados");
        }
	}
}
