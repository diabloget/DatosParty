package BlackJack;

public class Cards {
    private StackCards stack = new StackCards ();
    private Player winner;

    /**
     * Funciona como un pop de un pseudostack
     */
    public String giveCards(){
        String poping = stack.pop ();
        if(poping==null){
            createStack ();
            return giveCards ();
        }else{
            return poping;
        }
    }

    /**
     * Funcion cambia los valores del stack en caso de acabarse
     */
    public void createStack(){
        this.stack =  new StackCards ();
    }


}
