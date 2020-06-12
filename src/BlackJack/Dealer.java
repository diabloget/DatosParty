package BlackJack;

public class Dealer {
    public Dealer(String[]names){
        this.names = names;
        this.numberOfPlayers = names.length;
        players = new Player[names.length];
        results = new int[names.length];
        for(int a = 0; a< numberOfPlayers; a++){
            players[a] = new Player (deck);
        }
    }

    public int howManytie;
    public String[] ties = new String[4];
    int numberOfPlayers;
    int whoIsPlaying = 0;
    int cardNumber = 0;
    private int[] results;
    String newCard;
    private String[] names;
    private Player[] players;
    private Cards deck = new Cards ();

    public int getCount(){
        return players[whoIsPlaying].getCount ();
    }


    /**
     * @return el indice del jugador ganador de la partida
     */
    public int getWinner(){
        int index = 0;
        int holdValue = results[0];
        for(int score : results){
            if(score > holdValue){
                index++;
            }
        }
        return index;
    }


    /**
     * @return Verdadero en caso de haber algun empate
     */
    public boolean isTie(){
        int winner=-1;
        boolean tie = false;
        for(int result : results){
            if(result > winner){
                tie = false;
                winner = result;
            }else{
                if(result == winner){
                    tie = true;
                }
            }
        }
        if(tie){
            for(int index = 0; index < results.length; index++){
                if(results[index] == winner){
                    howManytie++;
                    ties[index] = names[index];
                }
            }
        }
        return tie;
    }


    /**
     * @return Verdadero en caso de que se deba terminar el juego
     */
    public boolean isOver(){
        return whoIsPlaying > names.length-1;
    }


    /**
     * @return nombre de quien este jugando actualmente
     */
    public String getWhoIsPlaying(){
        return names[whoIsPlaying];
    }

    /**
     * Maneja internamente el boton de stop
     * Condciona al objeto Player de parar
     */
    public void stop(){
        results[whoIsPlaying] = getCount ();
        whoIsPlaying++;
        cardNumber = 0;
    }

    /**
     * Maneja internamente el boton de get out
     * Condciona al objeto Player de salir
     */
    public void getOut(){
        results[whoIsPlaying] = 0;
        players[whoIsPlaying].getOut ();
        cardNumber = 0;
        whoIsPlaying++;
    }

    /**
     * Maneja internamente el boton de hit
     * Condciona al objeto Player de obtener cartas
     */
    public void hit(){
        players[whoIsPlaying].hit ();
        newCard = players[whoIsPlaying].getCardHandle ();
        cardNumber++;
    }





}
