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
    private static boolean fix = false;

    public static void fixFirstRound(){
        fix = true;
    }

    /**
     * Personaliza y devuelve el botón que setea los dados.
     * @return Button
     */
    public static Button buttonOn(){
        throwButton.setText("Tirar Dados");
        throwButton.setStyle("-fx-background-color: #3C3F41");
        throwButton.setOnMousePressed(event -> throwButton.setStyle("-fx-background-color: #313335"));
        throwButton.setOnMouseReleased(event -> throwButton.setStyle("-fx-background-color: #3C3F41"));
        throwButton.setTextFill(Color.valueOf("#C9C9C9"));
        throwButton.setOnAction(event -> diceSet());
        throwButton.relocate(163,500);
        return throwButton;
    }

    /**
     * Personaliza y devuelve el label de uno de los dados.
     * @return Label
     */
    public static Label dice1On(){
        dice1.setStyle("-fx-background-color: #3C3F41");
        dice1.setText("");
        dice1.setFont(Font.font(50));
        dice1.setAlignment(Pos.CENTER);
        dice1.setTextFill(Color.valueOf("#C9C9C9"));
        dice1.relocate(132,530);
        dice1.setPrefSize(65,65);
        return dice1;
    }

    /**
     * Personaliza y devuelve el label de uno de los dados.
     * @return Label
     */
    public static Label dice2On(){
        dice2.setStyle("-fx-background-color: #3C3F41");
        dice2.setText("");
        dice2.setFont(Font.font(50));
        dice2.setAlignment(Pos.CENTER);
        dice2.setTextFill(Color.valueOf("#C9C9C9"));
        dice2.relocate(203,530);
        dice2.setPrefSize(65,65);
        return dice2;
    }

    /**
     * Reinicia con randoms el valor de ambos dados.
     */
    private static void diceSet(){
        if(a+b != 0){
            //System.out.println("Ira we no mames");
        }else{
            a=getRandom(1, 4);
            b=getRandom(1, 4);
            dice1.setText(Integer.toString(a));
            dice2.setText(Integer.toString(b));

            if(fix){
                Round.RoundUpdate();
            }fixFirstRound();
        }
    }

    /**
     * Reduce el numero dentro del dado cada vez
     * que se da un paso.
     */
    public static void diceMinus(){
        if (a == 0 & b != 0){
            b--;
            dice2.setText(Integer.toString(b));
        }
        if(a != 0){
            a--;
            dice1.setText(Integer.toString(a));
        }
        /*if(a+b == 0){
            //Justo antes del comando de abajo se podría llamar un método en Round (no existe aún) que agarre el jugador y si está en casilla de evento lo ejecuta ( no evento jVj)
            Round.RoundUpdate();
        }*/
    }

    /**
     * Método que retorna el valor interno de los dados
     * (valor restante)
     * @return int
     */
    public static int diceValue(){
        return a+b;
    }

    private static void diceClear(){
        dice1.setText("0");
        dice2.setText("0");
    }


    /**
     * Método para calcular randoms entre un rango.
     * @param min
     * @param max
     * @return Int
     */
    public static int getRandom(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
