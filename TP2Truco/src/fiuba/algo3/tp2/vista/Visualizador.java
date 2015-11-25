package fiuba.algo3.tp2.vista;


import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Visualizador extends Application  {
	
        private Jugador jugador;
        private Mesa mesa;
        
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
	    	
	    	this.mesa= new Mesa("equipo1","equipo2");
	    	this.jugador= new Jugador("pablo",this.mesa);
	    	
	    	
	    		
	    	String direccionImagen = "file:/home/pablo/workspace/TP2Truco/src/fiuba/algo3/colecciones/images.jpeg";
	        String direccionCarta1= "file:/home/pablo/workspace/TP2Truco/src/fiuba/algo3/colecciones/b1.jpg"; 
	        String direccionCarta2= "file:/home/pablo/workspace/TP2Truco/src/fiuba/algo3/colecciones/e1.jpg";
	    	String direccionCarta3= "file:/home/pablo/workspace/TP2Truco/src/fiuba/algo3/colecciones/e7.jpg";
	        
	    	Image fondo = new Image(direccionImagen, 700, 800, false, true, true);
	        ImageView imagen = new ImageView();
		    imagen.setImage(fondo);
		    
		    Image unoBasto = new Image(direccionCarta1);
            ImageView carta1 = new ImageView();
            carta1.setImage(unoBasto);
            carta1.setLayoutX(160);
            carta1.setLayoutY(400);
            
            Image unoEspada = new Image(direccionCarta2);
            ImageView carta2 = new ImageView();
            carta2.setImage(unoEspada);
            carta2.setLayoutX(250);
            carta2.setLayoutY(400);
            
            Image sieteEspada = new Image(direccionCarta3);
            ImageView carta3 = new ImageView();
            carta3.setImage(sieteEspada);
            carta3.setLayoutX(340);
            carta3.setLayoutY(400);
            
           
            
            
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
	        
	        Button botonCarta1 = new Button();
	        botonCarta1.setText("Carta 1");
	        Button botonCarta2 = new Button();
	        botonCarta2.setText("Carta 2");
	        Button botonCarta3 = new Button();
	        botonCarta3.setText("Carta 3");
	        

	        HBox contenedorCartas = new HBox(10, botonCarta1,botonCarta2,botonCarta3);
	        HBox contenedorCantos = new HBox(50,botonEnvido,botonTruco);
	        HBox contenedorOpcion = new HBox(30,botonQuerer,botonNoQuerer,botonIrseAlMazo);
	        

	        VBox contenedorPrincipal = new VBox(contenedorCartas,contenedorCantos,contenedorOpcion);
	        contenedorPrincipal.setSpacing(8);
	        contenedorPrincipal.setPadding(new Insets(20));

	        BotonEnvidoEventHandler botonEnvidoEventHandler = new BotonEnvidoEventHandler(this.jugador);
	        botonEnvido.setOnAction(botonEnvidoEventHandler);
	        
            Group root = new Group();
            root.getChildren().add(imagen);
            root.getChildren().addAll(carta1,carta2,carta3);
            root.getChildren().add(contenedorPrincipal);
             
	        
	        Scene scene = new Scene(root, 600, 800);
	        
	        return scene;
	    }
	    	
}


