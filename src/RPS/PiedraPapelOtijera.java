package RPS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import boardScreen.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PiedraPapelOtijera {
	public PiedraPapelOtijera(Player playerA, Player playerB) {
		this.playerA = playerA;
		this.playerB = playerB;
	}

	ArrayList<Button> ListaBotones = new ArrayList<Button>();
	int temp=0;
	ArrayList<Integer> lista = new 	ArrayList<Integer>();
	private Player playerA;
	private Player playerB;



	public Pane getPane() throws FileNotFoundException {
		FileInputStream Piedra = new FileInputStream("Piedra.png");
		Image PiedraImage = new Image(Piedra);
		FileInputStream Papel = new FileInputStream("Papel.png");
		Image PapelImage = new Image(Papel);
		FileInputStream Tijera = new FileInputStream("tijera.png");
		Image tijeraImage = new Image(Tijera);
		Pane pane = new Pane();
		pane.setStyle("-fx-background-color: #96e3e9;");
		for(int i =0;i<3;i++) {
			ListaBotones.add(new Button());
			
		}
		ListaBotones.get(0).setTranslateY(150);
		ListaBotones.get(1).setTranslateY(150);
		ListaBotones.get(2).setTranslateY(150);
		ListaBotones.get(0).setTranslateX(25);
		ListaBotones.get(1).setTranslateX(155);
		ListaBotones.get(2).setTranslateX(280);
	
		ListaBotones.get(0).setGraphic(new ImageView(PiedraImage));
		ListaBotones.get(0).setStyle("-fx-background-color: #12af9c;");
		ListaBotones.get(1).setGraphic(new ImageView(PapelImage));
		ListaBotones.get(1).setStyle("-fx-background-color: #dd2626;");
		ListaBotones.get(2).setGraphic(new ImageView(tijeraImage));
		ListaBotones.get(2).setStyle("-fx-background-color: #b1cc00;");

		
		
		ListaBotones.get(0).setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				try {
					revisarjuego(1);
				} catch (FileNotFoundException ex) {
					ex.printStackTrace ();
				}
			}
		});
		ListaBotones.get(1).setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				try {
					revisarjuego(2);
				} catch (FileNotFoundException ex) {
					ex.printStackTrace ();
				}
			}
		});
		ListaBotones.get(2).setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				try {
					revisarjuego(3);
				} catch (FileNotFoundException ex) {
					ex.printStackTrace ();
				}
			}
		});

		
		
		pane.getChildren().addAll(ListaBotones.get(0),ListaBotones.get(1),ListaBotones.get(2));
		return pane;
		
	}
	
	private void revisarjuego(int num) throws FileNotFoundException {
		if(temp==0) {
			temp=num;
			lista.add(temp);
			
		}else {
			lista.add(num);
			if(lista.get(0)==1 && lista.get(1)== 1 ) {
				RPS.newGame (playerA, playerB);
			}
			else if(lista.get(0)==2 && lista.get(1)==2) {
				RPS.newGame (playerA, playerB);
			}
			else if(lista.get(0)==3 && lista.get(1)==3) {
				RPS.newGame (playerA, playerB);
			}
			else if(lista.get(0)==1 && lista.get(1)==2) {
				RPS.setWinner (1);
				RPS.roundHandler ();
			}
			else if(lista.get(0)==1 && lista.get(1)==3) {
				RPS.setWinner (0);
				RPS.roundHandler ();
			}
			else if(lista.get(0)==3 && lista.get(1)==1) {
				RPS.setWinner (1);
				RPS.roundHandler ();
			}
			else if(lista.get(0)==3 && lista.get(1)==2) {
				RPS.setWinner (0);
				RPS.roundHandler ();
			}
			else if(lista.get(0)==2 && lista.get(1)==1) {
				RPS.setWinner (0);
				RPS.roundHandler ();
			}
			else if(lista.get(0)==2 && lista.get(1)==3) {
				RPS.setWinner (1);
				RPS.roundHandler ();
			}
		}
			
	}
		
	
	
	
}
