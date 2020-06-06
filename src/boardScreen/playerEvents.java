package boardScreen;

import playersScreen.PlayerList;

public class playerEvents {
    private static int lastPosition;
    private static String lastPath;

    public static void checkEvents(){
        winCoins();
        loseCoins();
    }

    public static void versus(String lastPather, int lastPositioner){
        lastPosition = lastPositioner;
        lastPath = lastPather;

        for(Player player: PlayerList.players){
            if(Round.getCurrent().getPosition() == player.getPosition() & Round.getCurrent() != player){

                //System.out.println("LOS JUGADORES TIENEN QUE DARSE A PICHAZOS!!");
                break;
            }
        }

    }

    /**
     * Función que revisa si el jugador debe ganar monedas debido a una casilla.
     * **/
    public static void winCoins(){
        if(EventPositions.doEvent(Round.getCurrent().getPath(), "green", Round.getCurrent().getPosition())  &  dices.diceValue() == 0){ //Buscar en una lista de posiciones en lugar de "== 3"
            Round.getCurrent().setCoins(Round.getCurrent().getCoins() + 4);
            System.out.println("Un jugador acaba de ganar y ahora tiene: " + Round.getCurrent().getCoins());
        }
    }

    /**
     * Función que revisa si el jugador debe perder monedas debido a una casilla.
     * **/
    public static void loseCoins(){
        if(EventPositions.doEvent(Round.getCurrent().getPath(), "red", Round.getCurrent().getPosition())  &  dices.diceValue() == 0){ //Buscar en una lista de posiciones en lugar de "== 5"
            if(Round.getCurrent().getCoins() >= 2){
                Round.getCurrent().minusCoins(2);
            }else{
                Round.getCurrent().setCoins(0);
            }
            System.out.println("Un jugador acaba de perder y ahora tiene: " + Round.getCurrent().getCoins());
        }
    }

    public static void YellowEvent(){
        //despiche
        if(EventPositions.doEvent(Round.getCurrent().getPath(), "yellow", Round.getCurrent().getPosition())  &  dices.diceValue() == 0);
    }

    /**
     * Función que al iniciar un duelo entre dos jugadores, si el jugador que lo inicio pierde, se le castiga
     * haciéndole teleport a la Isla, mientras que si el perdedor fue el pasivo, su castigo será algo más leve.
     * @param player
     */

    public void Punishment(Player player){
        if(player == Round.getCurrent()){
            player.setPath("doubleCircularPath");
            player.setPosition(0);
            player.movePlayer(XYAxes.getXY(player.getPath()).get(player.getPosition()));

        }else{
            player.setPath(lastPath);
            player.setPosition(lastPosition);
            player.movePlayer(XYAxes.getXY(player.getPath()).get(player.getPosition()));
        }

    }
}
