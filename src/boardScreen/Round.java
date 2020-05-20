package boardScreen;

import javafx.scene.input.KeyEvent;
import playersScreen.PlayerList;

public class Round {
    public static int roundNumber = 0;
    public static int currentPlayer = 0;
    //Empezar la ronda en 0 y sumar un entero cada vez que el primer jugador pasa
    //Usar el indice de turno para extraer el jugador al que le corresponde el turno actual
    public static void RoundUpdate(){
        if(currentPlayer == PlayerList.players.size()-2){
            roundNumber ++;
            currentPlayer = 0;
        }else {
            currentPlayer ++;
        }
    }

    public static void moveCurrent(KeyEvent e){
        steps.stepCalculator(PlayerList.getPlayers(currentPlayer), e);
    }

}
