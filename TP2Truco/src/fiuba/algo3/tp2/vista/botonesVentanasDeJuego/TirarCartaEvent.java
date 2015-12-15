package fiuba.algo3.tp2.vista.botonesVentanasDeJuego;

import fiuba.algo3.tp2.excepciones.CartaInexistenteEnManoDeJugadorExeption;
import fiuba.algo3.tp2.excepciones.NoSePuedeJugarUnaCartaException;
import fiuba.algo3.tp2.excepciones.NoSePuedeSeguirJugandoExcepcion;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.vista.VentanasDelJuego;
import javafx.event.Event;
import javafx.scene.input.*;

@SuppressWarnings({ "hiding", "rawtypes" })
public class TirarCartaEvent<MouseEvent> implements javafx.event.EventHandler {

	private Carta carta;
	private PartidaDeTruco partida;
	private VentanasDelJuego visual;

	public TirarCartaEvent(PartidaDeTruco partida, Carta carta, VentanasDelJuego visual){
		this.partida = partida;
		this.carta = carta;
		this.visual = visual;
	}

	@Override
	public void handle(Event evento) {
		try{
			this.partida.jugarCarta(this.carta);
			visual.modificarEtiquetaInformacion("");
			this.visual.modificarStageJugador();
			this.visual.modificarStageCartasEnMesa();
		} catch(CartaInexistenteEnManoDeJugadorExeption | NoSePuedeJugarUnaCartaException e){
			//solo evito que se juege la carta, haciendo nada
		} catch (NoSePuedeSeguirJugandoExcepcion e){
			this.visual.cerrarVentanasJuego();
		}
	}

}