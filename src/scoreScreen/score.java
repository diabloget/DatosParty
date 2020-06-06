package scoreScreen;

import boardScreen.board;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.main;
import playersScreen.PlayerList;

public class score {
    private static Pane scorepane = new Pane();
    private static Scene scorescene = new Scene(scorepane,500,550);
    private static boolean singleton = false;

    private static void initializator(boolean temp){
        if(temp==false){

            ////
            scorepane.setStyle("-fx-background-color: #2B2B2B");

            //////
            singleton=true;
        }else{
            System.out.println("Singletón confirmado");
        }

    }

    public static Scene getScoreScene() {
        initializator(singleton);
        return scorescene;
    }
}
