package boardScreen;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import playersScreen.PlayerList;

import java.awt.*;

public class Player {
    public static ImageView playerIcon = Icons.getIcon(PlayerList.getPlayertocreate());
    private static int position = -1;
    private static String path = "mainPath";
    private static int coins;
    private static int stars;

    public static void movePlayer(Point xy){
        //playerIcon.setOpacity(1);
        playerIcon.relocate(xy.x + 1.5, xy.y);
    }

    //
    public static void setPath(String Path){
       path = Path;
    }
    public static String getPath(){
        return path;
    }


    //
    public static ImageView getPlayerIcon(){
        //playerIcon.setOpacity(0);
        return playerIcon;
    }

    //Métodos relacionados a las estrellas del jugador.
    public static void setStars(int starsadded){
        stars += starsadded;
    }
    public static int getStars(){
        return stars;
    }

    //Métodos relacionados a las monedas del jugador.
    public static void setCoins(int coinsadded){
        coins += coinsadded;
    }

    public static int getCoins(){
        return coins;
    }

    //Métodos relacionados a la posición del jugador.
    public static int getPosition(){
        return position;
    }

    public static void setPosition(int newPosition){
        position = newPosition;
    }

}
