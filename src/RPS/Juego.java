package RPS;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Juego extends Application{

	PiedraPapelOtijera interfaz = new PiedraPapelOtijera ();
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(interfaz.getPane(), 400, 400);
		primaryStage.setTitle("PiedraPapeloTijera");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	} 
    public static void main(String[] args) {
    	launch(args);
    
    }
}
