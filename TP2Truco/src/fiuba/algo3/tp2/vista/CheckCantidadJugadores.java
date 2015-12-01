package fiuba.algo3.tp2.vista;

import javafx.event.Event;
import javafx.scene.Scene;

public class CheckCantidadJugadores<MouseEvent> implements javafx.event.EventHandler {
	private int cantidadDeJugadores;
	
	public CheckCantidadJugadores (int cantidadDeJugadores){
		this.cantidadDeJugadores = cantidadDeJugadores;
	}
	
	@Override
	public void handle(Event evento) {
         return;	
	}

}
