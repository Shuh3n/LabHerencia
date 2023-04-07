package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CorrienteController implements Initializable{

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
    private Button btnAgregarCuentaCorriente;

    @FXML
    private TextField txtNuevoSaldoRetiro;

    @FXML
    private Button btnNuevaCuentaCorriente;

    @FXML
    private TextField txtTasaAnual;

    @FXML
    private Button btnCerrarConsignacion;

    @FXML
    private Button btnCerrarRetiroCorriente;

    @FXML
    private TextField txtCuentaRetirar;

    @FXML
    private TextField txtSaldoConsignar;

    @FXML
    private Button btnRetirarCorriente;

    @FXML
    private Button btnConsultarCuentaCorriente;

    @FXML
    private TextField txtSaldo;

    @FXML
    private Button btnConsignarCorriente;

    @FXML
    private TextField txtCuentaConsignar;



    @FXML
    void nuevaCorriente(ActionEvent event) {

    }

    @FXML
    void agregarCorriente(ActionEvent event) {

    }

    @FXML
    void consultarCorriente(ActionEvent event) {

    }

    @FXML
    void consignarCorriente(ActionEvent event) {

    }

    @FXML
    void retirarCorriente(ActionEvent event) {

    }


    @FXML
    void initialize() {


    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
