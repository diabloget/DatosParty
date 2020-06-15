package boardScreen;

import javafx.scene.input.KeyEvent;
import playersScreen.PlayerList;

import java.io.FileNotFoundException;

public class Round {
    private static int roundNumber = 0;
    private static int currentPlayer = 0;
    //Empezar la ronda en 0 y sumar un entero cada vez que el primer jugador pasa
    //Usar el indice de turno para extraer el jugador al que le corresponde el turno actual

    /**
     * Método que actualiza el jugador en turno y la Ronda.
     */
    public static void RoundUpdate() throws FileNotFoundException {
        if(currentPlayer == PlayerList.getNamesArray().length-1){
            Player[] names = new Player[PlayerList.getNamesArray ().length];
            for(int index = 0; index < PlayerList.getNamesArray ().length ; index++){
                names[index] = PlayerList.getPlayers (index);
            }
            playerEvents.startMinigame (names, false);
            roundNumber ++;
            currentPlayer = 0;
        }else {
            currentPlayer ++;
        }
    }

    public static Player getCurrent(){
        return PlayerList.getPlayers(currentPlayer);
    }

    public static void moveCurrent(KeyEvent e) throws FileNotFoundException {
        steps.stepCalculator(PlayerList.getPlayers(currentPlayer), e);
    }
}
