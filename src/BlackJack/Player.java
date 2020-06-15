package BlackJack;

public class Player {
    private boolean isOut = false;
    private String cardHandle;
    private int count;
    Cards card;

    public Player(Cards cardsReference){
        this.card = cardsReference;
    }


    public String getCardHandle() {
        return cardHandle;
    }


    /**
     * Internamente colecciona las cartas y las evalua
     */
    public void hit(){
        getCard();
        int newCard = evaluate(cardHandle);
        count = count + newCard;
        System.out.println (count);

    }


    /**
     * Impide al jugador seguir en el juego
     */
    public void getOut(){
        isOut = true;
    }


    /**
     * @return conteo de cartas
     * Si el jugador se salio entonces es nulo
     */
    public int getCount(){
        if(isOut){
            return 0;
        }else {
            return this.count;
        }
    }


    /**
     * De manera externa devuelve valores de Strings para ser usados en la interfaz
     */
    public void  getCard(){
        cardHandle = card.giveCards ();
    }


    /**
     * @param card
     * @return Carta de forma string evaluada en su valor numerico
     */
    private int evaluate(String card){
        if(card.equals ("A")){
            return 1;
        }else{
            if(card.equals ("J")){
                return 11;
            }else{
                if(card.equals ("Q")){
                    return 12;
                }else{
                    if(card.equals ("K")){
                        return 13;
                    }else{
                        return Integer.parseInt (card);
                    }
                }
            }
        }
    }

}
