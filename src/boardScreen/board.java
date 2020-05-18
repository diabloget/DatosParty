package boardScreen;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.awt.*;

public class board{
    static private boolean singleton = false;
    private static Pane boardpane = new Pane();
    private static Scene boardscene = new Scene(boardpane,1250,900);


    ///Player
    public static Player player1 = new Player();

    private static void initializator(boolean temp){
        if(temp==false){
            boardpane.setStyle("-fx-background-color: #2B2B2B");
            singleton=true;
            axes.initPaths();

            /////// MAPA

            //bot
            boardpane.getChildren().add(boxes.detour("#f2f270", 1112, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1034, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 956, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 878, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 800, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 722, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 644, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 566, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 488, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 410, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 254, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 176, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 98, 830));

            //left
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 750));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 670));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 590));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 510));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 430));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 350));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 270));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 190));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 110));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 30));

            //top
            boardpane.getChildren().add(boxes.detour("#65bffa", 98, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 176, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 254, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 410, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 488, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 566, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 644, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 722, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 800, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 878, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 956, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1034, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1112, 30));

            //right
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 110));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 190));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 270));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 350));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 430));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 510));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 590));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 670));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 750));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 830));

            //left/mid
            boardpane.getChildren().add(boxes.detour("#65bffa", 98, 430));
            boardpane.getChildren().add(boxes.detour("#65bffa", 176, 430));
            boardpane.getChildren().add(boxes.detour("#65bffa", 254, 430));

            //top/bot in mid
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 110));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 190));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 270));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 350));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 430));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 510));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 590));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 670));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 750));

            //mid/right
            boardpane.getChildren().add(boxes.detour("#65bffa", 410, 350));
            boardpane.getChildren().add(boxes.detour("#65bffa", 488, 350));
            boardpane.getChildren().add(boxes.detour("#65bffa", 566, 350));
            boardpane.getChildren().add(boxes.detour("#65bffa", 566, 270));
            boardpane.getChildren().add(boxes.detour("#65bffa", 644, 270));
            boardpane.getChildren().add(boxes.detour("#65bffa", 722, 270));
            boardpane.getChildren().add(boxes.detour("#65bffa", 800, 270));
            boardpane.getChildren().add(boxes.detour("#65bffa", 878, 270));
            boardpane.getChildren().add(boxes.detour("#65bffa", 956, 270));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1034, 270));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1112, 270));


            //Isla
                //top
            boardpane.getChildren().add(boxes.detour("#ffbd00", 722, 430));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 800, 430));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 878, 430));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 956, 430));
                //right
            boardpane.getChildren().add(boxes.detour("#ffbd00", 1034, 430));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 1034, 510));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 1034, 590));
                //bot
            boardpane.getChildren().add(boxes.detour("#ffbd00", 1034, 670));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 956, 670));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 878, 670));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 800, 670));
                //left
            boardpane.getChildren().add(boxes.detour("#ffbd00", 722, 670));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 722, 590));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 722, 510));


            //
            //boardpane.getChildren().add(Star.getStarIcon());
            boardpane.getChildren().add(dices.buttonOn());
            boardpane.getChildren().add(dices.dice1On());
            boardpane.getChildren().add(dices.dice2On());

            //
            boardpane.getChildren().add(DirectionButtons.getTop());
            boardpane.getChildren().add(DirectionButtons.getRight());
            boardpane.getChildren().add(DirectionButtons.getBot());
            boardpane.getChildren().add(DirectionButtons.getLeft());


            //
            boardpane.getChildren().add(player1.getPlayerIcon());
            player1.movePlayer(new Point(500,500));

            //

            boardpane.setOnKeyPressed(event -> {
                steps.stepCalculator(player1, event);
            });


        }else{
            System.out.println("Singletón confirmado");
        }

    }

    public static Scene getBoardScene() {
        initializator(singleton);
        return boardscene;
    }


}
