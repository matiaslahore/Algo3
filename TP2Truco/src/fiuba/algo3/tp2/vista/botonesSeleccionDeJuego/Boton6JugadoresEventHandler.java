package fiuba.algo3.tp2.vista.botonesSeleccionDeJuego;

import fiuba.algo3.tp2.vista.SeleccionDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class Boton6JugadoresEventHandler implements EventHandler<ActionEvent> {
	
	SeleccionDeJuego seleccionDeJuego;
	CheckBox check;
	int cantidadJugadores;
	boolean conFlor;
	Stage stage;
	
	public Boton6JugadoresEventHandler(SeleccionDeJuego seleccionDeJuego, CheckBox check,Stage stage){
		this.stage=stage;
		this.seleccionDeJuego= seleccionDeJuego;
		this.check= check;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		this.stage.close();
		this.cantidadJugadores= 6;
		this.seleccionDeJuego.creacionDeEquiposYJugadores(this.check.isSelected(), cantidadJugadores);
	}

}