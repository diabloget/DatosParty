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
        if (Jesucristo <= 49) {
            XYAxes.initMainXY(x, y);
        }
        if (Jesucristo <= 52 & Jesucristo > 49) {
            XYAxes.initSingleXY(x, y);
        }
        if (Jesucristo <= 61 & Jesucristo > 52) {
            XYAxes.initDoubleXY1(x, y);
        }
        if (Jesucristo <= 72 & Jesucristo > 61) {
            XYAxes.initDoubleXY2(x, y);
        }
        if (Jesucristo <= 86 & Jesucristo > 72) {
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
