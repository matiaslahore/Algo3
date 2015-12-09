package fiuba.algo3.tp2.vista;

import javafx.event.Event;
import javafx.stage.Stage;

public class BotonEmpezarJuegoEventHandler<MouseEvent> implements javafx.event.EventHandler {
	
	SeleccionDeJuego seleccionDeJuego;
	Stage stage;
	
	public BotonEmpezarJuegoEventHandler (SeleccionDeJuego seleccionDeJuego, Stage stage){
		this.seleccionDeJuego=seleccionDeJuego;
		this.stage=stage;
	}
	
	@Override
	public void handle(Event evento) {
		this.stage.close();
		this.seleccionDeJuego.creacionDePartida();
	}

}
