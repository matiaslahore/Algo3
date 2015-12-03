package fiuba.algo3.tp2.vista;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoSinFlor;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Visualizador extends Application  {

	private int index;
	private ImagenesCarta imagenesCarta;
	private int cantidadDeJugadores;
	private boolean conFlor;
	private Group escena;
	private ArrayList<ConjuntoCartas<ImageView>> listaJugadores; 
	private PartidaDeTruco partida;
	private ConjuntoCartas<ImageView> cartasEnMesa;
	private Stage stageJugadorConTurno;
	private Stage stageCartasEnMesa;
	private VBox botonesDelJugador;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Scene opcionesDeJuego = this.obtenerOpcionesDeJuego(stage);
		stage.setTitle("Partida De Truco");
		stage.setScene(opcionesDeJuego);
		stage.show();
	}

	@SuppressWarnings("unchecked")
	private Scene obtenerOpcionesDeJuego(Stage stage) {
		//VBOXGeneral
		VBox vBoxGeneral = new VBox();
		vBoxGeneral.setSpacing(5);
		vBoxGeneral.setPadding(new Insets(10));

		//HBOXBinvenida
		HBox hBoxBienvenida = new HBox();
		hBoxBienvenida.setSpacing(5);
		hBoxBienvenida.setPadding(new Insets(10));

		//HBOXCantidadJugadores
		VBox checkCantidadJugadores = new VBox();
		checkCantidadJugadores.setSpacing(5);
		checkCantidadJugadores.setPadding(new Insets(10));

		//HBOXFlor
		VBox checkFlor = new VBox();
		checkFlor.setSpacing(5);
		checkFlor.setPadding(new Insets(10));

		//HBoxJugar
		HBox boxJugar = new HBox();
		boxJugar.setSpacing(20);
		boxJugar.setPadding(new Insets(20));

		//CHECHBOX
		CheckBox checkBox2jugadores = new CheckBox("2 Jugadores");
		CheckBox checkBox4jugadores = new CheckBox("4 Jugadores");
		CheckBox checkBox6jugadores = new CheckBox("6 Jugadores");
		CheckBox checkBoxJugarConIA = new CheckBox("Jugar con IA");
		CheckBox checkBoxFlor = new CheckBox("Jugar con Flor");

		//LABELS
		Label lbBienvenido = new Label(" Bienvenido a Fon Truco ");
		lbBienvenido.setFont(new Font("Arial", 22));
		Label lbCantJugadores = new Label(" 1 - Seleccione la cantidad de jugadores");
		Label lbjugarContraIA = new Label(" 1.1 - Jugar contra la computadora");
		Label lbFlor = new Label(" 2 - ¿Jugar con Flor?");

		//BOTON Jugar
		Button botonJugar = new Button();
		botonJugar.setText("Jugar");

		//AGREGAR check y labels a HBoxs
		hBoxBienvenida.getChildren().add(lbBienvenido);
		checkCantidadJugadores.getChildren().addAll(lbCantJugadores,checkBox2jugadores,checkBox4jugadores,checkBox6jugadores,lbjugarContraIA,checkBoxJugarConIA);
		checkFlor.getChildren().addAll(lbFlor,checkBoxFlor);
		boxJugar.getChildren().add(botonJugar);

		//Agragar los HBox a los VBox
		vBoxGeneral.getChildren().addAll(hBoxBienvenida,checkCantidadJugadores,checkFlor,boxJugar);

		//HANDLERS
		checkBox2jugadores.addEventHandler(MouseEvent.MOUSE_CLICKED, new CheckCantidadJugadores<MouseEvent>(2,this,checkBox4jugadores,checkBox6jugadores));
		checkBox4jugadores.addEventHandler(MouseEvent.MOUSE_CLICKED, new CheckCantidadJugadores<MouseEvent>(4,this,checkBox2jugadores,checkBox6jugadores));
		checkBox6jugadores.addEventHandler(MouseEvent.MOUSE_CLICKED, new CheckCantidadJugadores<MouseEvent>(6,this,checkBox2jugadores,checkBox4jugadores));
		checkBoxJugarConIA.addEventHandler(MouseEvent.MOUSE_CLICKED, new CheckJugarConIA<MouseEvent>(this,checkBox2jugadores,checkBox4jugadores,checkBox6jugadores));
		checkBoxFlor.addEventHandler(MouseEvent.MOUSE_CLICKED, new CheckJugarConFlor<MouseEvent>(this));
		botonJugar.addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonEmpezarJuegoEventHandler<MouseEvent>(this,stage));

		//SCENE
		FlowPane root = new FlowPane();
		root.setHgap(20);
		root.getChildren().add(vBoxGeneral);
		Scene scene = new Scene(root, 400, 400);

		scene.getStylesheets().add("fiuba/algo3/tp2/vista/myEstilo.css");

		return scene;
	}

	public void iniciarVentanaDelJuego(Stage stage){
		//creacion de la partida
		if (this.conFlor)
			this.partida= new PartidaDeTrucoConFlor("Equipo UNO", "Equipo DOS");
		this.partida= new PartidaDeTrucoSinFlor("Equipo UNO", "Equipo DOS");

		//cargar nombres de jugadores
		ArrayList<String> lista1 = new ArrayList<String> ();
		lista1.add("PEPITO");
		this.partida.cargarJugadoresEnEquipoUno(lista1);
		ArrayList<String> lista2 = new ArrayList<String> ();
		lista2.add("JUANITO MARAVILLA");
		this.partida.cargarJugadoresEnEquipoDos(lista2);
		this.partida.iniciar();
		
		//escenario
		Scene scene = this.ventanaPrincipal(stage);
		stage.setTitle("Partida de Truco");
		stage.setScene(scene);
		stage.show();

		//VENTANAS DEL JUEGO
		this.stageJugadorConTurno = new Stage();
		this.stageJugadorConTurno.setTitle("Cartas Del Jugador");
		this.botonesDelJugador = botonesDelJugador(this.stageJugadorConTurno);
		Scene sceneCartasJugador = this.cargarSceneDelJugador();
		this.stageJugadorConTurno.setScene(sceneCartasJugador);
		this.stageJugadorConTurno.show();

		this.stageCartasEnMesa = new Stage();
		this.stageCartasEnMesa.setTitle("Cartas En Juego");
		Scene sceneCartasEnMesa = this.cargarSceneDeLaMesa();
		this.stageCartasEnMesa.setScene(sceneCartasEnMesa);
		this.stageCartasEnMesa.show();
	}

	private VBox botonesDelJugador(Stage stage) {
		//etiqueta para mensajes
		Label etiqueta = new Label();

		//botones de opciones para el jugador actual.
		Button botonEnvido = new Button();
		botonEnvido.setText("Envido");
		BotonEnvidoEventHandler botonEnvidoEventHandler = new BotonEnvidoEventHandler(this.partida, this, this.stageJugadorConTurno, this.stageCartasEnMesa);
		botonEnvido.setOnAction(botonEnvidoEventHandler);

		Button botonRealEnvido = new Button();
		botonRealEnvido.setText("Real Envido");
		BotonRealEnvidoEventHandler botonRealEnvidoEventHandler = new BotonRealEnvidoEventHandler(this.partida, etiqueta);
		botonRealEnvido.setOnAction(botonRealEnvidoEventHandler);

		Button botonFaltaEnvido = new Button();
		botonFaltaEnvido.setText("Falta Envido");
		BotonFaltaEnvidoEventHandler botonFaltaEnvidoEventHandler = new BotonFaltaEnvidoEventHandler(this.partida, etiqueta);
		botonFaltaEnvido.setOnAction(botonFaltaEnvidoEventHandler);

		Button botonFlor = new Button();
		botonFlor.setText("Flor");
		BotonFlorEventHandler botonFlorEventHandler = new BotonFlorEventHandler(this.partida, etiqueta);
		botonFlor.setOnAction(botonFlorEventHandler);

		Button botonFlorContraResto = new Button();
		botonFlorContraResto.setText("Flor X Resto");
		BotonFlorContraRestoEventHandler botonFlorContraRestoEventHandler = new BotonFlorContraRestoEventHandler(this.partida, etiqueta);
		botonFlorContraResto.setOnAction(botonFlorContraRestoEventHandler);

		Button botonTruco = new Button();
		botonTruco.setText("Truco");
		BotonTrucoEventHandler botonTrucoEventHandler = new BotonTrucoEventHandler(this.partida, this, this.stageJugadorConTurno, this.stageCartasEnMesa);
        botonTruco.setOnAction(botonTrucoEventHandler);
        
        Button botonReTruco = new Button();
		botonReTruco.setText("Truco");
		BotonReTrucoEventHandler botonReTrucoEventHandler = new BotonReTrucoEventHandler(this.partida, this, this.stageJugadorConTurno, this.stageCartasEnMesa);
        botonReTruco.setOnAction(botonReTrucoEventHandler);
        
        Button botonValeCuatro = new Button();
		botonValeCuatro.setText("Truco");
		BotonValeCuatroEventHandler botonValeCuatroEventHandler = new BotonValeCuatroEventHandler(this.partida, this, this.stageJugadorConTurno, this.stageCartasEnMesa);
        botonValeCuatro.setOnAction(botonValeCuatroEventHandler);
		
		Button botonQuerer = new Button();
		botonQuerer.setText("Querer");
		BotonQuererEventHandler botonQuererEventHandler = new BotonQuererEventHandler(this.partida, this, this.stageJugadorConTurno, this.stageCartasEnMesa);
		botonQuerer.setOnAction(botonQuererEventHandler);

		Button botonNoQuerer = new Button();
		botonNoQuerer.setText("No Querer");
		BotonNoQuererEventHandler botonNoQuererEventHandler = new BotonNoQuererEventHandler(this.partida, etiqueta);
		botonNoQuerer.setOnAction(botonNoQuererEventHandler);

		Button botonIrseAlMazo = new Button();
		botonIrseAlMazo.setText("Irse al Mazo");
		BotonIrseAlMazoEventHandler botonIrseAlMazoEventHandler = new BotonIrseAlMazoEventHandler(this.partida, this, this.stageJugadorConTurno, this.stageCartasEnMesa);
		botonIrseAlMazo.setOnAction(botonIrseAlMazoEventHandler);
		
		

		//contenedores de los botones
		HBox contenedorCantos = new HBox(35,botonEnvido,botonRealEnvido,botonFaltaEnvido,botonTruco,botonReTruco,botonValeCuatro);
		HBox contenedorOpcion = new HBox(30,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		if (this.conFlor)
			contenedorOpcion.getChildren().addAll(botonFlor,botonFlorContraResto);

		VBox contenedorBotones = new VBox(contenedorOpcion,contenedorCantos, etiqueta);
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
		this.escena = new Group();
		
		this.escena.getChildren().add(imagen); //carga el fondo
		this.escena.getChildren().add(this.botonesDelJugador); //agregue botones sin las cartas
		this.escena.getChildren().add(nombre);
		this.escena.getChildren().add(agregarCartasDelJugador());
		
		Scene scene = new Scene(this.escena, 600, 320);
		return scene;
	}
	
	@SuppressWarnings("unchecked")
	public Group agregarCartasDelJugador(){
		Group root = new Group();
		double layoutX = 80;
		
		List<Carta> listaCartasJugador = this.partida.cartasDelJugadorConTurno();
		
		Iterator<Carta> itr = listaCartasJugador.iterator();
		while(itr.hasNext()) {
			Carta carta = (Carta) itr.next();
			
			Image imgCarta = new Image(this.imagenesCarta.obtenerDireccionDeCarta(carta.cartaComoString()));
			ImageView cartaComoImagen = new ImageView();
			cartaComoImagen.setImage(imgCarta);
			cartaComoImagen.setFitHeight(150);
			cartaComoImagen.setFitWidth(110);
			cartaComoImagen.setLayoutX(layoutX);
			cartaComoImagen.setLayoutY(120);
			cartaComoImagen.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEvent<MouseEvent>(this.partida, carta, this, this.stageJugadorConTurno, this.stageCartasEnMesa));
			
			layoutX += 150;
			
			root.getChildren().add(cartaComoImagen);
		}
		return root;
	}

	public Scene cargarSceneDeLaMesa() {
		//puntos de los equipos
		Label puntajeEquipo1 = new Label();
		String texto1 = this.partida.obtenerNombreDeEquipoUno()+": "+ this.partida.obtenerPuntajeDeEquipoUno()+ " PUNTOS";
		String texto2 = this.partida.obtenerNombreDeEquipoDos() +": "+ this.partida.obtenerPuntajeDeEquipoDos()+ " PUNTOS";
		puntajeEquipo1.setText(texto1);
		puntajeEquipo1.setTextFill(Color.web("#FF0000"));
		Label puntajeEquipo2 = new Label();
		puntajeEquipo2.setText(texto2);
		puntajeEquipo2.setTextFill(Color.web("#FFBB11"));
		
		VBox puntaje = new VBox(puntajeEquipo1,puntajeEquipo2);
		
		//imagen de fondo de la mesa
		String direccionImagen = "/fiuba/algo3/tp2/vista/imagenes/fondo.jpg";
		Image fondo = new Image(direccionImagen, 700, 800, false, true, true);
		ImageView imagen = new ImageView();
		imagen.setImage(fondo);
		
		//escenario de imagenes de la mesa 
		this.escena = new Group();
		
		this.escena.getChildren().add(imagen); //carga el fondo
		this.escena.getChildren().add(puntaje);
		this.escena.getChildren().add(agregarCartasEnJuego());
		
		Scene scene = new Scene(this.escena, 600, 320);
		return scene;
	}
	
	public Group agregarCartasEnJuego(){
		Group root = new Group();
		double layoutX = 80;
		double layoutY = 120;
		
		List<Carta> listaCartasJugador = this.partida.cartasEnJuego();
		
		Iterator<Carta> itr = listaCartasJugador.iterator();
		while(itr.hasNext()) {
			
			Carta carta = (Carta) itr.next();
			Image imgCarta = new Image(this.imagenesCarta.obtenerDireccionDeCarta(carta.cartaComoString()));
			ImageView cartaComoImagen = new ImageView();
			cartaComoImagen.setImage(imgCarta);
			cartaComoImagen.setFitHeight(150);
			cartaComoImagen.setFitWidth(110);
			cartaComoImagen.setLayoutX(layoutX);
			cartaComoImagen.setLayoutY(layoutY);
			
			layoutX += 50;
			
			root.getChildren().add(cartaComoImagen);
		}
		return root;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void jugarProximo (){
		if (this.cartasEnMano())	
			this.jugadorTurnoActual();
	}
	
	//crea la ventana del juego llamando al metodo agregarDosJugadores
	public Scene ventanaPrincipal(Stage stage){

		//parametros iniciales
		this.index =-1;
		this.listaJugadores= new ArrayList<ConjuntoCartas<ImageView>> ();
		this.imagenesCarta=new ImagenesCarta();
		this.cartasEnMesa= new ConjuntoCartas<ImageView>();

		//imagen de fondo de la mesa
		String direccionImagen= "/fiuba/algo3/tp2/vista/imagenes/fondo.jpg";
		Image fondo = new Image(direccionImagen, 700, 800, false, true, true);
		ImageView imagen = new ImageView();
		imagen.setImage(fondo);

		//etiqueta para mensajes
		Label etiqueta = new Label();
		Label puntajeEquipo1 = new Label();
		String texto1= this.partida.obtenerNombreDeEquipoUno()+": "+ this.partida.obtenerPuntajeDeEquipoUno()+ " PUNTOS";
		String texto2= this.partida.obtenerNombreDeEquipoDos() +": "+ this.partida.obtenerPuntajeDeEquipoDos()+ " PUNTOS";
		puntajeEquipo1.setText(texto1);
		puntajeEquipo1.setTextFill(Color.web("#FF0000"));
		puntajeEquipo1.setPrefSize(120, 10);
		Label puntajeEquipo2 = new Label();
		puntajeEquipo2.setText(texto2);
		puntajeEquipo2.setTextFill(Color.web("#FFBB11"));
		puntajeEquipo2.setPrefSize(120, 10);

		//botones de opciones para el jugador actual.
		Button botonEnvido = new Button();
		botonEnvido.setText("Envido");
		//BotonEnvidoEventHandler botonEnvidoEventHandler = new BotonEnvidoEventHandler(this.partida, etiqueta);
		//botonEnvido.setOnAction(botonEnvidoEventHandler);

		Button botonRealEnvido = new Button();
		botonRealEnvido.setText("Real Envido");
		BotonRealEnvidoEventHandler botonRealEnvidoEventHandler = new BotonRealEnvidoEventHandler(this.partida, etiqueta);
		botonRealEnvido.setOnAction(botonRealEnvidoEventHandler);

		Button botonFaltaEnvido = new Button();
		botonFaltaEnvido.setText("Falta Envido");
		BotonFaltaEnvidoEventHandler botonFaltaEnvidoEventHandler = new BotonFaltaEnvidoEventHandler(this.partida, etiqueta);
		botonFaltaEnvido.setOnAction(botonFaltaEnvidoEventHandler);

		Button botonFlor = new Button();
		botonFlor.setText("Flor");
		BotonFlorEventHandler botonFlorEventHandler = new BotonFlorEventHandler(this.partida, etiqueta);
		botonFlor.setOnAction(botonFlorEventHandler);

		Button botonFlorContraResto = new Button();
		botonFlorContraResto.setText("Flor X Resto");
		BotonFlorContraRestoEventHandler botonFlorContraRestoEventHandler = new BotonFlorContraRestoEventHandler(this.partida, etiqueta);
		botonFlorContraResto.setOnAction(botonFlorContraRestoEventHandler);

		Button botonTruco = new Button();
		botonTruco.setText("Truco");

		Button botonQuerer = new Button();
		botonQuerer.setText("Querer");
		//BotonQuererEventHandler botonQuererEventHandler = new BotonQuererEventHandler(this.partida, etiqueta);
		//botonQuerer.setOnAction(botonQuererEventHandler);

		Button botonNoQuerer = new Button();
		botonNoQuerer.setText("No Querer");
		BotonNoQuererEventHandler botonNoQuererEventHandler = new BotonNoQuererEventHandler(this.partida, etiqueta);
		botonNoQuerer.setOnAction(botonNoQuererEventHandler);

		Button botonIrseAlMazo = new Button();
		botonIrseAlMazo.setText("Irse al Mazo");
		//BotonIrseAlMazoEventHandler botonIrseAlMazoEventHandler = new BotonIrseAlMazoEventHandler(this, stage,this.partida, etiqueta);
		//botonIrseAlMazo.setOnAction(botonIrseAlMazoEventHandler);

		//contenedores de los botones

		HBox contenedorCantos = new HBox(40,botonEnvido,botonRealEnvido,botonFaltaEnvido,botonTruco);
		HBox contenedorOpcion = new HBox(30,botonQuerer,botonNoQuerer,botonIrseAlMazo,puntajeEquipo1,puntajeEquipo2);
		if (this.conFlor)
			contenedorCantos.getChildren().addAll(botonFlor,botonFlorContraResto);

		//contenedor principal
		VBox contenedorPrincipal = new VBox(contenedorOpcion,contenedorCantos, etiqueta);
		contenedorPrincipal.setSpacing(8);
		contenedorPrincipal.setPadding(new Insets(20));

		//Variable de posicionemiento de las cartas
		double layoutY=0;

		//escenario de imagenes de la mesa 
		this.escena = new Group();
		this.escena.getChildren().add(imagen); //carga el fondo
		//cantidad de jugadores que voy a poner en la mesa
		for (int i=0; i<this.cantidadDeJugadores/2 ; i++)
		{ 
			this.escena = agregarDosJugadores(this.escena, layoutY);
			layoutY+=200;
		}

		this.escena.getChildren().add(contenedorPrincipal); //agregue botones sin las cartas

		//dimensiones de la pantalla
		Scene scene = new Scene(this.escena, 600, 800);


		return scene;
	}

	// crea de a dos jugadores y en la scene ya existente
	public Group agregarDosJugadores (Group root, double layoutY){


		layoutY+= 80; 


		String direccionReverso= "/fiuba/algo3/tp2/vista/imagenes/reverso.jpg";
		Image reverso = new Image(direccionReverso);
		ImageView j1carta1 = new ImageView();
		j1carta1.setImage(reverso);
		j1carta1.setFitHeight(80);
		j1carta1.setFitWidth(50);
		j1carta1.setLayoutX(80);
		j1carta1.setLayoutY(layoutY);
		j1carta1.setRotate(90);

		ImageView j2carta1 = new ImageView();
		j2carta1.setImage(reverso);
		j2carta1.setFitHeight(80);
		j2carta1.setFitWidth(50);
		j2carta1.setLayoutX(480);
		j2carta1.setLayoutY(layoutY);
		j2carta1.setRotate(270);

		layoutY+=60;

		ImageView j1carta2 = new ImageView();
		j1carta2.setImage(reverso);
		j1carta2.setFitHeight(80);
		j1carta2.setFitWidth(50);
		j1carta2.setLayoutX(80);
		j1carta2.setLayoutY(layoutY);
		j1carta2.setRotate(90);

		ImageView j2carta2 = new ImageView();
		j2carta2.setImage(reverso);
		j2carta2.setFitHeight(80);
		j2carta2.setFitWidth(50);
		j2carta2.setLayoutX(480);
		j2carta2.setLayoutY(layoutY);
		j2carta2.setRotate(270);

		layoutY+=60;

		ImageView j1carta3 = new ImageView();
		j1carta3.setImage(reverso);
		j1carta3.setFitHeight(80);
		j1carta3.setFitWidth(50);
		j1carta3.setLayoutX(80);
		j1carta3.setLayoutY(layoutY);
		j1carta3.setRotate(90);

		ImageView j2carta3 = new ImageView();
		j2carta3.setImage(reverso);
		j2carta3.setFitHeight(80);
		j2carta3.setFitWidth(50);
		j2carta3.setLayoutX(480);
		j2carta3.setLayoutY(layoutY);
		j2carta3.setRotate(270);

		//lista de imagenes para darlas vuelta cuando sea el turno.
		ConjuntoCartas<ImageView> listaJug1 = new ConjuntoCartas<ImageView>();
		listaJug1.add(j1carta1);
		listaJug1.add(j1carta2);
		listaJug1.add(j1carta3);

		ConjuntoCartas<ImageView> listaJug2 = new ConjuntoCartas<ImageView>();
		listaJug2.add(j2carta1);
		listaJug2.add(j2carta2);
		listaJug2.add(j2carta3);

		this.listaJugadores.add(listaJug1);
		this.listaJugadores.add(listaJug2);


		root.getChildren().addAll(j1carta1,j1carta2,j1carta3,j2carta1,j2carta2,j2carta3);
		return root;
	}

	//METODO IMPORTANTE  SE LLAMA CADA VEZ Q COMIENZA EL TURNO DE UN JUGADOR
	@SuppressWarnings("unchecked")
	public void jugadorTurnoActual (){

		//calculos internos al visualizador
		this.siguienteJugador(); //avanza el index del jugador que toca
		System.out.println(this.index + " es el numero de la lista");
		double espacioAColocar = 200; // pone la carta sobre la izq
		if (index%2!=0)
			espacioAColocar = 300; // pone la carta sobre la derecha 

		// recopilo cartas del jugador en turno.
		ConjuntoCartas<ImageView> conjuntoCartas= this.listaJugadores.get(index); // agarro el conjunto de cartas de ese jugador
		List<Carta> cartas= this.partida.cartasDelJugadorConTurno();
		for (int i=0; i<cartas.size(); i++){
			Carta carta = cartas.get(i);  //agarro una carta
			String nombre= cartas.get(i).cartaComoString(); //pido su nombre
			System.out.println(nombre); // quitar
			String direccion = this.buscarImagen(nombre); // busco la imagen
			Image imagen = new Image(direccion); // creo la imagen
			ImageView view = this.listaJugadores.get(index).get(i);
			view.setImage(imagen);
			view.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>(this,this.partida,this.cartasEnMesa,conjuntoCartas,carta,view,espacioAColocar));
		}

	}

	public boolean cartasEnMano (){
		boolean noTermina = false;
		for (int i=0; i<this.cantidadDeJugadores;i++){
			if (this.listaJugadores.get(i).size()!=0)// si algun jugador tiene una carta.
				noTermina=true;
		}
		return noTermina;

	}

	private void siguienteJugador (){
		if(this.index < this.cantidadDeJugadores-1)
			this.index++;
		else
			this.index=0;
		System.out.println(this.index+ " numero de index");
	}

	public void resetearEscena (){

	}


	public String buscarImagen (String nombre){
		return this.imagenesCarta.obtenerDireccionDeCarta(nombre);
	}

	public void cargarCantidadJugadores (int cantidad){
		this.cantidadDeJugadores= cantidad;
	}

	public void jugarConFlor (boolean jugarConFlor){
		this.conFlor = jugarConFlor;
	}

	public String pedirNombre (){
		//hacer pantalla Textlabel
		String nombre = "";
		return nombre;
	}

	public Label crearJugadores (){
		TextField jugadorText = new TextField();
		jugadorText.setPromptText("Nombre del Jugador");
		Label etiquetaNombre = new Label();

		etiquetaNombre.setText("");
		if (jugadorText.getText().equals("")) {
			etiquetaNombre.setText("Debe ingresar un usuario");
			etiquetaNombre.setTextFill(Color.web("#FF0000"));
			jugadorText.requestFocus();
		}
		etiquetaNombre.setText(jugadorText.getText());
		return etiquetaNombre;
	}
}


