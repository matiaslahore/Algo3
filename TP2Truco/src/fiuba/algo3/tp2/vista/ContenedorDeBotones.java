package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.cantosPosibles.*;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.vista.botonesVentanasDeJuego.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

	private int padding = 10;
	private int spacing = 10;

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

		if (cantos.getClass().equals(CantosIniciales.class)) {
			return botonesParaCantosIniciales();
		}
		if (cantos.getClass().equals(RondaSinEnvido.class)) {
			return botonesParaRondaSinEnvido();
		}
		if (cantos.getClass().equals(CanteEnvido.class)) {
			return botonesParaCanteEnvido();
		}
		if (cantos.getClass().equals(CanteRealEnvido.class)) {
			return botonesParaCanteEnvido();
		}
		if (cantos.getClass().equals(CanteFaltaEnvido.class)) {
			return botonesParaCanteEnvido();
		}
		if (cantos.getClass().equals(CanteFlor.class)) {
			return botonesParaCanteFlor();
		}
		if (cantos.getClass().equals(CanteContraFlor.class)) {
			return botonesParaCanteContraFlor();
		}
		if (cantos.getClass().equals(CanteContraFlorxResto.class)) {
			return botonesParaCanteContraFlorxResto();
		}
		if (cantos.getClass().equals(CantaronFlor.class)) {
			return botonesParaCantaronFlor();
		}
		if (cantos.getClass().equals(CantaronContraFlor.class)) {
			return botonesParaCantaronContraFlor();
		}
		if (cantos.getClass().equals(CantaronContraFlorxResto.class)) {
			return botonesParaCantaronContraFlorxResto();
		}
		if (cantos.getClass().equals(CanteTruco.class)) {
			return botonesParaCanteTruco();
		}
		if (cantos.getClass().equals(CanteReTruco.class)) {
			return botonesParaCanteReTruco();
		}
		if (cantos.getClass().equals(CanteValeCuatro.class)) {
			return botonesParaCanteValeCuatro();
		}
		if (cantos.getClass().equals(CantaronTruco.class)) {
			return botonesParaCantaronTruco();
		}
		if (cantos.getClass().equals(CantaronReTruco.class)) {
			return botonesParaCantaronReTruco();
		}
		if (cantos.getClass().equals(CantaronValeCuatro.class)) {
			return botonesParaCantaronValeCuatro();
		}
		if (cantos.getClass().equals(CantaronEnvido.class)) {
			return botonesParaCantaronEnvido();
		}
		if (cantos.getClass().equals(CantaronEnvidoEnvido.class)) {
			return botonesParaCantaronEnvidoEnvido();
		}
		if (cantos.getClass().equals(CantaronRealEnvido.class)) {
			return botonesParaCantaronRealEnvido();
		}
		if (cantos.getClass().equals(CantaronFaltaEnvido.class)) {
			return botonesParaCantaronFaltaEnvido();
		}
		if (cantos.getClass().equals(QuiseTruco.class)) {
			return botonesParaQuiseTruco();
		}
		if (cantos.getClass().equals(QuiseReTruco.class)) {
			return botonesParaQuiseReTruco();
		}
		if (cantos.getClass().equals(QuiseValeCuatro.class)) {
			return botonesParaQuiseValeCuatro();
		}
		return null;

	}

	private VBox botonesParaCantosIniciales(){
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonEnvido,botonRealEnvido,botonFaltaEnvido);
		if (this.conFlor) contenedorEnvido.getChildren().addAll(botonFlor);
		this.contenedorTruco = new HBox(spacing,botonTruco);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botonesRondaInicial = new VBox(contenedorOpcion,contenedorEnvido,contenedorTruco);

		return botonesRondaInicial;
	}

	private VBox botonesParaRondaSinEnvido(){
		//sirve para flor cantada envido cantado, ronda dos y ronda tres
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonTruco);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botonesRondaUno = new VBox(contenedorOpcion,contenedorTruco);

		return botonesRondaUno;
	}

	private VBox botonesParaCanteEnvido(){
		return botonesParaRondaSinEnvido();
	}

	private VBox botonesParaCanteFlor(){
		//sirve para flor cantada envido cantado, ronda dos y ronda tres
		return botonesParaRondaSinEnvido();
	}

	private VBox botonesParaCanteTruco(){
		//sirve para los q no pueden cantar truco y cuando se canto el vale4
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);

		contenedorOpcion.setPadding(new Insets(padding));

		VBox botonMazo = new VBox(contenedorOpcion);

		return botonMazo;
	}

	private VBox botonesParaCanteReTruco(){
		//sirve para los q no pueden cantar truco y cuando se canto el vale4
		return botonesParaCanteTruco();
	}

	private VBox botonesParaCanteValeCuatro(){
		//sirve para los q no pueden cantar truco y cuando se canto el vale4
		return botonesParaCanteTruco();
	}

	private VBox botonesParaQuiseTruco(){
		//sirve para los q pueden cantar retruco
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonReTruco);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botones = new VBox(contenedorOpcion,contenedorTruco);

		return botones;
	}

	private VBox botonesParaQuiseReTruco(){
		//sirve para los q pueden cantar valeCuatro
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonValeCuatro);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botones = new VBox(contenedorOpcion,contenedorTruco);

		return botones;
	}
	
	private VBox botonesParaQuiseValeCuatro(){
		return botonesParaCanteTruco();
	}

	private VBox botonesParaCantaronTruco(){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonReTruco);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botonesTruco = new VBox(contenedorOpcion,contenedorTruco);

		return botonesTruco;
	}

	private VBox botonesParaCantaronReTruco(){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonValeCuatro);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botonesReTruco = new VBox(contenedorOpcion,contenedorTruco);

		return botonesReTruco;
	}

	private VBox botonesParaCantaronValeCuatro(){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);

		contenedorOpcion.setPadding(new Insets(padding));

		VBox botonesValeCuatro = new VBox(contenedorOpcion);

		return botonesValeCuatro;
	}

	private VBox botonesParaCantaronEnvido(){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonEnvido,botonRealEnvido,botonFaltaEnvido);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botonesEnvido = new VBox(contenedorOpcion,contenedorEnvido);

		return botonesEnvido;
	}

	private VBox botonesParaCantaronEnvidoEnvido(){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonRealEnvido,botonFaltaEnvido);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botonesEnvidoEnvido = new VBox(contenedorOpcion,contenedorEnvido);

		return botonesEnvidoEnvido;
	}

	private VBox botonesParaCantaronRealEnvido(){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonFaltaEnvido);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botonesRealEnvido = new VBox(contenedorOpcion,contenedorEnvido);

		return botonesRealEnvido;
	}

	private VBox botonesParaCantaronFaltaEnvido(){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);

		contenedorOpcion.setPadding(new Insets(padding));

		VBox botonesFaltaEnvido = new VBox(contenedorOpcion);

		return botonesFaltaEnvido;
	}

	private VBox botonesParaQuiseEnvido(){
		return botonesParaRondaSinEnvido();
	}
	
	private VBox botonesParaCantaronContraFlorxResto() {
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botonesRealEnvido = new VBox(contenedorOpcion);

		return botonesRealEnvido;
	}

	private VBox botonesParaCantaronContraFlor() {
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonFlorContraResto);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botones = new VBox(contenedorOpcion,contenedorEnvido);

		return botones;
	}

	private VBox botonesParaCantaronFlor() {
		this.contenedorOpcion = new HBox(spacing,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonFlor,botonContraFlor,botonFlorContraResto);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botones = new VBox(contenedorOpcion,contenedorEnvido);

		return botones;
	}

	private VBox botonesParaCanteContraFlorxResto() {
		return botonesParaRondaSinEnvido();
	}

	private VBox botonesParaCanteContraFlor() {
		return botonesParaRondaSinEnvido();
	}

}
