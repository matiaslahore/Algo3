package fiuba.algo3.tp2.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

public class Boton2JugadoresEventHandler implements EventHandler<ActionEvent> {
	
	
	SeleccionDeJuego seleccionDeJuego;
	CheckBox check;
	int cantidadJugadores;
	boolean conFlor;
	
	public Boton2JugadoresEventHandler(SeleccionDeJuego seleccionDeJuego, CheckBox check){
		
		this.seleccionDeJuego= seleccionDeJuego;
		this.check= check;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		this.cantidadJugadores= 2;
		this.seleccionDeJuego.creacionDePartida(this.check.isSelected(), cantidadJugadores);
	}

}