package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.OyenteDePartida;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonContraFlorEventHandler;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonEnvidoEventHandler;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonFaltaEnvidoEventHandler;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonFlorContraRestoEventHandler;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonFlorEventHandler;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonIrseAlMazoEventHandler;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonNoQuererEventHandler;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonQuererEventHandler;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonReTrucoEventHandler;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonRealEnvidoEventHandler;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonTrucoEventHandler;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.BotonValeCuatroEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorDeBotones implements OyenteDePartida {
	
	private boolean conFlor;
	private Stage stage;
	PartidaDeTruco partida;
	private Label etiqueta;
	VentanasDelJuego ventanaDelJuego;
	
	public ControladorDeBotones(PartidaDeTruco partida, boolean conFlor,VentanasDelJuego ventana){
		partida.agregarOyentesALaPartida(this);
		this.partida = partida;
		this.conFlor = conFlor;
		this.ventanaDelJuego = ventana;
	}

	@Override
	public void seCantoTruco() {
		System.out.println("se Canto Truco");
	}

	@Override
	public void seQuiso() {
		System.out.println("se Quiso ");
	}

	@Override
	public void noSeQuiso() {
		System.out.println("No se Quiso ");
	}

	@Override
	public void seCantoFlor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoContraFlorAJuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoContraFlor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoFaltaEnvido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoEnvido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoValeCuatro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoReTruco() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void seCantoEnvidoEnvido() {
		//Aca vas a crear una neuva visual con todos los botones menos el de envido
	}

	@Override
	public void seCantoRealEnvido() {
		//lo mismo pero aca vas a crear todos menos los de envido y real envido
	}
	
	public VBox botonesDelJugador() {
		//etiqueta para mensajes
		this.etiqueta = new Label();

		//botones de opciones para el jugador actual.
		Button botonEnvido = new Button("Envido");
		BotonEnvidoEventHandler botonEnvidoEventHandler = new BotonEnvidoEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
		botonEnvido.setOnAction(botonEnvidoEventHandler);

		Button botonRealEnvido = new Button("Real Envido");
		BotonRealEnvidoEventHandler botonRealEnvidoEventHandler = new BotonRealEnvidoEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
		botonRealEnvido.setOnAction(botonRealEnvidoEventHandler);

		Button botonFaltaEnvido = new Button("Falta Envido");
		BotonFaltaEnvidoEventHandler botonFaltaEnvidoEventHandler = new BotonFaltaEnvidoEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
		botonFaltaEnvido.setOnAction(botonFaltaEnvidoEventHandler);

		Button botonFlor = new Button("Flor");
		BotonFlorEventHandler botonFlorEventHandler = new BotonFlorEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
		botonFlor.setOnAction(botonFlorEventHandler);

		Button botonContraFlor = new Button("Contra Flor");
		BotonContraFlorEventHandler botonContraFlorEventHandler = new BotonContraFlorEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
		botonContraFlor.setOnAction(botonContraFlorEventHandler);

		Button botonFlorContraResto = new Button("Flor X Resto");
		BotonFlorContraRestoEventHandler botonFlorContraRestoEventHandler = new BotonFlorContraRestoEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
		botonFlorContraResto.setOnAction(botonFlorContraRestoEventHandler);

		Button botonTruco = new Button("Truco");
		BotonTrucoEventHandler botonTrucoEventHandler = new BotonTrucoEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
		botonTruco.setOnAction(botonTrucoEventHandler);

		Button botonReTruco = new Button("ReTruco");
		BotonReTrucoEventHandler botonReTrucoEventHandler = new BotonReTrucoEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
		botonReTruco.setOnAction(botonReTrucoEventHandler);

		Button botonValeCuatro = new Button("ValeCuatro");
		BotonValeCuatroEventHandler botonValeCuatroEventHandler = new BotonValeCuatroEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
		botonValeCuatro.setOnAction(botonValeCuatroEventHandler);

		Button botonQuerer = new Button("Querer");
		BotonQuererEventHandler botonQuererEventHandler = new BotonQuererEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
		botonQuerer.setOnAction(botonQuererEventHandler);

		Button botonNoQuerer = new Button("No Querer");
		BotonNoQuererEventHandler botonNoQuererEventHandler = new BotonNoQuererEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
		botonNoQuerer.setOnAction(botonNoQuererEventHandler);

		Button botonIrseAlMazo = new Button("Irse al Mazo");
		BotonIrseAlMazoEventHandler botonIrseAlMazoEventHandler = new BotonIrseAlMazoEventHandler(this.partida, this.ventanaDelJuego, etiqueta);
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

	public void agregarStage(Stage stageJugadorConTurno) {
		this.stage = stageJugadorConTurno;
	}


}
