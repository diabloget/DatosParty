package Simon;

import boardScreen.playerEvents;
import javafx.scene.Scene;
import playersScreen.PlayerList;
import main.*;

public class KeepingScore {
    private Scene oldTempScene;
    int numberOfPlayers;
    int[] scores;
    public int whichPlayer=0;

    KeepingScore(int numberOfPlayers, Scene oldTempScene){
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
                    playerEvents.setWinner (PlayerList.getPlayers (getWinner ()));
                    main.window.setScene(oldTempScene);
                }
                return false;
            }
        }
        scores[whichPlayer]++;
        return true;
    }



}