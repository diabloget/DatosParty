package boardScreen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Random;

public class dices {
    private static int a;
    private static int b;
    private static Label dice1 = new Label();
    private static Label dice2 = new Label();
    private static Button throwButton = new Button();


    public static Button buttonOn(){
        throwButton.setText("Tirar Dados");
        throwButton.setStyle("-fx-background-color: #3C3F41");
        throwButton.setOnMousePressed(event -> throwButton.setStyle("-fx-background-color: #313335"));
        throwButton.setOnMouseReleased(event -> throwButton.setStyle("-fx-background-color: #3C3F41"));
        throwButton.setTextFill(Color.valueOf("#C9C9C9"));
        throwButton.setOnAction(event -> diceSet());
        throwButton.relocate(163,550);
        return throwButton;
    }

    public static Label dice1On(){
        dice1.setStyle("-fx-background-color: #3C3F41");
        dice1.setText("");
        dice1.setFont(Font.font(50));
        dice1.setAlignment(Pos.CENTER);
        dice1.setTextFill(Color.valueOf("#C9C9C9"));
        dice1.relocate(132,580);
        dice1.setPrefSize(65,65);
        return dice1;
    }

    public static Label dice2On(){
        dice2.setStyle("-fx-background-color: #3C3F41");
        dice2.setText("");
        dice2.setFont(Font.font(50));
        dice2.setAlignment(Pos.CENTER);
        dice2.setTextFill(Color.valueOf("#C9C9C9"));
        dice2.relocate(203,580);
        dice2.setPrefSize(65,65);
        return dice2;
    }

    private static void diceSet(){
        a=getRandom(1, 6);
        b=getRandom(1, 6);
        dice1.setText(Integer.toString(a));
        dice2.setText(Integer.toString(b));

        steps.stepCalculator(board.player1, a+b, DirectionButtons.direction);
    }

    private static void diceClear(){
        dice1.setText("");
        dice2.setText("");
    }


    public static int getRandom(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
