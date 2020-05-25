package BlackJack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayBlackJack extends Application {

    public static void main(String[] args) {
        launch (args);
    }

    private GridPane gamePane = new GridPane ();
    private Scene gameScene = new Scene (gamePane,500,400, Color.GREEN);
    Text playing = new Text ();
    Button hit = new Button ("HIT");
    
    String[] x = {"Jose","Miguel","Juam"};
    BlackJack game = new BlackJack (x);

    private void update(){
        for(int index = 0; index <= game.cardNumber; index++){

        }
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
