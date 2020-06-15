package boardScreen;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import playersScreen.PlayerList;

import java.awt.*;

public class Star {
    private static ImageView starIcon = Icons.getIcon(5);
    private static int position;
    private static String path;
    private static Button buyButton = new Button();
    private static boolean available;


    public static ImageView getStarIcon(){
        available = false;
        hideStar(878, 120);
        return starIcon;
    }

    public static void hideStar(int x, int y){
        starIcon.relocate(x+1.5, y);
        starIcon.setOpacity(0);
    }

    public static void renderStar(){
        //Random Position
        if(!available){
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
            starIcon.relocate(xy.x-14, xy.y-8);
            //
            starIcon.setOpacity(1);
        }
        available = true;
    }


    //Métodos relacionados a la posición de la Estrella.

    public static Button starButton(){
        buyButton.setText("Comprar Estrella ");
        buyButton.setStyle("-fx-background-color: #3C3F41");
        buyButton.setOnMousePressed(event -> buyButton.setStyle("-fx-background-color: #313335"));
        buyButton.setOnMouseReleased(event -> buyButton.setStyle("-fx-background-color: #3C3F41"));
        buyButton.setTextFill(Color.valueOf("#C9C9C9"));
        buyButton.setOnAction(event -> checkAvailable());
        buyButton.relocate(143.5,290);
        return buyButton;
    }

    public static void checkAvailable(){
        for(Player player: PlayerList.players){
            if(position == player.getPosition() & path == player.getPath() & available & player.getCoins() >=10){
                System.out.println("Jugador compró estrella");
                player.setStars(1);
                player.minusCoins(10);
                available = false;
                starIcon.setOpacity(0);
                break;
            }
        }
    }

}