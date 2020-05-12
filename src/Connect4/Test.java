package Connect4;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class Test extends Application {
    String[] names = new String[]{"Alonso", "Juan", "Pato", "ll"};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Connect4 foo = new Connect4(4, primaryStage, names);
        foo.starting();



    }
}
