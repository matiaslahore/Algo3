package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.cantosPosibles.*;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ContenedorDeBotones {

	private PartidaDeTruco partida;
	private boolean conFlor;
	private Button botonEnvido;
	private Button botonRealEnvido;
	private Button botonFaltaEnvido;
	private Button botonFlor;
	private Button botonContraFlor;
	private Button botonFlorContraResto;
	private Button botonTruco;
	private Button botonReTruco;
	private Button botonValeCuatro;
	private Button botonQuerer;
	private Button botonNoQuerer;
	private Button botonIrseAlMazo;

	private HBox contenedorOpcion;
	private HBox contenedorEnvido;
	private HBox contenedorTruco;

	private int padding = 5;
	private int spacing = 10;

	public ContenedorDeBotones(PartidaDeTruco partida, VentanasDelJuego visual, boolean conFlor){
		this.partida = partida;
		this.conFlor = conFlor;

		this.botonEnvido = new Button("Envido");
		BotonEnvidoEventHandler botonEnvidoEventHandler = new BotonEnvidoEventHandler(this.partida, visual);
		botonEnvido.setOnAction(botonEnvidoEventHandler);

		this.botonRealEnvido = new Button("Real Envido");
		BotonRealEnvidoEventHandler botonRealEnvidoEventHandler = new BotonRealEnvidoEventHandler(this.partida, visual);
		botonRealEnvido.setOnAction(botonRealEnvidoEventHandler);

		this.botonFaltaEnvido = new Button("Falta Envido");
		BotonFaltaEnvidoEventHandler botonFaltaEnvidoEventHandler = new BotonFaltaEnvidoEventHandler(this.partida, visual);
		botonFaltaEnvido.setOnAction(botonFaltaEnvidoEventHandler);

		this.botonFlor = new Button("Flor");
		BotonFlorEventHandler botonFlorEventHandler = new BotonFlorEventHandler(this.partida, visual);
		botonFlor.setOnAction(botonFlorEventHandler);

		this.botonContraFlor = new Button("Contra Flor");
		BotonContraFlorEventHandler botonContraFlorEventHandler = new BotonContraFlorEventHandler(this.partida, visual);
		botonContraFlor.setOnAction(botonContraFlorEventHandler);

		this.botonFlorContraResto = new Button("Flor X Resto");
		BotonFlorContraRestoEventHandler botonFlorContraRestoEventHandler = new BotonFlorContraRestoEventHandler(this.partida, visual);
		botonFlorContraResto.setOnAction(botonFlorContraRestoEventHandler);

		this.botonTruco = new Button("Truco");
		BotonTrucoEventHandler botonTrucoEventHandler = new BotonTrucoEventHandler(this.partida, visual);
		botonTruco.setOnAction(botonTrucoEventHandler);

		this.botonReTruco = new Button("ReTruco");
		BotonReTrucoEventHandler botonReTrucoEventHandler = new BotonReTrucoEventHandler(this.partida, visual);
		botonReTruco.setOnAction(botonReTrucoEventHandler);

		this.botonValeCuatro = new Button("ValeCuatro");
		BotonValeCuatroEventHandler botonValeCuatroEventHandler = new BotonValeCuatroEventHandler(this.partida, visual);
		botonValeCuatro.setOnAction(botonValeCuatroEventHandler);

		this.botonQuerer = new Button("Querer");
		BotonQuererEventHandler botonQuererEventHandler = new BotonQuererEventHandler(this.partida, visual);
		botonQuerer.setOnAction(botonQuererEventHandler);

		this.botonNoQuerer = new Button("No Querer");
		BotonNoQuererEventHandler botonNoQuererEventHandler = new BotonNoQuererEventHandler(this.partida, visual);
		botonNoQuerer.setOnAction(botonNoQuererEventHandler);

		this.botonIrseAlMazo = new Button("Irse al Mazo");
		BotonIrseAlMazoEventHandler botonIrseAlMazoEventHandler = new BotonIrseAlMazoEventHandler(this.partida, visual);
		botonIrseAlMazo.setOnAction(botonIrseAlMazoEventHandler);
	}

	public VBox botonesParaJugadorActual() {
		CantosPosiblesEntreEquipos cantos = this.partida.cantosEquipoActual();

		return cantos.botonesParaCanto(this);
	}

	public VBox botonesPara(CantosIniciales canto){
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonEnvido,botonRealEnvido,botonFaltaEnvido);
		if (this.conFlor && this.partida.jugadorActualTieneFlor())
			contenedorEnvido.getChildren().add(botonFlor);
		this.contenedorTruco = new HBox(spacing,botonTruco);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botonesRondaInicial = new VBox(contenedorOpcion,contenedorEnvido,contenedorTruco);
        
		return botonesRondaInicial;
	}

	public VBox botonesPara(RondaSinEnvido canto){
		//sirve para flor cantada envido cantado, ronda dos y ronda tres
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonTruco);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botonesRondaUno = new VBox(contenedorOpcion,contenedorTruco);

		return botonesRondaUno;
	}

	public VBox botonesPara(CanteEnvido canto){
		return botonesPara(new RondaSinEnvido());
	}
	
	public VBox botonesPara(CanteRealEnvido canteRealEnvido) {
		return botonesPara(new CanteEnvido());
	}
	
	public VBox botonesPara(CanteFaltaEnvido canteRealEnvido) {
		return botonesPara(new CanteEnvido());
	}

	public VBox botonesPara(CanteEnvidoEnvido canteEnvidoEnvido) {
		return botonesPara(new CanteEnvido());
	}

	public VBox botonesPara(CanteFlor canto){
		//sirve para flor cantada envido cantado, ronda dos y ronda tres
		return botonesPara(new RondaSinEnvido());
	}

	public VBox botonesPara(CanteTruco canto){
		//sirve para los q no pueden cantar truco y cuando se canto el vale4
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);

		contenedorOpcion.setPadding(new Insets(padding));

		VBox botonMazo = new VBox(contenedorOpcion);

		return botonMazo;
	}

	public VBox botonesPara(CanteReTruco canto){
		//sirve para los q no pueden cantar truco y cuando se canto el vale4
		return botonesPara(new CanteTruco());
	}

	public VBox botonesPara(CanteValeCuatro canto){
		//sirve para los q no pueden cantar truco y cuando se canto el vale4
		return botonesPara(new CanteTruco());
	}

	public VBox botonesPara(QuiseTruco canto){
		//sirve para los q pueden cantar retruco
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonReTruco);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botones = new VBox(contenedorOpcion,contenedorTruco);

		return botones;
	}

	public VBox botonesPara(QuiseReTruco canto){
		//sirve para los q pueden cantar valeCuatro
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonValeCuatro);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botones = new VBox(contenedorOpcion,contenedorTruco);

		return botones;
	}
	
	public VBox botonesPara(QuiseValeCuatro canto){
		return botonesPara(new CanteTruco());
	}

	public VBox botonesPara(CantaronTruco canto){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonReTruco);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botonesTruco = new VBox(contenedorOpcion,contenedorTruco);

		return botonesTruco;
	}

	public VBox botonesPara(CantaronReTruco canto){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonValeCuatro);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botonesReTruco = new VBox(contenedorOpcion,contenedorTruco);

		return botonesReTruco;
	}

	public VBox botonesPara(CantaronValeCuatro canto){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);

		contenedorOpcion.setPadding(new Insets(padding));

		VBox botonesValeCuatro = new VBox(contenedorOpcion);

		return botonesValeCuatro;
	}

	public VBox botonesPara(CantaronEnvido canto){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonEnvido,botonRealEnvido,botonFaltaEnvido);
		if (this.conFlor) 
			contenedorEnvido.getChildren().add(botonFlor);
		
		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botonesEnvido = new VBox(contenedorOpcion,contenedorEnvido);

		return botonesEnvido;
	}

	public VBox botonesPara(CantaronEnvidoEnvido canto){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonRealEnvido,botonFaltaEnvido);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botonesEnvidoEnvido = new VBox(contenedorOpcion,contenedorEnvido);

		return botonesEnvidoEnvido;
	}

	public VBox botonesPara(CantaronRealEnvido canto){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonFaltaEnvido);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botonesRealEnvido = new VBox(contenedorOpcion,contenedorEnvido);

		return botonesRealEnvido;
	}

	public VBox botonesPara(CantaronFaltaEnvido canto){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);

		contenedorOpcion.setPadding(new Insets(padding));

		VBox botonesFaltaEnvido = new VBox(contenedorOpcion);

		return botonesFaltaEnvido;
	}
	
	public VBox botonesPara(CantaronContraFlorxResto canto) {
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botonesRealEnvido = new VBox(contenedorOpcion);

		return botonesRealEnvido;
	}

	public VBox botonesPara(CantaronContraFlor canto) {
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonFlorContraResto);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botones = new VBox(contenedorOpcion,contenedorEnvido);

		return botones;
	}

	public VBox botonesPara(CantaronFlor canto) {
		this.contenedorOpcion = new HBox(spacing,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonFlor,botonContraFlor,botonFlorContraResto);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botones = new VBox(contenedorOpcion,contenedorEnvido);

		return botones;
	}

	public VBox botonesPara(CanteContraFlorxResto canto) {
		return botonesPara(new RondaSinEnvido());
	}

	public VBox botonesPara(CanteContraFlor canto) {
		return botonesPara(new RondaSinEnvido());
	}


}
