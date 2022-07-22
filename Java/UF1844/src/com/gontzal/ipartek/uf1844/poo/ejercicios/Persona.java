package com.gontzal.ipartek.uf1844.poo.ejercicios;

import java.util.Objects;

public class Persona {
	private static final int SOBREPESO = 1;

	private static final int PESO_BAJO = -1;

	private static final int PESO_IDEAL = 0;

	private static final char HOMBRE = 'H';

	private String nombre;
	private int edad;
	private String dni;
	private char sexo;
	private Double peso;
	private Double altura;

	public Persona() {
		this.sexo = HOMBRE;
	}

	public Persona(String nombre, int edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}

	public Persona(String nombre, int edad, char sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = generarDNI();
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public static char getHombre() {
		return HOMBRE;
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, dni, edad, nombre, peso, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& Objects.equals(dni, other.dni) && edad == other.edad && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso) && sexo == other.sexo;
	}

	public int calcularIMC() {

		int imc;
		Double resultado;

		resultado = peso / Math.pow(altura, 2);

		if (resultado < 20) {
			imc = PESO_IDEAL;
		} else if (20 >= resultado || resultado <= 25) {
			imc = PESO_BAJO;
		} else {
			imc = SOBREPESO;
		}

		return imc;

	}

	public boolean esMayorDeEdad() {

		boolean mayorDeEdad = true;
		if (edad < 18) {
			mayorDeEdad = false;
		}

		return mayorDeEdad;
	}

	public String generarDNI() {

		StringBuffer sb = new StringBuffer();
		int numero;

		for (int i = 0; i < 8; i++) {
			numero = (int) (Math.random() * 10 + 1);
			sb.append(numero);
		}

		sb.append(calcularLetra(Integer.parseInt(sb.toString())));
		return sb.toString();

	}

	private char calcularLetra(int numDNI) {
		char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };
		return letras[numDNI % 23];
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", sexo=" + sexo + ", peso=" + peso
				+ ", altura=" + altura + "]";
	}
	
	

}
