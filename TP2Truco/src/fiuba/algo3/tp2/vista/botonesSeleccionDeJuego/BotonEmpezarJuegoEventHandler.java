package fiuba.algo3.tp2.vista.botonesSeleccionDeJuego;

import java.util.List;

import fiuba.algo3.tp2.vista.SeleccionDeJuego;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BotonEmpezarJuegoEventHandler<MouseEvent> implements javafx.event.EventHandler {
	
	SeleccionDeJuego seleccionDeJuego;
	Stage stage;
	
	public BotonEmpezarJuegoEventHandler (SeleccionDeJuego seleccionDeJuego, Stage stage){
		this.seleccionDeJuego=seleccionDeJuego;
		this.stage = stage;
	}
	
	@Override
	public void handle(Event evento) {
		if(this.seleccionDeJuego.validarCampos()){
		  this.stage.close();
		  this.seleccionDeJuego.creacionDePartida();
		}
	}

}
