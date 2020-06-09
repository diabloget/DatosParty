package playersScreen;

import boardScreen.board;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import main.main;
import java.util.ArrayList;

public class players{
    private static int limiter = 0;
    static private boolean singleton = false;
    private static Pane playerpane = new Pane();
    private static Scene playerscene = new Scene(playerpane,500,550);
    private static Button switcher = new Button("Empezar");
    private static Label wall = new Label();
    private static TextField playeradder = new TextField();
    private static Text playeraddertext = new Text("Añade hasta 4 jugadores:");
    private static TextFlow playerlisttext = new TextFlow();
    private static Alert alert = new Alert(Alert.AlertType.WARNING);
    private static Alert alert2 = new Alert(Alert.AlertType.WARNING);

    private static Text texter(String child){
        Text temptext = new Text(child);
        temptext.setFill(Color.web("#fa6565"));
        temptext.setFont(Font.font(20));
        return temptext;
    }

    private static void initializator(boolean temp){
        if(temp==false){
            alert.setTitle("Cámate po favo");
            alert.setHeaderText(null);
            alert.setContentText("Oye viejo, cálmate, estás intentando añadir más \n jugadores de los que se permiten en el juego");
            ////
            alert2.setTitle("Ira men deja te explico");
            alert2.setHeaderText(null);
            alert2.setContentText("Yo sé que conseguir amigos puede ser difícil, pero, \neste juego es para mínimo dos jugadores, al menos \nañádete a ti mismo dos veces. :)");
            ////
            wall.setStyle("-fx-background-color: #7efafa");
            wall.setPrefSize(450, 500);
            wall.relocate(30, 30);
            ////
            playeraddertext.relocate(140,40);
            playeraddertext.setFont(Font.font(20));
            playeraddertext.setStroke(Color.valueOf("#635f5f"));

            ////
            playerlisttext.setLineSpacing(5);
            playerlisttext.setStyle("-fx-background-color: #635f5f");
            playerlisttext.setPrefSize(180,250);
            playerlisttext.relocate(70, 70);
            ////
            playeradder.relocate(255, 75);
            playeradder.setOnKeyPressed(event -> {
                if(event.getCode().equals(KeyCode.ENTER)) {
                    if(limiter<4){
                        PlayerList.setPlayernames(playeradder.getText());
                        playerlisttext.getChildren().add(texter(playeradder.getText()+ "\n"));
                    }if(limiter>=4){
                        alert.showAndWait();
                    }
                    limiter+=1;
                    playeradder.clear();
                }
            });

            ////

            ////
            switcher.relocate(220, 500);
            switcher.setStyle("-fx-background-color: #c7fa7e");
            switcher.setOnAction(event -> {
                if(limiter>1){
                    PlayerList.setPlayers();
                    main.window.setScene(board.getBoardScene());
                    /*
                    Revisar esto
                     */
                }else{
                    alert2.showAndWait();
                }
            });
            ////
            playerpane.setStyle("-fx-background-color: #2B2B2B");
            playerpane.getChildren().addAll(wall, switcher, playerlisttext, playeraddertext, playeradder);

            //////
            singleton=true;
        }else{
            System.out.println("Singletón confirmado");
        }

    }

    public static Scene getPlayerScene() {
        initializator(singleton);
        return playerscene;
    }
}