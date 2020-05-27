package BlackJack;

public class Player {
    private boolean isOut = false;
    private String cardHandle;
    private String name;
    private int count;
    Cards card;

    public String getCardHandle() {
        return cardHandle;
    }

    public Player(Cards cardsReference){
        this.card = cardsReference;
    }

    public void hit(){
        getCard();
        int newCard = evaluate(cardHandle);
        count = count + newCard;
        System.out.println (count);

    }


    public void getOut(){
        isOut = true;
    }

    public int getCount(){
        if(isOut){
            return 0;
        }else {
            return this.count;
        }
    }

    public void  getCard(){
        cardHandle = card.giveCards ();
    }

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
