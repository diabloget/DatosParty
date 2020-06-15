package RPS;

import javafx.scene.Scene;

import java.io.FileNotFoundException;

public class RPS {
    public RPS(Player[] names, boolean versus){
        RPS.names= names;
        RPS.versus = versus;
        RPS.oldTempScene = board.getBoardScene ();
        RPS.roundNumber = 1;
    }
    private static Scene oldTempScene;
    private static boolean versus;
    private static Player finalWinner;
    public static Player winnerRoundA;
    public static Player winnerRoundB;
    public static int roundNumber = 1;
    private static PiedraPapelOtijera interfaz;
    public static Player[] names;


    /**
     * @param playerA
     * @param playerB
     * @throws FileNotFoundException
     * Genera una nueva ronda de gato
     */
    public static void newGame(Player playerA, Player playerB) throws FileNotFoundException {
        interfaz= new PiedraPapelOtijera (playerA, playerB);
        main.window.setScene(new Scene (interfaz.getPane(), 720, 599));
    }

    /**
     * @throws FileNotFoundException
     * Maneja excepciones de empate y realiza un campeonato entre los jugadores
     */
    public static void roundHandler() throws FileNotFoundException {
        if(roundNumber < names.length){
            if(names.length == 4){
                if(roundNumber == 1){
                    roundNumber++;
                    newGame (names[0], names[1]);
                }
                if(roundNumber == 2){
                    roundNumber++;
                    newGame (names[2], names[3]);
                }else{
                    roundNumber++;
                    newGame (winnerRoundA, winnerRoundB);
                }
            }else if(names.length == 3){
                roundNumber++;
                if(roundNumber == 1){
                    newGame (names[0], names[1]);
                }else{
                    roundNumber++;
                    newGame (names[2], winnerRoundA);
                }
            }else{
                roundNumber++;
                newGame (names[0], names[1]);
            }
        }else{
            System.out.println (finalWinner.getName ());
            finalWinner.setCoins (10);
            if(versus){
                versusMethodPositionsGameT ();
            }
            main.window.setScene (oldTempScene);
        }
    }

    /**
     * @param who
     * Maneja ganadores por ronda en caso de ser campeonato
     */
    public static void setWinner(int who){
        if(names.length == 4){
            if(roundNumber == 1){
                winnerRoundA = names[who];
            }else if(roundNumber == 2){
                winnerRoundB = names[who+2];
            }else{
                if(who == 0) {
                    finalWinner= winnerRoundA;
                }else {
                    finalWinner = winnerRoundB;
                }
            }
        }else if(names.length == 3){
            if(roundNumber == 1){
                winnerRoundA = names[who];
            }else{
                if(who == 0) {
                    finalWinner=names[2];
                }
                else{
                    finalWinner = winnerRoundB;
                }
            }

        }else {
            finalWinner = names[who];
        }
    }

    /**
     * @throws FileNotFoundException
     * LLama a empezar el juego
     */
    public void starting() throws FileNotFoundException {
        roundHandler ();
    }

    /**
     * Maneja excepciones de juegos tipo versus
     */
    private static void versusMethodPositionsGameT(){
        for(Player search : names){
            if(!search.equals (finalWinner)){
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
