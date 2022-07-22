package com.gontzal.ipartek.uf1844.poo.ej5;

public class Complejos {

	double num1;
	double num2;

	public Complejos(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public Complejos() {

	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public Complejos sumar(Complejos c) {

		Complejos resultado = new Complejos();

		resultado.num1 = num1 + c.num1;
		resultado.num2 = num2 + c.num2;

		return resultado;
	}

	public Complejos restar(Complejos c) {

		Complejos resultado = new Complejos();

		resultado.num1 = num1 - c.num1;
		resultado.num2 = num2 - c.num2;

		return resultado;

	}

	public Complejos multiplicar(Complejos c) {

		Complejos resultado = new Complejos();

		resultado.num1 = (num1 * c.num1) - (num2 * c.num2);
		resultado.num2 = (num1 * c.num2) + (num2 * c.num1);

		return resultado;
	}

	public Complejos dividir(Complejos c) {
		
		Complejos resultado = new Complejos();
		
		resultado.num1=((num1*c.num1)+(num2*c.num2)) / (Math.pow(c.num1, 2) + Math.pow(c.num2, 2));
		resultado.num2=((num2*c.num1)+(num1*c.num2)) / (Math.pow(c.num1, 2) + Math.pow(c.num2, 2));
		
		return resultado;
	}

	@Override
	public String toString() {
		return "( " + num1 + " , " + num2 + " )";
	}

}
