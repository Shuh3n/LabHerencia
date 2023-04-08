package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.CuentaException;

public class Banco {

	List<Cuenta> listaCuentas = new ArrayList<Cuenta>();

	public Banco(){

	}

	public Banco(List<Cuenta> listaCuentas) {
		super();
		this.listaCuentas = listaCuentas;
	}

	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}

	/**
	 * Se verefica si la cuenta esta en la lista
	 * @param numCuenta
	 * @return
	 */
	public boolean verificarCuenta(String numCuenta){
		boolean encontrado= false;
		for (Cuenta cuenta : listaCuentas) {
			if(cuenta.getNumCuenta().equals(numCuenta)){
				encontrado= true;
				return encontrado;
			}
		}

		return encontrado;
	}
	/**
	 * Se revisa que la lista no este vacia, luego se revisa si la cuenta en la lista tiene el mismo
	 * numero de cuenta, para devolver esta cuenta
	 * @param num_Cuenta
	 * @return
	 */
    public CuentaAhorros consultarCuenta(String numCuenta) {

        if(verificarCuenta(numCuenta)){
            for (int i = 0; i < listaCuentas.size(); i++) {
            	if(listaCuentas.get(i).getNumCuenta().equals(numCuenta)){
                   return (CuentaAhorros)listaCuentas.get(i);
            	}
            }
        }

        return null;


    }
    public CuentaCorriente consultarCuentaCorriente(String numCuenta) {

        if(verificarCuenta(numCuenta)){
            for (int i = 0; i < listaCuentas.size(); i++) {
            	if(listaCuentas.get(i).getNumCuenta().equals(numCuenta)){
                   return (CuentaCorriente)listaCuentas.get(i);
            	}
            }
        }

        return null;


    }
    public boolean crearCuenta(String numCuenta, float saldo, float tasaAnual){

    	if(!verificarCuenta(numCuenta)){
    		Cuenta cuenta = new CuentaAhorros(saldo, tasaAnual, numCuenta);
    		listaCuentas.add(cuenta);
    		return true;
    	}
		return false;


    }
    public boolean crearCuentaCorriente(String numCuenta, float saldo, float tasaAnual){

    	if(!verificarCuenta(numCuenta)){
    		Cuenta cuenta = new CuentaCorriente(saldo, tasaAnual, numCuenta);
    		listaCuentas.add(cuenta);
    		return true;
    	}
		return false;


    }

	public boolean consignarAhorro(String numCuentaConsignar, float numSaldoConsignar) throws CuentaException {
		 CuentaAhorros cuenta= new CuentaAhorros();
		 boolean flag = false;
	        cuenta= (CuentaAhorros) consultarCuenta(numCuentaConsignar);
	        if(cuenta!=null){
	            cuenta.consignar(numSaldoConsignar);
	            flag= true;
	        }
	        return flag;

	}

	public boolean retirarAhorro(String numCuentaretirar, float saldoRetiro) {
		boolean flag = false;
        CuentaAhorros cuenta= new CuentaAhorros();
        cuenta= (CuentaAhorros) consultarCuenta(numCuentaretirar);
        if(cuenta!=null){
            flag = cuenta.retirar(saldoRetiro);
        }
        return flag;
    }

	public boolean consignarCorriente(String txtnumCuenta, float numSaldoConsignar) {
		CuentaCorriente cuenta= new CuentaCorriente();
		 boolean flag = false;
	        cuenta= (CuentaCorriente) consultarCuentaCorriente(txtnumCuenta);
	        if(cuenta!=null){
	            cuenta.consignar(numSaldoConsignar);
	            flag= true;
	        }
	        return flag;

	}






}
