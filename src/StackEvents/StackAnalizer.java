package StackEvents;
import boardScreen.*;
import main.main;
import playersScreen.PlayerList;
import scoreScreen.StealScene;

import java.io.FileNotFoundException;
import java.util.Random;

public class StackAnalizer {
    private static Stack events = Stack.getStack ();


    /**
     * @return Un arreglo de dos enteros para escoger jugadores del duelo
     */
    private static int[] generatorDuel(){
        int[] returnInt = new int[2];
        returnInt[0] = new Random ().nextInt (PlayerList.getNamesArray ().length);
        returnInt[1] = new Random ().nextInt (PlayerList.getNamesArray ().length);
        if(returnInt[0]==returnInt[1]){
            returnInt = generatorDuel ();
        }
        return returnInt;
    }


    /**
     * @return Entero divisible por la cantidad de jugadores y menor al acantidad de monedas
     */
    private static int generatorGiveAway(){
        int forReturn = new Random().nextInt (Round.getCurrent ().getCoins ()+1);
        if(Round.getCurrent().getCoins() % PlayerList.getNamesArray().length == 0){
            return 0;
        }
        if(forReturn % PlayerList.getNamesArray ().length != 0){
            forReturn = generatorGiveAway ();
        }
        return forReturn;
    }

    /**
     * Maneja los eventos de los stacks
     * Se llama por las casillas amarillas.
     */
    public static void analize() throws FileNotFoundException {
        String newEvent = events.pop();
        if(newEvent == "duel"){
            int[] randInts = generatorDuel ();
            Player[] forPlaying = {PlayerList.getPlayers (randInts[0]),PlayerList.getPlayers (randInts[1]) };
            playerEvents.startMinigame (forPlaying, false);
        }

        //Falta
        if(newEvent == "stealCoins"){
            StealScene coinsSteal = new StealScene("coins");
            coinsSteal.getScene ();
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
            StealScene starsSteal = new StealScene("stars");
            starsSteal.getScene ();
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
