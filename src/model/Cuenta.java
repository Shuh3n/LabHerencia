package model;

import exceptions.CuentaException;

/**
 * Esta clase denominada Cuenta modela una cuenta bancaria con los
 * atributos saldo, número de consignaciones, número de retiros, tasa
 * anual de interés y comisión mensual.
 * @version 1
 */
public abstract class Cuenta {

	/* Atributo que define el sueldo de una cuenta bancaria*/
	protected float saldo;
	/* Atributo que define el número de consignaciones realizadas en
	una cuenta bancaria */
	protected int númeroConsignaciones = 0;
	// Atributo que define el número de retiros de una cuenta bancaria
	protected int númeroRetiros = 0;
	// Atributo que define la tasa anual de intereses de una cuenta bancaria
	protected float tasaAnual;
	/* Atributo que define la comisión mensual que se cobra a una
	cuenta bancaria */
	protected float comisiónMensual = 0;

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	protected String numCuenta;



	/**
	 * Constructor de la clase Cuenta
	 * @param saldo Parámetro que define el saldo de la cuenta
	 * @param tasaAnual Parámetro que define la tasa anual de interés de
	 * la cuenta
	 */
	public Cuenta(float saldo, float tasaAnual, String numCuenta) {
		this.saldo = saldo;
		this.tasaAnual = tasaAnual;
		this.numCuenta= numCuenta;
	}




	public Cuenta() {
		super();
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getNúmeroConsignaciones() {
		return númeroConsignaciones;
	}

	public void setNúmeroConsignaciones(int númeroConsignaciones) {
		this.númeroConsignaciones = númeroConsignaciones;
	}

	public int getNúmeroRetiros() {
		return númeroRetiros;
	}

	public void setNúmeroRetiros(int númeroRetiros) {
		this.númeroRetiros = númeroRetiros;
	}

	public float getTasaAnual() {
		return tasaAnual;
	}

	public void setTasaAnual(float tasaAnual) {
		this.tasaAnual = tasaAnual;
	}

	public float getComisiónMensual() {
		return comisiónMensual;
	}

	public void setComisiónMensual(float comisiónMensual) {
		this.comisiónMensual = comisiónMensual;
	}

	/**
	 * Método que recibe una cantidad de dinero a consignar y actualiza
	 * el saldo de la cuenta
	 * @param saldo Parámetro que define la cantidad de dinero a
	 * consignar en la cuenta
	 */


	public void consignar(float cantidad) {
		saldo +=cantidad;
		númeroConsignaciones ++;
	}
	/**
	 * Método que recibe una cantidad de dinero a retirar y actualiza el
	 * saldo de la cuenta
	 * @param saldo Parámetro que define la cantidad de dinero a retirar
	 * de la cuenta
	198 Ejercicios de programación orientada a objetos con Java y UML
	 * @throws CuentaException
	 */
	public boolean retirar(float cantidad)  {
		boolean flag = false;
		float nuevoSaldo = saldo - cantidad;
		/* Si la cantidad a retirar no supera el saldo, el retiro no se puede realizar */
		if (nuevoSaldo >= 0) {
			saldo -= cantidad;
			númeroRetiros ++;
			flag = true;


		}
		return flag;

	}
	/**
	 * Método que calcula interés mensual de la cuenta a partir de la tasa
	 * anual aplicada
	 */
	public void calcularInterés() {
		float tasaMensual = tasaAnual / 12; /* Convierte la tasa anual en mensual */
		float interesMensual = saldo * tasaMensual;
		saldo += interesMensual; /* Actualiza el saldo aplicando el interés 	mensual */
	}
	/**
	 * Método que genera un extracto aplicando al saldo actual una
	 * comisión y calculando sus intereses
	 */
	public void extractoMensual() {
		saldo -= comisiónMensual;
		calcularInterés();
	}

	@Override
	public String toString() {
		return "Saldo: " + saldo +
				"\nNúmero de Consignaciones: " + númeroConsignaciones +
				"\nNúmero de Retiros: " + númeroRetiros +
				"\nTasa Anual: " + tasaAnual +
				"\nComisión Mensual: " + comisiónMensual +
				"\nNúmero de Cuenta: " + numCuenta;

	}







}