package com.gontzal.ipartek.uf1844.poo.ej3;

public class Libro {
	private String titulo;
	private String autor;
	private int ejemplares;
	private int prestados;
	
	public Libro() {
		
	}

	public Libro(String titulo, String autor, int ejemplares, int prestados) {
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplares = ejemplares;
		this.prestados = prestados;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	public int getPrestados() {
		return prestados;
	}

	public void setPrestados(int prestados) {
		this.prestados = prestados;
	}
	
	
	public boolean prestamo() {
		boolean prestamoCorrecto=true;
		
		if(prestados<ejemplares) {
			prestados++;
			ejemplares--;
		}
		else {
			prestamoCorrecto=false;
		}
		return prestamoCorrecto;
	}
	
	public boolean devolucion() {
		boolean devolucionCorrecta=true;
		
		if(prestados==0) {
			devolucionCorrecta=false;
			
		}else {
			prestados--;
			ejemplares++;
		}
		
		return devolucionCorrecta;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", ejemplares=" + ejemplares + ", prestados="
				+ prestados + "]";
	}
	
	
	
}
