package BlackJack;

import java.util.*;

public class StackCards {
    public StackCards(){
        Collections.shuffle (Arrays.asList (this.deck));
    }
    private int top;
    private String[] deck ={"A","2","3","4","5","6","7","8","9","10","J","Q","K","A","2","3","4","5","6","7","8","9","10","J","Q","K","A","2","3","4","5","6","7","8","9","10","J","Q","K","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    public String pop(){
        if(top<deck.length){
            return deck[top];
        }else{
            return null;
        }
    }
}