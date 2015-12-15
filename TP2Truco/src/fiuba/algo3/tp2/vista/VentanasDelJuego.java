package fiuba.algo3.tp2.vista;

import java.util.Iterator;
import java.util.List;

import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.TirarCartaEvent;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VentanasDelJuego extends Application{

	private ImagenesCarta imagenesCarta;

	private PartidaDeTruco partida;
	private Stage stageJugadorConTurno;
	private Stage stageCartasEnMesa;
	private VBox botonesDelJugador;
	private Label etiqueta;
	private int cantidadJugadores;
	private ContenedorDeBotones contenedorBotones;

	public VentanasDelJuego (PartidaDeTruco partida, int cantidadJugadores, boolean conFlor){
		this.partida = partida;
		this.cantidadJugadores = cantidadJugadores;
		this.imagenesCarta = new ImagenesCarta();
		this.contenedorBotones = new ContenedorDeBotones(this.partida, this, conFlor);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.partida.iniciar();

		this.stageJugadorConTurno = new Stage();
		this.stageJugadorConTurno.setTitle("Cartas Del Jugador");
		//this.controladorDeBotones.agregarStage(this.stageJugadorConTurno);
		modificarStageJugador();
		this.stageJugadorConTurno.setX(0);
		this.stageJugadorConTurno.setResizable(false);
		this.stageJugadorConTurno.show();

		this.stageCartasEnMesa = new Stage();
		this.stageCartasEnMesa.setTitle("Cartas En Juego");
		modificarStajeCartasEnMesa();
		this.stageCartasEnMesa.setX(730);
		this.stageCartasEnMesa.setResizable(false);
		this.stageCartasEnMesa.show();
	}
	
	public Scene cargarSceneDelJugador() {
		//imagen de fondo de la mesa
		String direccionImagen = "/fiuba/algo3/tp2/vista/imagenes/fondo.jpg";
		Image fondo = new Image(direccionImagen, 700, 800, false, true, true);
		ImageView imagen = new ImageView();
		imagen.setImage(fondo);

		BackgroundFill back = new BackgroundFill(Color.SEAGREEN, null, null);
		Background bk = new Background(back);
		botonesDelJugador.setBackground(bk);
		botonesDelJugador.setPrefSize(670, 140);
		
		//puntos de los equipos
		Label nombreJugador = new Label();
		String texto1 = "TRUNO DE: " + this.partida.obtenerNombreDelJugadorConTurno();
		nombreJugador.setText(texto1);
		nombreJugador.setTextFill(Color.YELLOW);
		nombreJugador.setStyle("-fx-font-size: 16pt;");
		HBox nombre = new HBox(nombreJugador);
		nombre.setLayoutX(240);
		nombre.setLayoutY(320);
		nombre.setAlignment(Pos.CENTER);
		
		//escenario de imagenes de la mesa 
		BorderPane escena = new BorderPane();
		
		BackgroundImage bkImage = new BackgroundImage(fondo, null, null, null, null);
		escena.setBackground(new Background(bkImage));
		escena.setTop(this.botonesDelJugador);
		escena.setBottom(nombre);
		escena.setCenter(agregarCartasDelJugador());

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
			cartaComoImagen.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEvent<MouseEvent>(this.partida, carta, this, this.etiqueta));

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
		puntajeEquipo1.setTextFill(Color.GREEN);
		puntajeEquipo1.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
		
		Label puntajeEquipo2 = new Label();
		textoPuntaje = this.partida.obtenerNombreDeEquipoDos() +": "+ this.partida.obtenerPuntajeDeEquipoDos()+ " PUNTOS";
		puntajeEquipo2.setText(textoPuntaje);
		puntajeEquipo2.setTextFill(Color.YELLOW);
		puntajeEquipo2.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
		
		
		HBox puntaje = new HBox(puntajeEquipo1,puntajeEquipo2);
		puntaje.setLayoutX(130);
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
			
			if (i == cantidadJugadores) {
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
		this.botonesDelJugador = this.contenedorBotones.botonesParaJugadorActual();
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

		Button inicio = new Button("Inicio");
		inicio.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
		inicio.setPrefSize(100, 20);

		inicio.setOnAction(new EventHandler<ActionEvent>() {
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

		VBox volverBox = new VBox(inicio);
		volverBox.setPadding(new Insets(0, 0, 15, 0));
		volverBox.setAlignment(Pos.BOTTOM_CENTER);

		BorderPane escena = new BorderPane();
		escena.getChildren().add(imagen);
		escena.setCenter(puntajes);
		escena.setBottom(volverBox);

		Scene scene = new Scene(escena, 350, 300);
		return scene;
	}
	
	public void cerrarVentanas(){
		this.stageCartasEnMesa.close();
		this.stageJugadorConTurno.close();	
	}

}
