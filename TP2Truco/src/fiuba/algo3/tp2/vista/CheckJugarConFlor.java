package fiuba.algo3.tp2.vista;

import javafx.event.Event;
import javafx.scene.Scene;

public class CheckJugarConFlor<MouseEvent> implements javafx.event.EventHandler {
	private boolean jugarConFlor;
	
	public CheckJugarConFlor (boolean flor){
		this.jugarConFlor = flor;
	}
	
	@Override
	public void handle(Event evento) {
         this.jugarConFlor = true;
	}

}