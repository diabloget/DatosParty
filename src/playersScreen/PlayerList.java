package playersScreen;

import boardScreen.Player;
import java.util.ArrayList;

public class PlayerList {
    private static int playertocreate = 1;
    private static ArrayList<String> playernames = new ArrayList<>();
    public static ArrayList<Player> players = new ArrayList<>();

    public static Player player1 = new Player();
    public static Player player2 = new Player();
    public static Player player3 = new Player();
    public static Player player4 = new Player();

    //Métodos que corresponden a la lista con el nombre de los jugadores.
    public static ArrayList getPlayernames(){
        return playernames;
    }

    public static void setPlayernames(String player){
        playernames.add(player);
    }


    //Métodos que corresponden a la lista CON los jugadores.
    public static void setPlayers(){
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        int temp = 3;
        while(temp > playernames.size()){
            players.remove(temp);
            temp--;
        }
    }

    public static Player getPlayers(int playertoget){
        return players.get(playertoget);
    }


}