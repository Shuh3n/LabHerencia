package controllers;


import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BancoController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCuentaCorriente;

    @FXML
    private Button btnCuentaAhorros;

	private Stage stage;

	private Aplicacion aplicacion;



    @FXML
    void showVentanaAhorros(ActionEvent event) throws IOException  {
    	FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("../Views/AhorroView.fxml"));
		AnchorPane anchorPane= (AnchorPane)loader.load();
		AhorroController Ahorroscontroller = loader.getController();
		Ahorroscontroller.setAplicacion(aplicacion);
		Scene scene= new Scene(anchorPane);
		Stage stage = new Stage();
		stage.setScene(scene);
		Ahorroscontroller.init(stage, this);
		stage.show();
		this.stage.close();

    }
    public void show() {
		stage.show();

	}

    @FXML
    void showVentanaCorriente(ActionEvent event) throws IOException {
    	FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("../Views/CorrienteView.fxml"));
		AnchorPane anchorPane= (AnchorPane)loader.load();
		CorrienteController Corrientecontroller = loader.getController();
		Corrientecontroller.setAplicacion(aplicacion);
		Scene scene= new Scene(anchorPane);
		Stage stage = new Stage();
		stage.setScene(scene);
		Corrientecontroller.init(stage, this);
		stage.show();
		this.stage.close();

    }

    @FXML
    void initialize() {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion= aplicacion;

	}
	public void setStage(Stage primaryStage) {
		stage = primaryStage;

	}






}
