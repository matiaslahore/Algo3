package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.cantosPosibles.CantaronEnvido;
import fiuba.algo3.tp2.cantosPosibles.CantaronEnvidoEnvido;
import fiuba.algo3.tp2.cantosPosibles.CantaronFaltaEnvido;
import fiuba.algo3.tp2.cantosPosibles.CantaronReTruco;
import fiuba.algo3.tp2.cantosPosibles.CantaronRealEnvido;
import fiuba.algo3.tp2.cantosPosibles.CantaronTruco;
import fiuba.algo3.tp2.cantosPosibles.CantaronValeCuatro;
import fiuba.algo3.tp2.cantosPosibles.CanteEnvido;
import fiuba.algo3.tp2.cantosPosibles.CanteFlor;
import fiuba.algo3.tp2.cantosPosibles.CanteReTruco;
import fiuba.algo3.tp2.cantosPosibles.CanteTruco;
import fiuba.algo3.tp2.cantosPosibles.CanteValeCuatro;
import fiuba.algo3.tp2.cantosPosibles.CantosIniciales;
import fiuba.algo3.tp2.cantosPosibles.CantosPosiblesEntreEquipos;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreadorDeBotones extends ContenedorDeBotones {

	public CreadorDeBotones(PartidaDeTruco partida, VentanasDelJuego visual, boolean conFlor) {
		super(partida, visual, conFlor);
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
	
	public VBox botonesPara(CantosPosiblesEntreEquipos cantos) {
		return (this.botonesPara(cantos));
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
