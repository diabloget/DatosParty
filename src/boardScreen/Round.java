package boardScreen;

import javafx.scene.input.KeyEvent;
import playersScreen.PlayerList;

public class Round {
    private static int roundNumber = 0;
    private static int currentPlayer = 0;
    //Empezar la ronda en 0 y sumar un entero cada vez que el primer jugador pasa
    //Usar el indice de turno para extraer el jugador al que le corresponde el turno actual
    public static void RoundUpdate(){
        if(currentPlayer == PlayerList.getNamesArray().length-1){
            // Iniciar juego.
            roundNumber ++;
            currentPlayer = 0;
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
