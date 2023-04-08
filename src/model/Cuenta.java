package model;

import exceptions.CuentaException;

/**
 * Esta clase denominada Cuenta modela una cuenta bancaria con los
 * atributos saldo, n�mero de consignaciones, n�mero de retiros, tasa
 * anual de inter�s y comisi�n mensual.
 * @version 1
 */
public abstract class Cuenta {

	/* Atributo que define el sueldo de una cuenta bancaria*/
	protected float saldo;
	/* Atributo que define el n�mero de consignaciones realizadas en
	una cuenta bancaria */
	protected int n�meroConsignaciones = 0;
	// Atributo que define el n�mero de retiros de una cuenta bancaria
	protected int n�meroRetiros = 0;
	// Atributo que define la tasa anual de intereses de una cuenta bancaria
	protected float tasaAnual;
	/* Atributo que define la comisi�n mensual que se cobra a una
	cuenta bancaria */
	protected float comisi�nMensual = 0;

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	protected String numCuenta;



	/**
	 * Constructor de la clase Cuenta
	 * @param saldo Par�metro que define el saldo de la cuenta
	 * @param tasaAnual Par�metro que define la tasa anual de inter�s de
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

	public int getN�meroConsignaciones() {
		return n�meroConsignaciones;
	}

	public void setN�meroConsignaciones(int n�meroConsignaciones) {
		this.n�meroConsignaciones = n�meroConsignaciones;
	}

	public int getN�meroRetiros() {
		return n�meroRetiros;
	}

	public void setN�meroRetiros(int n�meroRetiros) {
		this.n�meroRetiros = n�meroRetiros;
	}

	public float getTasaAnual() {
		return tasaAnual;
	}

	public void setTasaAnual(float tasaAnual) {
		this.tasaAnual = tasaAnual;
	}

	public float getComisi�nMensual() {
		return comisi�nMensual;
	}

	public void setComisi�nMensual(float comisi�nMensual) {
		this.comisi�nMensual = comisi�nMensual;
	}

	/**
	 * M�todo que recibe una cantidad de dinero a consignar y actualiza
	 * el saldo de la cuenta
	 * @param saldo Par�metro que define la cantidad de dinero a
	 * consignar en la cuenta
	 */


	public void consignar(float cantidad) {
		saldo +=cantidad;
		n�meroConsignaciones ++;
	}
	/**
	 * M�todo que recibe una cantidad de dinero a retirar y actualiza el
	 * saldo de la cuenta
	 * @param saldo Par�metro que define la cantidad de dinero a retirar
	 * de la cuenta
	198 Ejercicios de programaci�n orientada a objetos con Java y UML
	 * @throws CuentaException
	 */
	public boolean retirar(float cantidad)  {
		boolean flag = false;
		float nuevoSaldo = saldo - cantidad;
		/* Si la cantidad a retirar no supera el saldo, el retiro no se puede realizar */
		if (nuevoSaldo >= 0) {
			saldo -= cantidad;
			n�meroRetiros ++;
			flag = true;


		}
		return flag;

	}
	/**
	 * M�todo que calcula inter�s mensual de la cuenta a partir de la tasa
	 * anual aplicada
	 */
	public void calcularInter�s() {
		float tasaMensual = tasaAnual / 12; /* Convierte la tasa anual en mensual */
		float interesMensual = saldo * tasaMensual;
		saldo += interesMensual; /* Actualiza el saldo aplicando el inter�s 	mensual */
	}
	/**
	 * M�todo que genera un extracto aplicando al saldo actual una
	 * comisi�n y calculando sus intereses
	 */
	public void extractoMensual() {
		saldo -= comisi�nMensual;
		calcularInter�s();
	}

	@Override
	public String toString() {
		return "Saldo: " + saldo +
				"\nN�mero de Consignaciones: " + n�meroConsignaciones +
				"\nN�mero de Retiros: " + n�meroRetiros +
				"\nTasa Anual: " + tasaAnual +
				"\nComisi�n Mensual: " + comisi�nMensual +
				"\nN�mero de Cuenta: " + numCuenta;

	}







}