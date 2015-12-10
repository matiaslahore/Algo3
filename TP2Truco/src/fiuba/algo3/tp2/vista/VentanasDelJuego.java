package fiuba.algo3.tp2.vista;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConIASinFlor;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VentanasDelJuego extends Application{

	private ImagenesCarta imagenesCarta;
	private boolean conFlor = true;
	private PartidaDeTruco partida;
	private Stage stageJugadorConTurno;
	private Stage stageCartasEnMesa;
	private VBox botonesDelJugador;

	/*
	public VentanasDelJuego (PartidaDeTruco partida){
		this.partida = partida;
		this.partida.iniciar();
		//VENTANAS DEL JUEGO
		this.stageJugadorConTurno = new Stage();
		this.stageJugadorConTurno.setTitle("Cartas Del Jugador");
		this.botonesDelJugador = botonesDelJugador(this.stageJugadorConTurno);
		modificarStageJugador();
		this.stageJugadorConTurno.setX(0);
		this.stageJugadorConTurno.show();

		this.stageCartasEnMesa = new Stage();
		this.stageCartasEnMesa.setTitle("Cartas En Juego");
		modificarStajeCartasEnMesa();
		this.stageCartasEnMesa.setX(730);
		this.stageCartasEnMesa.show();
		this.imagenesCarta = new ImagenesCarta();
	}*/

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		imagenesCarta = new ImagenesCarta();
		/*
		//creacion de la partida
		//if (this.conFlor)
		this.partida = new PartidaDeTrucoConFlor("Equipo UNO", "Equipo DOS");
		//this.partida = new PartidaDeTrucoSinFlor("Equipo UNO", "Equipo DOS");

		//cargar nombres de jugadores
		this.partida.cargarJugadoresEnEquipoUno(Arrays.asList("jugador1","jugador3","jugador5"));
		this.partida.cargarJugadoresEnEquipoDos(Arrays.asList("jugador2","jugador4","jugador6"));
		this.partida.iniciar();
		 */

		this.partida = new PartidaDeTrucoConIASinFlor("EquipoIA","EquipoHumano");
		this.partida.cargarJugadoresEnEquipoDos(Arrays.asList("jugadorHumano"));
		this.partida.iniciar();

		//VENTANAS DEL JUEGO

		this.stageJugadorConTurno = new Stage();
		this.stageJugadorConTurno.setTitle("Cartas Del Jugador");
		this.botonesDelJugador = botonesDelJugador(this.stageJugadorConTurno);
		modificarStageJugador();
		this.stageJugadorConTurno.setX(0);
		this.stageJugadorConTurno.show();

		this.stageCartasEnMesa = new Stage();
		this.stageCartasEnMesa.setTitle("Cartas En Juego");
		modificarStajeCartasEnMesa();
		this.stageCartasEnMesa.setX(730);
		this.stageCartasEnMesa.show();
	}

	private VBox botonesDelJugador(Stage stage) {
		//etiqueta para mensajes
		Label etiqueta = new Label();

		//botones de opciones para el jugador actual.
		Button botonEnvido = new Button("Envido");
		BotonEnvidoEventHandler botonEnvidoEventHandler = new BotonEnvidoEventHandler(this.partida, this, etiqueta);
		botonEnvido.setOnAction(botonEnvidoEventHandler);

		Button botonRealEnvido = new Button("Real Envido");
		BotonRealEnvidoEventHandler botonRealEnvidoEventHandler = new BotonRealEnvidoEventHandler(this.partida, this, etiqueta);
		botonRealEnvido.setOnAction(botonRealEnvidoEventHandler);

		Button botonFaltaEnvido = new Button("Falta Envido");
		BotonFaltaEnvidoEventHandler botonFaltaEnvidoEventHandler = new BotonFaltaEnvidoEventHandler(this.partida, this, etiqueta);
		botonFaltaEnvido.setOnAction(botonFaltaEnvidoEventHandler);

		Button botonFlor = new Button("Flor");
		BotonFlorEventHandler botonFlorEventHandler = new BotonFlorEventHandler(this.partida, this, etiqueta);
		botonFlor.setOnAction(botonFlorEventHandler);

		Button botonContraFlor = new Button("Contra Flor");
		BotonContraFlorEventHandler botonContraFlorEventHandler = new BotonContraFlorEventHandler(this.partida, this, etiqueta);
		botonContraFlor.setOnAction(botonContraFlorEventHandler);

		Button botonFlorContraResto = new Button("Flor X Resto");
		BotonFlorContraRestoEventHandler botonFlorContraRestoEventHandler = new BotonFlorContraRestoEventHandler(this.partida, this, etiqueta);
		botonFlorContraResto.setOnAction(botonFlorContraRestoEventHandler);

		Button botonTruco = new Button("Truco");
		BotonTrucoEventHandler botonTrucoEventHandler = new BotonTrucoEventHandler(this.partida, this, etiqueta);
		botonTruco.setOnAction(botonTrucoEventHandler);

		Button botonReTruco = new Button("ReTruco");
		BotonReTrucoEventHandler botonReTrucoEventHandler = new BotonReTrucoEventHandler(this.partida, this, etiqueta);
		botonReTruco.setOnAction(botonReTrucoEventHandler);

		Button botonValeCuatro = new Button("ValeCuatro");
		BotonValeCuatroEventHandler botonValeCuatroEventHandler = new BotonValeCuatroEventHandler(this.partida, this, etiqueta);
		botonValeCuatro.setOnAction(botonValeCuatroEventHandler);

		Button botonQuerer = new Button("Querer");
		BotonQuererEventHandler botonQuererEventHandler = new BotonQuererEventHandler(this.partida, this, etiqueta);
		botonQuerer.setOnAction(botonQuererEventHandler);

		Button botonNoQuerer = new Button("No Querer");
		BotonNoQuererEventHandler botonNoQuererEventHandler = new BotonNoQuererEventHandler(this.partida, this, etiqueta);
		botonNoQuerer.setOnAction(botonNoQuererEventHandler);

		Button botonIrseAlMazo = new Button("Irse al Mazo");
		BotonIrseAlMazoEventHandler botonIrseAlMazoEventHandler = new BotonIrseAlMazoEventHandler(this.partida, this, etiqueta);
		botonIrseAlMazo.setOnAction(botonIrseAlMazoEventHandler);

		//contenedores de los botones
		HBox contenedorEnvido = new HBox(30,botonEnvido,botonRealEnvido,botonFaltaEnvido);
		HBox contenedorTruco = new HBox(30,botonTruco,botonReTruco,botonValeCuatro);
		HBox contenedorOpcion = new HBox(30,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		if (this.conFlor)
			contenedorEnvido.getChildren().addAll(botonFlor,botonContraFlor,botonFlorContraResto);

		VBox contenedorBotones = new VBox(contenedorOpcion,contenedorEnvido, contenedorTruco, etiqueta);
		contenedorBotones.setSpacing(8);
		contenedorBotones.setPadding(new Insets(20));

		return contenedorBotones;
	}

	public Scene cargarSceneDelJugador() {
		//imagen de fondo de la mesa
		String direccionImagen = "/fiuba/algo3/tp2/vista/imagenes/fondo.jpg";
		Image fondo = new Image(direccionImagen, 700, 800, false, true, true);
		ImageView imagen = new ImageView();
		imagen.setImage(fondo);

		//puntos de los equipos
		Label nombreJugador = new Label();
		String texto1 = "TRUNO DE: " + this.partida.obtenerNombreDelJugadorConTurno();
		nombreJugador.setText(texto1);
		nombreJugador.setTextFill(Color.web("#FF0000"));
		HBox nombre = new HBox(nombreJugador);
		nombre.setAlignment(Pos.CENTER);

		//escenario de imagenes de la mesa 
		Group escena = new Group();

		escena.getChildren().add(imagen); //carga el fondo
		escena.getChildren().add(this.botonesDelJugador); //agregue botones sin las cartas
		escena.getChildren().add(nombre);
		escena.getChildren().add(agregarCartasDelJugador());

		Scene scene = new Scene(escena, 670, 350);
		return scene;
	}

	@SuppressWarnings("unchecked")
	public Group agregarCartasDelJugador(){
		Group root = new Group();
		double layoutX = 90;

		List<Carta> listaCartasJugador = this.partida.obtenerCartasDelJugadorConTurno();

		Iterator<Carta> itr = listaCartasJugador.iterator();
		while(itr.hasNext()) {
			Carta carta = (Carta) itr.next();
			System.out.println(carta.cartaComoString());
			Image imgCarta = new Image(this.imagenesCarta.obtenerDireccionDeCarta(carta.cartaComoString()));
			ImageView cartaComoImagen = new ImageView();
			cartaComoImagen.setImage(imgCarta);
			cartaComoImagen.setFitHeight(150);
			cartaComoImagen.setFitWidth(110);
			cartaComoImagen.setLayoutX(layoutX);
			cartaComoImagen.setLayoutY(150);
			cartaComoImagen.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEvent<MouseEvent>(this.partida, carta, this));

			layoutX += 150;

			root.getChildren().add(cartaComoImagen);
		}
		return root;
	}

	public Scene cargarSceneDeLaMesa() {
		//puntos de los equipos
		Label puntajeEquipo1 = new Label();
		String textoPuntaje = this.partida.obtenerNombreDeEquipoUno()+": "+ this.partida.obtenerPuntajeDeEquipoUno()+ " PUNTOS";
		puntajeEquipo1.setText(textoPuntaje);
		puntajeEquipo1.setTextFill(Color.web("#FF0000"));
		Label puntajeEquipo2 = new Label();
		textoPuntaje = this.partida.obtenerNombreDeEquipoDos() +": "+ this.partida.obtenerPuntajeDeEquipoDos()+ " PUNTOS";
		puntajeEquipo2.setText(textoPuntaje);
		puntajeEquipo2.setTextFill(Color.web("#FFBB11"));

		HBox puntaje = new HBox(puntajeEquipo1,puntajeEquipo2);
		puntaje.setSpacing(30);

		//imagen de fondo de la mesa
		String direccionImagen = "/fiuba/algo3/tp2/vista/imagenes/fondo.jpg";
		Image fondo = new Image(direccionImagen, 700, 800, false, true, true);
		ImageView imagen = new ImageView();
		imagen.setImage(fondo);

		//escenario de imagenes de la mesa 
		Group escena = new Group();

		escena.getChildren().add(imagen); //carga el fondo
		escena.getChildren().add(puntaje);
		escena.getChildren().add(agregarCartasEnJuego());

		Scene scene = new Scene(escena, 600, 480);
		return scene;
	}

	public Group agregarCartasEnJuego(){
		Group root = new Group();
		double layoutX = 80;
		double layoutY = 40;
		
		List<Carta> listaCartasJugador = this.partida.cartasEnJuego();
		int i = 1;
		for (Carta carta : listaCartasJugador) {
			Image imgCarta = new Image(this.imagenesCarta.obtenerDireccionDeCarta(carta.cartaComoString()));
			ImageView cartaComoImagen = new ImageView();
			cartaComoImagen.setImage(imgCarta);
			cartaComoImagen.setFitHeight(150);
			cartaComoImagen.setFitWidth(110);
			cartaComoImagen.setLayoutX(layoutX);
			cartaComoImagen.setLayoutY(layoutY);

			layoutY += 50;

			if (i == 6) {
				layoutY = 40;
				layoutX += 150;
				i = 0;
			}

			i = i+1;
			
			root.getChildren().add(cartaComoImagen);
		}

		return root;
	}

	public void modificarStageJugador(){
		Scene sceneCartasJugador = this.cargarSceneDelJugador();
		this.stageJugadorConTurno.setScene(sceneCartasJugador);
	}

	public void modificarStajeCartasEnMesa(){
		Scene sceneCartasEnMesa = this.cargarSceneDeLaMesa();
		this.stageCartasEnMesa.setScene(sceneCartasEnMesa);
	}


	public void cerrarVentanasJuego() {
		this.stageCartasEnMesa.close();
		this.stageJugadorConTurno.close();

		Stage menuFinalizacion = new Stage();
		menuFinalizacion.setTitle("PARTIDA FINALIZADA");

		Scene sceneFinalizada = cargarSceneFinalizacion(menuFinalizacion);
		menuFinalizacion.setScene(sceneFinalizada);
		menuFinalizacion.setResizable(false);
		menuFinalizacion.show();
	}

	public Scene cargarSceneFinalizacion(Stage menuFinalizacion) {
		Label nombreEquipo1 = new Label(this.partida.obtenerNombreDeEquipoUno());
		nombreEquipo1.setTextFill(Color.WHITE);
		nombreEquipo1.setFont(Font.font(22));
		Label puntajeEquipo1 = new Label(Integer.toString(this.partida.obtenerPuntajeDeEquipoUno()));
		puntajeEquipo1.setFont(Font.font(62));
		puntajeEquipo1.setTextFill(Color.WHITE);

		Label nombreEquipo2 = new Label(this.partida.obtenerNombreDeEquipoDos());
		nombreEquipo2.setTextFill(Color.WHITE);
		nombreEquipo2.setFont(Font.font(22));
		Label puntajeEquipo2 = new Label(Integer.toString(this.partida.obtenerPuntajeDeEquipoDos()));
		puntajeEquipo2.setFont(Font.font(62));
		puntajeEquipo2.setTextFill(Color.WHITE);

		VBox puntajeUno = new VBox(nombreEquipo1,puntajeEquipo1);
		puntajeUno.setSpacing(30);
		puntajeUno.setAlignment(Pos.CENTER);
		VBox puntajeDos = new VBox(nombreEquipo2,puntajeEquipo2);
		puntajeDos.setSpacing(30);
		puntajeDos.setAlignment(Pos.CENTER);

		HBox puntajes = new HBox(puntajeUno, puntajeDos);
		puntajes.setSpacing(30);
		puntajes.setAlignment(Pos.CENTER);

		String direccionImagen = "/fiuba/algo3/tp2/vista/imagenes/fOpciones.jpg";
		Image fondo = new Image(direccionImagen);
		ImageView imagen = new ImageView();
		imagen.setImage(fondo);

		Button volver = new Button("Inicio");
		volver.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
		volver.setPrefSize(100, 20);

		volver.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				SeleccionDeJuego vista = new SeleccionDeJuego();
				menuFinalizacion.close();
				try {
					vista.start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
				);

		HBox volverBox = new HBox(volver);
		volverBox.setAlignment(Pos.BOTTOM_CENTER);

		BorderPane escena = new BorderPane();
		escena.getChildren().add(imagen);
		escena.setCenter(puntajes);
		escena.setBottom(volverBox);

		Scene scene = new Scene(escena, 350, 300);
		return scene;
	}

}
