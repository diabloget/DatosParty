package boardScreen;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class icons {
    public static ImageView star = new ImageView(new Image("file:icons/star.png", 80, 80, true, false));

    public static ImageView player1 = new ImageView(new Image("file:icons/player1.png", 100, 100, true, false));
    public static ImageView player2 = new ImageView(new Image("file:icons/player2.png", 100, 100, true, false));
    public static ImageView player3 = new ImageView(new Image("file:icons/player3.png", 100, 100, true, false));
    public static ImageView player4 = new ImageView(new Image("file:icons/player4.png", 100, 100, true, false));

    //public static void playericon(int player){
    //}

    public static ImageView starOn(){
        star.relocate(2,20);
        return star;
    }
    public static void starRelocater(){
        star.relocate(50,50);
    }



    public static ImageView player1On(){
        star.relocate(2,20);
        return star;
    }

    //star.relocate(2,20);
}
