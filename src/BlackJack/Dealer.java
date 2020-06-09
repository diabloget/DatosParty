package BlackJack;

public class Dealer {
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
    public Dealer(String[]names){
        this.names = names;
        this.numberOfPlayers = names.length;
        players = new Player[names.length];
        results = new int[names.length];
        for(int a = 0; a< numberOfPlayers; a++){
            players[a] = new Player (deck);
        }
    }
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
    public int getCount(){
        return players[whoIsPlaying].getCount ();
    }
    public boolean isOver(){
        return whoIsPlaying > names.length-1;
    }
    public String getWhoIsPlaying(){
        return names[whoIsPlaying];
    }

    public void stop(){
        results[whoIsPlaying] = getCount ();
        whoIsPlaying++;
        cardNumber = 0;
    }

    public void getOut(){
        results[whoIsPlaying] = 0;
        players[whoIsPlaying].getOut ();
        cardNumber = 0;
        whoIsPlaying++;
    }

    public void hit(){
        players[whoIsPlaying].hit ();
        newCard = players[whoIsPlaying].getCardHandle ();
        cardNumber++;
    }





}
