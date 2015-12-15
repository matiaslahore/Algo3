package fiuba.algo3.tp2.vista.botonesVentanasDeJuego;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.NoSePuedeSeguirJugandoExcepcion;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.vista.VentanasDelJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonQuererEventHandler implements EventHandler<ActionEvent>{

	private PartidaDeTruco partida;
	private VentanasDelJuego visual;

	//constructor
	public BotonQuererEventHandler(PartidaDeTruco partida, VentanasDelJuego visual){
		this.partida= partida;
		this.visual = visual;
	}

	@Override
	public void handle(ActionEvent actionEvent){
		try{
			this.partida.quiero();
			String ganador = partida.ganadorEnvido();
			if (ganador.isEmpty())
				visual.modificarEtiquetaInformacion(this.partida.obtenerNombreDelJugadorConTurno() + " DICE QUIERO!");
			else visual.modificarEtiquetaInformacion("El envido lo gana " + ganador);
			
			this.visual.modificarStageJugador();
			this.visual.modificarStageCartasEnMesa();
		} catch (CantoInvalidoException quererError){
		} catch (NoSePuedeSeguirJugandoExcepcion e){
			this.visual.cerrarVentanasJuego();
		}
	}

}
