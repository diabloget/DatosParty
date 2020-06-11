package StackEvents;
import boardScreen.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import main.main;
import playersScreen.PlayerList;
import scoreScreen.StealScene;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class StackAnalizer {
    private static Stack events = Stack.getStack ();

    private static int[] generatorDuel(){
        int[] returnInt = new int[2];
        returnInt[0] = new Random ().nextInt (PlayerList.getNamesArray ().length);
        returnInt[1] = new Random ().nextInt (PlayerList.getNamesArray ().length);
        if(returnInt[0]==returnInt[1]){
            returnInt = generatorDuel ();
        }
        return returnInt;
    }

    private static int generatorGiveAway(){
        int forReturn = new Random().nextInt (Round.getCurrent ().getStars ());
        if(forReturn % PlayerList.getNamesArray ().length != 0){
            forReturn = generatorGiveAway ();
        }
        return forReturn;
    }

    public static void analize(){
        String newEvent = "stealCoins";
        if(newEvent == "duel"){
            int[] randInts = generatorDuel ();
            Player[] forPlaying = {PlayerList.getPlayers (randInts[0]),PlayerList.getPlayers (randInts[1]) };
            playerEvents.startMinigame (forPlaying, false);
        }

        //Falta
        if(newEvent == "stealCoins"){
            String type = "coins";
            ChoiceDialog d = SelectPlayer.alertInit(type);
            Optional<String> result = d.showAndWait();
            if (result.isPresent() && result.get() == "1"){
                if(type.equals("stars")){
                    Round.getCurrent().setStars(1);
                    PlayerList.getPlayers(0).setStars(-1);

                }else{
                    Round.getCurrent().setCoins(2);
                    PlayerList.getPlayers(0).minusCoins(2);

                }
            }if (result.isPresent() && result.get() == "2") {
                if(type.equals("stars")){
                    Round.getCurrent().setStars(1);
                    PlayerList.getPlayers(1).setStars(-1);

                }else{
                    Round.getCurrent().setCoins(2);
                    PlayerList.getPlayers(1).minusCoins(2);
                }
            }if (result.isPresent() && result.get() == "3") {
                if(type.equals("stars")){
                    Round.getCurrent().setStars(1);
                    PlayerList.getPlayers(2).setStars(-1);
                }else{
                    Round.getCurrent().setCoins(2);
                    PlayerList.getPlayers(2).minusCoins(2);
                }
            }if(result.isPresent() && result.get() == "4") {
                if(type.equals("stars")){
                    Round.getCurrent().setStars(1);
                    PlayerList.getPlayers(3).setStars(-1);
                }else{
                    Round.getCurrent().setCoins(2);
                    PlayerList.getPlayers(3).minusCoins(2);
                }
            } else {
                //
            }

        }

        if(newEvent == "gveAwayCoins"){
            int giveAway = generatorGiveAway () / PlayerList.getNamesArray ().length;
            for(Player each : PlayerList.players){
                if(each.equals (Round.getCurrent ())){
                    each.setCoins (-giveAway*PlayerList.getNamesArray ().length);
                }else{
                    each.setCoins (giveAway);
                }
            }
        }

        if(newEvent == "looseStar"){
            Round.getCurrent ().setStars (-1);
            PlayerList.getPlayers (new Random ().nextInt (PlayerList.getNamesArray ().length));
        }

        if(newEvent == "2Stars"){
            Round.getCurrent ().setStars (2);
        }

        if(newEvent == "5Stars"){
            Round.getCurrent ().setStars (5);
        }

        //Falta
        if(newEvent == "stealStar"){

        }

        if(newEvent == "teletransport"){
            int randInt = new Random ().nextInt (2);
            if(randInt==0){
                Round.getCurrent ().setPath ("doubleCircularPath");
                Round.getCurrent ().setPosition (0);
                Round.getCurrent ().movePlayer(XYAxes.getXY(Round.getCurrent ().getPath()).get(Round.getCurrent ().getPosition()));
            }else{
                Round.getCurrent ().setPath ("mainPath");
                Round.getCurrent ().setPosition (new Random ().nextInt (50));
                Round.getCurrent ().movePlayer(XYAxes.getXY(Round.getCurrent ().getPath()).get(Round.getCurrent ().getPosition()));
            }
        }

        if(newEvent == "switchPlaces"){
            int randInt = new Random ().nextInt (PlayerList.getNamesArray ().length);
            String tempPath = Round.getCurrent ().getPath ();
            int tempPosition = Round.getCurrent ().getPosition ();
            Round.getCurrent ().setPosition (PlayerList.getPlayers (randInt).getPosition ());
            Round.getCurrent ().setPath (PlayerList.getPlayers (randInt).getPath ());
            Round.getCurrent ().movePlayer(XYAxes.getXY(Round.getCurrent ().getPath()).get(Round.getCurrent ().getPosition()));
            PlayerList.getPlayers (randInt).setPath (tempPath);
            PlayerList.getPlayers (randInt).setPosition (tempPosition);
            PlayerList.getPlayers (randInt).movePlayer(XYAxes.getXY(PlayerList.getPlayers (randInt).getPath()).get(PlayerList.getPlayers (randInt).getPosition()));
        }
    }
}
