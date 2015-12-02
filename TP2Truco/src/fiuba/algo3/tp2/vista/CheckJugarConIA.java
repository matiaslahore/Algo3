package fiuba.algo3.tp2.vista;

import javafx.event.Event;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class CheckJugarConIA<MouseEvent> implements javafx.event.EventHandler {
	CheckBox checkBoxjugadores;
	CheckBox checkBoxjugadores2;
	CheckBox checkBoxjugadores3;
	Visualizador visualizador;
	int cantidadJugadores;
	
	public CheckJugarConIA (Visualizador visualizador, CheckBox checkBoxjugadores, CheckBox checkBoxjugadores2,CheckBox checkBoxjugadores3){
		this.visualizador = visualizador;
		this.cantidadJugadores = 2;
		this.checkBoxjugadores = checkBoxjugadores;
		this.checkBoxjugadores2 = checkBoxjugadores2;
		this.checkBoxjugadores3 = checkBoxjugadores3;
	}
	
	@Override
	public void handle(Event evento) {
		this.visualizador.cargarCantidadJugadores(this.cantidadJugadores);
	    this.checkBoxjugadores.setSelected(false);
	    this.checkBoxjugadores2.setSelected(false);
	    this.checkBoxjugadores3.setSelected(false);
	}
}
