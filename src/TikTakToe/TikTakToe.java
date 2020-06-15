package TikTakToe;

public class TikTakToe {

    public TikTakToe(String[] names, boolean versus){
        this.names = names;
        this.versus = versus;
    }
    private static boolean versus;
    private static String finalWinner;
    public static String winnerRoundA;
    public static String winnerRoundB;
    public static int roundNumber = 1;
    private static GatoInterfaz interfaz;

    private static String[] names;

    public static void newGame(String playerA, String playerB){
        interfaz= new GatoInterfaz ();
        //main.window.setScene(new Scene(interfaz.getPane(), 720, 599))
    }

    public static void roundHandler(){
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
            //finalWinner.setCoin(10);
            if(versus){
                //versusMethod()
            }
        }
    }

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

    public void starting(){
        roundHandler ();
    }
}
