package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SeleccionDeJuego extends Application{
	
	private boolean conFlor;
	private int cantidadJugadores;
	private List<TextField> nombresEquipos;
	private List<TextField> nombresJugadores;
	private VentanasDelJuego ventanasDelJuego;
	
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
		check.setStyle("-fx-background-color: orange; -fx-font-size: 12pt;");
		check.setSelected(false);
		
		
		
		Button boton2Jugadores = new Button();
		boton2Jugadores.setText("2 Jugadores");
		Boton2JugadoresEventHandler boton2JugadoresEventHandler = new Boton2JugadoresEventHandler(this, check);
		boton2Jugadores.setOnAction(boton2JugadoresEventHandler);
		boton2Jugadores.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
		
		Button boton4Jugadores = new Button();
		boton4Jugadores.setText("4 Jugadores");
		Boton4JugadoresEventHandler boton4JugadoresEventHandler = new Boton4JugadoresEventHandler(this, check);
		boton4Jugadores.setOnAction(boton4JugadoresEventHandler);
		boton4Jugadores.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
		
		Button boton6Jugadores = new Button();
		boton6Jugadores.setText("6 Jugadores");
		Boton6JugadoresEventHandler boton6JugadoresEventHandler = new Boton6JugadoresEventHandler(this, check);
		boton6Jugadores.setOnAction(boton6JugadoresEventHandler);
		boton6Jugadores.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
		
		Button botonJugarContraPc = new Button();
		botonJugarContraPc.setText("Jugar Contra Pc");
		BotonJugarContraPcEventHandler botonJugarContraPcEventHandler = new BotonJugarContraPcEventHandler(this, check);
		botonJugarContraPc.setOnAction(botonJugarContraPcEventHandler);
		botonJugarContraPc.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
		
		HBox box = new HBox();
		box.setLayoutX(80);
		box.setLayoutY(240);
		box.getChildren().add(check);
		HBox box2 = new HBox();
		box2.setSpacing(5);
		box2.setLayoutX(80);
		box2.setLayoutY(270);
		box2.getChildren().addAll(boton2Jugadores,boton4Jugadores,boton6Jugadores,botonJugarContraPc);
		
		Group root = new Group();
		root.getChildren().addAll(contenedorImagen,box,box2);
		
		
		Scene scene = new Scene(root,500,375);
		return scene;
	}
	
	public void creacionDeEquiposYJugadores(boolean jugarConFlor, int cantidadJugadores){
		
		this.conFlor=jugarConFlor;
		this.cantidadJugadores=cantidadJugadores;
		
		String direccion= "/fiuba/algo3/tp2/vista/imagenes/fondo.jpg";
		Image image = new Image(direccion);
		ImageView contenedorImagen = new ImageView();
		contenedorImagen.setImage(image);
		
		Stage stage = new Stage();
		Group root = new Group();
		root.getChildren().add(contenedorImagen);
		
		this.nombresEquipos= new ArrayList<TextField>();
		this.nombresJugadores= new ArrayList<TextField>();
		
		int layoutY = 0;
		for (int j=1; j<3 ; j++){
		  layoutY+=50;	
		  this.nombresEquipos.add(this.crearTextField(root,"INGRESE EL NOMBRE DEL EQUIPO "+j,layoutY));
		  for (int i=1; i<((cantidadJugadores+2)/2); i++){
			    layoutY+=50;	
		    	this.nombresJugadores.add(this.crearTextField(root,"INGRESE EL NOMBRE DEL JUGADOR "+i+" DEL EQUIPO "+j,layoutY));
		  }
		}
		
		Button botonEmpezarJuego = new Button();
		botonEmpezarJuego.setText("EMPEZAR JUEGO!");
		BotonEmpezarJuegoEventHandler botonEmpezarJuegoEventHandler = new BotonEmpezarJuegoEventHandler(this, stage);
		botonEmpezarJuego.setOnAction(botonEmpezarJuegoEventHandler);
		botonEmpezarJuego.setLayoutY(470);
		botonEmpezarJuego.setLayoutX(100);
		
		root.getChildren().add(botonEmpezarJuego);

		Scene scene = new Scene(root, 300, 500);
		stage.setScene(scene);
		stage.show();
			
	}
	
	public void creacionDePartida(){
		
		PartidaDeTruco partida;
		String nombreEq1 = this.nombresEquipos.get(0).getText();
		String nombreEq2 = this.nombresEquipos.get(1).getText();
		
		if (this.conFlor)
			partida = new PartidaDeTrucoConFlor(nombreEq1,nombreEq2);
		else
			partida = new PartidaDeTrucoSinFlor(nombreEq1, nombreEq2);
		
		int i;
		List<String> lista1 = new ArrayList<String> ();
		List<String> lista2 = new ArrayList<String> ();
		
		for ( i=0; i<(this.cantidadJugadores/2) ; i++){
			System.out.println(i +" eq1");
			lista1.add(this.nombresJugadores.get(i).getText());
		}
		partida.cargarJugadoresEnEquipoUno(lista1);
		
		for (i=i ; i<this.cantidadJugadores ; i++){
			System.out.println(i +" eq2");
			lista2.add(this.nombresJugadores.get(i).getText());
		}
		partida.cargarJugadoresEnEquipoDos(lista2);
				
		this.ventanasDelJuego= new VentanasDelJuego(partida);
	}
	
	public void creacionDePartidaIa (boolean jugarConFlor){
		
		PartidaDeTruco partida;
		String nombreEq1 ="";
		
		if(jugarConFlor)
			partida = new PartidaDeTrucoConIAConFlor(nombreEq1, "Pc");
		else 
			partida = new PartidaDeTrucoConIASinFlor(nombreEq1, "Pc");
		
        this.ventanasDelJuego= new VentanasDelJuego(partida);
		
	}
	
	public TextField crearTextField(Group root, String mensaje, int layoutY){
		
		Label etiqueta = new Label();
		etiqueta.setText(mensaje);
		etiqueta.setLayoutY(layoutY);
		etiqueta.setTextFill(Color.RED);
		
		TextField textoIngresado = new TextField();
		textoIngresado.setPromptText("ingrese un nombre");
		textoIngresado.setLayoutY(layoutY+25);
		
		root.getChildren().add(etiqueta);
		root.getChildren().add(textoIngresado);
		
		return textoIngresado;
		
	}

}