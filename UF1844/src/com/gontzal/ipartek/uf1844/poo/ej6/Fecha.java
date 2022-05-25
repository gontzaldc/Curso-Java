package com.gontzal.ipartek.uf1844.poo.ej6;

import java.time.LocalDate;

public class Fecha {

	private int dia;
	private int mes;
	private int year;

	public Fecha() {

	}

	public Fecha(int dia, int mes, int year) {
		this.dia = dia;
		this.mes = mes;
		this.year = year;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, yearCorrecto;

		yearCorrecto = year > 0;

		mesCorrecto = mes >= 1 && mes <= 12;

		switch (mes) {

		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			diaCorrecto = dia >= 1 && dia <= 31;
			break;

		case 2:
			if (esBisiesto()) {
				diaCorrecto = dia >= 1 && dia <= 29;
			} else {
				diaCorrecto = dia >= 1 && dia <= 28;
			}
			break;

		default:
			diaCorrecto = dia >= 1 && dia <= 30;
		}

		return yearCorrecto && mesCorrecto && diaCorrecto;
	}

	public void diaSiguiente() {

		dia++;

		if (!fechaCorrecta()) {
			dia = 1;
			mes++;

			if (!fechaCorrecta()) {
				mes = 1;
				year++;
			}
		}

	}

	private boolean esBisiesto() {

		boolean esBisiesto = false;

		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			esBisiesto = true;
		}

		return esBisiesto;
	}

	@Override
	public String toString() {
		
		LocalDate date = LocalDate.of(year, mes, dia);
		
		return date.getDayOfMonth() +"-"+date.getMonthValue()+"-"+ date.getYear();
	}
	
	

}
