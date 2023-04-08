package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.CuentaCorriente;

public class CorrienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNuevoSaldoConsignacion;

    @FXML
    private TextField txtInfoEstadoCuenta;

    @FXML
    private TextField txtInfoNumCuenta;

    @FXML
    private TextField txtNuevoSaldoRetiro;

    @FXML
    private TextField txtInfoNumRetiros;

    @FXML
    private Button btnLimpiarConsignar;

    @FXML
    private Button btnLimpiarInfoRetiro;

    @FXML
    private Button btnConsignarCorriente;

    @FXML
    private TextField txtSaldoRetiro;

    @FXML
    private Button btnBack;

    @FXML
    private TextField txtInfoTasaAnual;

    @FXML
    private TextField txtNumCuenta;

    @FXML
    private TextField txtInfoSaldo;

    @FXML
    private Button btnAgregarCuentaCorriente;

    @FXML
    private Button btnNuevaCuentaCorriente;

    @FXML
    private TextField txtTasaAnual;

    @FXML
    private Button btnInfoLimpiar;

    @FXML
    private TextField txtInfoNumconsignaciones;

    @FXML
    private TextField txtCuentaRetirar;

    @FXML
    private TextField txtSaldoConsignar;

    @FXML
    private TextField txtSaldoCuenta;

    @FXML
    private Button btnRetirarCorriente;

    @FXML
    private TextField txtSaldo;

    @FXML
    private Button btnConsultar2;

    @FXML
    private TextField txtCuentaConsignar;

    @FXML
    private TextField txtInfoComisionMensual;

	private BancoController controllerBanco;

	private Stage stage;

	private Aplicacion aplicacion;


    @FXML
    void limpiarCorriente(ActionEvent event) {
    	txtNumCuenta.setText("");
    	txtSaldoCuenta.setText("");
    	txtTasaAnual.setText("");

    }

    @FXML
    void agregarCorriente(ActionEvent event) throws Exception {
		String numCuenta = txtNumCuenta.getText();
		String txtsaldo = txtSaldoCuenta.getText();
		String txttasaAnual = txtTasaAnual.getText();

		if (validarDatos(numCuenta, txtsaldo, txttasaAnual)) {

			float saldo = convertirAFloat(txtsaldo);
			float tasaAnual = convertirAFloat(txttasaAnual);

			crearCorriente(numCuenta, saldo, tasaAnual);
			txtNumCuenta.setText("");
			txtSaldoCuenta.setText("");
			txtTasaAnual.setText("");

		}

	}

    private float convertirAFloat(String numero) {
		return Float.parseFloat(numero);
	}

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


	private void crearCorriente(String numCuenta, float saldo, float tasaAnual) throws Exception {

		if (aplicacion.crearCuentaCorriente(numCuenta, saldo, tasaAnual)) {
			mostrarMensaje("Notificación cuenta", "Cuenta Ahorros", "Cuenta creada con éxito", AlertType.INFORMATION);
		}

		else{
			mostrarMensaje("Notificación cuenta", "Cuenta no creada", "La cuenta no ha sido creada", AlertType.INFORMATION);
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
    void showVentanaPrincipal(ActionEvent event) {
    	controllerBanco.show();
		stage.close();
    }


    @FXML
    void consignarCorriente(ActionEvent event) {
    	String txtnumCuenta = txtCuentaConsignar.getText();
    	String txtSaldo = txtSaldoConsignar.getText();

    	if(validarDatos(txtnumCuenta, txtSaldo)){
    		float numSaldoConsignar = convertirAFloat(txtSaldo);
    		if(aplicacion.consignarCorriente(txtnumCuenta, numSaldoConsignar)){
    			CuentaCorriente cuenta = aplicacion.consultarCuentaCorriente(txtnumCuenta);
    			txtNuevoSaldoConsignacion.setDisable(true);
    			txtNuevoSaldoConsignacion.setText("" + cuenta.getSaldo());
    			txtCuentaConsignar.setText("");
    			txtSaldoConsignar.setText("");
    			mostrarMensaje("Notificación cuenta", "Consignación realizada", "Consignación realizada con éxito",
    					AlertType.INFORMATION);
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
    	txtNuevoSaldoConsignacion.setText("");
		txtCuentaConsignar.setText("");
		txtSaldoConsignar.setText("");
    }

    @FXML
    void retirarAhorro(ActionEvent event) {

    }

    @FXML
    void limpiarInfoRetiro(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCuenta(ActionEvent event) {

    }

    @FXML
    void limpiarInfoCuenta(ActionEvent event) {

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
}
