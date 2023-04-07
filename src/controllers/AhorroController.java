package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AhorroController {

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
    private Button btnConsultarCuentaAhorro;

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
    private Button btnRetirarCorriente;

    @FXML
    private TextField txtSaldo;

    @FXML
    private Button btnConsignarCorriente;

    @FXML
    private Button btnBack;

    @FXML
    private TextField txtCuentaConsignar;

	private Stage stage;

	private BancoController controllerBanco;

	@FXML
	void showVentanaPrincipal(ActionEvent event) {
		controllerBanco.show();
    	stage.close();
	}





    @FXML
    void nuevaAhorro(ActionEvent event) {
    	txtNumCuenta.setText("Ingrese el numero de la cuenta");
    	txtSaldo.setText("");
    	txtTasaAnual.setText("");
    }

    @FXML
    void agregarAhorro(ActionEvent event) {
       	String numCuenta= txtNumCuenta.getText();
    	Float saldo= Float.parseFloat(txtSaldo.getText());
    	Float tasaAnual= Float.parseFloat(txtTasaAnual.getText());

    	if(datosValidos(numCuenta,saldo,tasaAnual)){
    		crearAhorro(numCuenta,saldo,tasaAnual);
    	}
    }

    private void crearAhorro(String numCuenta, Float saldo, Float tasaAnual) {
		// TODO Auto-generated method stub

	}
    /**
     * Metodo que sirve para verificar si la uinformacion de la cuenta es correcta, es decir que
     * no es
     * @param numCuenta
     * @param saldo
     * @param tasaAnual
     * @return
     */
	private boolean datosValidos(String numCuenta, Float saldo, Float tasaAnual) {
		String notificacion="";


		if(numCuenta==null || numCuenta.equals("")){
			notificacion+= "Numero de la cuenta invalido\n";
		}
		if(saldo==null || saldo.equals("")){
			notificacion+= "Saldo invalido\n";
		}
		if(tasaAnual==null || tasaAnual.equals("")){
			notificacion+= "Tasa anual invalida\n";
		}


		if(notificacion.equals("")){
			return true;
		}


		Alert alert= new Alert(AlertType.WARNING);
		alert.setTitle("Notificacion cuenta");
		alert.setHeaderText("Informacion invalida");
		alert.setContentText(notificacion);
		alert.showAndWait();

		return false;
	}


	@FXML
    void consultarAhorro(ActionEvent event) {

    }

    @FXML
    void consignarAhorro(ActionEvent event) {

    }

    @FXML
    void retirarAhorro(ActionEvent event) {

    }

    @FXML
    void initialize() {


    }

	public void init(Stage stage, BancoController bancoController) {
		this.controllerBanco = bancoController;
    	this.stage = stage;

	}

}
