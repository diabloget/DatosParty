package boardScreen;

import javafx.scene.input.KeyEvent;
import playersScreen.PlayerList;

public class Round {
    private static int roundNumber = 0;
    private static int currentPlayer = 0;
    //Empezar la ronda en 0 y sumar un entero cada vez que el primer jugador pasa
    //Usar el indice de turno para extraer el jugador al que le corresponde el turno actual

    /**
     * Método que actualiza el jugador en turno y la Ronda.
     */
    public static void RoundUpdate(){
        if(currentPlayer == PlayerList.getNamesArray().length-1){
            Player[] names = new Player[PlayerList.getNamesArray ().length];
            for(int index = 0; index < PlayerList.getNamesArray ().length ; index++){
                names[index] = PlayerList.getPlayers (index);
            }
            playerEvents.startMinigame (names, false);
            roundNumber ++;
            currentPlayer = 0;

            //Star

        }else {
            currentPlayer ++;
        }
    }

    public static Player getCurrent(){
        return PlayerList.getPlayers(currentPlayer);
    }

    public static void moveCurrent(KeyEvent e){
        steps.stepCalculator(PlayerList.getPlayers(currentPlayer), e);
    }
}
