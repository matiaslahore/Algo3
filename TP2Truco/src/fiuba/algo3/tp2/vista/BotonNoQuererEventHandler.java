package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.NoSePuedeSeguirJugandoExcepcion;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BotonNoQuererEventHandler implements EventHandler<ActionEvent>{

	private PartidaDeTruco partida;
	private Label etiqueta;
	private VentanasDelJuego visual;

	//constructor
	public BotonNoQuererEventHandler(PartidaDeTruco partida, VentanasDelJuego visual, Label etiqueta){
		this.partida = partida;
		this.visual = visual;
		this.etiqueta = etiqueta;
	}

	@Override
	public void handle(ActionEvent actionEvent){
		try{
			this.partida.noQuiero();
			etiqueta.setText("NO QUIERO!");
			etiqueta.setTextFill(Color.web("#008000"));

			this.visual.modificarStageJugador();
			this.visual.modificarStajeCartasEnMesa();

		} catch (CantoInvalidoException noQuererError){
			etiqueta.setText("CANTO INVALIDO");
			etiqueta.setTextFill(Color.web("#FF0000"));
		} catch (NoSePuedeSeguirJugandoExcepcion e){
			this.visual.cerrarVentanasJuego();
		}
	}

}