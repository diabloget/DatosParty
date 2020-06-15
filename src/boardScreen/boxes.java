package boardScreen;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class boxes {
    private static int pos = 0;

    /**
     * Crea y personaliza cada uno de los círculos que
     * corresponden al mapa del tablero.
     * También añade las posiciones a las listas de posiciones y
     * las posiciones se envían para ser añadidas si son eventos
     * a sus respectivas listas en la clase EventPositions.
     * @param color
     * @param x
     * @param y
     * @return Circle
     */
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
