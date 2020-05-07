package boardScreen;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import main.main;
import playersScreen.players;

public class board{
    static private boolean singleton = false;
    private static Pane boardpane = new Pane();
    private static Scene boardscene = new Scene(boardpane,1000,850);
    private static Button switcher = new Button("segunda");


    private static void initializator(boolean temp){
        if(temp==false){
            switcher.setOnAction(event -> main.window.setScene(players.getPlayerScene()));
            boardpane.setStyle("-fx-background-color: #2B2B2B");
            boardpane.getChildren().addAll(switcher);
            singleton=true;
        }else{
            System.out.println("Singletón confirmado");
        }

    }

    public static Scene getBoardScene() {
        initializator(singleton);
        return boardscene;
    }
}
