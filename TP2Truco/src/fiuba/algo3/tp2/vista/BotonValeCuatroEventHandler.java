package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonValeCuatroEventHandler implements EventHandler<ActionEvent>{
	
	private PartidaDeTruco partida;
	private Label etiqueta;
	private Visualizador visual;
	private Stage stageJugador;
	private Stage stageMesa;

	//constructor
	public BotonValeCuatroEventHandler (PartidaDeTruco partida, Visualizador visual, Stage stageJugador, Stage stageMesa, Label etiqueta){
		this.partida= partida;
		this.visual = visual;
		this.stageJugador = stageJugador;
		this.stageMesa = stageMesa;
		this.etiqueta= etiqueta;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		try{
		this.partida.cantarQuieroValeCuatro();
		} catch (CantoInvalidoException ValeCuatroError){
			etiqueta.setText("NO PUEDE CANTAR VALE CUATRO");
	        etiqueta.setTextFill(Color.web("#FF0000"));
		}
		etiqueta.setText("RONDA EN ESTADO: VALE CUATRO");
        etiqueta.setTextFill(Color.web("#FF0000"));
	}

}