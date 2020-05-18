package boardScreen;

import javafx.scene.image.ImageView;

public class Star {
    private static ImageView starIcon = Icons.getIcon(5);
    private static int position;


    public static ImageView getStarIcon(){
        return starIcon;
    }

    public static void moveStar(int x, int y){
        starIcon.relocate(x+1.5, y);
    }

    //Métodos relacionados a la posición del jugador.
    public static int getPosition(){
        return position;
    }

    public static void setPosition(int newPosition){
        position = newPosition;
    }
}
