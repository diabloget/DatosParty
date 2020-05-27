package BlackJack;

public class Cards {
    private StackCards stack = new StackCards ();
    private Player winner;

    public String giveCards(){
        String poping = stack.pop ();
        if(poping==null){
            createStack ();
            return giveCards ();
        }else{
            return poping;
        }
    }

    public void createStack(){
        this.stack =  new StackCards ();
    }


}
