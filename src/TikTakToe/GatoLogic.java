package TikTakToe;

import boardScreen.Player;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GatoLogic {
	public GatoLogic(Player a, Player b){
		this.a = a;
		this.b = b;
	}
	private Player a;
	private Player b;
	private int Switch = 0;
	
	
	ArrayList<Integer> Celdas = new ArrayList<Integer>();
	int [][] matriz = {{3,75,5},{63,7,81},{21,75,13}};
	boolean jugador= true;
	
	/**
	 * esta funcion recibe un numero que funciona para revisar si alguien gano el juego, cada vez que se presiona una celda
	 * envia un numero a esta funcion 
	 * @param Switch
	 */
	public void setSwitch(int Switch) {
		this.Switch=Switch;
	}
	/**
	 * esta funcion me retorna el switch 
	 * @return
	 */
	public int getSwitch() {
		return this.Switch;
	}
	/**
	 * esta funcion cuida que no se presione dos veces la misma celda 
	 * @param celda
	 * @return
	 */
	public boolean Verificar(int celda) {
		int i =0;
		while(i<Celdas.size()) {
			if(Celdas.get(i)==celda) {
				System.out.println("mov repetido");
				return false;
				
			}
			i++;
			
		}
		return true;
	
		
	}
	/**
	 * Esta funcion revisa cada vez que se presiona un label, si el juego termina en empate o si alguien gano
	 * @param a
	 * @param b
	 * @param celda
	 * @param contador
	 */
	public void setLista(int a,int b,int celda,int contador,String jugador) throws FileNotFoundException {
		matriz[a][b]=Switch;
		Celdas.add(celda);
		if(matriz[0][0]==matriz[0][1] && matriz[0][1]==matriz[0][2]) {
			if(jugador.equals ("jugador 2")){
				TikTakToe.setWinner (1);
				TikTakToe.roundHandler ();
			}else {
				TikTakToe.setWinner (0);
				TikTakToe.roundHandler ();
			}
			
		}else if(matriz[1][0]==matriz[1][1] && matriz[1][1]==matriz[1][2]) {
			if(jugador.equals ("jugador 2")){
				TikTakToe.setWinner (1);
				TikTakToe.roundHandler ();
			}else {
				TikTakToe.setWinner (0);
				TikTakToe.roundHandler ();
			}
			
		}else if(matriz[2][0]==matriz[2][1] && matriz[2][1]==matriz[2][2]) {
			if(jugador.equals ("jugador 2")){
				TikTakToe.setWinner (1);
				TikTakToe.roundHandler ();
			}else {
				TikTakToe.setWinner (0);
				TikTakToe.roundHandler ();
			}
			
		}else if(matriz[0][0]==matriz[1][0] && matriz[1][0]==matriz[2][0]) {
			if(jugador.equals ("jugador 2")){
				TikTakToe.setWinner (1);
				TikTakToe.roundHandler ();
			}else {
				TikTakToe.setWinner (0);
				TikTakToe.roundHandler ();
			}
			
		}else if(matriz[0][1]==matriz[1][1] && matriz[1][1]==matriz[2][1]) {
			if(jugador.equals ("jugador 2")){
				TikTakToe.setWinner (1);
				TikTakToe.roundHandler ();
			}else {
				TikTakToe.setWinner (0);
				TikTakToe.roundHandler ();
			}
			
		}else if(matriz[2][0]==matriz[2][1] && matriz[2][1]==matriz[2][2]) {
			if(jugador.equals ("jugador 2")){
				TikTakToe.setWinner (1);
				TikTakToe.roundHandler ();
			}else {
				TikTakToe.setWinner (0);
				TikTakToe.roundHandler ();
			}

			
		}else if(matriz[0][0]==matriz[1][1] && matriz[1][1]==matriz[2][2]) {
			if(jugador.equals ("jugador 2")){
				TikTakToe.setWinner (1);
				TikTakToe.roundHandler ();
			}else {
				TikTakToe.setWinner (0);
				TikTakToe.roundHandler ();
			}
			
		}else if(matriz[2][0]==matriz[1][1] && matriz[1][1]==matriz[0][2]) {
			if(jugador.equals ("jugador 2")){
				TikTakToe.setWinner (1);
				TikTakToe.roundHandler ();
			}else {
				TikTakToe.setWinner (0);
				TikTakToe.roundHandler ();
			}
		}else if(contador==9) {
			TikTakToe.newGame (TikTakToe.names[0], TikTakToe.names[1]);
		}
	}
	/**
	 * Esta funcion me define cual jugador es el que gana, el uno o el dos, las equis o los ceros
	 * @return
	 */
	public String getString() {
		if(this.jugador==true) {
			this.jugador=false;
			return "jugador 1";
		}else {
			this.jugador=true;
			return "jugador 2";
		}
	}
}
