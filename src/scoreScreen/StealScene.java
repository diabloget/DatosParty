package scoreScreen;

import boardScreen.Round;
import boardScreen.board;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import main.main;
import playersScreen.PlayerList;

public class StealScene {
    public StealScene(String type){
        textTittle = type;

    }

    private GridPane paneForSteal = new GridPane ();
    private Scene steal = new Scene (paneForSteal, 200, 300);
    private Text text =  new Text ();
    private String textTittle;

    public void getScene(){
        paneForSteal.setVgap (15);
        paneForSteal.setHgap (15);
        setButtons ();
        main.window.setScene (steal);
    }


    private void setButtons(){
        text.setText (textTittle);
        paneForSteal.add (text,0,0);
        Button player1 = new Button ("Player 1");
        Button player2 = new Button ("Player 2");
        Button player3 = new Button ("Player 3");
        Button player4 = new Button ("Player 4");
        Button[] buttons = {player1, player2, player3, player4};
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
        Button cancel = new Button ("Cancel");
        paneForSteal.add (cancel,0, index);
        cancel.setOnAction (actionEvent -> {
            main.window.setScene (board.getBoardScene ());
        });

        for(int indexAux = 0; index < PlayerList.getNamesArray ().length; index++){
            int finalIndex=indexAux;
            buttons[indexAux].setOnAction (actionEvent -> {
                if( text.getText ().equals ("coins")) {
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
    }
}
