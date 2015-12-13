package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.cantosPosibles.CantosPosiblesEntreEquipos;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorDeBotones {
	CreadorDeBotones creadorDeBotones;
	PartidaDeTruco partida;
	boolean conFlor;
	Button botonEnvido;
	Button botonRealEnvido;
	Button botonFaltaEnvido;
	Button botonFlor;
	Button botonContraFlor;
	Button botonFlorContraResto;
	Button botonTruco;
	Button botonReTruco;
	Button botonValeCuatro;
	Button botonQuerer;
	Button botonNoQuerer;
	Button botonIrseAlMazo;

	HBox contenedorOpcion;
	HBox contenedorEnvido;
	HBox contenedorTruco;

	int padding = 10;
	int spacing = 10;

	public ContenedorDeBotones(PartidaDeTruco partida, VentanasDelJuego visual, boolean conFlor){
		this.partida = partida;
		this.conFlor = conFlor;
		Label etiqueta = new Label();

		this.contenedorOpcion = new HBox();
		this.contenedorEnvido = new HBox();
		this.contenedorTruco = new HBox();

		this.botonEnvido = new Button("Envido");
		BotonEnvidoEventHandler botonEnvidoEventHandler = new BotonEnvidoEventHandler(this.partida, visual, etiqueta);
		botonEnvido.setOnAction(botonEnvidoEventHandler);

		this.botonRealEnvido = new Button("Real Envido");
		BotonRealEnvidoEventHandler botonRealEnvidoEventHandler = new BotonRealEnvidoEventHandler(this.partida, visual, etiqueta);
		botonRealEnvido.setOnAction(botonRealEnvidoEventHandler);

		this.botonFaltaEnvido = new Button("Falta Envido");
		BotonFaltaEnvidoEventHandler botonFaltaEnvidoEventHandler = new BotonFaltaEnvidoEventHandler(this.partida, visual, etiqueta);
		botonFaltaEnvido.setOnAction(botonFaltaEnvidoEventHandler);

		this.botonFlor = new Button("Flor");
		BotonFlorEventHandler botonFlorEventHandler = new BotonFlorEventHandler(this.partida, visual, etiqueta);
		botonFlor.setOnAction(botonFlorEventHandler);

		this.botonContraFlor = new Button("Contra Flor");
		BotonContraFlorEventHandler botonContraFlorEventHandler = new BotonContraFlorEventHandler(this.partida, visual, etiqueta);
		botonContraFlor.setOnAction(botonContraFlorEventHandler);

		this.botonFlorContraResto = new Button("Flor X Resto");
		BotonFlorContraRestoEventHandler botonFlorContraRestoEventHandler = new BotonFlorContraRestoEventHandler(this.partida, visual, etiqueta);
		botonFlorContraResto.setOnAction(botonFlorContraRestoEventHandler);

		this.botonTruco = new Button("Truco");
		BotonTrucoEventHandler botonTrucoEventHandler = new BotonTrucoEventHandler(this.partida, visual, etiqueta);
		botonTruco.setOnAction(botonTrucoEventHandler);

		this.botonReTruco = new Button("ReTruco");
		BotonReTrucoEventHandler botonReTrucoEventHandler = new BotonReTrucoEventHandler(this.partida, visual, etiqueta);
		botonReTruco.setOnAction(botonReTrucoEventHandler);

		this.botonValeCuatro = new Button("ValeCuatro");
		BotonValeCuatroEventHandler botonValeCuatroEventHandler = new BotonValeCuatroEventHandler(this.partida, visual, etiqueta);
		botonValeCuatro.setOnAction(botonValeCuatroEventHandler);

		this.botonQuerer = new Button("Querer");
		BotonQuererEventHandler botonQuererEventHandler = new BotonQuererEventHandler(this.partida, visual, etiqueta);
		botonQuerer.setOnAction(botonQuererEventHandler);

		this.botonNoQuerer = new Button("No Querer");
		BotonNoQuererEventHandler botonNoQuererEventHandler = new BotonNoQuererEventHandler(this.partida, visual, etiqueta);
		botonNoQuerer.setOnAction(botonNoQuererEventHandler);

		this.botonIrseAlMazo = new Button("Irse al Mazo");
		BotonIrseAlMazoEventHandler botonIrseAlMazoEventHandler = new BotonIrseAlMazoEventHandler(this.partida, visual, etiqueta);
		botonIrseAlMazo.setOnAction(botonIrseAlMazoEventHandler);
	}

	public VBox botonesParaJugadorActual() {
		CantosPosiblesEntreEquipos cantos = this.partida.cantosEquipoActual();
		System.out.println(cantos);
		return(this.creadorDeBotones.botonesPara(cantos));
	}
	
	
}
