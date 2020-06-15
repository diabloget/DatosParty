package boardScreen;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import playersScreen.PlayerList;
import scoreScreen.scoreTable;

import java.awt.*;

public class Player {
    private String name;
    private ImageView playerIcon = Icons.getPlayerIcon();
    private int position = -1;
    private String path = "mainPath";
    private int coins;
    private int stars;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    /**
     * Método que mueve gráficamente al jugador, tiene un añadido
     * al eje x para asegurarse que el ícono encaje correctamente.
     * @param xy
     */
    public void movePlayer(Point xy){
        //System.out.println("Posición en " + this.path + "es " + position);
        playerIcon.setOpacity(1);

        playerIcon.relocate(xy.x + 1.5, xy.y);
    }

    //
    public void setPath(String Path){
       path = Path;
    }

    public String getPath(){
        return path;
    }


    //
    public ImageView getPlayerIcon(){
        playerIcon.setOpacity(0);
        return playerIcon;
    }

    //Métodos relacionados a las estrellas del jugador.
    public void setStars(int starsadded){
        if(stars + starsadded>=0){
            stars += starsadded;
        }else{
            stars = 0;
        }
        
        scoreTable.updatePlayerData();
    }

    public int getStars(){
        return stars;
    }

    //Métodos relacionados a las monedas del jugador.
    public void setCoins(int coinsadded){
        if(getCoins ()+ coinsadded > 0) {
            this.coins+=coinsadded;
        }else{
            coins = 0;
        }

        scoreTable.updatePlayerData();
    }

    public int getCoins(){
        return coins;
    }

    public void minusCoins(int minus){
        if(this.coins < minus){
            this.coins = 0;
        }else {

            this.coins = this.coins - minus;
        }

        scoreTable.updatePlayerData();
    }

    //Métodos relacionados a la posición del jugador.
    public int getPosition(){
        return position;
    }

    public void setPosition(int newPosition){
        position = newPosition;
    }

}
