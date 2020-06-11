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

import javax.swing.plaf.basic.BasicButtonUI;

public class StealScene {
    public StealScene(String tittle){
         this.tittle.setText (tittle);
        paneForSteal.add (this.tittle,0,0);
        paneForSteal.setVgap (15);
        int index = 1;
        for( HBox hbox : scoreTable.gethBoxes ()){
            if(index<= PlayerList.getNamesArray ().length) {
                paneForSteal.add (hbox, index, 0);
            }
            index++;
        }
        setButtons ();
    }

    public Scene getScene(){
        return this.steal;
    }
    private GridPane paneForSteal = new GridPane ();
    private Scene steal = new Scene (paneForSteal, 200, 300);
    private Text tittle;

    private void setButtons(){
        Button player1 = new Button ();
        Button player2 = new Button ();
        Button player3 = new Button ();
        Button player4 = new Button ();
        Button[] buttons = {player1, player2, player3, player4};

        for(int index = 0; index < PlayerList.getNamesArray ().length; index++){
            paneForSteal.add (buttons[index], index+1, 0);
            buttons[index].setBackground (Background.EMPTY);
            int finalIndex=index;
            buttons[index].setOnAction (actionEvent -> {
                if(tittle.getText ().equals ("coins")) {
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
