package fiuba.algo3.tp2.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class BotonJugarContraPcEventHandler implements EventHandler<ActionEvent> {
	
	SeleccionDeJuego seleccionDeJuego;
	CheckBox check;
	int cantidadJugadores;
	boolean conFlor;
	Stage stage;
	
	public BotonJugarContraPcEventHandler(SeleccionDeJuego seleccionDeJuego, CheckBox check, Stage stage){
		this.stage=stage;
		this.seleccionDeJuego= seleccionDeJuego;
		this.check= check;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		this.stage.close();
		this.seleccionDeJuego.creacionDePartidaIa(this.check.isSelected());
	}

}