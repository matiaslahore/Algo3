package fiuba.algo3.tp2.vista.botonesVentanasDeJuego;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.vista.VentanasDelJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BotonReTrucoEventHandler implements EventHandler<ActionEvent>{

	private PartidaDeTruco partida;
	private Label etiqueta;
	private VentanasDelJuego visual;

	//constructor
	public BotonReTrucoEventHandler (PartidaDeTruco partida, VentanasDelJuego visual, Label etiqueta){
		this.partida= partida;
		this.visual = visual;
		this.etiqueta= etiqueta;
	}

	@Override
	public void handle(ActionEvent actionEvent){
		try{
			this.partida.cantarQuieroReTruco();
			etiqueta.setText("QUIERO RE TRUCO!");
			etiqueta.setTextFill(Color.web("#008000"));
			
			this.visual.modificarStageJugador();
			this.visual.modificarStajeCartasEnMesa();

		} catch (CantoInvalidoException | EquipoQueCantaNoPuedeVolverACantarException e){
			etiqueta.setText("NO PUEDE CANTAR QUIERO RE TRUCO");
			etiqueta.setTextFill(Color.web("#FF0000"));
		}
	}

}