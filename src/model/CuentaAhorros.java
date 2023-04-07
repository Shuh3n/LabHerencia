package model;

import exceptions.CuentaException;

/**
 * Esta clase denominada CuentaAhorros modela una cuenta de ahorros
 * que es una subclase de Cuenta. Tiene un nuevo atributo: activa.
 * @version 1
 */
public class CuentaAhorros extends Cuenta {
	/* Atributo que identifica si una cuenta está activa; lo está si su saldo es superior a 10000 */
	private boolean activa;
	/**
	 * Constructor de la clase CuentaAhorros
	 * @param saldo Parámetro que define el saldo de la cuenta de ahorros
	 * @param tasa Parámetro que define la tasa anual de interés de la
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
	 * Método que recibe una cantidad de dinero a retirar y actualiza el
	 * saldo de la cuenta
	 * @param saldo Parámetro que define la cantidad a retirar de una
	 * cuenta de ahorros
	 * @throws CuentaException
	 */
	public void retirar(float cantidad) throws CuentaException {
		 // Si la cuenta está activa, se puede retirar dinero
		if (this.activa)
			/* Invoca al método retirar de la clase padre */
			super.retirar(cantidad);
	}
	/**
	 * Método que recibe una cantidad de dinero a consignar y actualiza
	 * el saldo de la cuenta
	 * @param saldo Parámetro que define la cantidad a consignar en
	 * una cuenta de ahorros
	 */
	public void consignar(float cantidad) {
		 // Si la cuenta está activa, se puede consignar dinero 200
		if (activa)
		/* Invoca al método consignar dela clase padre */
			super.consignar(cantidad);
	}
	/**
	 * Método que genera el extracto mensual de una cuenta de ahorros
	 */
	public void extractoMensual() {
		/* Si la cantidad de retiros es superior a cuatro, se genera una comisión mensual */
		if (númeroRetiros > 4) {
			comisiónMensual += (númeroRetiros - 4) * 1000;
		}
		super.extractoMensual(); // Invoca al método de la clase padre /* Si el saldo actualizado de la cuenta es menor a 10000, la cuenta no se activa */
		if ( saldo < 10000 )
			activa = false;
	}
	/**
	 * Método que muestra en pantalla los datos de una cuenta de ahorros
	 */
	public void imprimir() {
		System.out.println("Saldo = $ " + saldo);
		System.out.println("Comisión mensual = $ " + comisiónMensual);
		System.out.println("Número de transacciones = "+ (númeroConsignaciones + númeroRetiros));
		System.out.println();
	}
}