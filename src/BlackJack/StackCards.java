package BlackJack;

import java.util.*;

public class StackCards {
    public StackCards(){
        Collections.shuffle (Arrays.asList (this.deck));
    }
    private int top = 0;
    private String[] deck ={"A","2","3","4","5","6","7","8","9","10","J","Q","K","A","2","3","4","5","6","7","8","9","10","J","Q","K","A","2","3","4","5","6","7","8","9","10","J","Q","K","A","2","3","4","5","6","7","8","9","10","J","Q","K"};


    /**
     * @return Valor de String de la carta encima del stack.
     */
    public String pop(){
        if(top<deck.length){
            String returnPop =  deck[top];
            top++;
            return returnPop;
        }else{
            return null;
        }
    }
}