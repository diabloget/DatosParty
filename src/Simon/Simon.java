package Simon;
import boardScreen.Player;
import boardScreen.board;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import main.main;

import java.util.Arrays;

public class Simon  {
    public Simon(Player[]names, boolean versus){
        this.versus = versus;
        this.names = new String[names.length];
        for(int index = 0; index < names.length; index++ ){
            this.names[index] = names[index].getName ();
        }
        oldScene = board.getBoardScene();
        this.score = new KeepingScore(numberOfPlayers, oldScene, versus, names);
    }
    private boolean versus;
    private KeepingScore score;
    private Scene oldScene;
    int gameNumber=0;
    String[] names;
    private int move=0;
    private double[] level = new double[]{0.6,0.4,0.2,0.1,0.01,0.001,0.0001};
    private int whichLevel = 0;
    public int numberOfPlayers = 2;
    public String[] colorAnswers = new String[5];
    public String[] playerAnswers = new String[5];
    public GridPane gamePane = new GridPane();
    public Scene simonScene =  new Scene(gamePane,400,400);


    public void prepareForPlayer(){
        CreateTransition transitions = new CreateTransition();
        transitions.createSquares(gamePane, level[whichLevel]);
        colorAnswers=transitions.colorOrder;
        settingAction(transitions);

    }
    private void settingAction(CreateTransition transitions){
        System.out.println(Arrays.toString(colorAnswers));
        transitions.blue.setOnAction(actionEvent -> {
            if(move<4) {
                playerAnswers[ move ] = "blue";
                move++;
            }else{
                playerAnswers[move]="blue";
                move=0;
                checkAnswers();
            }
        });
        transitions.red.setOnAction(actionEvent -> {
            if(move<4) {
                playerAnswers[ move ] = "red";
                move++;
            }else{
                playerAnswers[move]="red";
                move=0;
                checkAnswers();
            }
        });
        transitions.green.setOnAction(actionEvent -> {
            if(move<4) {
                playerAnswers[ move ] = "green";
                move++;
            }else{
                playerAnswers[move]="green";
                move=0;
                checkAnswers();
            }
        });
        transitions.yellow.setOnAction(actionEvent -> {
            if(move<4) {
                playerAnswers[ move ] = "yellow";
                move++;
            }else{
                playerAnswers[move]="yellow";
                move=0;
                checkAnswers();
            }
        });

    }

    private void checkAnswers() {
        System.out.println(Arrays.toString(playerAnswers));
        if(score.winOrLoose(colorAnswers, playerAnswers)){
            System.out.println("win");
            whichLevel++;
            score.scores[score.whichPlayer]=whichLevel;
            prepareForPlayer();
        }else{
            System.out.println("loose next");
            whichLevel=0;
            if ( gameNumber==names.length ) {

            }else {
                gameNumber++;
                prepareForPlayer();
            }
        }
    }


    public void starting() {
        gamePane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        gamePane.setHgap(20);
        gamePane.setVgap(20);
        prepareForPlayer();
        main.window.setScene(simonScene);

    }
}
