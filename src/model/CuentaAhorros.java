package model;

import exceptions.CuentaException;

/**
 * Esta clase denominada CuentaAhorros modela una cuenta de ahorros
 * que es una subclase de Cuenta. Tiene un nuevo atributo: activa.
 * @version 1
 */
public class CuentaAhorros extends Cuenta {
	/* Atributo que identifica si una cuenta est� activa; lo est� si su saldo es superior a 10000 */
	private boolean activa;
	/**
	 * Constructor de la clase CuentaAhorros
	 * @param saldo Par�metro que define el saldo de la cuenta de ahorros
	 * @param tasa Par�metro que define la tasa anual de inter�s de la
	 * cuenta de ahorros
	 * @param numCuenta Parametro que define el numero de la cuenta
	 */
	public CuentaAhorros(float saldo, float tasa, String numCuenta) {
		super(saldo, tasa,numCuenta);
		if (saldo < 10000) /* Si el saldo es menor a 10000, la cuenta no se activa */
			activa = false;
		else
			activa = true;
	}
	/**
	 * M�todo que recibe una cantidad de dinero a retirar y actualiza el
	 * saldo de la cuenta
	 * @param saldo Par�metro que define la cantidad a retirar de una
	 * cuenta de ahorros
	 * @throws CuentaException
	 */
	public void retirar(float cantidad) throws CuentaException {
		 // Si la cuenta est� activa, se puede retirar dinero
		if (this.activa)
			/* Invoca al m�todo retirar de la clase padre */
			super.retirar(cantidad);
	}
	/**
	 * M�todo que recibe una cantidad de dinero a consignar y actualiza
	 * el saldo de la cuenta
	 * @param saldo Par�metro que define la cantidad a consignar en
	 * una cuenta de ahorros
	 */
	public void consignar(float cantidad) {
		 // Si la cuenta est� activa, se puede consignar dinero 200
		if (activa)
		/* Invoca al m�todo consignar dela clase padre */
			super.consignar(cantidad);
	}
	/**
	 * M�todo que genera el extracto mensual de una cuenta de ahorros
	 */
	public void extractoMensual() {
		/* Si la cantidad de retiros es superior a cuatro, se genera una comisi�n mensual */
		if (n�meroRetiros > 4) {
			comisi�nMensual += (n�meroRetiros - 4) * 1000;
		}
		super.extractoMensual(); // Invoca al m�todo de la clase padre /* Si el saldo actualizado de la cuenta es menor a 10000, la cuenta no se activa */
		if ( saldo < 10000 )
			activa = false;
	}
	/**
	 * M�todo que muestra en pantalla los datos de una cuenta de ahorros
	 */
	public void imprimir() {
		System.out.println("Saldo = $ " + saldo);
		System.out.println("Comisi�n mensual = $ " + comisi�nMensual);
		System.out.println("N�mero de transacciones = "+ (n�meroConsignaciones + n�meroRetiros));
		System.out.println();
	}
}