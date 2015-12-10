package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BotonValeCuatroEventHandler implements EventHandler<ActionEvent>{

	private PartidaDeTruco partida;
	private Label etiqueta;
	private VentanasDelJuego visual;

	//constructor
	public BotonValeCuatroEventHandler (PartidaDeTruco partida, VentanasDelJuego visual, Label etiqueta){
		this.partida= partida;
		this.visual = visual;
		this.etiqueta= etiqueta;
	}

	@Override
	public void handle(ActionEvent actionEvent){
		try{
			this.partida.cantarQuieroValeCuatro();
			etiqueta.setText("QUIERO VALE CUAAATRO!!!");
			etiqueta.setTextFill(Color.web("#008000"));

			this.visual.modificarStageJugador();
			this.visual.modificarStajeCartasEnMesa();

		} catch (CantoInvalidoException | EquipoQueCantaNoPuedeVolverACantarException e){
			etiqueta.setText("NO PUEDE CANTAR QUIERO VALE CUATRO");
			etiqueta.setTextFill(Color.web("#FF0000"));
		}
	}

}