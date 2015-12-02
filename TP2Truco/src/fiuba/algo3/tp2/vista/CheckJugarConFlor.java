package fiuba.algo3.tp2.vista;

import javafx.event.Event;
import javafx.scene.Scene;

public class CheckJugarConFlor<MouseEvent> implements javafx.event.EventHandler {
	Visualizador visualizador;
	
	public CheckJugarConFlor (Visualizador visualizador){
		this.visualizador = visualizador;
	}
	
	@Override
	public void handle(Event evento) {
		this.visualizador.jugarConFlor(true);
	}

}