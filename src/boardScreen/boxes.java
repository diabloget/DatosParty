package boardScreen;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class boxes {
    private static int pos = 0;

    public static Circle detour(String color, int x, int y) {
        //Event Position Setter
        EventPositions.setEventPosition(color, pos);

        //init XYAxes
        if (pos <= 49) {
            XYAxes.initMainXY(x, y);
        }
        if (pos <= 52 & pos > 49) {
            XYAxes.initSingleXY(x, y);
        }
        if (pos <= 61 & pos > 52) {
            XYAxes.initDoubleXY1(x, y);
        }
        if (pos <= 72 & pos > 61) {
            XYAxes.initDoubleXY2(x, y);
        }
        if (pos <= 86 & pos > 72) {
            XYAxes.initDoubleCircularXY(x, y);
        }
        ++pos;
        //

        Circle circle = new Circle();
        circle.setRadius(26);
        circle.setFill(Color.valueOf(color));
        circle.relocate(x, y);
        return circle;
    }
}
