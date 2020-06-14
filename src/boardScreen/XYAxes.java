package boardScreen;

import Lists.*;

import java.awt.*;
import java.util.ArrayList;

public class XYAxes {
    public static CircularSimpleLinkedList<Point> mainXY = new CircularSimpleLinkedList<> ();
    public static SimpleLinkedList<Point> singleXY = new SimpleLinkedList<> ();
    public static DoubleLinkedList<Point> doubleXY1 = new DoubleLinkedList<> ();
    public static DoubleLinkedList<Point> doubleXY2 = new DoubleLinkedList<> ();
    public static CircularDoubleLinkedList<Point> doubleCircularXY = new CircularDoubleLinkedList<> ();

    static void initMainXY(int x, int y){
        mainXY.addLast (new Point(x, y));
    }

    static void initSingleXY(int x, int y){
        singleXY.addLast (new Point(x, y));
    }

    static void initDoubleXY1(int x, int y){
        doubleXY1.addLast (new Point(x, y));

    }

    static void initDoubleXY2(int x, int y){
        doubleXY2.addLast (new Point(x, y));
    }

    static void initDoubleCircularXY(int x, int y){
        doubleCircularXY.addLast (new Point(x, y));
    }

    /**
     * Función que recibe una string con el nombre del path y devuelve
     * su equivalente en Lista Enlazada.
     * @param path
     * @return ListPath
     */
    public static ListParent<Point> getXY(String path){
        if(path.equals ("mainPath")){
            return mainXY;
        }if(path.equals ("singlePath")){
            return singleXY;

        }if(path.equals ("doublePath1")){
            return doubleXY1;

        }if(path.equals ("doublePath2")){
            return doubleXY2;

        }if(path.equals ("doubleCircularPath")){
            return doubleCircularXY;
        }
        return mainXY;
    }

}
