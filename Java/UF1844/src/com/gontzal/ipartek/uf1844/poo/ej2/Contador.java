package com.gontzal.ipartek.uf1844.poo.ej2;

public class Contador {

	private int contador;

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		if (contador <= 0) {
			this.contador = 0;
		} else {
			this.contador = contador;
		}
	}

	public Contador(int contador) {
		if (contador < 0) {
			this.contador = 0;
		} else {
			this.contador = contador;
		}
	}

	public Contador() {
	}

	public void incrementar() {
		contador++;
	}

	public void decrementar() {
		contador--;
		if (contador < 0) {
			contador = 0;
		}
	}

}
