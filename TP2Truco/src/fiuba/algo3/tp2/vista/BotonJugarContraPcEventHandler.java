package fiuba.algo3.tp2.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

public class BotonJugarContraPcEventHandler implements EventHandler<ActionEvent> {
	
	SeleccionDeJuego seleccionDeJuego;
	CheckBox check;
	int cantidadJugadores;
	boolean conFlor;
	
	public BotonJugarContraPcEventHandler(SeleccionDeJuego seleccionDeJuego, CheckBox check){
		
		this.seleccionDeJuego= seleccionDeJuego;
		this.check= check;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		this.seleccionDeJuego.creacionDePartidaIa(this.check.isSelected());
	}

}