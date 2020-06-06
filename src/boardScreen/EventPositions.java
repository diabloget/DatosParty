package boardScreen;

import java.util.ArrayList;

public class EventPositions {
    public static ArrayList<Integer> greenMainPath = new ArrayList<>();
    public static ArrayList<Integer> redMainPath = new ArrayList<>();
    public static ArrayList<Integer> yellowMainpath = new ArrayList<>();

    public static ArrayList<Integer> greenDoublePath1 = new ArrayList<>();
    public static ArrayList<Integer> redDoublePath1 = new ArrayList<>();
    public static ArrayList<Integer> yellowDoublepath1 = new ArrayList<>();

    public static ArrayList<Integer> greenDoublePath2 = new ArrayList<>();
    public static ArrayList<Integer> redDoublePath2 = new ArrayList<>();
    public static ArrayList<Integer> yellowDoublepath2 = new ArrayList<>();

    public static ArrayList<Integer> greenSinglePath = new ArrayList<>();
    public static ArrayList<Integer> redSinglePath = new ArrayList<>();
    public static ArrayList<Integer> yellowSinglePath = new ArrayList<>();

    //verde #34ca84
    //rojo #c12f2f
    //Amar #ffbd00

    public static void setEventPosition(String Color, int pos){
        int aux;

        if (pos <= 49) {
            if(Color == "#34ca84"){
                greenMainPath.add(pos);
            }

            if(Color == "#c12f2f"){
                redMainPath.add(pos);
            }

            if(Color == "#ffbd00"){
                yellowMainpath.add(pos);
            }

        }

        if (pos <= 52 & pos > 49) {
            aux = pos - 50;

            if(Color == "#34ca84"){
                greenSinglePath.add(aux);
            }

            if(Color == "#c12f2f"){
                redSinglePath.add(aux);
            }

            if(Color == "#ffbd00"){
                yellowSinglePath.add(aux);
            }
        }

        if (pos <= 61 & pos > 52) {
            aux = pos - 53;

            if(Color == "#34ca84"){
                greenDoublePath1.add(aux);

            }

            if(Color == "#c12f2f"){
                redDoublePath1.add(aux);
            }

            if(Color == "#ffbd00"){
                yellowDoublepath1.add(aux);
            }

        }

        if (pos <= 72 & pos > 61) {
            aux = pos - 62;

            if(Color == "#34ca84"){
                greenDoublePath2.add(aux);
            }

            if(Color == "#c12f2f"){
                redDoublePath2.add(aux);
            }

            if(Color == "#ffbd00"){
                yellowDoublepath2.add(aux);
            }
        }
    }

    public static boolean doEvent(String path, String type, int pos){
        //System.out.println(path + type + pos);

        if(path == "mainPath"){
            if(type == "green"){
                return greenMainPath.contains(pos);
            }
            if(type == "red"){
                return redMainPath.contains(pos);
            }
            if(type == "yellow"){
                return yellowMainpath.contains(pos);
            }
        }

        if(path == "singlePath"){
            if(type == "green"){
                return greenSinglePath.contains(pos);
            }
            if(type == "red"){
                return redSinglePath.contains(pos);
            }
            if(type == "yellow"){
                return yellowSinglePath.contains(pos);
            }
        }

        if(path == "doublePath1"){
            if(type == "green"){
                return greenDoublePath1.contains(pos);
            }
            if(type == "red"){
                return redDoublePath1.contains(pos);
            }
            if(type == "yellow"){
                return yellowDoublepath1.contains(pos);
            }
        }

        if(path == "mainPath"){
            if(type == "green"){
                return greenDoublePath2.contains(pos);
            }
            if(type == "red"){
                return redDoublePath2.contains(pos);
            }
            if(type == "yellow"){
                return yellowDoublepath2.contains(pos);
            }
        }

        if(path == "circularDoblePath"){
            if(type == "yellow"){
                return true;
            }
        }

        return false;
    }


}
