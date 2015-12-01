package fiuba.algo3.tp2.vista;


import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mano;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Humano;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Visualizador extends Application  {
	
        private Jugador jugador;
        private ImagenesCarta imagenesCarta;
        
        public static void main(String[] args)
    	{
        	 launch(args);
    	}
        
	
	    @Override
	    public void start(Stage stage) throws Exception {
	        
	    	Scene scene= this.ventanaPrincipal();
	        stage.setTitle("Partida de Truco");
	        stage.setScene(scene);
	        stage.show();
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
		
			Mesa mesa = new Mesa();
			Equipo equipo1= new Equipo("equipoUno",mesa);
			Equipo equipo2=new Equipo("equipoDos",mesa);
			equipo1.cargarJugadores("pablo");
			equipo2.cargarJugadores("nico");
			mesa.sentarJugadores(equipo1.obtenerJugadores(), equipo2.obtenerJugadores());
			mesa.instanciarJuez(equipo1, equipo2);
			
			//imagen de fondo de la mesa
	    	String direccionImagen= "/fiuba/algo3/tp2/vista/imagenes/fondo.jpg";
	    	Image fondo = new Image(direccionImagen, 700, 800, false, true, true);
	        ImageView imagen = new ImageView();
		    imagen.setImage(fondo);
		    
		    //estiqueta para mensajes
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

	        Button botonTruco = new Button();
	        botonTruco.setText("Truco");
	        
	        Button botonQuerer = new Button();
	        botonQuerer.setText("Querer");
	        
	        Button botonNoQuerer = new Button();
	        botonNoQuerer.setText("No Querer");
	        
	        Button botonIrseAlMazo = new Button();
	        botonIrseAlMazo.setText("Irse al Mazo");
	        
            //contenedores de los botones
	        HBox contenedorCantos = new HBox(50,botonEnvido,botonTruco,puntajeEquipo1,puntajeEquipo2);
	        HBox contenedorOpcion = new HBox(30,botonQuerer,botonNoQuerer,botonIrseAlMazo);
	        
	        
	        //contenedor principal
	        VBox contenedorPrincipal = new VBox(contenedorCantos,contenedorOpcion, etiqueta);
	        contenedorPrincipal.setSpacing(8);
	        contenedorPrincipal.setPadding(new Insets(20));
	        
	        //Variable de posicionemiento de las cartas
	        double layoutY=0;
	        
	        //escenario de imagenes de la mesa 
	        Group root = new Group();
	        root.getChildren().add(imagen); //carga el fondo
	        for (int i=0; i<mesa.cantidadDeJugadores()/2 ; i++)
	        { 
	            root = agregarDosJugadores(root, layoutY);
	            layoutY+=200;
		    }
            root.getChildren().add(contenedorPrincipal);
            
            //dimensiones de la pantalla
	        Scene scene = new Scene(root, 600, 800);
	        
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
	            j1carta1.setLayoutX(80);
	            j1carta1.setLayoutY(layoutY);
	            j1carta1.setRotate(270);
	            j1carta1.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>());

	            ImageView j2carta1 = new ImageView();
	            j2carta1.setImage(reverso);
	            j2carta1.setFitHeight(80);
	            j2carta1.setFitWidth(50);
	            j2carta1.setLayoutX(480);
	            j2carta1.setLayoutY(layoutY);
	            j2carta1.setRotate(90);
	            j2carta1.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>());
	          
	            layoutY+=60;
	            
	            ImageView j1carta2 = new ImageView();
	            j1carta2.setImage(reverso);
	            j1carta2.setFitHeight(80);
	            j1carta2.setFitWidth(50);
	            j1carta2.setLayoutX(80);
	            j1carta2.setLayoutY(layoutY);
	            j1carta2.setRotate(270);
	            j1carta2.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>());
	            
	            ImageView j2carta2 = new ImageView();
	            j2carta2.setImage(reverso);
	            j2carta2.setFitHeight(80);
	            j2carta2.setFitWidth(50);
	            j2carta2.setLayoutX(480);
	            j2carta2.setLayoutY(layoutY);
	            j2carta2.setRotate(90);
	            j2carta2.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>());
	            
	            layoutY+=60;
	            
	            ImageView j1carta3 = new ImageView();
	            j1carta3.setImage(reverso);
	            j1carta3.setFitHeight(80);
	            j1carta3.setFitWidth(50);
	            j1carta3.setLayoutX(80);
	            j1carta3.setLayoutY(layoutY);
	            j1carta3.setRotate(270);
	            j1carta3.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>());
	           
	            ImageView j2carta3 = new ImageView();
	            j2carta3.setImage(reverso);
	            j2carta3.setFitHeight(80);
	            j2carta3.setFitWidth(50);
	            j2carta3.setLayoutX(480);
	            j2carta3.setLayoutY(layoutY);
	            j2carta3.setRotate(90);
	            j2carta3.addEventHandler(MouseEvent.MOUSE_CLICKED, new TirarCartaEventHandler<MouseEvent>());
			    
	            root.getChildren().addAll(j1carta1,j1carta2,j1carta3,j2carta1,j2carta2,j2carta3);
            return root;
		}
		
	
}


