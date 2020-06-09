package Simon;

import javafx.application.Application;
import javafx.stage.Stage;

public class Test extends Application {
    String[] names = new String[]{"Alonso", "Juan", "Pedro"};
    Simon s = new Simon(names);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        s.starting();

    }
}
