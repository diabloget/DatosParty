package boardScreen;

import BlackJack.BlackJack;
import Simon.Simon;
import StackEvents.StackAnalizer;
import playersScreen.PlayerList;
import Connect4.*;
import playersScreen.PlayerList;

import java.util.Random;

public class playerEvents {
    private static int lastPosition;
    private static String lastPath;
    private static Player winner;

    public static void setWinner(Player won){
        winner = won;
    }

    public static void checkEvents(){
        winCoins();
        loseCoins();
    }

    public static void startMinigame(Player[] names){
        int randomInt = new Random ().nextInt (7);

            if(randomInt == 6) {
                Connect4 game = new Connect4 (names);
                game.starting ();
            }
            if (randomInt == 5){
                Simon game = new Simon (names);
                game.starting ();
            }
            if(randomInt == 4){
                BlackJack game = new BlackJack (names);
                game.starting ();
            }
    }

    public static void versus(String lastPather, int lastPositioner){
        lastPosition = lastPositioner;
        lastPath = lastPather;
        for(Player player: PlayerList.players){
            if(Round.getCurrent().getPosition() == player.getPosition() & Round.getCurrent() != player){
                Player[] namesInGame = {Round.getCurrent(), player};
                startMinigame (namesInGame);
            }
            break;
            }
        }



    /**
     * Función que revisa si el jugador debe ganar monedas debido a una casilla.
     * **/
    public static void winCoins(){
        if(EventPositions.doEvent(Round.getCurrent().getPath(), "green", Round.getCurrent().getPosition())  &  dices.diceValue() == 0){ //Buscar en una lista de posiciones en lugar de "== 3"
            Round.getCurrent().setCoins(4);
            System.out.println("Un jugador acaba de ganar y ahora tiene: " + Round.getCurrent().getCoins());
        }
    }

    /**
     * Función que revisa si el jugador debe perder monedas debido a una casilla.
     * **/
    public static void loseCoins(){
        if(EventPositions.doEvent(Round.getCurrent().getPath(), "red", Round.getCurrent().getPosition())  &  dices.diceValue() == 0){ //Buscar en una lista de posiciones en lugar de "== 5"
            if(Round.getCurrent().getCoins() >= 2){
                Round.getCurrent().minusCoins(2);
            }else{
                Round.getCurrent().setCoins(0);
            }
            System.out.println("Un jugador acaba de perder y ahora tiene: " + Round.getCurrent().getCoins());
        }
    }

    public static void YellowEvent(){
        //despiche
        if(EventPositions.doEvent(Round.getCurrent().getPath(), "yellow", Round.getCurrent().getPosition())  &  dices.diceValue() == 0){
            StackAnalizer.analize ();
        }
    }

    /**
     * Función que al iniciar un duelo entre dos jugadores, si el jugador que lo inicio pierde, se le castiga
     * haciéndole teleport a la Isla, mientras que si el perdedor fue el pasivo, su castigo será algo más leve.
     * @param player
     */

    public void Punishment(Player player){
        if(player == Round.getCurrent()){
            player.setPath("doubleCircularPath");
            player.setPosition(0);
            player.movePlayer(XYAxes.getXY(player.getPath()).get(player.getPosition()));

        }else{
            player.setPath(lastPath);
            player.setPosition(lastPosition);
            player.movePlayer(XYAxes.getXY(player.getPath()).get(player.getPosition()));
        }

    }
}
