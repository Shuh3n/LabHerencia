package application;
import java.io.IOException;

import model.Banco;
import model.CuentaAhorros;
import model.CuentaCorriente;
import controllers.BancoController;
import exceptions.CuentaException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Aplicacion extends Application{

	//Solo puede existir una instancia de la clase principal, en este caso tenemos una sola intancia
	//de la clase biblioteca
	private Banco banco;
	private Stage primaryStage;


	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage= primaryStage;
		this.banco= new Banco();
		mostrarVentanaPrincipal();
	}

	private void mostrarVentanaPrincipal() throws IOException {
		//Se establece la ruta de la ventana que desea ejecutar

		FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("../Views/banco.fxml"));
		AnchorPane anchorPane= (AnchorPane)loader.load();
		BancoController bancoController = loader.getController();
		bancoController.setAplicacion(this);

		Scene scene= new Scene(anchorPane);
		primaryStage.setScene(scene);
		primaryStage.show();
		BancoController controller = loader.getController();
		controller.setStage(primaryStage);

	}


	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public boolean crearCuentaAhorro(String numCuenta, float saldo, float tasaAnual){
		return banco.crearCuenta(numCuenta, saldo, tasaAnual);
	}

	public CuentaAhorros consultarCuenta(String numCuenta) {
		CuentaAhorros cuenta = (CuentaAhorros) banco.consultarCuenta(numCuenta);
		return cuenta;
	}

	public boolean consignarAhorro(String numCuentaConsignar, float numSaldoConsignar) throws CuentaException {
		return banco.consignarAhorro(numCuentaConsignar, numSaldoConsignar);

	}

	public boolean retirarAhorro(String numCuentaretirar, float saldoRetiro) throws CuentaException {
        return banco.retirarAhorro(numCuentaretirar,saldoRetiro);
    }

	public boolean crearCuentaCorriente(String numCuenta, float saldo, float tasaAnual) {
		return banco.crearCuentaCorriente(numCuenta, saldo, tasaAnual);

	}

	public boolean consignarCorriente(String txtnumCuenta, float numSaldoConsignar) {
		return banco.consignarCorriente(txtnumCuenta, numSaldoConsignar);
	}

	public CuentaCorriente consultarCuentaCorriente(String txtnumCuenta) {
		CuentaCorriente cuenta = (CuentaCorriente) banco.consultarCuentaCorriente(txtnumCuenta);
		return cuenta;
	}


}
