package boardScreen;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

public class DirectionButtons {
    public static int direction = 0;

    public static Button top = new Button();
    public static Button right = new Button();
    public static Button bot = new Button();
    public static Button left = new Button();

    public static void defaultColor(){
        top.setStyle("-fx-background-color: #313335");
        right.setStyle("-fx-background-color: #313335");
        bot.setStyle("-fx-background-color: #313335");
        left.setStyle("-fx-background-color: #313335");
        direction = 0;
    }

    public static Button getTop(){
        top.setStyle("-fx-background-color: #313335");
        top.setOnMousePressed(event -> {
            defaultColor();
            top.setStyle("-fx-background-color: #10E6A0");
            direction = 1;
        });
        top.setGraphic(Icons.getIcon(6));
        top.relocate(182.5,665);
        return top;
    }

    public static Button getRight(){
        right.setStyle("-fx-background-color: #313335");
        right.setOnMousePressed(event -> {
            defaultColor();
            right.setStyle("-fx-background-color: #10E6A0");
            direction = 2;
        });
        right.relocate(238,720);
        right.setRotate(90);
        right.setGraphic(Icons.getIcon(7));
        return right;
    }

    public static Button getBot(){
        bot.setStyle("-fx-background-color: #313335");
        bot.setOnMousePressed(event -> {
            defaultColor();
            bot.setStyle("-fx-background-color: #10E6A0");
            direction = 3;
        });
        bot.relocate(182.5,775);
        bot.setGraphic(Icons.getIcon(8));
        return bot;
    }

    public static Button getLeft(){
        left.setStyle("-fx-background-color: #313335");
        left.setOnMousePressed(event -> {
            defaultColor();
            left.setStyle("-fx-background-color: #10E6A0");
            direction = 4;
        });
        left.relocate(128,720);
        left.setRotate(90);
        left.setGraphic(Icons.getIcon(9));
        return left;
    }

}
