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
		System.out.println(cantos);
		return(this.botonesPara(cantos));
	}


	private VBox botonesPara(CantosIniciales cantos){
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

	private VBox botonesPara(CanteEnvido cantos){
		//sirve para flor cantada envido cantado, ronda dos y ronda tres
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonTruco);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botonesRondaUno = new VBox(contenedorOpcion,contenedorTruco);

		return botonesRondaUno;
	}

	private VBox botonesPara(CanteFlor cantos){
		//sirve para flor cantada envido cantado, ronda dos y ronda tres
		return botonesPara(new CanteEnvido());
	}

	private VBox botonesPara(CanteTruco cantos){
		//sirve para los q no pueden cantar truco y cuando se canto el vale4
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);

		contenedorOpcion.setPadding(new Insets(padding));

		VBox botonMazo = new VBox(contenedorOpcion);

		return botonMazo;
	}

	private VBox botonesPara(CanteReTruco cantos){
		//sirve para los q no pueden cantar truco y cuando se canto el vale4
		return botonesPara(new CanteTruco());
	}

	private VBox botonesPara(CanteValeCuatro cantos){
		//sirve para los q no pueden cantar truco y cuando se canto el vale4
		return botonesPara(new CanteTruco());
	}

	/*private VBox botonesPara(QuiseTruco cantos){
		//sirve para los q pueden cantar retruco
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonReTruco);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botones = new VBox(contenedorOpcion);

		return botones;
	}*/

	/*private VBox botonesPara(QuiseReTruco cantos){
		//sirve para los q pueden cantar valeCuatro
		this.contenedorOpcion = new HBox(spacing,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonValeCuatro);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botones = new VBox(contenedorOpcion);

		return botones;
	}*/

	private VBox botonesPara(CantaronTruco cantos){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonReTruco);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botonesTruco = new VBox(contenedorOpcion,contenedorTruco);

		return botonesTruco;
	}

	private VBox botonesPara(CantaronReTruco cantos){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorTruco = new HBox(spacing,botonValeCuatro);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorTruco.setPadding(new Insets(padding));

		VBox botonesReTruco = new VBox(contenedorOpcion,contenedorTruco);

		return botonesReTruco;
	}

	private VBox botonesPara(CantaronValeCuatro cantos){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);

		contenedorOpcion.setPadding(new Insets(padding));

		VBox botonesValeCuatro = new VBox(contenedorOpcion);

		return botonesValeCuatro;
	}

	private VBox botonesPara(CantaronEnvido cantos){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonEnvido,botonRealEnvido,botonFaltaEnvido);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botonesEnvido = new VBox(contenedorOpcion,contenedorEnvido);

		return botonesEnvido;
	}

	private VBox botonesPara(CantaronEnvidoEnvido cantos){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonRealEnvido,botonFaltaEnvido);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botonesEnvidoEnvido = new VBox(contenedorOpcion,contenedorEnvido);

		return botonesEnvidoEnvido;
	}

	private VBox botonesPara(CantaronRealEnvido cantos){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);
		this.contenedorEnvido = new HBox(spacing,botonFaltaEnvido);

		contenedorOpcion.setPadding(new Insets(padding));
		contenedorEnvido.setPadding(new Insets(padding));

		VBox botonesRealEnvido = new VBox(contenedorOpcion,contenedorEnvido);

		return botonesRealEnvido;
	}

	private VBox botonesPara(CantaronFaltaEnvido cantos){
		this.contenedorOpcion = new HBox(spacing,botonQuerer,botonNoQuerer,botonIrseAlMazo);

		contenedorOpcion.setPadding(new Insets(padding));

		VBox botonesFaltaEnvido = new VBox(contenedorOpcion);

		return botonesFaltaEnvido;
	}


}
