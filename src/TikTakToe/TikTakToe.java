package TikTakToe;

import boardScreen.Player;
import boardScreen.board;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class TikTakToe {
    public TikTakToe(Player[] names, boolean versus){
        this.names = new String[names.length];
        int index = 0;
        while(index < this.names.length){
            this.names[index] = names[index].getName ();
            index++;
        }
        this.oldTempScene =board.getBoardScene ();
    }
    private Scene oldTempScene;
    private int gameRound = 0;
    private String[] names;
    private GridPane game1 = new GridPane ();
    private GridPane game2 = new GridPane ();
    private GridPane game3 = new GridPane ();
    private Scene gameScene = new Scene (game1, 500,500);

    private void settingGame(int gameNumber){

    }

    public void starting(){

    }

}
