package scoreScreen;

import boardScreen.Player;
import boardScreen.board;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.main;
import playersScreen.PlayerList;

import java.util.ArrayList;

public class score {
    private static Pane scorepane = new Pane();
    private static Scene scorescene = new Scene(scorepane,150,160);
    private static VBox table = new VBox(10);
    private static boolean singleton = false;

    private static void initializator(boolean temp){
        if(temp==false){
            ////
            scorepane.setStyle("-fx-background-color: #2B2B2B");
            for (HBox hboxesito:scoreTable.hBoxes){
                table.getChildren().add(hboxesito);
            }

            scorepane.getChildren().add(table);

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
