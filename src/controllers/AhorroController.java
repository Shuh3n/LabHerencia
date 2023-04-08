package controllers;

import java.net.URL;

import java.util.ResourceBundle;

import application.Aplicacion;
import exceptions.CuentaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CuentaAhorros;


public class AhorroController implements Initializable{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtNuevoSaldoConsignacion;

	@FXML
	private TextField txtSaldoRetiro;

	@FXML
	private TextField txtNumCuenta;

	@FXML
	private Button btnNuevaCuentaAhorro;

	@FXML
	private TextField txtNuevoSaldoRetiro;

	@FXML
	private Button btnAgregarCuentaAhorro;

	@FXML
	private TextField txtTasaAnual;

	@FXML
	private TextField txtCuentaRetirar;

	@FXML
	private TextField txtSaldoConsignar;

	@FXML
	private TextField txtInfoTasaAnual;


	@FXML
	private Button btnRetirarCorriente;

	@FXML
	private TextField txtSaldo;

	@FXML
	private Button btnConsignarCorriente;

	@FXML
	private Button btnBack;

	@FXML
	private Button btnInfoLimpiar;

	@FXML
    private TextField txtInfoEstadoCuenta;

	@FXML
    private Button btnConsultar2;

	@FXML
	private Button btnLimpiarInfoRetiro;

	@FXML
	private Button btnLimpiarConsignar;


	@FXML
	private TextField txtInfoNumRetiros;

	@FXML
	private TextField txtInfoNumconsignaciones;

	@FXML
    private TextField txtInfoSaldo;

    @FXML
    private TextField txtInfoNumCuenta;

    @FXML
    private TextField txtInfoComisionMensual;

	@FXML
	private TextField txtCuentaConsignar;

	private Stage stage;

	private BancoController controllerBanco;

	private Aplicacion aplicacion;



	@FXML
	void showVentanaPrincipal(ActionEvent event) {
		controllerBanco.show();
		stage.close();
	}

	@FXML
	void nuevaAhorro(ActionEvent event) {
		txtNumCuenta.setText("");
		txtSaldo.setText("");
		txtTasaAnual.setText("");
	}

	@FXML
	void agregarAhorro(ActionEvent event) throws Exception {
		String numCuenta = txtNumCuenta.getText();
		String txtsaldo = txtSaldo.getText();
		String txttasaAnual = txtTasaAnual.getText();

		if (validarDatos(numCuenta, txtsaldo, txttasaAnual)) {

			float saldo = convertirAFloat(txtsaldo);
			float tasaAnual = convertirAFloat(txttasaAnual);

			crearAhorro(numCuenta, saldo, tasaAnual);
			txtNumCuenta.setText("");
			txtSaldo.setText("");
			txtTasaAnual.setText("");

		}

	}

	private float convertirAFloat(String numero) {
		return Float.parseFloat(numero);
	}

	private void crearAhorro(String numCuenta, float saldo, float tasaAnual) throws Exception {

		if (aplicacion.crearCuentaAhorro(numCuenta, saldo, tasaAnual)) {
			mostrarMensaje("Notificación cuenta", "Cuenta Ahorros", "Cuenta creada con éxito", AlertType.INFORMATION);
		}

		else{
			mostrarMensaje("Notificación cuenta", "Cuenta no creada", "La cuenta no ha sido creada", AlertType.INFORMATION);
		}

	}

	/**
	 * Metodo que sirve para verificar si la uinformacion de la cuenta es
	 * correcta, es decir que no es
	 *
	 * @param numCuenta
	 * @param saldo
	 * @param tasaAnual
	 * @return
	 */
	private boolean validarDatos(String numCuenta, String saldo, String tasaAnual) {
		String notificacion = "";

		if (numCuenta == null || numCuenta.equals("")) {
			notificacion += "Número de la cuenta inválido\n";
		}

		/*Se valida que el saldo ingresado no sea null ni sea cadena vacía,
		además se valida que sea numérico para su correcta conversión */
		if (saldo == null || saldo.equals("")) {
			notificacion += "Saldo inválido\n";
		} else if(!esNumero(saldo)){
			notificacion += "El saldo ingresado debe ser numérico\n";
		}

		/*Se valida que la tasa anual ingresada no sea null ni sea cadena vacía,
		además se valida que sea numérico para su correcta conversión */
		if (tasaAnual == null || tasaAnual.equals("")) {
			notificacion += "Tasa anual inválida\n";
		} else if (!esNumero(tasaAnual)) {
			notificacion += "La tasa anual ingresada debe ser numérica\n";
		}

		if (!notificacion.equals("")) {
			mostrarMensaje("Notificación", "Cuenta no creada", notificacion, AlertType.WARNING);
			return false;
		}

		return true;
	}
	private boolean validarDatos(String numCuenta, String saldo) {
		String notificacion = "";

		if (numCuenta == null || numCuenta.equals("")) {
			notificacion += "Número de la cuenta inválido\n";
		}

		/*Se valida que el saldo ingresado no sea null ni sea cadena vacía,
		además se valida que sea numérico para su correcta conversión */
		if (saldo == null || saldo.equals("")) {
			notificacion += "Saldo inválido\n";
		} else if(!esNumero(saldo)){
			notificacion += "El saldo ingresado debe ser numérico\n";
		}

		/*Se valida que la tasa anual ingresada no sea null ni sea cadena vacía,
		además se valida que sea numérico para su correcta conversión */

		if (!notificacion.equals("")) {
			return false;
		}

		return true;
	}

	private boolean esNumero(String string) {
		try {

			Float.parseFloat(string);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertype) {
		Alert alert = new Alert(alertype);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();
	}




	@FXML
	void consignarAhorro(ActionEvent event) throws CuentaException {
		String numCuentaConsignar= txtCuentaConsignar.getText();
		String saldoConsignar= txtSaldoConsignar.getText();

		if(validarDatos(numCuentaConsignar, saldoConsignar)){
			float numSaldoConsignar = convertirAFloat(saldoConsignar);
			if(aplicacion.consignarAhorro(numCuentaConsignar, numSaldoConsignar)){
				CuentaAhorros cuenta = aplicacion.consultarCuenta(numCuentaConsignar);
				txtNuevoSaldoConsignacion.setDisable(true);
				txtCuentaConsignar.setText("");
				txtSaldoConsignar.setText("");

				if(cuenta.isActiva()){
					txtNuevoSaldoConsignacion.setText(""+ cuenta.getSaldo());
				}
				else{
					txtNuevoSaldoConsignacion.setText("");
					mostrarMensaje("Notificación cuenta", "Cuenta inactiva", "La cuenta a la que desea consignar está inactiva", AlertType.INFORMATION);
				}
			}
			else{
				mostrarMensaje("Notificación cuenta", "Cuenta no encontrada", "La cuenta no ha sido encontrada",
						AlertType.INFORMATION);
			}


		}
		else{
			mostrarMensaje("Notificación cuenta", "Datos no válidos", "Los datos ingresados son incorrectos",
					AlertType.WARNING);
		}

	}
	@FXML
	void limpiarInfoConsignar(ActionEvent event) {
		txtCuentaConsignar.setText("");
		txtSaldoConsignar.setText("");
		txtNuevoSaldoConsignacion.setText("");

	}

	@FXML
    void retirarAhorro(ActionEvent event) throws CuentaException {
        String numCuentaretirar= txtCuentaRetirar.getText();
        String saldoRetiro= txtSaldoRetiro.getText();

        if(validarDatos(numCuentaretirar, saldoRetiro)){
        	float numSaldoRetiro = convertirAFloat(saldoRetiro);
        	CuentaAhorros cuenta = aplicacion.consultarCuenta(numCuentaretirar);
            if(aplicacion.retirarAhorro(numCuentaretirar,numSaldoRetiro)){
            	txtNuevoSaldoRetiro.setText(""+ cuenta.getSaldo());
        		mostrarMensaje("Notificación cuenta", "Retiro realizado", "El retiro se realizó correctamente", AlertType.INFORMATION);
				txtNuevoSaldoRetiro.setDisable(true);
				txtCuentaRetirar.setText("");
				txtSaldoRetiro.setText("");
			}
            else{
            	if(cuenta!=null && !cuenta.isActiva()){
        			mostrarMensaje("Notificación cuenta", "Cuenta inactiva", "La cuenta de la que desea retirar se encuentra inactiva", AlertType.INFORMATION);
        			txtCuentaRetirar.setText("");
    				txtSaldoRetiro.setText("");
        		}
            	else{
            		if(cuenta!=null && cuenta.getSaldo()-numSaldoRetiro<0){
                		mostrarMensaje("Notificación cuenta", "Saldo insuficiente", "El saldo que desea retirar es insuficiente",
        						AlertType.INFORMATION);
                		txtCuentaRetirar.setText("");
        				txtSaldoRetiro.setText("");
                	}

            		else{
            			mostrarMensaje("Notificación cuenta", "Cuenta no encontrada", "La cuenta no ha sido encontrada",
            					AlertType.INFORMATION);
            			txtCuentaRetirar.setText("");
        				txtSaldoRetiro.setText("");
            		}
            	}


            }
        }
        else{
			mostrarMensaje("Notificación cuenta", "Datos no válidos", "Los datos ingresados son incorrectos",
					AlertType.WARNING);
		}
    }

	@FXML
    void limpiarInfoRetiro(ActionEvent event){
		txtNuevoSaldoRetiro.setText("");
		txtCuentaRetirar.setText("");
		txtSaldoRetiro.setText("");
	}
	@FXML
	void initialize() {

	}

	public void init(Stage stage, BancoController bancoController) {
		this.controllerBanco = bancoController;
		this.stage = stage;

	}

	public void setAplicacion(Aplicacion aplicacion){
			this.aplicacion = aplicacion;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
    void mostrarInfoCuenta(ActionEvent event) {
		String numCuenta = txtInfoNumCuenta.getText();

		if (numCuenta != null && !numCuenta.equals("")) {
			CuentaAhorros cuenta = aplicacion.consultarCuenta(numCuenta);
			if (cuenta != null) {
				txtInfoSaldo.setDisable(true);
				txtInfoNumconsignaciones.setDisable(true);
				txtInfoNumRetiros.setDisable(true);
				txtInfoTasaAnual.setDisable(true);
				txtInfoComisionMensual.setDisable(true);
				txtInfoEstadoCuenta.setDisable(true);

				setTxtFields(String.valueOf(cuenta.getSaldo()),
						String.valueOf(cuenta.getNúmeroConsignaciones()),
						String.valueOf(cuenta.getNúmeroRetiros()),
						String.valueOf(cuenta.getTasaAnual()),
						String.valueOf(cuenta.getComisiónMensual()), ""+ cuenta.isActiva());

			}
			else {
				mostrarMensaje("Notificación cuenta", "Cuenta no encontrada", "La cuenta no ha sido encontrada",
						AlertType.INFORMATION);
			}
		}
		else{
			mostrarMensaje("Notificación", "Datos inválidos", "Por favor ingresar correctamente el número de cuenta",
					AlertType.WARNING);
			setTxtFields("", "", "", "", "", "", "");

		}

    }
	@FXML
	void limpiarInfoCuenta(){
		setTxtFields("", "", "", "", "", "", "");


	}

	public void setTxtFields(String uno, String dos, String tres, String cuatro, String cinco, String seis, String siete){
		txtInfoNumCuenta.setText(uno);
		txtInfoSaldo.setText(dos);
		txtInfoNumconsignaciones.setText(tres);
		txtInfoNumRetiros.setText(cuatro);
		txtInfoTasaAnual.setText(cinco);
		txtInfoComisionMensual.setText(seis);
		txtInfoEstadoCuenta.setText(siete);

	}

	public void setTxtFields(String uno, String dos, String tres, String cuatro, String cinco, String seis){
		txtInfoSaldo.setText(uno);
		txtInfoNumconsignaciones.setText(dos);
		txtInfoNumRetiros.setText(tres);
		txtInfoTasaAnual.setText(cuatro);
		txtInfoComisionMensual.setText(cinco);
		txtInfoEstadoCuenta.setText(seis);
	}





}
