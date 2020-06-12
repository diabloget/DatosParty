package boardScreen;

import javafx.scene.image.ImageView;

import java.awt.*;

public class Star {
    private static ImageView starIcon = Icons.getIcon(5);
    private static int position;
    private static String path;
    private static boolean bought;


    public static ImageView getStarIcon(){
        deRenderStar();
        return starIcon;
    }
    public static void deRenderStar(){
        starIcon.setOpacity(0);
    }

    public static void hideStar(int x, int y){
        starIcon.relocate(x+1.5, y);
    }

    public static void renderStar(){
        //Random Position
        int temp = dices.getRandom(0,3);
        if(temp == 0){
            path = "mainPath";
        }
        if(temp == 1){
            path = "singlePath";
        }
        if(temp == 2){
            path = "doublePath1";
        }
        if(temp == 3){
            path = "doublePath2";
        }
        position = dices.getRandom(0, XYAxes.getXY(path).size()-1);
        Point xy = (XYAxes.getXY(path).get(position));
        starIcon.relocate(xy.x+1.5, xy.y);
        //
        starIcon.setOpacity(1);
        resetStar();
    }

    public static void  buyStar(Player player){
        player.setStars(1);
        bought = true;
    }

    public static void resetStar(){
        bought = false;
    }


    //Métodos relacionados a la posición de la Estrella.
    public static int getPosition(){
        return position;
    }

    public static void setPosition(int newPosition){
        position = newPosition;
    }
}
