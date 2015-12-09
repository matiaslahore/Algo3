package fiuba.algo3.tp2.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class Boton2JugadoresEventHandler implements EventHandler<ActionEvent> {
	
	
	SeleccionDeJuego seleccionDeJuego;
	CheckBox check;
	int cantidadJugadores;
	boolean conFlor;
	Stage stage;
	
	public Boton2JugadoresEventHandler(SeleccionDeJuego seleccionDeJuego, CheckBox check, Stage stage){
		
		this.seleccionDeJuego= seleccionDeJuego;
		this.check= check;
		this.stage=stage;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		this.stage.close();
		this.cantidadJugadores= 2;
		this.seleccionDeJuego.creacionDeEquiposYJugadores(this.check.isSelected(), cantidadJugadores);
	}

}