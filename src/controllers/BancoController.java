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
import model.Banco;

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

	private Banco Banco;



    @FXML
    void showVentanaAhorros(ActionEvent event) throws IOException  {
    	FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("../Views/AhorroView.fxml"));
		AnchorPane anchorPane= (AnchorPane)loader.load();
		AhorroController controller = loader.getController();
		Scene scene= new Scene(anchorPane);
		Stage stage = new Stage();
		stage.setScene(scene);
		controller.init(stage, this);
		stage.show();
		this.stage.close();

    }
    public void show() {
		stage.show();

	}

    @FXML
    void showVentanaCorriente(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion= aplicacion;
		this.Banco= aplicacion.getBanco();

	}
	public void setStage(Stage primaryStage) {
		stage = primaryStage;

	}






}
