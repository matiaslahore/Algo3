package fiuba.algo3.tp2.vista;


import fiuba.algo3.tp2.controlador.Administrador;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mano;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
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
	
        private Administrador administrador;
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
	    	
	    	
	    	
	    	
	
	    	String direccionImagen= "/fiuba/algo3/tp2/vista/imagenes/fondo.jpg";
	    	
	        String direccionCarta1= "/fiuba/algo3/tp2/vista/imagenes/b1.jpg"; 
	        String direccionCarta2= "/fiuba/algo3/tp2/vista/imagenes/e1.jpg";
	    	String direccionCarta3= "/fiuba/algo3/tp2/vista/imagenes/e7.jpg";
	        
	    	Image fondo = new Image(direccionImagen, 700, 800, false, true, true);
	        ImageView imagen = new ImageView();
		    imagen.setImage(fondo);
		    
		    
		    
		   
            
	        Button botonEnvido = new Button();
	        botonEnvido.setText("Envido");

	        Button botonTruco = new Button();
	        botonTruco.setText("Truco");
	        
	        Button botonQuerer = new Button();
	        botonQuerer.setText("Querer");
	        
	        Button botonNoQuerer = new Button();
	        botonNoQuerer.setText("No Querer");
	        
	        Button botonIrseAlMazo = new Button();
	        botonIrseAlMazo.setText("Irse al Mazo");
	        

	        HBox contenedorCantos = new HBox(50,botonEnvido,botonTruco);
	        HBox contenedorOpcion = new HBox(30,botonQuerer,botonNoQuerer,botonIrseAlMazo);
	        
	        Label etiqueta = new Label();
	        
	        VBox contenedorPrincipal = new VBox(contenedorCantos,contenedorOpcion, etiqueta);
	        contenedorPrincipal.setSpacing(8);
	        contenedorPrincipal.setPadding(new Insets(20));
	        
	        double layoutY=0;
	        
	        Group root = new Group();
	        root.getChildren().add(imagen); //carga el fondo
	        root = agregarDosJugadores(root, layoutY);
	        root = agregarDosJugadores(root, layoutY+200);
	        root = agregarDosJugadores(root, layoutY+400);
            root.getChildren().add(contenedorPrincipal);
             
	        
	        Scene scene = new Scene(root, 600, 800);
	        

	        BotonEnvidoEventHandler botonEnvidoEventHandler = new BotonEnvidoEventHandler(this.jugador, etiqueta);
	        botonEnvido.setOnAction(botonEnvidoEventHandler);
	        
            
	        
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


