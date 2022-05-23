package com.gontzal.ipartek.uf1844.poo.ej4;

public class Fraccion {
	int num;
	int den;

	public Fraccion(int num, int den) {

		this.num = num;
		if (den == 0) {
			this.den = 1;
		} else {
			this.den = den;
		}
	}

	public Fraccion() {
		this.num = 0;
		this.den = 1;
	}

	public Fraccion(int num) {
		this.num = num;
		this.den = 1;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDen() {
		return den;
	}

	public void setDen(int den) {
		this.den = den;
	}

	public Fraccion sumar(Fraccion f) {
		Fraccion resultado = new Fraccion();
		resultado.num = this.num * f.den + this.den * f.num;
		resultado.den = this.den * f.den;

		resultado.simplificar();

		return resultado;

	}

	public Fraccion restar(Fraccion f) {
		Fraccion resultado = new Fraccion();
		resultado.num = this.num * f.den - this.den * f.num;
		resultado.den = this.den * f.den;

		resultado.simplificar();

		return resultado;
	}
	
	public Fraccion multiplicar(Fraccion f) {
		Fraccion resultado = new Fraccion();
		
		resultado.num=this.num * f.num;
		resultado.den= this.den*f.den;
		
		resultado.simplificar();
		return resultado;
	}
	
	public Fraccion dividir(Fraccion f) {
		Fraccion resultado = new Fraccion();
		
		resultado.num=this.num * f.den;
		resultado.den= this.den*f.num;
		
		resultado.simplificar();
		return resultado;
	}

	private int mcd() {
		int u = Math.abs(num); // valor absoluto del numerador
		int v = Math.abs(den); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	private void simplificar() {
		int n = mcd(); // se calcula el mcd de la fracción
		num = num / n;
		den = den / n;
	}

	@Override
	public String toString() {
		return num + "/" + den;
	}
}
