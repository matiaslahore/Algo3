package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BotonContraFlorEventHandler implements EventHandler<ActionEvent>{

	private PartidaDeTruco partida;
	private Label etiqueta;
	private VistaHardCodeada visual;

	//constructor
	public BotonContraFlorEventHandler(PartidaDeTruco partida, VistaHardCodeada visual, Label etiqueta){
		this.partida= partida;
		this.visual = visual;
		this.etiqueta= etiqueta;
	}

	@Override
	public void handle(ActionEvent actionEvent){
		try{
			this.partida.cantarContraFlor();
			etiqueta.setText("CONTRA FLOR");
			etiqueta.setTextFill(Color.web("#FF0000"));
		} catch (CantoInvalidoException FlorContraRestoError){
			etiqueta.setText("NO PUEDE CANTAR CONTRA FLOR");
			etiqueta.setTextFill(Color.web("#FF0000"));
		}
		this.visual.modificarStageJugador();
	}

}