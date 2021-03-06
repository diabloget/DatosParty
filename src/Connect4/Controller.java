package Connect4;

import boardScreen.Player;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import main.main;

public class Controller {
    Controller(Circle[][] positions, int numberPlayers, String[] names, Scene oldTempScene, boolean versus, Player[] call){
        DecideWinner winner = new DecideWinner(numberPlayers, versus, call);
        this.oldScene = oldTempScene;
        this.positions=positions;
        this.numberPlayers =numberPlayers;
        this.winner=winner;
        this.names=names;
    }
    private Scene oldScene;
    Text whoIsPlaying= new Text();
    String[] names;
    DecideWinner winner;
    public int numberPlayers;
    private Circle[][] positions;
    private String color = "red";
    int[] rows = new int[]{5,5,5,5,5,5,5};
    private Button column1Btn = new Button();
    private Button column2Btn = new Button();
    private Button column3Btn = new Button();
    private Button column4Btn = new Button();
    private Button column5Btn = new Button();
    private Button column6Btn = new Button();
    private Button column7Btn = new Button();


    /**
     * @param gameMatrix
     * Refrezca la imagen en la IGU
     */
    public void refreshColor(String[][] gameMatrix){
        for(int y=0; y<6; y++){
            for(int x=0; x<7; x++){
                if(gameMatrix[y][x].equals("black")){
                    positions[y][x].setFill(Color.BLACK);
                }else {
                    if(gameMatrix[y][x].equals("blue")){
                        positions[y][x].setFill(Color.BLUE);
                    }else {
                        if(gameMatrix[y][x].equals("red")){
                            positions[y][x].setFill(Color.RED);
                        }}
                }
            }
        }

    }


    /**
     * @param player1
     * @param player2
     * proyecta los nombres del encuentro
     */
    public void assignMatch(int player1, int player2){
        whoIsPlaying.setText("Matching: " +names[player1] + " vs " +names[player2] );
    }


    /**
     * @param gameMatrix
     * @param gamePane
     * Agrega botones para su¿imular caida de fichas
     */
    public void addingButtons(String[][] gameMatrix, GridPane gamePane){
        gamePane.add(whoIsPlaying,8,0);
        assignMatch(0,1);
        addButtonsAux(gamePane, column1Btn,0 );
        addButtonsAux(gamePane, column2Btn,1 );
        addButtonsAux(gamePane, column3Btn,2 );
        addButtonsAux(gamePane, column4Btn,3 );
        addButtonsAux(gamePane, column5Btn,4 );
        addButtonsAux(gamePane, column6Btn,5 );
        addButtonsAux(gamePane, column7Btn,6 );
        column1Btn.setOnAction(actionEvent -> {
            changeRow(0, gameMatrix);
            refreshColor(gameMatrix);
            if(winner.isWinner(0,rows[0]+1,gameMatrix, color)=="nextMatch"){
                assignMatch(winner.playingIs[0],winner.playingIs[1]);
                restartToDefault(gameMatrix);
            }else {
                if ( winner.isWinner(0, rows[ 0 ] + 1, gameMatrix, color) == "true" ) {
                    main.window.setScene (oldScene);
                }
            }
        });
        column2Btn.setOnAction(actionEvent -> {
            changeRow(1, gameMatrix);
            refreshColor(gameMatrix);
            if(winner.isWinner(1,rows[1]+1,gameMatrix, color)=="nextMatch"){
                assignMatch(winner.playingIs[0],winner.playingIs[1]);
                restartToDefault(gameMatrix);
            }else {
                if ( winner.isWinner(1, rows[ 1 ] + 1, gameMatrix, color) == "true" ) {
                    main.window.setScene (oldScene);
                }
            }
        });
        column3Btn.setOnAction(actionEvent -> {
            changeRow(2, gameMatrix);
            refreshColor(gameMatrix);
            if(winner.isWinner(2,rows[2]+1,gameMatrix, color)=="nextMatch"){
                assignMatch(winner.playingIs[0],winner.playingIs[1]);
                restartToDefault(gameMatrix);
            }else {
                if ( winner.isWinner(2, rows[ 2 ] + 1, gameMatrix, color) == "true" ) {
                    main.window.setScene (oldScene);
                }
            }
        });
        column4Btn.setOnAction(actionEvent -> {
            changeRow(3,gameMatrix);
            refreshColor(gameMatrix);
            if(winner.isWinner(3,rows[3]+1,gameMatrix, color)=="nextMatch"){
                assignMatch(winner.playingIs[0],winner.playingIs[1]);
                restartToDefault(gameMatrix);
            }else {
                if ( winner.isWinner(3, rows[ 3 ] + 1, gameMatrix, color) == "true" ) {
                    main.window.setScene (oldScene);
                }
            }
        });
        column5Btn.setOnAction(actionEvent -> {
            changeRow(4, gameMatrix);
            refreshColor(gameMatrix);
            if(winner.isWinner(4,rows[4]+1,gameMatrix, color)=="nextMatch"){
                assignMatch(winner.playingIs[0],winner.playingIs[1]);
                restartToDefault(gameMatrix);
            }else {
                if ( winner.isWinner(4, rows[ 4 ] + 1, gameMatrix, color) == "true" ) {
                    main.window.setScene (oldScene);
                }
            }
        });
        column6Btn.setOnAction(actionEvent -> {
            changeRow(5, gameMatrix);
            refreshColor(gameMatrix);
            if(winner.isWinner(5,rows[5]+1,gameMatrix, color)=="nextMatch"){
                assignMatch(winner.playingIs[0],winner.playingIs[1]);
                restartToDefault(gameMatrix);
            }else {
                if ( winner.isWinner(5, rows[ 5 ] + 1, gameMatrix, color) == "true" ) {
                    main.window.setScene (oldScene);
                }
            }
        });
        column7Btn.setOnAction(actionEvent -> {
            changeRow(6, gameMatrix);
            refreshColor(gameMatrix);
            if(winner.isWinner(6,rows[6]+1,gameMatrix, color)=="nextMatch"){
                assignMatch(winner.playingIs[0],winner.playingIs[1]);
                restartToDefault(gameMatrix);
            }else {
                if ( winner.isWinner(6, rows[ 6 ] + 1, gameMatrix, color) == "true" ) {

                    main.window.setScene (oldScene);
                }
            }

        });
    }


    /**
     * @param gamePane
     * @param columnBtn
     * @param column
     * Funcion auxiliar para poder agregar botones iterativmente
     */
    private void addButtonsAux(GridPane gamePane, Button columnBtn ,int column) {
        columnBtn.setPrefSize(81,585);
        columnBtn.setBackground(Background.EMPTY);
        gamePane.add(columnBtn,column,0,1,7);
    }


    /**
     * @param column
     * @param gameMatrix
     * Cambia el contador de fila en cada columna
     * Se asegura de que no sobre pase
     * Utiliza en la nterfaz y para analizar resultados
     */
    public void changeRow(int column, String[][] gameMatrix){
        if(rows[column]>=0) {
            gameMatrix[ rows[ column ] ][ column ] = color;
            rows[ column ]--;
            changeColor();
        }else{
            System.out.println("error");
        }
    }


    /**
     * Coloca en la matriz el color correspondiente al turno
     */
    private void changeColor(){
        if(color.equals("red")){
            color="blue";
        }else{
            color="red";
        }
    }


    /**
     * @param gameMatrix
     * Reinicia la partida para crear campeonato
     */
    private void restartToDefault(String[][] gameMatrix){
        rows = new int[]{5,5,5,5,5,5,5};
        for(int y=0; y<6; y++){
            for(int x=0; x<7; x++){
                gameMatrix[y][x]="black";

            }
        }
        color="red";
        refreshColor(gameMatrix);
    }

}
