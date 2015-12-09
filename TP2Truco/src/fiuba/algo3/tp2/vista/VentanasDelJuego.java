package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConIASinFlor;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VentanasDelJuego {

	private ImagenesCarta imagenesCarta;
	private boolean conFlor = true;
	private PartidaDeTruco partida;
	private Stage stageJugadorConTurno;
	private Stage stageCartasEnMesa;
	private VBox botonesDelJugador;

	public VentanasDelJuego (PartidaDeTruco partida){
		
		//creacion de la partida
		//if (this.conFlor)
		/*this.partida = new PartidaDeTrucoConFlor("Equipo UNO", "Equipo DOS");
		//this.partida = new PartidaDeTrucoSinFlor("Equipo UNO", "Equipo DOS");

		//cargar nombres de jugadores
		ArrayList<String> lista1 = new ArrayList<String> ();
		lista1.add("jugador1");
		lista1.add("jugador3");
		lista1.add("jugador5");
		this.partida.cargarJugadoresEnEquipoUno(lista1);
		ArrayList<String> lista2 = new ArrayList<String> ();
		lista2.add("jugador2");
		lista2.add("jugador4");
		lista2.add("jugador6");
		this.partida.cargarJugadoresEnEquipoDos(lista2);
		this.partida.iniciar();
		
		
		this.partida = new PartidaDeTrucoConIASinFlor("Equipo IA", "Equipo DOS");
		ArrayList<String> lista2 = new ArrayList<String> ();
		lista2.add("jugador2");
		this.partida.cargarJugadoresEnEquipoDos(lista2);
		this.partida.iniciar();*/
		
		this.partida=partida;
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

}
