package scoreScreen;

import boardScreen.Round;
import boardScreen.board;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.main;
import playersScreen.PlayerList;

public class StealScene {
    public StealScene(String type){
        textTittle = type;
    }

    private GridPane paneForSteal = new GridPane ();
    private Scene steal = new Scene (paneForSteal, 100, 200);
    private Text text =  new Text ();
    private String textTittle;

    public void getScene(){
        paneForSteal.setVgap (15);
        paneForSteal.setHgap (15);
        setButtons ();
        main.window.setScene (steal);
    }


    /**
     * Agrega los botones para seleccionar robo
     */
    private void setButtons(){
        paneForSteal.setStyle("-fx-background-color: #2B2B2B");


        text.setText (textTittle);
        paneForSteal.add (text,0,0);
        Button player1 = new Button ("Player 1");
        Button player2 = new Button ("Player 2");
        Button player3 = new Button ("Player 3");
        Button player4 = new Button ("Player 4");
        Button[] buttons = {player1, player2, player3, player4};
        for(Button button:buttons){
            button.setStyle("-fx-background-color: #3C3F41");
            button.setOnMousePressed(event -> button.setStyle("-fx-background-color: #313335"));
            button.setOnMouseReleased(event -> button.setStyle("-fx-background-color: #3C3F41"));
            button.setTextFill(Color.valueOf("#C9C9C9"));
        }




        int index = 0;
        int indexPositions = 0;
        while (index < PlayerList.getNamesArray().length) {
            if (!Round.getCurrent().equals(PlayerList.getPlayers(index))) {
                if(textTittle == "stars"){
                    if (PlayerList.getPlayers(index).getStars()>0){
                        paneForSteal.add (buttons[index], 0, indexPositions+1);
                    }
                }
                if(textTittle == "coins"){
                    if (PlayerList.getPlayers(index).getCoins()>0){
                        paneForSteal.add (buttons[index], 0, indexPositions+1);
                    }
                }
                indexPositions++;
            }
            index++;
        }


        for(int indexAux = 0; indexAux < PlayerList.getNamesArray ().length; indexAux++){
            int finalIndex=indexAux;
            buttons[indexAux].setOnAction (actionEvent -> {
                if( textTittle.equals ("coins")) {
                    Round.getCurrent ().setCoins (2);
                    PlayerList.getPlayers (finalIndex).setCoins (-2);
                    main.window.setScene (board.getBoardScene ());
                }
                else{
                    Round.getCurrent ().setStars (1);
                    PlayerList.getPlayers (finalIndex).setStars (-1);
                    main.window.setScene (board.getBoardScene ());
                }
            });
        }
        Button cancel = new Button ("Cancel");
        cancel.setStyle("-fx-background-color: #3C3F41");
        cancel.setOnMousePressed(event -> cancel.setStyle("-fx-background-color: #313335"));
        cancel.setOnMouseReleased(event -> cancel.setStyle("-fx-background-color: #3C3F41"));
        cancel.setTextFill(Color.valueOf("#C9C9C9"));


        paneForSteal.add (cancel,0, index);
        cancel.setOnAction (actionEvent -> {
            main.window.setScene (board.getBoardScene ());
        });
    }
}
