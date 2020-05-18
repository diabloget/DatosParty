package boardScreen;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Icons {
    public static ImageView star = new ImageView(new Image("file:icons/star.png", 80, 80, true, false));

    public static ImageView player1 = new ImageView(new Image("file:icons/player1.png", 50, 50, true, false));
    public static ImageView player2 = new ImageView(new Image("file:icons/player2.png", 50, 50, true, false));
    public static ImageView player3 = new ImageView(new Image("file:icons/player3.png", 50, 50, true, false));
    public static ImageView player4 = new ImageView(new Image("file:icons/player4.png", 50, 50, true, false));

    public static ImageView top = new ImageView(new Image("file:icons/top.png", 18, 18, true, false));
    public static ImageView right = new ImageView(new Image("file:icons/right.png", 18, 18, true, false));
    public static ImageView bot = new ImageView(new Image("file:icons/bot.png", 18, 18, true, false));
    public static ImageView left = new ImageView(new Image("file:icons/left.png", 18, 18, true, false));

    public static ImageView getIcon(int selectedIcon){
        if(selectedIcon == 1){
            return player1;
        }
        if(selectedIcon == 2){
            return player2;
        }
        if(selectedIcon == 3){
            return player3;
        }
        if(selectedIcon == 4){
            return player4;
        }
        if(selectedIcon == 5){
            return star;
        }
        if(selectedIcon == 6){
            return top;
        }
        if(selectedIcon == 7){
            right.setRotate(-90);
            return right;
        }
        if(selectedIcon == 8){
            return bot;
        }
        if(selectedIcon == 9){
            left.setRotate(-90);
            return left;
        }if(selectedIcon == 10){
            return new ImageView(new Image("file:icons/square.png", 8, 8, true, false));
        }
        else{
            return star;
        }
    }
}
