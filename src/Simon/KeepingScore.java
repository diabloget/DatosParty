package Simon;

import boardScreen.Player;
import boardScreen.Round;
import boardScreen.XYAxes;
import boardScreen.playerEvents;
import javafx.scene.Scene;
import playersScreen.PlayerList;
import main.*;

public class KeepingScore {
    private Player[] call;
    private boolean versus;
    private Scene oldTempScene;
    int numberOfPlayers;
    int[] scores;
    public int whichPlayer=0;

    KeepingScore(int numberOfPlayers, Scene oldTempScene, boolean versus, Player[] call){
        this.call = call;
        this.versus = versus;
        this.numberOfPlayers=numberOfPlayers;
        this.oldTempScene = oldTempScene;
        this.scores = new int[numberOfPlayers];
        for(int s : scores){
            s=0;
        }
    }


    private int getWinner(){
        int index = 0;
        int holdValue = scores[0];
        for(int score : scores){
            if(score > holdValue){
                index++;
            }
        }
        return index;
    }

    public boolean winOrLoose(String[] answers, String[] moves) {
        for(int counter = 0; counter<5; counter++){
            if(!answers[counter].equals(moves[counter])){
                whichPlayer++;
                if(whichPlayer >= numberOfPlayers){
                    PlayerList.getPlayers (getWinner ()).setCoins (10);
                    if(versus){versusMethodPositions ();}
                    main.window.setScene(oldTempScene);
                }
                return false;
            }
        }
        scores[whichPlayer]++;
        return true;
    }

    private void versusMethodPositions(){
        for( Player search : call){
            if(!search.equals (PlayerList.getPlayers (getWinner ()))){
                if(! Round.getCurrent ().equals (search) ) {
                    search.setPath (playerEvents.lastPath);
                    search.setPosition (playerEvents.lastPosition);
                    search.movePlayer(XYAxes.getXY(search.getPath()).get(search.getPosition()));
                }else {
                    playerEvents.Punishment (search);
                }
            }
        }
    }


}