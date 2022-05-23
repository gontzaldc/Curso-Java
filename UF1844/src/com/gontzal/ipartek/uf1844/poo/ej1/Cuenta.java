package com.gontzal.ipartek.uf1844.poo.ej1;

public class Cuenta {
	private String nombre;
	private String numCuenta;
	private double interes;
	private double saldo;

	public Cuenta(String nombre, String numCuenta, double interes, double saldo) {
		this.nombre = nombre;
		this.numCuenta = numCuenta;
		this.interes = interes;
		this.saldo = saldo;
	}

	public Cuenta() {

	}

	public Cuenta(Cuenta cuenta) {
		this(cuenta.getNombre(), cuenta.getNumCuenta(), cuenta.getInteres(), cuenta.getSaldo());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean ingreso(double cantidad) {

		boolean ingresoCorrecto = true;
		if (cantidad <= 0) {
			ingresoCorrecto = false;
		} else {
			this.saldo += cantidad;
		}
		return ingresoCorrecto;
	}

	public boolean reintegro(double cantidad) {
		boolean reintegroCorrecto = true;

		if (this.saldo < cantidad || cantidad <= 0) {
			reintegroCorrecto = false;
		} else {
			this.saldo -= cantidad;
		}
		return reintegroCorrecto;
	}

	public boolean transferencia(Cuenta c, double cantidad) {
		boolean transferenciaCorrecta = true;

		if (this.saldo < cantidad) {
			transferenciaCorrecta = false;
		} else {
			reintegro(cantidad);
			c.ingreso(cantidad);
		}
		return transferenciaCorrecta;
	}

}
