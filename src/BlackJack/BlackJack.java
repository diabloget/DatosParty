package BlackJack;

import boardScreen.*;
import boardScreen.Player;
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
import main.main;
import playersScreen.PlayerList;

public class BlackJack {
    public BlackJack(Player[] names, boolean versus){
        this.versus = versus;
        this.call = names;
        String[] name = new String[names.length];
        for(int index = 0; index < names.length; index++){
            name[index] = names[index].getName();
        }
        this.game = new Dealer (name);
        this.oldTempScene = board.getBoardScene();
    }
    private Player[] call;
    private boolean versus;
    private Scene oldTempScene;
    private Dealer game;
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


    /**
     * Funcion que llama a newPlayer en caso de que pare de jugar o libera una carta del stack para seguir
     * Se utiliza en los tres botones del juego
     * @param isNew
     */
    private void update(boolean isNew){
        if(isNew){
            newPlayer ();
        }else {
            playerCards[ game.cardNumber ].setText (game.newCard);
        }
    }

    /**
     * Funcion que genera parte grafica a un nuevo jugador en caso de existir
     * En caso de no existir mas jugadore decide las premiaciones y castigos
     */
    private void newPlayer(){
        if(game.isOver ()){
            if(game.isTie ()){
                String[] newNames = new String[game.howManytie];
                int index = 0;
                for(String name: newNames){
                    newNames[index] = game.ties[index];
                    index++;
                }
                game = new Dealer (newNames);
                newPlayer ();
            }else {
                PlayerList.getPlayers (game.getWinner ()).setCoins (10);
                if(versus){versusMethodPositions();}
                main.window.setScene (oldTempScene);
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

    /**
     * Genera la parte visual para poder empezar a jugar
     * Al primer jugador se le colocan dos cartas
     */
    private void settingUp(){
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

    /**
     * Llamar funcion para empezar el minijuego de Black Jack
     */
    public void starting() {
        settingUp ();
        main.window.setScene (gameScene);
    }


    /**
     * Funcion llamada desde el boton hit
     * Se encarga de manejar de manera grafica y llamar hit de manera interna
     */
    private void hitting(){
        game.hit ();
        if(game.getCount () > 21){
            gettingOut ();
        }else {
            update (false);
        }

    }
    /**
     * Funcion llamada desde el boton get out
     * Se encarga de manejar de manera grafica y llamar get out de manera interna
     */
    private void gettingOut(){
        game.getOut ();
        update (true);
    }

    /**
     * Funcion llamada desde el boton stop
     * Se encarga de manejar de manera grafica y llamar stop de manera interna
     */
    private void stopping(){
        game.stop ();
        update (true);
    }


    /**
     * Funcion llamda desde newPLayer
     * Maneja los castigos para ganadores y perdedores del minijuego
     */
    private void versusMethodPositions(){
        for(Player search : call){
            if(!search.equals (PlayerList.getPlayers (game.getWinner ()))){
                if(! Round.getCurrent ().equals (search) ) {
                    search.setPath (playerEvents.lastPath);
                    search.setPosition (playerEvents.lastPosition);
                    search.movePlayer(XYAxes.getXY(search.getPath()).get(search.getPosition()));
                }else {
                    playerEvents.Punishment (search);
                }
            }
        }
    }

}
