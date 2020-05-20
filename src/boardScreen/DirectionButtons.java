package boardScreen;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

public class DirectionButtons {

    public static Button top = new Button();
    public static Button right = new Button();
    public static Button bot = new Button();
    public static Button left = new Button();

    public static void greenButtonsUp(){
        top.setStyle("-fx-background-color: #10E6A0");
    }

    public static void greenButtonsRight(){
        right.setStyle("-fx-background-color: #10E6A0");
    }

    public static void greenButtonsDown(){
        bot.setStyle("-fx-background-color: #10E6A0");
    }

    public static void greenButtonsLeft(){
        left.setStyle("-fx-background-color: #10E6A0");
    }

    public static void defaultColor(){
        top.setStyle("-fx-background-color: #313335");
        right.setStyle("-fx-background-color: #313335");
        bot.setStyle("-fx-background-color: #313335");
        left.setStyle("-fx-background-color: #313335");
    }

    public static Button getTop(){
        top.setStyle("-fx-background-color: #313335");
        top.setOnMousePressed(event -> {
            defaultColor();
            top.setStyle("-fx-background-color: #10E6A0");
        });
        top.setGraphic(Icons.getIcon(6));
        top.relocate(182.5,645);
        return top;
    }

    public static Button getRight(){
        right.setStyle("-fx-background-color: #313335");
        right.setOnMousePressed(event -> {
            defaultColor();
            right.setStyle("-fx-background-color: #10E6A0");
        });
        right.relocate(238,700);
        right.setRotate(90);
        right.setGraphic(Icons.getIcon(7));
        return right;
    }

    public static Button getBot(){
        bot.setStyle("-fx-background-color: #313335");
        bot.setOnMousePressed(event -> {
            defaultColor();
            bot.setStyle("-fx-background-color: #10E6A0");
        });
        bot.relocate(182.5,755);
        bot.setGraphic(Icons.getIcon(8));
        return bot;
    }

    public static Button getLeft(){
        left.setStyle("-fx-background-color: #313335");
        left.setOnMousePressed(event -> {
            defaultColor();
            left.setStyle("-fx-background-color: #10E6A0");
        });
        left.relocate(128,700);
        left.setRotate(90);
        left.setGraphic(Icons.getIcon(9));
        return left;
    }

}
