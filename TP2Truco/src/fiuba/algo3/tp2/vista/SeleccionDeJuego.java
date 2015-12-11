package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConIAConFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConIASinFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoSinFlor;
import fiuba.algo3.tp2.vista.botonesSeleccionDeJuego.Boton2JugadoresEventHandler;
import fiuba.algo3.tp2.vista.botonesSeleccionDeJuego.Boton4JugadoresEventHandler;
import fiuba.algo3.tp2.vista.botonesSeleccionDeJuego.Boton6JugadoresEventHandler;
import fiuba.algo3.tp2.vista.botonesSeleccionDeJuego.BotonEmpezarJuegoEventHandler;
import fiuba.algo3.tp2.vista.botonesSeleccionDeJuego.BotonJugarContraPcEventHandler;
import fiuba.algo3.tp2.vista.botonesSeleccionDeJuego.BotonVolverEventHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SeleccionDeJuego extends Application{

	private boolean conFlor;
	private int cantidadJugadores;
	private List<TextField> nombresEquipos;
	private List<TextField> nombresJugadores;
	private List<TextField> camposDeValidacion;
	private List<Label> mensajesDeValidacion;
	private VentanasDelJuego ventanasDelJuego;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		this.cargarPantallaPrincipal(stage);
	}
	
	public void cargarPantallaPrincipal (Stage stage){
		stage.setTitle("FON-TRUCO Seleccion de juego");
		stage.setScene(this.opcionesDeJuego(stage));
		stage.setResizable(false);
		stage.show();
	}

	public Scene opcionesDeJuego(Stage stage){
		String direccion= "/fiuba/algo3/tp2/vista/imagenes/fondoPrincipal.jpg";
		Image image = new Image(direccion);
		ImageView contenedorImagen = new ImageView();
		contenedorImagen.setImage(image);

		CheckBox check = new CheckBox("Jugar Con Flor");
		check.setStyle("-fx-background-color: orange; -fx-font-size: 12pt;");
		check.setSelected(false);

		Button boton2Jugadores = new Button();
		boton2Jugadores.setText("2 Jugadores");
		Boton2JugadoresEventHandler boton2JugadoresEventHandler = new Boton2JugadoresEventHandler(this, check,stage);
		boton2Jugadores.setOnAction(boton2JugadoresEventHandler);
		boton2Jugadores.setStyle("-fx-background-color: blue; -fx-text-fill: white;");

		Button boton4Jugadores = new Button();
		boton4Jugadores.setText("4 Jugadores");
		Boton4JugadoresEventHandler boton4JugadoresEventHandler = new Boton4JugadoresEventHandler(this, check,stage);
		boton4Jugadores.setOnAction(boton4JugadoresEventHandler);
		boton4Jugadores.setStyle("-fx-background-color: blue; -fx-text-fill: white;");

		Button boton6Jugadores = new Button();
		boton6Jugadores.setText("6 Jugadores");
		Boton6JugadoresEventHandler boton6JugadoresEventHandler = new Boton6JugadoresEventHandler(this, check,stage);
		boton6Jugadores.setOnAction(boton6JugadoresEventHandler);
		boton6Jugadores.setStyle("-fx-background-color: blue; -fx-text-fill: white;");

		Button botonJugarContraPc = new Button();
		botonJugarContraPc.setText("Jugar Contra Pc");
		BotonJugarContraPcEventHandler botonJugarContraPcEventHandler = new BotonJugarContraPcEventHandler(this, check,stage);
		botonJugarContraPc.setOnAction(botonJugarContraPcEventHandler);
		botonJugarContraPc.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");

		HBox hboxCheck = new HBox(check);
		hboxCheck.setAlignment(Pos.CENTER);
		HBox hboxBotones = new HBox(boton2Jugadores,boton4Jugadores,boton6Jugadores,botonJugarContraPc);
		hboxBotones.setAlignment(Pos.CENTER);

		VBox vboxPrincipal = new VBox(hboxCheck,hboxBotones);
		vboxPrincipal.setAlignment(Pos.CENTER);

		BorderPane root = new BorderPane();
		root.getChildren().add(contenedorImagen);
		root.setCenter(vboxPrincipal);

		Scene scene = new Scene(root,500,375);
		return scene;
	}

	@SuppressWarnings("unchecked")
	public void creacionDeEquiposYJugadores(boolean jugarConFlor, int cantidadJugadores){

		this.conFlor=jugarConFlor;
		this.cantidadJugadores=cantidadJugadores;

		String direccion= "/fiuba/algo3/tp2/vista/imagenes/fOpciones.jpg";
		Image image = new Image(direccion);
		ImageView contenedorImagen = new ImageView();
		contenedorImagen.setImage(image);

		Label titulo = new Label("Fon-Truco");
		titulo.setFont(Font.font("Calibri", FontWeight.BOLD, 32));
		titulo.setTextFill(Color.WHITE);
		titulo.setLayoutX(20);

		Stage stage = new Stage();
		Group root = new Group();
		root.getChildren().addAll(contenedorImagen,titulo);

		this.nombresEquipos= new ArrayList<TextField>();
		this.nombresJugadores= new ArrayList<TextField>();
		this.camposDeValidacion= new ArrayList<TextField>();
		this.mensajesDeValidacion= new ArrayList<Label>();

		int layoutY = 0;
		for (int j=1; j<3 ; j++){
			layoutY+=50; // dejo espacio
			Label etiqueta = this.crearLabel("INGRESE EL NOMBRE DEL EQUIPO "+j, layoutY);
			this.mensajesDeValidacion.add(etiqueta);
			TextField campoDeIngreso = this.crearTextField(root,etiqueta,layoutY);
			this.camposDeValidacion.add(campoDeIngreso);
			this.nombresEquipos.add(campoDeIngreso);
			for (int i=1; i<((cantidadJugadores+2)/2); i++){
				layoutY+=50;
				Label etiqueta2 = this.crearLabel("INGRESE EL NOMBRE DEL JUGADOR "+i+" DEL EQUIPO "+j, layoutY);
				this.mensajesDeValidacion.add(etiqueta2);
				TextField campoDeIngreso2 = this.crearTextField(root,etiqueta2,layoutY);
				this.camposDeValidacion.add(campoDeIngreso2);
				this.nombresJugadores.add(campoDeIngreso2);
			}
			layoutY+=25;
		}

		Button botonEmpezarJuego = new Button();
		botonEmpezarJuego.setText("EMPEZAR JUEGO!");
		@SuppressWarnings("rawtypes")
		BotonEmpezarJuegoEventHandler botonEmpezarJuegoEventHandler = new BotonEmpezarJuegoEventHandler(this, stage);
		botonEmpezarJuego.setOnAction(botonEmpezarJuegoEventHandler);
		botonEmpezarJuego.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
		botonEmpezarJuego.setLayoutY(470);
		botonEmpezarJuego.setLayoutX(200);
		
		Button botonVolver = new Button();
		botonVolver.setText("Volver");
		BotonVolverEventHandler botonVolverEventHandler = new BotonVolverEventHandler (this,stage);
		botonVolver.setOnAction(botonVolverEventHandler);
	    botonVolver.setStyle("-fx-background-color: green; -fx-text-fill: white;");
	    botonVolver.setLayoutY(470);
		botonVolver.setLayoutX(40);
	    
		root.getChildren().addAll(botonEmpezarJuego,botonVolver);

		Scene scene = new Scene(root, 350, 500);
		stage.setTitle("Ingrese Datos");
		stage.setScene(scene);
		stage.setResizable(false);
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

		for (i = 0; i<(this.cantidadJugadores/2) ; i++){
			lista1.add(this.nombresJugadores.get(i).getText());
		}
		partida.cargarJugadoresEnEquipoUno(lista1);

		for (i = i ; i<this.cantidadJugadores ; i++){
			lista2.add(this.nombresJugadores.get(i).getText());
		}
		partida.cargarJugadoresEnEquipoDos(lista2);

		this.ventanasDelJuego = new VentanasDelJuego(partida, this.cantidadJugadores, this.conFlor);
		
		try {
			this.ventanasDelJuego.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void creacionDePartidaIa (boolean jugarConFlor){

		this.cantidadJugadores = 2;
		
		PartidaDeTruco partida;

		List<String> lista2 = new ArrayList<String> ();
		lista2.add("USTED");

		if(jugarConFlor)
			partida = new PartidaDeTrucoConIAConFlor("CPU", "USTED");
		else 
			partida = new PartidaDeTrucoConIASinFlor("CPU", "USTED");

		partida.cargarJugadoresEnEquipoDos(lista2);

		this.ventanasDelJuego = new VentanasDelJuego(partida, this.cantidadJugadores, this.conFlor);
		try {
			this.ventanasDelJuego.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean validarCampos (){
		boolean camposValidos = true;
		for (int j=0; j<this.camposDeValidacion.size(); j++){ 
			if((this.camposDeValidacion.get(j).getText().equals(""))){
				this.camposDeValidacion.get(j).setText("NOMBRE INVALIDO, REINGRESE");
				this.camposDeValidacion.get(j).setStyle("-fx-background-color: red;");
			    camposValidos = false; 
			}
		}
		return camposValidos;
	}
	
	public Label crearLabel(String mensaje,int layoutY){
		
		Label etiqueta = new Label();
		etiqueta.setStyle("-fx-font-size: 10pt;");
		etiqueta.setText(mensaje);
		etiqueta.setLayoutY(layoutY);
		etiqueta.setTextFill(Color.WHITE);
		
		return etiqueta;
		
	}

	public TextField crearTextField(Group root, Label etiqueta, int layoutY){


		TextField textoIngresado = new TextField();
		textoIngresado.setPromptText("ingrese un nombre");
		textoIngresado.setLayoutY(layoutY+15);
		textoIngresado.setLayoutX(3);
		textoIngresado.setPrefWidth(344);

		root.getChildren().add(etiqueta);
		root.getChildren().add(textoIngresado);

		return textoIngresado;
	}

}