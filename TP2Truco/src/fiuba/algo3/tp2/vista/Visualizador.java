package fiuba.algo3.tp2.vista;


import java.util.List;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.ConFlor;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.EstadoFlor;
import fiuba.algo3.tp2.modelo.Mesa;
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
import javafx.stage.Stage;

public class Visualizador extends Application  {
	
        private Jugador jugadorE1;
        private Jugador jugadorE2;
        private ImagenesCarta imagenesCarta;
        private Mesa mesa;
        ListaCircular<ImageView> jugadores;
        private int cantidadDeJugadores;
        private boolean conFlor;
        
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
	        Scene scene= this.ventanaPrincipal();
	        stage.setTitle("Partida de Truco");
	        stage.setScene(scene);
	        stage.show();
	        
	    }
	    
	    private Scene obtenerOpcionesDeJuego(Stage stage) {
	    	//VLablesCantJugadores
	        VBox labelCantJugadores = new VBox();
	        labelCantJugadores.setSpacing(10);
	        labelCantJugadores.setPadding(new Insets(10));
	    	
	    	//VBOXJugadores
	    	VBox checkCantidadJugadores = new VBox();
	        checkCantidadJugadores.setSpacing(10);
	        checkCantidadJugadores.setPadding(new Insets(10));
	    	
	        //VBOXFlor
	    	VBox checkFlor = new VBox();
	    	checkFlor.setSpacing(10);
	    	checkFlor.setPadding(new Insets(10));
	    	
	        //VLablesFlor
	        VBox labelFlor = new VBox();
	        labelFlor.setSpacing(10);
	        labelFlor.setPadding(new Insets(10));
	       
		    //CHECHBOX
	        CheckBox checkBox2jugadores = new CheckBox("2 Jugadores");
	    	CheckBox checkBox4jugadores = new CheckBox("4 Jugadores");
	    	CheckBox checkBox6jugadores = new CheckBox("6 Jugadores");
	    	CheckBox checkBoxFlor = new CheckBox("Jugar con Flor");
	    	
	    	//LABELS
	    	Label lbCantJugadores = new Label(" 1 - Seleccione la cantidad de jugadores");
	    	Label lbFlor = new Label(" 2 - ¿Jugar con Flor?");
	    	
	    	//AGREGAR check y labels a VBoxs
	        checkCantidadJugadores.getChildren().addAll(checkBox2jugadores, checkBox4jugadores, checkBox6jugadores);
	        labelCantJugadores.getChildren().add(lbCantJugadores);
	        checkFlor.getChildren().add(checkBoxFlor);
	        labelFlor.getChildren().add(lbFlor);
	        
	        //BOTON Jugar
	    	Button botonJugar = new Button();
	    	botonJugar.setText("Jugar");
	    	HBox contenedorBotonJugar = new HBox(50,botonJugar);
	    	VBox boxJugar = new VBox(contenedorBotonJugar);
	    	boxJugar.setSpacing(0);
	    	boxJugar.setPadding(new Insets(50));
	    	
	    	//SCENE
	    	FlowPane root = new FlowPane();
	        root.setHgap(20);
	        root.getChildren().addAll(labelCantJugadores, checkCantidadJugadores);
	        root.getChildren().addAll(labelFlor, checkFlor);    
	        root.getChildren().add(boxJugar);
	        Scene scene = new Scene(root, 340, 350);
	        
	        //HANDLERS
	    	checkBox2jugadores.addEventHandler(MouseEvent.MOUSE_CLICKED, new CheckCantidadJugadores<MouseEvent>(2,this,checkBox4jugadores,checkBox6jugadores));
	    	checkBox4jugadores.addEventHandler(MouseEvent.MOUSE_CLICKED, new CheckCantidadJugadores<MouseEvent>(4,this,checkBox2jugadores,checkBox6jugadores));
	     	checkBox6jugadores.addEventHandler(MouseEvent.MOUSE_CLICKED, new CheckCantidadJugadores<MouseEvent>(6,this,checkBox2jugadores,checkBox4jugadores));
	     	checkBoxFlor.addEventHandler(MouseEvent.MOUSE_CLICKED, new CheckJugarConFlor<MouseEvent>(this));
	    	botonJugar.addEventHandler(MouseEvent.MOUSE_CLICKED, new BotonEmpezarJuegoEventHandler<MouseEvent>(this,stage));
	        
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
		    EstadoFlor estado = new ConFlor();
			this.mesa = new Mesa();
			Equipo equipo1= new Equipo("equipoUno",mesa);
			Equipo equipo2=new Equipo("equipoDos",mesa);
			equipo1.cargarJugadores("pablo");
			equipo2.cargarJugadores("nico");
			mesa.sentarJugadores(equipo1.obtenerJugadores(), equipo2.obtenerJugadores());
			mesa.instanciarJuez(equipo1, equipo2,estado);
			mesa.iniciarRonda();
			
			this.jugadores = new ListaCircular<ImageView>();
			this.imagenesCarta=new ImagenesCarta();
			
			
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
	        BotonEnvidoEventHandler botonEnvidoEventHandler = new BotonEnvidoEventHandler(this.jugadorE1, etiqueta);
	        botonEnvido.setOnAction(botonEnvidoEventHandler);
            
	        Button botonRealEnvido = new Button();
	        botonRealEnvido.setText("Real Envido");
	        
	        Button botonFaltaEnvido = new Button();
	        botonFaltaEnvido.setText("Falta Envido");
	        
	        Button botonTruco = new Button();
	        botonTruco.setText("Truco");
	        
	        Button botonQuerer = new Button();
	        botonQuerer.setText("Querer");
	        
	        Button botonNoQuerer = new Button();
	        botonNoQuerer.setText("No Querer");
	        
	        Button botonIrseAlMazo = new Button();
	        botonIrseAlMazo.setText("Irse al Mazo");
	        
            //contenedores de los botones
	        HBox contenedorCantos = new HBox(50,botonEnvido,botonRealEnvido,botonFaltaEnvido,botonTruco);
	        HBox contenedorOpcion = new HBox(30,botonQuerer,botonNoQuerer,botonIrseAlMazo,puntajeEquipo1,puntajeEquipo2);
	        
	        
	        //contenedor principal
	        VBox contenedorPrincipal = new VBox(contenedorOpcion,contenedorCantos, etiqueta);
	        contenedorPrincipal.setSpacing(8);
	        contenedorPrincipal.setPadding(new Insets(20));
	        
	        //Variable de posicionemiento de las cartas
	        double layoutY=0;
	        
	        //escenario de imagenes de la mesa 
	        Group root = new Group();
	        root.getChildren().add(imagen); //carga el fondo
	        System.out.println(this.cantidadDeJugadores);
	        for (int i=0; i<this.cantidadDeJugadores/2 ; i++)
	        { 
	            root = agregarDosJugadores(root, layoutY);
	            layoutY+=200;
		    }
	        
            root.getChildren().add(contenedorPrincipal);
            this.jugadorTurnoActual(root, mesa); //quitar esto
            
            //dimensiones de la pantalla
	        Scene scene = new Scene(root, 600, 800);
	        
	        return scene;
	    }
	    	
		public Group agregarDosJugadores (Group root, double layoutY){
			
			layoutY+= 80; 
			double layoutXIzq= 80;
			double layoutXDer= 480;
			
			String direccionReverso= "/fiuba/algo3/tp2/vista/imagenes/reverso.jpg";
			 Image reverso = new Image(direccionReverso);
	            ImageView j1carta1 = new ImageView();
	            j1carta1.setImage(reverso);
	            j1carta1.setFitHeight(80);
	            j1carta1.setFitWidth(50);
	            j1carta1.setLayoutX(layoutXIzq);
	            j1carta1.setLayoutY(layoutY);
	            j1carta1.setRotate(270);

	            ImageView j2carta1 = new ImageView();
	            j2carta1.setImage(reverso);
	            j2carta1.setFitHeight(80);
	            j2carta1.setFitWidth(50);
	            j2carta1.setLayoutX(layoutXDer);
	            j2carta1.setLayoutY(layoutY);
	            j2carta1.setRotate(90);
	           // Carta carta = jugador.obtenerCartasDelJugador().obtenerCartas().get(0);
	           // j2carta1.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>(mesa,jugador,carta,layoutXDer-100,j2carta1));
	          
	            layoutY+=60;
	            
	            ImageView j1carta2 = new ImageView();
	            j1carta2.setImage(reverso);
	            j1carta2.setFitHeight(80);
	            j1carta2.setFitWidth(50);
	            j1carta2.setLayoutX(layoutXIzq);
	            j1carta2.setLayoutY(layoutY);
	            j1carta2.setRotate(270);
	            //j1carta2.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>());
	            
	            ImageView j2carta2 = new ImageView();
	            j2carta2.setImage(reverso);
	            j2carta2.setFitHeight(80);
	            j2carta2.setFitWidth(50);
	            j2carta2.setLayoutX(layoutXDer);
	            j2carta2.setLayoutY(layoutY);
	            j2carta2.setRotate(90);
	            //j2carta2.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>());
	            
	            layoutY+=60;
	            
	            ImageView j1carta3 = new ImageView();
	            j1carta3.setImage(reverso);
	            j1carta3.setFitHeight(80);
	            j1carta3.setFitWidth(50);
	            j1carta3.setLayoutX(layoutXIzq);
	            j1carta3.setLayoutY(layoutY);
	            j1carta3.setRotate(270);
	            //j1carta3.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>());
	           
	            ImageView j2carta3 = new ImageView();
	            j2carta3.setImage(reverso);
	            j2carta3.setFitHeight(80);
	            j2carta3.setFitWidth(50);
	            j2carta3.setLayoutX(layoutXDer);
	            j2carta3.setLayoutY(layoutY);
	            j2carta3.setRotate(90);
	           // j2carta3.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>());
	            
	            //lista de imagenes para darlas vuelta cuando sea el turno.
			    this.jugadores.add(j1carta1);
			    this.jugadores.add(j1carta2);
			    this.jugadores.add(j1carta3);
			    this.jugadores.add(j2carta1);
			    this.jugadores.add(j2carta2);
			    this.jugadores.add(j2carta3);
			    
	            root.getChildren().addAll(j1carta1,j1carta2,j1carta3,j2carta1,j2carta2,j2carta3);
            return root;
		}

		public Group jugadorTurnoActual (Group root,Mesa mesa){
		      
			  Jugador jugadorActual = mesa.siguienteJugadorConTurno();
			  List<Carta> cartas= jugadorActual.obtenerCartasDelJugador().obtenerCartas();
			  for (int i=0; i<jugadorActual.cantidadDeCartas(); i++){
				  String nombre= cartas.get(i).cartaComoString();
				  String direccion = this.buscarImagen(nombre);
				  Image imagen = new Image(direccion);
				  ImageView view = this.jugadores.get(i);
			      view.setImage(imagen);
			  }
			 
			return root;
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
}
		
		
	