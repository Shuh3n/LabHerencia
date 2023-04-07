package application;
import java.io.IOException;

import model.Banco;
import controllers.BancoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Aplicacion extends Application{

	//Solo puede existir una instancia de la clase principal, en este caso tenemos una sola intancia
	//de la clase biblioteca
	Banco banco;
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage= primaryStage;
		this.banco= new Banco();
		primaryStage.setTitle("Banco UQ");
		mostrarVentanaPrincipal();
	}

	private void mostrarVentanaPrincipal() throws IOException {
		//Se establece la ruta de la ventana que desea ejecutar
		try{
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
		}catch(IOException e){

		}
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


}
