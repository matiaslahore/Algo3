package fiuba.algo3.tp2.vista;

import javafx.event.Event;
import javafx.scene.control.CheckBox;

public class CheckCantidadJugadores<MouseEvent> implements javafx.event.EventHandler {
	CheckBox checkBoxjugadores;
	CheckBox checkBoxjugadores2;
	
	public CheckCantidadJugadores (final int cantidadDadaDeJugadores, int cantidadDeJugadores, CheckBox checkBoxjugadores, CheckBox checkBoxjugadores2){
		cantidadDeJugadores = cantidadDadaDeJugadores;
		this.checkBoxjugadores = checkBoxjugadores;
		this.checkBoxjugadores2 = checkBoxjugadores2;
	}
	
	@Override
	public void handle(Event evento) {
	    this.checkBoxjugadores.setSelected(false);
	    this.checkBoxjugadores2.setSelected(false);
	}
}
