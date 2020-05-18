package boardScreen;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class boxes {
    private static int Jesucristo = 0;

    public static Circle detour(String color, int x, int y) {
        //init XYAxes
        if (Jesucristo <= 50) {
            XYAxes.initMainXY(x, y);
        }
        if (Jesucristo <= 53) {
            XYAxes.initSingleXY(x, y);
        }
        if (Jesucristo <= 62) {
            XYAxes.initDoubleXY1(x, y);
        }
        if (Jesucristo <= 73) {
            XYAxes.initDoubleXY2(x, y);
        }
        if (Jesucristo <= 87) {
            XYAxes.initDoubleCircularXY(x, y);
        }
        Jesucristo++;
        //



        Circle circle = new Circle();
        circle.setRadius(26);
        circle.setFill(Color.valueOf(color));
        circle.relocate(x, y);
        return circle;
    }
}
