package StackEvents;

import boardScreen.Round;
import javafx.scene.control.*;
import javafx.*;
import playersScreen.PlayerList;

import java.util.ArrayList;
import java.util.Optional;

public class SelectPlayer {
    public static ChoiceDialog<String> alertInit(String type){
        ArrayList<String> choices = new ArrayList<>();
        int index = 0;
        while (index < PlayerList.getNamesArray().length) {
            if (!Round.getCurrent().equals(PlayerList.getPlayers(index))) {
                if(type == "stars"){
                    if (PlayerList.getPlayers(index).getStars()>0){
                        choices.add(Integer.toString(index));
                    }
                }
                if(type == "coins"){
                    if (PlayerList.getPlayers(index).getCoins()>0){
                        choices.add(Integer.toString(index));
                    }
                }

            }
            index++;
        }

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Selecciona Jugador", choices);

        dialog.setTitle("Evento de tipo: " + type);
        dialog.setContentText("Selecciona a un jugador para robarle sus " + type);
        dialog.setContentText("Robar a jugador: ");
        //alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree,buttonTypeFour, buttonTypeCancel);



        /*
        Optional<String> result = Dialo.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeOne){
            if(type.equals("stars")){
                Round.getCurrent().setStars(1);
                PlayerList.getPlayers(0).setStars(-1);

            }else{
                Round.getCurrent().setCoins(2);
                PlayerList.getPlayers(1).minusCoins(2);

            }
        } else if (result.isPresent() && result.get() == buttonTypeTwo) {
            if(type.equals("stars")){
                Round.getCurrent().setStars(1);
                PlayerList.getPlayers(1).setStars(-1);

            }else{
                Round.getCurrent().setCoins(2);
                PlayerList.getPlayers(1).minusCoins(2);
            }
        } else if (result.isPresent() && result.get() == buttonTypeThree) {
            if(type.equals("stars")){
                Round.getCurrent().setStars(1);
                PlayerList.getPlayers(2).setStars(-1);
            }else{
                Round.getCurrent().setCoins(2);
                PlayerList.getPlayers(1).minusCoins(2);
            }
        } else if(result.isPresent() && result.get() == buttonTypeFour) {
            if(type.equals("stars")){
                Round.getCurrent().setStars(1);
                PlayerList.getPlayers(3).setStars(-1);
            }else{
                Round.getCurrent().setCoins(2);
                PlayerList.getPlayers(1).minusCoins(2);
            }
        } else {
            //
        }

         */


        return dialog;
    }
}
