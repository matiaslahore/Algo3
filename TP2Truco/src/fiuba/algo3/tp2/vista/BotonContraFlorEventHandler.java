package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonContraFlorEventHandler implements EventHandler<ActionEvent>{

	private PartidaDeTruco partida;
	private Label etiqueta;
	private VistaHardCodeada visual;
	private Stage stageJugador;

	//constructor
	public BotonContraFlorEventHandler(PartidaDeTruco partida, VistaHardCodeada visual, Stage stageJugador, Label etiqueta){
		this.partida= partida;
		this.visual = visual;
		this.stageJugador = stageJugador;
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
		Scene scene = this.visual.cargarSceneDelJugador();
		this.stageJugador.setScene(scene);
	}

}