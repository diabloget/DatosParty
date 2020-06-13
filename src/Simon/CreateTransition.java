package Simon;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.animation.*;
import javafx.util.Duration;


public class CreateTransition {
    public Text go = new Text("GO");
    public Button red = new Button();
    public Button green = new Button();
    public Button blue = new Button();
    public Button yellow = new Button();
    private FillTransition[] ilumination;
    private Rectangle greenSquare = new Rectangle();
    private Rectangle redSquare = new Rectangle();
    private Rectangle yellowSquare = new Rectangle();
    private Rectangle blueSquare = new Rectangle();
    private Button start = new Button();
    private String[] colors = {"blue", "red", "green", "yellow"};
    public String[] colorOrder = {colors[new Random().nextInt(colors.length)],colors[new Random().nextInt(colors.length)],colors[new Random().nextInt(colors.length)],colors[new Random().nextInt(colors.length)],colors[new Random().nextInt(colors.length)]};

    /**
     * @param iluminate
     * @param level
     * Inicia las propiedades de iluminacion al primer jugador
     */
    private void giveTransitionProperties(FillTransition iluminate, double level){
        iluminate.setDelay(Duration.seconds(0.1));
        iluminate.setAutoReverse(true);
        iluminate.setCycleCount(2);
        iluminate.setDuration(Duration.seconds(level));
    }

    /**
     * @param level
     * Prepara las transiciones acorde al nivel
     */
    public void createTransitions(double level){
        FillTransition iluminate0 = new FillTransition();
        giveTransitionProperties(iluminate0, level);
        FillTransition iluminate1 = new FillTransition();
        giveTransitionProperties(iluminate1, level);
        FillTransition iluminate2 = new FillTransition();
        giveTransitionProperties(iluminate2, level);
        FillTransition iluminate3 = new FillTransition();
        giveTransitionProperties(iluminate3, level);
        FillTransition iluminate4 = new FillTransition();
        giveTransitionProperties(iluminate4, level);

        ilumination = new FillTransition[]{iluminate0,iluminate1,iluminate2,iluminate3,iluminate4};

    }


    /**
     * @param gamePane
     * @param level
     * Agrega figuras de la IGU
     */
    public void createSquares(GridPane gamePane, double level){
        greenSquare.setWidth(150);
        greenSquare.setHeight(150);
        greenSquare.setFill(Color.valueOf("2F7B26"));
        redSquare.setWidth(150);
        redSquare.setHeight(150);
        redSquare.setFill(Color.valueOf("832424"));
        yellowSquare.setWidth(150);
        yellowSquare.setHeight(150);
        yellowSquare.setFill(Color.valueOf("7F8324"));
        blueSquare.setWidth(150);
        blueSquare.setHeight(150);
        blueSquare.setFill(Color.valueOf("1F2487"));
        gamePane.add(greenSquare,1,0);
        gamePane.add(redSquare,1,1);
        gamePane.add(yellowSquare,2,0);
        gamePane.add(blueSquare,2,1);
        settingTransitions(gamePane, level);

    }


    /**
     * @param gamePane
     * @param level
     * Ordena de forma aleatoria las cinco iluminaciones
     */
    public void settingTransitions(GridPane gamePane, double level){
        createTransitions(level);
        for(int counter = 0; counter<colorOrder.length; counter++ ){
            if(colorOrder[counter].equals("red")){
                ilumination[counter].setShape(redSquare);
                ilumination[counter].setToValue(Color.valueOf("FF3A00"));
            }else{
                if(colorOrder[counter].equals("blue")){
                    ilumination[counter].setShape(blueSquare);
                    ilumination[counter].setToValue(Color.valueOf("009EFF"));
                }else{
                    if(colorOrder[counter].equals("yellow")){
                        ilumination[counter].setShape(yellowSquare);
                        ilumination[counter].setToValue(Color.valueOf("CDFF00"));
                    }else{
                        if(colorOrder[counter].equals("green")){
                            ilumination[counter].setShape(greenSquare);
                            ilumination[counter].setToValue(Color.valueOf("00FF2A"));
                        }
                    }
                }
            }
            int Counter = counter;
            if(Counter+1!=ilumination.length) {
                ilumination[ counter ].setOnFinished(actionEvent -> {
                    ilumination[ Counter + 1 ].play();
                });
            }else{
                ilumination[Counter].setOnFinished(actionEvent -> {
                    start.setText("Start");
                    gamePane.add(start,2,2);
                    start.setOnAction(actionEvent1 -> {
                        playGame(gamePane);
                    });
                });
            }
        }
        ilumination[0].setDelay(Duration.seconds(3));
        ilumination[0].play();
    }


    /**
     * @param gamePane
     * Inicia las trancisiones
     */
    public void playGame(GridPane gamePane){
        red.setBackground(Background.EMPTY);
        red.setPrefSize(150,150);
        green.setBackground(Background.EMPTY);
        green.setPrefSize(150,150);
        blue.setBackground(Background.EMPTY);
        blue.setPrefSize(150,150);
        yellow.setBackground(Background.EMPTY);
        yellow.setPrefSize(150,150);
        go.setFill(Color.WHITE);
        gamePane.add(go,3,0);
        gamePane.add(red,1,1);
        gamePane.add(green,1,0);
        gamePane.add(blue,2,1);
        gamePane.add(yellow,2,0);



    }


}