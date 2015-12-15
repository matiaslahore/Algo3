package fiuba.algo3.tp2.vista.botonesVentanasDeJuego;

import fiuba.algo3.tp2.excepciones.NoSePuedeSeguirJugandoExcepcion;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.vista.VentanasDelJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonIrseAlMazoEventHandler implements EventHandler<ActionEvent>{

	private PartidaDeTruco partida;
	private VentanasDelJuego visual;

	//constructor
	public BotonIrseAlMazoEventHandler(PartidaDeTruco partida, VentanasDelJuego visual){
		this.partida = partida;
		this.visual = visual;
	}

	@Override
	public void handle(ActionEvent actionEvent){
		try{
			this.partida.irseAlMazo();
			visual.modificarEtiquetaInformacion(this.partida.obtenerNombreDelJugadorConTurno() + " SE FUE AL MAZO!");
			this.visual.modificarStageJugador();
			this.visual.modificarStageCartasEnMesa();
		} catch (NoSePuedeSeguirJugandoExcepcion e){
			this.visual.cerrarVentanasJuego();
		}
	}

}