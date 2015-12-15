package fiuba.algo3.tp2.vista.botonesVentanasDeJuego;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.vista.VentanasDelJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BotonEnvidoEventHandler implements EventHandler<ActionEvent>{

	private PartidaDeTruco partida;
	private Label etiqueta;
	private VentanasDelJuego visual;

	//constructor
	public BotonEnvidoEventHandler(PartidaDeTruco partida, VentanasDelJuego visual, Label etiqueta){
		this.partida = partida;
		this.visual = visual;
		this.etiqueta = etiqueta;
	}

	@Override
	public void handle(ActionEvent actionEvent){
		try{
			etiqueta.setText(this.partida.obtenerNombreDelJugadorConTurno() + " CANTO: "+ "  ENVIDO!");
			etiqueta.setTextFill(Color.web("#FF0000"));
            
			this.partida.cantarEnvido();
			this.visual.modificarStageJugador();
			this.visual.modificarStajeCartasEnMesa();

		} catch (CantoInvalidoException envidoError){
			etiqueta.setText("NO PUEDE CANTAR ENVIDO");
			etiqueta.setTextFill(Color.web("#FF0000"));
		}
	}

}
