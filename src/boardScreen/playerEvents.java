package boardScreen;

import BlackJack.BlackJack;
import HorseBet.HorseBet;
import Simon.Simon;
import StackEvents.StackAnalizer;
import playersScreen.PlayerList;
import Connect4.*;
import java.util.Random;

public class playerEvents {
    public static int lastPosition;
    public static String lastPath;


    /**
     * Busca los eventos si deben ser llamados
     */
    public static void checkEvents(){
        winCoins();
        loseCoins();
        yellowEvent();
    }


    /**
     * @param names
     * @param versus
     * Llama a un mini juego aleatorio, sea tipo versus, duelo o todos
     */
    public static void startMinigame(Player[] names, boolean versus){
        int randomInt = 2;
  ///new Random ().nextInt (6);

            if(randomInt == 3) {
                Connect4 game = new Connect4 (names, versus);
                game.starting ();
            }
            if (randomInt == 5){
                Simon game = new Simon (names, versus);
                game.starting ();
            }
            if(randomInt == 4){
                BlackJack game = new BlackJack (names, versus);
                game.starting ();
            }
            if(randomInt == 2){
                HorseBet game = new HorseBet (names, versus);
                game.starting ();
            }
    }


    /**
     * Método que analiza si dos jugadores distintos comparten
     * una misma posición en el tablero para ejecutar un versus.
     * @param lastPather
     * @param lastPositioner
     */
    public static void versus(String lastPather, int lastPositioner){
        lastPosition = lastPositioner;
        lastPath = lastPather;
        for(Player player: PlayerList.players){
            if(Round.getCurrent().getPosition() == player.getPosition() & Round.getCurrent().getPath() == player.getPath() & Round.getCurrent() != player){
                System.out.println("Pichazos en el pretil");

                Player[] namesInGame = {Round.getCurrent(), player};
                startMinigame (namesInGame, true);
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
            //System.out.println("El jugador "+ Round.getCurrent().getName() + " acaba de ganar y ahora tiene: " + Round.getCurrent().getCoins());
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
                Round.getCurrent().setCoins(- Round.getCurrent().getCoins());
            }
            //System.out.println("El jugador "+ Round.getCurrent().getName() + " acaba de ganar y ahora tiene: " + Round.getCurrent().getCoins());
        }
    }


    /**
     * Verifica la casilla y llama a los eventos de manera aleatoria
     */
    public static void yellowEvent(){
        //despiche
        if(Round.getCurrent().getPath().equals("doubleCircularPath") &  dices.diceValue() == 0){
            System.out.println("Evento Amarillo prro");
            StackAnalizer.analize ();
        }else{
            if(EventPositions.doEvent(Round.getCurrent().getPath(), "yellow", Round.getCurrent().getPosition())  &  dices.diceValue() == 0){
                System.out.println("Evento Amarillo prro");
                StackAnalizer.analize ();
            }
        }
    }

    /**
     * Función que al iniciar un duelo entre dos jugadores, si el jugador que lo inicio pierde, se le castiga
     * haciéndole teleport a la Isla, mientras que si el perdedor fue el pasivo, su castigo será algo más leve.
     * @param player
     */

    public static void Punishment(Player player){
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
