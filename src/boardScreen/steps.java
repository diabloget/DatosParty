package boardScreen;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class steps {
    private static int lastPosition;
    private static String lastPath;
    private static boolean justone;
    private static int restriction = 0;

    /**
     * Método que analiza el evento de tecla para comprobar su
     * factibilidad y así calcular la posición del jugador.
     * @param player
     * @param e
     */
    public static void stepCalculator(Player player, KeyCode e){
        lastPosition = player.getPosition();
        lastPath = player.getPath();
        justone = true;
        if(dices.diceValue() != 0){
            //Movimiento en mainPath
            if(player.getPath() == "mainPath"){
                if(e == KeyCode.LEFT & player.getPosition() == 49   & justone){
                    player.setPosition(0);
                    reducer(player, "mainPath");
                }

                if(e == KeyCode.LEFT & player.getPosition() < 14   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "mainPath");
                }

                if(e == KeyCode.RIGHT & player.getPosition() >= 24 & player.getPosition() <= 38   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "mainPath");
                }

                if(e == KeyCode.UP & player.getPosition() >= 14 & player.getPosition() <= 23  & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "mainPath");
                }
                if(e == KeyCode.DOWN & player.getPosition() >= 39 & player.getPosition() <= 48  & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "mainPath");
                }
                if(e == KeyCode.UP & player.getPosition() == 10   & justone & restriction != 1){
                    restriction = 1;

                    player.setPosition(8);
                    reducer(player, "doublePath1");
                }
                if(e == KeyCode.DOWN & player.getPosition() == 28  & justone & restriction != 2){
                    restriction = 2;

                    player.setPosition(0);
                    reducer(player, "doublePath1");
                }
                if(e == KeyCode.RIGHT & player.getPosition() == 19   & justone){
                    player.setPosition(0);
                    reducer(player, "singlePath");
                }

                if(e == KeyCode.LEFT & player.getPosition() == 42   & justone & restriction != 2){
                    restriction = 2;

                    player.setPosition(10);
                    reducer(player, "doublePath2");
                }
            }

            //Movimiento en singlePath
            if(player.getPath() == "singlePath"){
                if(e == KeyCode.RIGHT & player.getPosition() == 2   & justone){
                    player.setPosition(4);
                    reducer(player, "doublePath1");
                }
                if(e == KeyCode.RIGHT & player.getPosition() >= 0   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "singlePath");
                }
            }



            //Movimiento en doblePath1
            if(player.getPath() == "doublePath1"){
                if(e == KeyCode.UP & player.getPosition() > 0 & player.getPosition() <=8   & justone & restriction != 2){
                    restriction = 1;

                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doublePath1");
                }
                if(e == KeyCode.UP & player.getPosition() == 0   & justone & restriction != 2){
                    restriction = 2;
                    player.setPosition(28);
                    reducer(player, "mainPath");

                }

                if(e == KeyCode.RIGHT & player.getPosition() == 3   & justone & restriction != 4){
                    restriction = 4;

                    player.setPosition(0);
                    reducer(player, "doublePath2");

                }

                if(e == KeyCode.DOWN & player.getPosition() >=0 & player.getPosition() <8   & justone & restriction != 1){
                    restriction = 2;
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doublePath1");

                }

                if(e == KeyCode.DOWN & player.getPosition() == 8   & justone & restriction != 1){
                    restriction = 1;

                    player.setPosition(10);
                    reducer(player, "mainPath");

                }

            }

            //Movimiento en doblePath2
            if(player.getPath() == "doublePath2"){

                if(e == KeyCode.LEFT & player.getPosition() >3 & player.getPosition() <=10   & justone & restriction != 1){
                    restriction = 2;

                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doublePath2");
                }

                if(e == KeyCode.LEFT & player.getPosition() > 0 & player.getPosition() <=2   & justone & restriction != 1){
                    restriction = 2;

                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doublePath2");
                }

                if(e == KeyCode.LEFT & player.getPosition() == 0   & justone & restriction != 4){
                    restriction = 4;

                    player.setPosition(3);
                    reducer(player, "doublePath1");

                }

                if(e == KeyCode.RIGHT & player.getPosition() >=0 & player.getPosition() <2   & justone & restriction != 2){
                    restriction = 1;

                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doublePath2");

                }

                if(e == KeyCode.RIGHT & player.getPosition() >=3 & player.getPosition() <=9   & justone & restriction != 2){
                    restriction = 1;

                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doublePath2");

                }

                if(e == KeyCode.RIGHT & player.getPosition() == 10   & justone & restriction != 2){
                    restriction = 2;

                    player.setPosition(42);
                    reducer(player, "mainPath");
                }

                if(e == KeyCode.UP & player.getPosition() == 2   & justone & restriction != 2){
                    restriction = 1;

                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doublePath2");

                }

                if(e == KeyCode.DOWN & player.getPosition() == 3   & justone & restriction != 1){
                    restriction = 2;

                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doublePath2");

                }


            }

            //Movimiento en circularDoblePath
            //Movimiento en doblePath1
            if(player.getPath() == "doubleCircularPath"){
                if(e == KeyCode.RIGHT & player.getPosition() >=0 & player.getPosition() <4   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doubleCircularPath");
                }

                if(e == KeyCode.DOWN & player.getPosition() >=4 & player.getPosition() <7   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doubleCircularPath");
                }

                if(e == KeyCode.LEFT & player.getPosition() >=7 & player.getPosition() <11   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doubleCircularPath");
                }

                if(e == KeyCode.UP & player.getPosition() >=11 & player.getPosition() <13   & justone){
                    player.setPosition(player.getPosition()+1);
                    reducer(player, "doubleCircularPath");
                }

                if(e == KeyCode.UP & player.getPosition() ==13   & justone){
                    player.setPosition(0);
                    reducer(player, "doubleCircularPath");
                }

                ///////////////// REVERSA /////////////////

                if(e == KeyCode.LEFT & player.getPosition() >0 & player.getPosition() <=4   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doubleCircularPath");
                }

                if(e == KeyCode.DOWN & player.getPosition() <=13 & player.getPosition() >11   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doubleCircularPath");
                }

                if(e == KeyCode.RIGHT & player.getPosition() >=11 & player.getPosition() >7   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doubleCircularPath");
                }

                if(e == KeyCode.UP & player.getPosition() >=7 & player.getPosition() >4   & justone){
                    player.setPosition(player.getPosition()-1);
                    reducer(player, "doubleCircularPath");
                }

                if(e == KeyCode.DOWN & player.getPosition() == 0   & justone){
                    player.setPosition(13);
                    reducer(player, "doubleCircularPath");
                }

            }



        }

    }

    /**
     * Método que se encarga de mover al jugador gráfica y verbalmente.
     * @param player
     * @param path
     */
    private static void reducer(Player player, String path){

        dices.diceMinus();
        player.setPath(path);
        //Cambiar a lista enlazada lo de abajo
        player.movePlayer(XYAxes.getXY(path).get(player.getPosition()));
        justone = false;

        playerEvents.versus(lastPath, lastPosition);
        if(dices.diceValue() == 0){
            restriction = 0;

            playerEvents.checkEvents();
        }
    }
}
