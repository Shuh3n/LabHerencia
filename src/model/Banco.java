package model;

import java.util.ArrayList;
import java.util.List;

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
    public Cuenta consultarCuenta(String num_Cuenta) {
        if(!listaCuentas.isEmpty()){
            for (int i = 0; i < listaCuentas.size(); i++) {
            	if(verificarCuenta(listaCuentas.get(i).getNumCuenta())){
                   return listaCuentas.get(i);
            	}
            }
        }

           return null;


    }

}
