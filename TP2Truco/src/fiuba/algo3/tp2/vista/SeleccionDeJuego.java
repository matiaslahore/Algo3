package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConIAConFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConIASinFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoSinFlor;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SeleccionDeJuego extends Application{
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("FON-TRUCO Seleccion de juego");
		stage.setScene(this.opcionesDeJuego());
		stage.show();
	}
	
	public Scene opcionesDeJuego(){
		String direccion= "/fiuba/algo3/tp2/vista/imagenes/fondoPrincipal.jpg";
		Image image = new Image(direccion);
		ImageView contenedorImagen = new ImageView();
		contenedorImagen.setImage(image);
		
		CheckBox check = new CheckBox("Jugar Con Flor");
		check.setSelected(false);
		
		Button boton2Jugadores = new Button();
		boton2Jugadores.setText("2 Jugadores");
		Boton2JugadoresEventHandler boton2JugadoresEventHandler = new Boton2JugadoresEventHandler(this, check);
		boton2Jugadores.setOnAction(boton2JugadoresEventHandler);
		
		
		
		
		Group root = new Group();
		root.getChildren().add(contenedorImagen);
		
		
		
		Scene scene = new Scene(root,500,375);
		return scene;
	}
	
	public PartidaDeTruco creacionDePartida(boolean jugarConFlor, int cantidadJugadores){
	
		PartidaDeTruco partida;
		String nombreEq1 = "";
		String nombreEq2 = "";
		
		
		if (jugarConFlor)
			partida = new PartidaDeTrucoConFlor(nombreEq1, nombreEq2);
		else
			partida = new PartidaDeTrucoSinFlor(nombreEq1, nombreEq2);
		
		return partida;
			
	}
	
	public PartidaDeTruco creacionDePartidaIa (boolean jugarConFlor){
		
		PartidaDeTruco partida;
		String nombreEq1 = "";
		if(jugarConFlor)
			partida = new PartidaDeTrucoConIAConFlor(nombreEq1, "Pc");
		else 
			partida = new PartidaDeTrucoConIASinFlor(nombreEq1, "Pc");
		
		return partida;
		
	}
	
	public void pedirNombrePorPantalla (String mensaje){
		
		TextField textoIngresado = new TextField();
		textoIngresado.setPromptText("ingrese un nombre");
		
		Label etiqueta = new Label();
		etiqueta.setText(mensaje);
		
		Group root = new Group();
		root.getChildren().add(etiqueta);
		root.getChildren().add(textoIngresado);
		
		
		Stage stage = new Stage();
		Scene scene = new Scene(root, 300, 150);
		stage.setScene(scene);
		stage.show();
		
		
	}

}