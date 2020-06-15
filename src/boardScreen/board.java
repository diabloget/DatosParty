package boardScreen;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import playersScreen.PlayerList;
import scoreScreen.scoreTable;

import java.awt.*;
import java.io.FileNotFoundException;

public class board{
    static private boolean singleton = false;
    private static Pane boardpane = new Pane();
    private static Scene boardscene = new Scene(boardpane,1250,900);

    /**
     * Añade todos los elementos a la scene del tablero.
     * @param temp
     */
    private static void initializator(boolean temp){
        if(temp==false){
            boardpane.setStyle("-fx-background-color: #2B2B2B");
            singleton=true;
            //axes.initPaths();
            /////// MAPA

            //bot
            boardpane.getChildren().add(boxes.detour("#65bffa", 1112, 830));
            boardpane.getChildren().add(boxes.detour("#c12f2f", 1034, 830));
            boardpane.getChildren().add(boxes.detour("#34ca84", 956, 830));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 878, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 800, 830));
            boardpane.getChildren().add(boxes.detour("#c12f2f", 722, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 644, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 566, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 488, 830));
            boardpane.getChildren().add(boxes.detour("#34ca84", 410, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 830));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 254, 830));
            boardpane.getChildren().add(boxes.detour("#34ca84", 176, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 98, 830));

            //left
            boardpane.getChildren().add(boxes.detour("#c12f2f", 15, 830));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 750));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 15, 670));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 590));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 510));
            boardpane.getChildren().add(boxes.detour("#34ca84", 15, 430));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 350));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 15, 270));
            boardpane.getChildren().add(boxes.detour("#65bffa", 15, 190));
            boardpane.getChildren().add(boxes.detour("#34ca84", 15, 110));
            boardpane.getChildren().add(boxes.detour("#c12f2f", 15, 30));

            //top
            boardpane.getChildren().add(boxes.detour("#34ca84", 98, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 176, 30));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 254, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 332, 30));
            boardpane.getChildren().add(boxes.detour("#34ca84", 410, 30));
            boardpane.getChildren().add(boxes.detour("#c12f2f", 488, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 566, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 644, 30));
            boardpane.getChildren().add(boxes.detour("#34ca84", 722, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 800, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 878, 30));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 956, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1034, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1112, 30));

            //right
            boardpane.getChildren().add(boxes.detour("#c12f2f", 1195, 30));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 110));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 1195, 190));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 270));
            boardpane.getChildren().add(boxes.detour("#34ca84", 1195, 350));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 430));
            boardpane.getChildren().add(boxes.detour("#c12f2f", 1195, 510));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 1195, 590));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 670));
            boardpane.getChildren().add(boxes.detour("#34ca84", 1195, 750));
            boardpane.getChildren().add(boxes.detour("#65bffa", 1195, 830));

            //left/mid
            boardpane.getChildren().add(boxes.detour("#65bffa", 98, 430));
            boardpane.getChildren().add(boxes.detour("#c12f2f", 176, 430));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 254, 430));

            //top/bot in mid
            boardpane.getChildren().add(boxes.detour("#ffbd00", 332, 110));
            boardpane.getChildren().add(boxes.detour("#c12f2f", 332, 190));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 332, 270));
            boardpane.getChildren().add(boxes.detour("#34ca84", 332, 350));
            boardpane.getChildren().add(boxes.detour("#c12f2f", 332, 430));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 332, 510));
            boardpane.getChildren().add(boxes.detour("#34ca84", 332, 590));
            boardpane.getChildren().add(boxes.detour("#c12f2f", 332, 670));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 332, 750));
            //rojo #c12f2f
            //Azul #65bffa
            //verde #34ca84
            //Amar #ffbd00

            //mid/right
            boardpane.getChildren().add(boxes.detour("#c12f2f", 410, 350));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 488, 350));
            boardpane.getChildren().add(boxes.detour("#34ca84", 566, 350));
            boardpane.getChildren().add(boxes.detour("#65bffa", 566, 270));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 644, 270));
            boardpane.getChildren().add(boxes.detour("#34ca84", 722, 270));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 800, 270));
            boardpane.getChildren().add(boxes.detour("#34ca84", 878, 270));
            boardpane.getChildren().add(boxes.detour("#c12f2f", 956, 270));
            boardpane.getChildren().add(boxes.detour("#ffbd00", 1034, 270));
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
            for(Player player:PlayerList.players){
                boardpane.getChildren().add(player.getPlayerIcon());
            }

            scoreTable.InitDataTable(90,110);
            for(HBox hboxito:scoreTable.hBoxes){
                boardpane.getChildren().add(hboxito);
            }


            boardpane.setOnKeyPressed(event -> {
                try {
                    Round.moveCurrent(event);
                } catch (FileNotFoundException e) {
                    e.printStackTrace ();
                }

                if(event.getCode() == KeyCode.UP){
                    DirectionButtons.greenButtonsUp();
                }
                if(event.getCode() == KeyCode.RIGHT){
                    DirectionButtons.greenButtonsRight();
                }
                if(event.getCode() == KeyCode.LEFT){
                    DirectionButtons.greenButtonsLeft();
                }
                if(event.getCode() == KeyCode.DOWN){
                    DirectionButtons.greenButtonsDown();
                }

            });

            boardpane.setOnKeyReleased(event -> {
                DirectionButtons.defaultColor();
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
