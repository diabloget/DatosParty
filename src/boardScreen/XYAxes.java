package boardScreen;

import java.awt.*;
import java.util.ArrayList;

public class XYAxes {
    public static ArrayList<Point> mainXY = new ArrayList<Point>();
    public static ArrayList<Point> singleXY = new ArrayList<Point>();
    public static ArrayList<Point> doubleXY1 = new ArrayList<Point>();
    public static ArrayList<Point> doubleXY2 = new ArrayList<Point>();
    public static ArrayList<Point> doubleCircularXY = new ArrayList<Point>();

    static void initMainXY(int x, int y){
        mainXY.add(new Point(x, y));
    }

    static void initSingleXY(int x, int y){
        singleXY.add(new Point(x, y));
    }

    static void initDoubleXY1(int x, int y){
        doubleXY1.add(new Point(x, y));

    }

    static void initDoubleXY2(int x, int y){
        doubleXY2.add(new Point(x, y));
    }

    static void initDoubleCircularXY(int x, int y){
        doubleCircularXY.add(new Point(x, y));
    }

    /**
     * Función que recibe una string con el nombre del path y devuelve
     * su equivalente en Lista Enlazada.
     * @param path
     * @return ListPath
     */
    public static ArrayList<Point> getXY(String path){
        if(path == "mainPath"){
            return mainXY;
        }if(path == "singlePath"){
            return singleXY;

        }if(path == "doublePath1"){
            return doubleXY1;

        }if(path == "doublePath2"){
            return doubleXY2;

        }if(path == "doubleCircularPath"){
            return doubleCircularXY;
        }
        return mainXY;
    }

}
