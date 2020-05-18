package playersScreen;

import java.util.ArrayList;

public class PlayerList {
    private static int playertocreate = 1;
    private static ArrayList<String> players = new ArrayList<>();


    public static ArrayList getPlayers(){
        return players;
    }

    public static void setPlayers(String player){
        players.add(player);
    }

    public static int getPlayertocreate(){
        int temp = playertocreate + 0;
        System.out.println(playertocreate);
        playertocreate += 1;
        System.out.println(playertocreate);
        System.out.println(temp);
        return temp;
    }
}