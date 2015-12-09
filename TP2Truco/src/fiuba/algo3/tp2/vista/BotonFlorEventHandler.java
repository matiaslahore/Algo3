package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BotonFlorEventHandler implements EventHandler<ActionEvent>{

	private PartidaDeTruco partida;
	private Label etiqueta;
	private VentanasDelJuego visual;

	//constructor
	public BotonFlorEventHandler (PartidaDeTruco partida, VentanasDelJuego visual, Label etiqueta){
		this.partida= partida;
		this.visual = visual;
		this.etiqueta= etiqueta;
	}

	@Override
	public void handle(ActionEvent actionEvent){
		try{
			this.partida.cantarFlor();
			etiqueta.setText(" FLOR !");
			etiqueta.setTextFill(Color.web("#FF0000"));
		} catch (CantoInvalidoException FlorError){
			etiqueta.setText("NO PUEDE CANTAR FLOR");
			etiqueta.setTextFill(Color.web("#FF0000"));
		}
		this.visual.modificarStageJugador();
		this.visual.modificarStajeCartasEnMesa();
	}

}