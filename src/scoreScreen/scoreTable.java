package scoreScreen;

import boardScreen.Icons;
import boardScreen.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import playersScreen.PlayerList;

import java.util.ArrayList;

public class scoreTable {
    private static HBox playerData1 = new HBox();
    private static HBox playerData2 = new HBox();
    private static HBox playerData3 = new HBox();
    private static HBox playerData4 = new HBox();

    public static ArrayList<HBox> hBoxes = new ArrayList<>();
    private static ArrayList<Label> coins = new ArrayList<>();
    private static ArrayList<Label> stars = new ArrayList<>();


    public static ArrayList<HBox> gethBoxes() {
        return hBoxes;
    }

    private static void initHBoxList(){
        hBoxes.add(playerData1);
        hBoxes.add(playerData2);
        hBoxes.add(playerData3);
        hBoxes.add(playerData4);
    }

    private static void initDataHBoxes(){
        setAvailable();
        initDataLabels();
        setAvailableColor();
        for(int index = 0; index < hBoxes.size();index++){
            hBoxes.get(index).getChildren().add(Icons.getIcon(index+10));
            hBoxes.get(index).getChildren().add(Icons.getIcon(14));
            hBoxes.get(index).getChildren().add(stars.get(index));
            hBoxes.get(index).getChildren().add(Icons.getIcon(15));
            hBoxes.get(index).getChildren().add(coins.get(index));
        }
    }

    private static void initDataLabels(){
        for(Label label:coins){
            label.setStyle("-fx-background-color: #313335");
            label.setFont(Font.font(15));
            //label.setAlignment(Pos.CENTER);
            label.setTextFill(Color.valueOf("#C9C9C9"));
            label.setPrefSize(20,20);
        }for(Label label:stars){
            label.setStyle("-fx-background-color: #313335");
            label.setFont(Font.font(15));
            //label.setAlignment(Pos.CENTER);
            label.setTextFill(Color.valueOf("#C9C9C9"));
            label.setPrefSize(20,20);
        }

    }

    public static void setAvailable(){
        for(HBox hbox:hBoxes){
            hbox.setStyle("-fx-background-color: #313335");
            hbox.setSpacing(10);
            hbox.setPadding(new Insets(5, 5, 5, 5));

            coins.add(new Label("0"));
            stars.add(new Label("0"));

        }

        for(int index = 0; index < PlayerList.players.size();index++){
            hBoxes.get(index).setStyle("-fx-background-color: #3C3F41");
            coins.get(index).setStyle("-fx-background-color: #3C3F41");
            stars.get(index).setStyle("-fx-background-color: #3C3F41");
        }
    }

    public static void setAvailableColor(){
        for(int index = 0; index < PlayerList.players.size();index++){
            hBoxes.get(index).setStyle("-fx-background-color: #3C3F41");
            coins.get(index).setStyle("-fx-background-color: #3C3F41");
            stars.get(index).setStyle("-fx-background-color: #3C3F41");
        }
    }

    public static void updatePlayerData(){
        int index = 0;
        for(Player player:PlayerList.players){
            coins.get(index).setText(Integer.toString(player.getCoins()));
            stars.get(index).setText(Integer.toString(player.getStars()));
            index ++;
        }
    }
    public static void relocateTable(int x, int y){
        int b = y;
        for(HBox hbox:hBoxes){
            hbox.relocate(x, b);
            b+= 40;
        }
    }

    public static void InitDataTable(int x, int y){
        initHBoxList();
        initDataHBoxes();
        relocateTable(x, y);
    }

}
