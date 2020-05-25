package BlackJack;

public class BlackJack {
    int numberOfPlayers;
    int whoIsPlaying = 0;
    int cardNumber = 0;
    String newCard;
    private Player[] players;
    private Cards deck;
    public BlackJack(String[]names){
        this.numberOfPlayers = names.length;
        for(int a = 0; a< numberOfPlayers; a++){
            players[a] = new Player (deck);
        }
    }
    public void startPlaying(){
        cardNumber = 0;
        getOut ();
        getOut ();
    }
    public void stop(){
        players[whoIsPlaying].stop ();
        whoIsPlaying++;
        startPlaying ();
    }

    public void getOut(){
        players[whoIsPlaying].getOut ();
        newCard = players[whoIsPlaying].getCardHandle ();
        whoIsPlaying++;
        startPlaying ();
    }

    public void getCard(){
        players[whoIsPlaying].getCard ();
        cardNumber++;
    }





}
