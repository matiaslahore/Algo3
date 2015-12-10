package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.NoSePuedeSeguirJugandoExcepcion;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class BotonIrseAlMazoEventHandler implements EventHandler<ActionEvent>{

	private PartidaDeTruco partida;
	private VentanasDelJuego visual;
	private Label etiqueta;

	//constructor
	public BotonIrseAlMazoEventHandler (PartidaDeTruco partida, VentanasDelJuego visual, Label etiqueta){
		this.partida= partida;
		this.visual = visual;
		this.etiqueta= etiqueta;
	}

	@Override
	public void handle(ActionEvent actionEvent){
		try{
			this.partida.irseAlMazo();

			etiqueta.setText("ME VOY AL MAZO!");

			this.visual.modificarStageJugador();
			this.visual.modificarStajeCartasEnMesa();
		} catch (NoSePuedeSeguirJugandoExcepcion e){
			this.visual.cerrarVentanasJuego();
		}
	}

}