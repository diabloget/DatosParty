package boardScreen;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class boxes {

    public static Circle detour(String color, double x, double y){
        Circle circle = new Circle();
        circle.setRadius(26);
        //circle.setStroke(Color.valueOf(color));
        circle.setFill(Color.valueOf(color));
        //#65bffa azul
        circle.relocate(x, y);
        return circle;
    }
}
