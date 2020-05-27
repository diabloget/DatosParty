package BlackJack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

public class PlayBlackJack extends Application {

    public static void main(String[] args) {
        launch (args);
    }

    private GridPane gamePane = new GridPane ();
    private Scene gameScene = new Scene (gamePane,550,400, Color.GREEN);
    Text playing = new Text ();
    Button hit = new Button ("HIT");
    Button stop = new Button ("Stop");
    Button getOut = new Button ("Get out");
    Text card1 = new Text("");
    Text card2 = new Text("");
    Text card3 = new Text("");
    Text card4 = new Text("");
    Text card5 = new Text("");
    Text card6 = new Text("");
    Text card7 = new Text("");
    Text card8 = new Text("");
    Text card9 = new Text("");
    Text card10 = new Text("");
    Text card11 = new Text("");
    Text card12 = new Text("");
    Text card13 = new Text("");
    Text[] playerCards = {card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13};


    String[] x = {"Jose","Miguel","Juam"};
    Dealer game = new Dealer (x);

    private void update(boolean isNew){
        if(isNew){
            newPlayer ();
        }else {
            playerCards[ game.cardNumber ].setText (game.newCard);
        }
    }

    private void newPlayer(){
        if(game.isOver ()){
            if(game.isTie ()){
                String[] newNames = new String[game.howManytie];
                int index = 0;
                for(String name: newNames){
                    name = game.ties[index];
                    index++;
                }
                game = new Dealer (newNames);
                starting ();
            }else {
                System.out.println (Arrays.toString (game.getResults ()));
                ///primaryStage.close();
            }
        }else {
            playing.setText ("Is playing: \n" + game.getWhoIsPlaying ());
            for ( Text card : playerCards ) {
                card.setText ("");
            }
            hitting ();
            hitting ();
        }
    }

    private void starting(){
        gamePane.setBackground (new Background (new BackgroundFill (Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        gamePane.setVgap (15);
        gamePane.setHgap (15);
        for(int index = 0; index<=6; index++){
            gamePane.add (playerCards[index],index,1);
            gamePane.add (new Rectangle (50,70,Color.WHITE),index+1,1);
        }
        for(int index = 0; index<=5; index++){
            gamePane.add (playerCards[index+7],index,2);
            gamePane.add (new Rectangle (50,70,Color.WHITE),index+1,2);
        }
        gamePane.add (playing,4,3);
        gamePane.add (getOut,1,3);
        gamePane.add (stop,2,3);
        gamePane.add (hit,3,3);
        hit.setOnAction (actionEvent -> {
            hitting ();
        });
        getOut.setOnAction (actionEvent -> {
            gettingOut();
        });
        stop.setOnAction (actionEvent -> {
            stopping ();
        });
        newPlayer ();
    }

    @Override
    public void start(Stage primaryStage) {
        starting ();
        primaryStage.setScene (gameScene);
        primaryStage.show ();
    }

    private void hitting(){
        game.hit ();
        if(game.getCount () > 21){
            gettingOut ();
        }else {
            update (false);
        }

    }
    private void gettingOut(){
        game.getOut ();
        update (true);
    }
    private void stopping(){
        game.stop ();
        update (true);
    }

}
