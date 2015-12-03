package fiuba.algo3.tp2.vista;


import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.EstadoConFlor;
import fiuba.algo3.tp2.modelo.EstadoFlor;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoSinFlor;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import javafx.application.Application;
import javafx.geometry.Insets;
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
	
        private Jugador jugador;
        private double layoutXDer;
        private double layoutXIzq;
        private int index;
        private ImagenesCarta imagenesCarta;
        private Mesa mesa;
        private int cantidadDeJugadores;
        private boolean conFlor;
        private Group escena;
        private ArrayList<ConjuntoCartas<ImageView>> listaJugadores; 
        private PartidaDeTruco partida;
        
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
	    
	    public void iniciarVentanaDelJuego(Stage stage){
	    	//creacion de la partida
	    	if (this.conFlor)
	    	   this.partida= new PartidaDeTrucoConFlor("Equipo UNO", "Equipo DOS");
	    	this.partida= new PartidaDeTrucoSinFlor("Equipo UNO", "Equipo DOS");
	    	this.partida.cargarJugadoresEnEquipoUno("Pablo");
	    	this.partida.cargarJugadoresEnEquipoDos("Nico");
	    	
	        Scene scene= this.ventanaPrincipal();
	        stage.setTitle("Partida de Truco");
	        stage.setScene(scene);
	        stage.show();
	        
	    }
	    
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
	
		public Scene ventanaPrincipal(){
	    	
		    //PRUEBAS DE PARAMETROS
		    EstadoFlor estado = new EstadoConFlor();
			this.mesa = new Mesa();
			Equipo equipo1= new Equipo("equipoUno",mesa);
			Equipo equipo2=new Equipo("equipoDos",mesa);
			for (int i=0; i<this.cantidadDeJugadores/2;i++){
			   equipo1.cargarJugadores("pablo");
			   equipo2.cargarJugadores("nico");
			}
			mesa.sentarJugadores(equipo1.obtenerJugadores(), equipo2.obtenerJugadores());
			mesa.instanciarJuez(equipo1, equipo2,estado);
			mesa.iniciarRonda();
			
			this.index =-1;
			this.listaJugadores= new ArrayList<ConjuntoCartas<ImageView>> ();
			this.imagenesCarta=new ImagenesCarta();
			this.layoutXIzq= 80;
			this.layoutXDer= 480;
			
			//imagen de fondo de la mesa
	    	String direccionImagen= "/fiuba/algo3/tp2/vista/imagenes/fondo.jpg";
	    	Image fondo = new Image(direccionImagen, 700, 800, false, true, true);
	        ImageView imagen = new ImageView();
		    imagen.setImage(fondo);
		    
		    //etiqueta para mensajes
	        Label etiqueta = new Label();
	        Label puntajeEquipo1 = new Label();
	        String texto1=  equipo1.obtenerNombre()+": "+ mesa.puntosEquipo(equipo1)+ " PUNTOS";
	        String texto2=  equipo2.obtenerNombre()+": "+ mesa.puntosEquipo(equipo2)+ " PUNTOS";
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
	        BotonEnvidoEventHandler botonEnvidoEventHandler = new BotonEnvidoEventHandler(this.jugador, etiqueta);
	        botonEnvido.setOnAction(botonEnvidoEventHandler);
            
	        Button botonRealEnvido = new Button();
	        botonRealEnvido.setText("Real Envido");
	        
	        Button botonFaltaEnvido = new Button();
	        botonFaltaEnvido.setText("Falta Envido");
	        
	        Button botonFlor = new Button();
	        botonFlor.setText("Flor");
	        
	        Button botonFlorContraResto = new Button();
	        botonFlorContraResto.setText("Flor X Resto");
	        
	        Button botonTruco = new Button();
	        botonTruco.setText("Truco");
	        
	        Button botonQuerer = new Button();
	        botonQuerer.setText("Querer");
	        
	        Button botonNoQuerer = new Button();
	        botonNoQuerer.setText("No Querer");
	        
	        Button botonIrseAlMazo = new Button();
	        botonIrseAlMazo.setText("Irse al Mazo");
	        
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
	        System.out.println(this.cantidadDeJugadores + " es la cantidad e jugadores");//PRUEBA
	        for (int i=0; i<this.cantidadDeJugadores/2 ; i++)
	        { 
	            this.escena = agregarDosJugadores(this.escena, layoutY);
	            layoutY+=200;
		    }
	        
            this.escena.getChildren().add(contenedorPrincipal); //agregue botones sin las cartas
            this.jugadorTurnoActual(mesa); //quitar esto  // agrega las cartas
            
            //dimensiones de la pantalla
	        Scene scene = new Scene(this.escena, 600, 800);
	        
	        return scene;
	    }
	    	
		public Group agregarDosJugadores (Group root, double layoutY){
			
			
			layoutY+= 80; 
			
			
			String direccionReverso= "/fiuba/algo3/tp2/vista/imagenes/reverso.jpg";
			 Image reverso = new Image(direccionReverso);
	            ImageView j1carta1 = new ImageView();
	            j1carta1.setImage(reverso);
	            j1carta1.setFitHeight(80);
	            j1carta1.setFitWidth(50);
	            j1carta1.setLayoutX(layoutXIzq);
	            j1carta1.setLayoutY(layoutY);
	            j1carta1.setRotate(90);

	            ImageView j2carta1 = new ImageView();
	            j2carta1.setImage(reverso);
	            j2carta1.setFitHeight(80);
	            j2carta1.setFitWidth(50);
	            j2carta1.setLayoutX(layoutXDer);
	            j2carta1.setLayoutY(layoutY);
	            j2carta1.setRotate(270);
	          
	            layoutY+=60;
	            
	            ImageView j1carta2 = new ImageView();
	            j1carta2.setImage(reverso);
	            j1carta2.setFitHeight(80);
	            j1carta2.setFitWidth(50);
	            j1carta2.setLayoutX(layoutXIzq);
	            j1carta2.setLayoutY(layoutY);
	            j1carta2.setRotate(90);
	            
	            ImageView j2carta2 = new ImageView();
	            j2carta2.setImage(reverso);
	            j2carta2.setFitHeight(80);
	            j2carta2.setFitWidth(50);
	            j2carta2.setLayoutX(layoutXDer);
	            j2carta2.setLayoutY(layoutY);
	            j2carta2.setRotate(270);
	            
	            layoutY+=60;
	            
	            ImageView j1carta3 = new ImageView();
	            j1carta3.setImage(reverso);
	            j1carta3.setFitHeight(80);
	            j1carta3.setFitWidth(50);
	            j1carta3.setLayoutX(layoutXIzq);
	            j1carta3.setLayoutY(layoutY);
	            j1carta3.setRotate(90);
	           
	            ImageView j2carta3 = new ImageView();
	            j2carta3.setImage(reverso);
	            j2carta3.setFitHeight(80);
	            j2carta3.setFitWidth(50);
	            j2carta3.setLayoutX(layoutXDer);
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

		public void jugadorTurnoActual (Mesa mesa){
		      double espacioAColocar = 200;
		      this.index+=1;
			  Jugador jugadorActual = mesa.siguienteJugadorConTurno();
			  List<Carta> cartas= jugadorActual.obtenerCartasDelJugador().obtenerCartas();
			  System.out.println(jugadorActual.cantidadDeCartas()+"es la cantidad de cartas");
			  for (int i=0; i<jugadorActual.cantidadDeCartas(); i++){
				  Carta carta = cartas.get(i);
				  String nombre= cartas.get(i).cartaComoString();
				  String direccion = this.buscarImagen(nombre);
				  Image imagen = new Image(direccion);
				  ImageView view = this.listaJugadores.get(index).get(i);
			      view.setImage(imagen);
			      view.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>(this.partida,jugador,carta,view,espacioAColocar));
			  }
			 
		}
		
		public void resetearEscena (){
			
		}
		
		public void tirarCarta (ImageView carta, double posicion){
			
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
}
		
		
	