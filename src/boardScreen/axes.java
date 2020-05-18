package boardScreen;

import java.util.ArrayList;

public class axes {
    public static ArrayList<Integer> mainPath = new ArrayList<Integer>();
    public static ArrayList<Integer> singlePath = new ArrayList<Integer>();
    public static ArrayList<Integer> doublePath1 = new ArrayList<Integer>();
    public static ArrayList<Integer> doublePath2 = new ArrayList<Integer>();
    public static ArrayList<Integer> doubleCircularPath = new ArrayList<Integer>();

    public static void setMainPath() {
        int temp = 0;
        while(temp<50){
            mainPath.add(temp);
            temp++;
        }
    }

    public static void setSinglePath() {
        int temp = 0;
        while(temp<3){
            singlePath.add(temp);
            temp++;
        }
    }

    public static void setDoublePath1() {
        int temp = 0;
        while(temp<9){
            doublePath1.add(temp);
            temp++;
        }
    }

    public static void setDoublePath2() {
        int temp = 0;
        while(temp<11){
            doublePath2.add(temp);
            temp++;
        }
    }

    public static void setDoubleCircularPath() {
        int temp = 0;
        while(temp<14){
            doubleCircularPath.add(temp);
            temp++;
        }
    }


    public static void initPaths(){
        setMainPath();
        setSinglePath();
        setDoublePath1();
        setDoublePath2();
        setDoubleCircularPath();
    }

    public static int pathSize(String Path){
        if(Path == "mainPath"){
            return mainPath.size();
        }if(Path == "singlePath"){
            return singlePath.size();

        }if(Path == "doublePath1"){
            return doublePath1.size();

        }if(Path == "doublePath2"){
            return doublePath2.size();

        }if(Path == "doubleCircularPath"){
            return doubleCircularPath.size();
        }
        return 0;
    }

}
