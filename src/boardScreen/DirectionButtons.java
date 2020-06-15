package boardScreen;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class DirectionButtons {

    public static Button top = new Button();
    public static Button right = new Button();
    public static Button bot = new Button();
    public static Button left = new Button();

    public static void greenButtonsUp(){
        top.setStyle("-fx-background-color: #10E6A0");
        Round.moveCurrent(KeyCode.UP);
    }

    public static void greenButtonsRight(){
        right.setStyle("-fx-background-color: #10E6A0");
        Round.moveCurrent(KeyCode.RIGHT);
    }

    public static void greenButtonsDown(){
        bot.setStyle("-fx-background-color: #10E6A0");
        Round.moveCurrent(KeyCode.DOWN);
    }

    public static void greenButtonsLeft(){
        left.setStyle("-fx-background-color: #10E6A0");
        Round.moveCurrent(KeyCode.LEFT);
    }

    /**
     * Método para settear el color del botón a su color
     * por defecto.
     */
    public static void defaultColor(){
        top.setStyle("-fx-background-color: #313335");
        right.setStyle("-fx-background-color: #313335");
        bot.setStyle("-fx-background-color: #313335");
        left.setStyle("-fx-background-color: #313335");
    }

    /**
     * Personaliza y devuelve uno de los botones de dirección
     * @return Button
     */
    public static Button getTop(){
        top.setStyle("-fx-background-color: #313335");
        top.setOnMousePressed(event -> {
            defaultColor();
            greenButtonsUp();
        });
        top.setOnMouseReleased(event -> defaultColor());
        top.setGraphic(Icons.getIcon(6));
        top.relocate(182.5,645);
        return top;
    }

    /**
     * Personaliza y devuelve uno de los botones de dirección
     * @return Button
     */
    public static Button getRight(){
        right.setStyle("-fx-background-color: #313335");
        right.setOnMousePressed(event -> {
            defaultColor();
            greenButtonsRight();
        });
        right.setOnMouseReleased(event -> defaultColor());
        right.relocate(238,700);
        right.setRotate(90);
        right.setGraphic(Icons.getIcon(7));
        return right;
    }

    /**
     * Personaliza y devuelve uno de los botones de dirección
     * @return Button
     */
    public static Button getBot(){
        bot.setStyle("-fx-background-color: #313335");
        bot.setOnMousePressed(event -> {
            defaultColor();
            greenButtonsDown();
        });
        bot.setOnMouseReleased(event -> defaultColor());
        bot.relocate(182.5,755);
        bot.setGraphic(Icons.getIcon(8));
        return bot;
    }

    /**
     * Personaliza y devuelve uno de los botones de dirección
     * @return Button
     */
    public static Button getLeft(){
        left.setStyle("-fx-background-color: #313335");
        left.setOnMousePressed(event -> {
            defaultColor();
            greenButtonsLeft();
        });
        left.setOnMouseReleased(event -> defaultColor());
        left.relocate(128,700);
        left.setRotate(90);
        left.setGraphic(Icons.getIcon(9));
        return left;
    }

}
