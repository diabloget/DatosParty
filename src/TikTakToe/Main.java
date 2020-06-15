package TikTakToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	

	GatoInterfaz interfaz = new GatoInterfaz ();
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(interfaz.getPane(), 720, 599);
		primaryStage.setTitle("Gato");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	} 
	public static void main(String[] args) throws Exception {
		launch(args);
	}
	
}
