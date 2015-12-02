package fiuba.algo3.tp2.vista;

import javafx.event.Event;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class CheckCantidadJugadores<MouseEvent> implements javafx.event.EventHandler {
	CheckBox checkBoxjugadores;
	CheckBox checkBoxjugadores2;
	Visualizador visualizador;
	int cantidadJugadores;
	
	public CheckCantidadJugadores (final int cantidadDadaDeJugadores,Visualizador visualizador, CheckBox checkBoxjugadores, CheckBox checkBoxjugadores2){
		this.visualizador = visualizador;
		this.cantidadJugadores = cantidadDadaDeJugadores;
		this.checkBoxjugadores = checkBoxjugadores;
		this.checkBoxjugadores2 = checkBoxjugadores2;
	}
	
	@Override
	public void handle(Event evento) {
		this.visualizador.cargarCantidadJugadores(this.cantidadJugadores);
	    this.checkBoxjugadores.setSelected(false);
	    this.checkBoxjugadores2.setSelected(false);
	}
}
