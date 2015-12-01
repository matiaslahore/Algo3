package fiuba.algo3.tp2.vista;

import javafx.event.Event;
import javafx.stage.Stage;

public class BotonEmpezarJuegoEventHandler<MouseEvent> implements javafx.event.EventHandler {
	
	Visualizador visualizador;
	Stage stage;
	
	public BotonEmpezarJuegoEventHandler (Visualizador visualizador, Stage stage){
		this.visualizador=visualizador;
		this.stage=stage;
	}
	
	@Override
	public void handle(Event evento) {
		this.stage.close();
		this.visualizador.iniciarVentanaDelJuego(this.stage);
	}

}
