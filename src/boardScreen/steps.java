package boardScreen;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class steps {
    private static int aux;
    private static boolean justone;

    public static void stepCalculator(Player player, KeyEvent e){
        justone = true;
        if(dices.diceValue() != 0){
            if(player.getPath() == "mainPath"){
                if(e.getCode() == KeyCode.LEFT & player.getPosition() == 49   & justone){
                    player.setPosition(0);
                    reducer(player, "mainPath");
                }

                if(e.getCode() == KeyCode.LEFT & player.getPosition() < 14   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "mainPath");
                }

                if(e.getCode() == KeyCode.RIGHT & player.getPosition() >= 24 & player.getPosition() <= 38   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "mainPath");
                }

                if(e.getCode() == KeyCode.UP & player.getPosition() >= 14 & player.getPosition() <= 23  & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "mainPath");
                }
                if(e.getCode() == KeyCode.DOWN & player.getPosition() >= 39 & player.getPosition() <= 48  & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "mainPath");
                }

                if(e.getCode() == KeyCode.UP & player.getPosition() == 10   & justone){
                    player.setPosition(8);
                    reducer(player, "doublePath1");
                }
                if(e.getCode() == KeyCode.RIGHT & player.getPosition() == 19   & justone){
                    player.setPosition(0);
                    reducer(player, "singlePath");
                }

                if(e.getCode() == KeyCode.LEFT & player.getPosition() == 42   & justone){
                    player.setPosition(10);
                    reducer(player, "doublePath2");
                }
            }

            //Movimiento en singlePath
            if(player.getPath() == "singlePath"){
                if(e.getCode() == KeyCode.RIGHT & player.getPosition() == 2   & justone){
                    player.setPosition(4);
                    reducer(player, "doublePath1");
                }
                if(e.getCode() == KeyCode.RIGHT & player.getPosition() >= 0   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "singlePath");
                }
            }



            //Movimiento en doblePath1
            if(player.getPath() == "doublePath1"){
                if(e.getCode() == KeyCode.UP & player.getPosition() > 0 & player.getPosition() <=8   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doublePath1");
                }
                if(e.getCode() == KeyCode.UP & player.getPosition() == 0   & justone){
                    player.setPosition(28);
                    reducer(player, "mainPath");

                }

                if(e.getCode() == KeyCode.RIGHT & player.getPosition() == 3   & justone){
                    player.setPosition(0);
                    reducer(player, "doublePath2");

                }

                if(e.getCode() == KeyCode.DOWN & player.getPosition() >=0 & player.getPosition() <8   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doublePath1");

                }

                if(e.getCode() == KeyCode.DOWN & player.getPosition() == 8   & justone){
                    player.setPosition(10);
                    reducer(player, "mainPath");

                }

            }

            //Movimiento en doblePath2
            if(player.getPath() == "doublePath2"){

                if(e.getCode() == KeyCode.LEFT & player.getPosition() >3 & player.getPosition() <=10   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doublePath2");
                }

                if(e.getCode() == KeyCode.LEFT & player.getPosition() > 0 & player.getPosition() <=2   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doublePath2");
                }

                if(e.getCode() == KeyCode.LEFT & player.getPosition() == 0   & justone){
                    player.setPosition(3);
                    reducer(player, "doublePath1");

                }

                if(e.getCode() == KeyCode.RIGHT & player.getPosition() >=0 & player.getPosition() <2   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doublePath2");

                }

                if(e.getCode() == KeyCode.RIGHT & player.getPosition() >=3 & player.getPosition() <=9   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doublePath2");

                }

                if(e.getCode() == KeyCode.RIGHT & player.getPosition() == 10   & justone){
                    player.setPosition(42);
                    reducer(player, "mainPath");
                }

                if(e.getCode() == KeyCode.UP & player.getPosition() == 2   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doublePath2");

                }

                if(e.getCode() == KeyCode.DOWN & player.getPosition() == 3   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doublePath2");

                }


            }

            //Movimiento en circularDoblePath
            //Movimiento en doblePath1
            if(player.getPath() == "doubleCircularPath"){
                if(e.getCode() == KeyCode.RIGHT & player.getPosition() >=0 & player.getPosition() <4   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doubleCircularPath");
                }

                if(e.getCode() == KeyCode.DOWN & player.getPosition() >=4 & player.getPosition() <7   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doubleCircularPath");
                }

                if(e.getCode() == KeyCode.LEFT & player.getPosition() >=7 & player.getPosition() <11   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doubleCircularPath");
                }

                if(e.getCode() == KeyCode.UP & player.getPosition() >=11 & player.getPosition() <13   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doubleCircularPath");
                }

                if(e.getCode() == KeyCode.UP & player.getPosition() ==13   & justone){
                    player.setPosition(0);
                    reducer(player, "doubleCircularPath");
                }

                ///////////////// REVERSA /////////////////

                if(e.getCode() == KeyCode.LEFT & player.getPosition() >0 & player.getPosition() <=4   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doubleCircularPath");
                }

                if(e.getCode() == KeyCode.DOWN & player.getPosition() <=13 & player.getPosition() >11   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doubleCircularPath");
                }

                if(e.getCode() == KeyCode.RIGHT & player.getPosition() >=11 & player.getPosition() >7   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doubleCircularPath");
                }

                if(e.getCode() == KeyCode.UP & player.getPosition() >=7 & player.getPosition() >4   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doubleCircularPath");
                }

                if(e.getCode() == KeyCode.DOWN & player.getPosition() == 0   & justone){
                    player.setPosition(13);
                    reducer(player, "doubleCircularPath");
                }

            }



        }

    }

    private static void reducer(Player player, String path){
        dices.diceMinus();
        player.setPath(path);
        System.out.println(path);
        player.movePlayer(XYAxes.getXY(path).get(player.getPosition()));
        System.out.println(XYAxes.doubleCircularXY.size());
        justone = false;
    }
}
