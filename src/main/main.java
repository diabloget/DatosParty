package main;

import boardScreen.board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import playersScreen.players;
import scoreScreen.score;

public class main extends Application {
    public static Stage window;

    public void start(Stage bStage) {
        window = bStage;
        window.setResizable(false);
        //Stage.getIcons().add(new Image("file:Icons/Icon.png"));
        window.setTitle("DatosParty");
        //window.setScene(score.getScoreScene());
        //window.setScene(board.getBoardScene());
        window.setScene(players.getPlayerScene());
        window.show();
    }
}
