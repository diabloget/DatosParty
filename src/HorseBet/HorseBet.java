package HorseBet;

import boardScreen.Player;
import boardScreen.Round;
import boardScreen.board;
import boardScreen.playerEvents;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import main.main;

import java.util.Random;


public class HorseBet {

    public HorseBet(Player[] names, boolean versus){
        this.versus = versus;
        this.names = names;
        this.results = new int[names.length];
        whoPlays = new Text ("Is playing: "+ names[0].getName ());
        this.oldTempScene =board.getBoardScene ();
    }
    private Scene oldTempScene;
    private Player winner;
    private Rectangle horseRectangle1 = new Rectangle();
    private Rectangle horseRectangle2 = new Rectangle();
    private Rectangle horseRectangle3 = new Rectangle();
    private Rectangle horseRectangle4 = new Rectangle();
    private Rectangle[] shapes = {horseRectangle1, horseRectangle2, horseRectangle3, horseRectangle4};
    private Player[] names;
    private Button horse1 = new Button ("Secretariat");
    private Button horse2 = new Button ("BoJack");
    private Button horse3 = new Button ("Herbie");
    private Button horse4 = new Button ("Lighting McQueen");
    private Text Secretariat = new Text ("Secretariat");
    private Text BoJack = new Text ("BoJack");
    private Text Herbie = new Text ("Herbie");
    private Text LightingMcQueen = new Text ("Lighting McQueen");
    private Text[] texts = {Secretariat, BoJack, Herbie, LightingMcQueen};
    private Text whoPlays;
    private Button[] arrayButtons = {horse1, horse2, horse3, horse4};
    private boolean versus;
    private int whoIsPlaying = 0;
    private GridPane gamePane = new GridPane ();
    private Scene gameScene = new Scene (gamePane, 500,250);
    private int[] results;


    /**
     * Agrega los elementos graficos del juego en la escena
     */
    private void settingGraphics(){

        for(int index = 0; index < names.length; index++){
            int finalIndex = index;
            gamePane.add (shapes[index], 1, index+1);
            gamePane.add (texts[index], 1, index+1);
            gamePane.add(arrayButtons[index], index+1, 6);
            arrayButtons[index].setOnAction (actionEvent -> {
                whoIsPlaying++;
                if(whoIsPlaying == names.length){
                    arrayButtons[finalIndex].setVisible (false);
                    arrayButtons[finalIndex].setBackground (Background.EMPTY);
                    results[whoIsPlaying-1] = finalIndex;
                    setUp ();
                }else{
                    results[whoIsPlaying-1] = finalIndex;
                    arrayButtons[finalIndex].setVisible (false);
                    arrayButtons[finalIndex].setBackground (Background.EMPTY);
                    whoPlays.setText ("Is playing: "+ names[whoIsPlaying].getName ());
                }
            });
        }

        gamePane.setHgap (20);
        gamePane.setVgap (20);
        gamePane.add (whoPlays, 1,0);
    }

    /**
     * Inicia las trancisiones para las carreras
     */
    private void setUp(){
        int randInt = new Random ().nextInt (names.length);
        TranslateTransition horseWinner = new TranslateTransition (Duration.seconds (1),shapes[randInt]);
        horseWinner.setOnFinished (actionEvent -> {
            backToGame ();
        });
        TranslateTransition otherHorse1;
        TranslateTransition otherHorse2;
        TranslateTransition otherHorse3;
        TranslateTransition[] transitions = new TranslateTransition[4];

        if(randInt == 0) {
            otherHorse1=new TranslateTransition (Duration.seconds (2), shapes[1]);
            otherHorse2=new TranslateTransition (Duration.seconds (2), shapes[2]);
            otherHorse3=new TranslateTransition (Duration.seconds (2), shapes[3]);
            transitions = new TranslateTransition[]{horseWinner, otherHorse1, otherHorse2, otherHorse3};
        }else{
            if(randInt == 1) {
                otherHorse1=new TranslateTransition (Duration.seconds (2), shapes[0]);
                otherHorse2=new TranslateTransition (Duration.seconds (2), shapes[2]);
                otherHorse3=new TranslateTransition (Duration.seconds (2), shapes[3]);
                transitions = new TranslateTransition[]{horseWinner, otherHorse1, otherHorse2, otherHorse3};
            }else{
                if(randInt == 2) {
                    otherHorse1=new TranslateTransition (Duration.seconds (2), shapes[0]);
                    otherHorse2=new TranslateTransition (Duration.seconds (2), shapes[1]);
                    otherHorse3=new TranslateTransition (Duration.seconds (2), shapes[3]);
                    transitions = new TranslateTransition[]{horseWinner, otherHorse1, otherHorse2, otherHorse3};
                }else{
                    if(randInt == 3) {
                        otherHorse1=new TranslateTransition (Duration.seconds (2), shapes[0]);
                        otherHorse2=new TranslateTransition (Duration.seconds (2), shapes[2]);
                        otherHorse3=new TranslateTransition (Duration.seconds (2), shapes[1]);
                        transitions = new TranslateTransition[]{horseWinner, otherHorse1, otherHorse2, otherHorse3};
                    }
                }
            }
        }
        for(int index = 0; index < names.length; index++){
            shapes[index].setFill (Color.BLACK);
            shapes[index].setHeight (50);
            shapes[index].setWidth (50);
            transitions[index].setByX (450);
            transitions[index].play ();
        }
        int index = 0;
        for(int x : results){
            if(x == randInt){
                names[index].setCoins (10);
                winner = names[index];
            }
        }
        if(versus){
            for(Player playerFinder : names){
                if(!playerFinder.equals (winner)){
                    if(playerFinder.equals (Round.getCurrent ())){
                        playerEvents.Punishment (playerFinder);
                    }else{
                        playerFinder.setPosition (playerEvents.lastPosition);
                        playerFinder.setPath (playerEvents.lastPath);
                    }
                }
            }
        }

    }

    /**
     * Metodo para empezar la partida
     */
    public void starting(){
        settingGraphics ();
        main.window.setScene (gameScene);
    }

    /**
     * Metodo para devolver al juego principal
     */
    private void backToGame(){
        main.window.setScene (oldTempScene);
    }


}
