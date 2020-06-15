package TikTakToe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import boardScreen.Player;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class GatoInterfaz {

	public GatoInterfaz(Player a, Player b){
		this.a = a;
		this.b = b;
	}
	private Player a;
	private Player b;
	private GatoLogic logica = new GatoLogic (a,b);
	int contador = 0;
	/**
	 * Esta funcion me genera la interfaz con todas las celdas
	 * @return
	 */
	public StackPane getPane() throws FileNotFoundException {
		
		StackPane root = new StackPane();

		FileInputStream i = new FileInputStream("gato.jpg");
		Image image = new Image(i);
				root.getChildren().addAll(new ImageView(image),Celdas(Celdas.ArribaIzquierda),Celdas(Celdas.ArribaCentro),
						Celdas(Celdas.ArribaDerecha),Celdas(Celdas.MedioIzquierda),Celdas(Celdas.MedioCentro),
						Celdas(Celdas.MedioDerecha),Celdas(Celdas.Abajoizquierda),Celdas(Celdas.AbajoCentro),
						Celdas(Celdas.AbajoDerecha));
		return root;
	
		
		
	}
	/**
	 *Esta funcion le da un evento a cada celda y se subdivide en 9 partes, 
	 * cada una se enfoca en una celda especifica
	 * @param tipo
	 * @return
	 * @throws FileNotFoundException
	 */
	public Label Celdas(Celdas tipo) throws FileNotFoundException {
		
		Label label = new Label();
		
		if (tipo ==Celdas.ArribaIzquierda) {
			int celda=0;
			int a=0;
			int b=0;
			label.setTranslateY(-180);
			label.setTranslateX(-170);
			label.setMinSize(170, 170);
			label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			      @Override
			      public void handle(MouseEvent e) {
			    	 
			    	  
			    	  if(logica.Verificar(celda)==false) {
			    		  System.out.println("No se puede sobreescribir lo marcado");
			    	  }else {
			    		  if(logica.getSwitch()==2) {
			    			  try {
			    				  FileInputStream Equis = new FileInputStream("Circulo.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(4);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }else {
				    		  try {
			    				  FileInputStream Equis = new FileInputStream("Equis.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(2);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }
			    	 }
			    	 
			      }
			    });
			return label;
		}
		if (tipo ==Celdas.ArribaCentro) {
			int celda=1;
			int a=0;
			int b=1;
			label.setTranslateY(-180);
			label.setTranslateX(10);
			label.setMinSize(170, 170);
			label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			      @Override
			      public void handle(MouseEvent e) {
			    	  if(logica.Verificar(celda)==false) {
			    		  System.out.println("No se puede sobreescribir lo marcado");
			    	  }else {
			    		  if(logica.getSwitch()==2) {
			    			  try {
			    				  FileInputStream Equis = new FileInputStream("Circulo.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(4);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }else {
				    		  try {
			    				  FileInputStream Equis = new FileInputStream("Equis.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(2);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }
			    	 }
			    	 
			      }
			    });
			return label;
		}
		if (tipo ==Celdas.ArribaDerecha) {
			int celda=2;
			int a=0;
			int b=2;
			label.setTranslateY(-180);
			label.setTranslateX(190);
			label.setMinSize(170, 170);
			label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			      @Override
			      public void handle(MouseEvent e) {
			    	  if(logica.Verificar(celda)==false) {
			    		  System.out.println("No se puede sobreescribir lo marcado");
			    	  }else {
			    		  if(logica.getSwitch()==2) {
			    			  try {
			    				  FileInputStream Equis = new FileInputStream("Circulo.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(4);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }else {
				    		  try {
			    				  FileInputStream Equis = new FileInputStream("Equis.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(2);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }
			    	 }
			    	 
			      }
			    });
			return label;
		}
		if (tipo ==Celdas.MedioIzquierda) {
			int celda=3;
			int a=1;
			int b=0;
			label.setTranslateX(-170);
			label.setMinSize(170, 170);
			label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			      @Override
			      public void handle(MouseEvent e) {
			    	  if(logica.Verificar(celda)==false) {
			    		  System.out.println("No se puede sobreescribir lo marcado");
			    	  }else {
			    		  if(logica.getSwitch()==2) {
			    			  try {
			    				  FileInputStream Equis = new FileInputStream("Circulo.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(4);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }else {
				    		  try {
			    				  FileInputStream Equis = new FileInputStream("Equis.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(2);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }
			    	 }
			    	 
			      }
			    });
			return label;
		}
		if (tipo ==Celdas.MedioCentro) {
			int celda=4;
			int a=1;
			int b=1;
			label.setMinSize(170, 170);
			label.setTranslateX(10);
			label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			      @Override
			      public void handle(MouseEvent e) {
			    	  if(logica.Verificar(celda)==false) {
			    		  System.out.println("No se puede sobreescribir lo marcado");
			    	  }else {
			    		  if(logica.getSwitch()==2) {
			    			  try {
			    				  FileInputStream Equis = new FileInputStream("Circulo.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(4);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }else {
				    		  try {
			    				  FileInputStream Equis = new FileInputStream("Equis.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(2);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }
			    	 }
			    	 
			      
			      }
			    });
			return label;
		}
		if (tipo ==Celdas.MedioDerecha) {
			int celda=5;
			int a=1;
			int b=2;
			label.setTranslateX(190);
			label.setMinSize(170, 170);
			label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			      @Override
			      public void handle(MouseEvent e) {
			    	  if(logica.Verificar(celda)==false) {
			    		  System.out.println("No se puede sobreescribir lo marcado");
			    	  }else {
			    		  if(logica.getSwitch()==2) {
			    			  try {
			    				  FileInputStream Equis = new FileInputStream("Circulo.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
					    		 
				    		  logica.setSwitch(4);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }else {
				    		  try {
			    				  FileInputStream Equis = new FileInputStream("Equis.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(2);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }
			    	 }
			    	 
			      }
			    });
			return label;
		}
		if (tipo ==Celdas.Abajoizquierda) {
			int celda=6;
			int a=2;
			int b=0;
			label.setTranslateX(-170);
			label.setTranslateY(180);
			label.setMinSize(170, 170);
			label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			      @Override
			      public void handle(MouseEvent e) {
			    	  if(logica.Verificar(celda)==false) {
			    		  System.out.println("No se puede sobreescribir lo marcado");
			    	  }else {
			    		  if(logica.getSwitch()==2) {
			    			  try {
			    				  FileInputStream Equis = new FileInputStream("Circulo.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(4);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }else {
				    		  try {
			    				  FileInputStream Equis = new FileInputStream("Equis.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(2);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }
			    	 }
			    	 
			      }
			    });
			return label;
		}
		if (tipo ==Celdas.AbajoCentro) {
			int celda=7;
			int a=2;
			int b=1;
			label.setMinSize(170, 170);
			label.setTranslateY(180);
			label.setTranslateX(10);
			label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			      @Override
			      public void handle(MouseEvent e) {
			    	  if(logica.Verificar(celda)==false) {
			    		  System.out.println("No se puede sobreescribir lo marcado");
			    	  }else {
			    		  if(logica.getSwitch()==2) {
			    			  try {
			    				  FileInputStream Equis = new FileInputStream("Circulo.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(4);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }else {
				    		  try {
			    				  FileInputStream Equis = new FileInputStream("Equis.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(2);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }
			    	 }
			    	 
			      }
			    });
			return label;
		}
		if (tipo ==Celdas.AbajoDerecha) {
			int celda=8;
			int a=2;
			int b=2;
			label.setTranslateY(180);
			label.setTranslateX(190);
			label.setMinSize(170, 170);
			label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			      @Override
			      public void handle(MouseEvent e) {
			    	  if(logica.Verificar(celda)==false) {
			    		  System.out.println("No se puede sobreescribir lo marcado");
			    	  }else {
			    		  if(logica.getSwitch()==2) {
			    			  try {
			    				  FileInputStream Equis = new FileInputStream("Circulo.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(4);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }else {
				    		  try {
			    				  FileInputStream Equis = new FileInputStream("Equis.png");
			    				  Image EquisImage = new Image(Equis);
			    				  label.setGraphic(new ImageView(EquisImage));
			    			  }catch(Exception a) {
			    				  a.printStackTrace();
			    			  }
				    		  logica.setSwitch(2);
				    		  contador++;
							  try {
								  logica.setLista(a,b,celda,contador,logica.getString());
							  } catch (FileNotFoundException ex) {
								  ex.printStackTrace ();
							  }
						  }
			    	 }
			    	 
			      }
			    });
			return label;
		}
		else {
			return null;
		}
	
		
	}
	
}
