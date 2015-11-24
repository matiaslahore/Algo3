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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Visualizador extends Application  {
	
        private Jugador jugador;
        private Mesa mesa;
        
	
	    @Override
	    public void start(Stage stage) throws Exception {
	        
	    	Scene scene= this.ventanaPrincipal();
	        stage.setTitle("Cuenta de Correos ALGOMAIL");
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
	    	

	        Button botonEnvido = new Button();
	        botonEnvido.setText("Envido");

	        Button botonTruco = new Button();
	        botonTruco.setText("Truco");
	        
	        Button botonQuerer = new Button();
	        botonQuerer.setText("Querer");
	        
	        Button botonNoQuerer = new Button();
	        botonNoQuerer.setText("No Querer");
	        
	        Button botonCarta1 = new Button();
	        botonCarta1.setText("Carta 1");
	        Button botonCarta2 = new Button();
	        botonCarta2.setText("Carta 2");
	        Button botonCarta3 = new Button();
	        botonCarta3.setText("Carta 3");
	        

	        HBox contenedorCartas = new HBox(botonCarta1,botonCarta2,botonCarta3);
	        HBox contenedorCantos = new HBox(botonEnvido,botonTruco);
	        HBox contenedorOpcion = new HBox(botonQuerer,botonNoQuerer);

	        VBox contenedorPrincipal = new VBox(contenedorCartas,contenedorCantos,contenedorOpcion);
	        contenedorPrincipal.setSpacing(8);
	        contenedorPrincipal.setPadding(new Insets(20));

	        BotonEnvidoEventHandler botonEnvidoEventHandler = new BotonEnvidoEventHandler(this.jugador);
	        botonEnvido.setOnAction(botonEnvidoEventHandler);
	        
             
	        
	        Scene scene = new Scene(contenedorPrincipal, 700, 600);
	        
	        return scene;
	    	
	    }

}

