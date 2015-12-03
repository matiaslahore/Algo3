package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BotonEnvidoEventHandler implements EventHandler<ActionEvent>{
	
	private PartidaDeTruco partida;
	private Label etiqueta;
	
	//constructor
	public BotonEnvidoEventHandler (PartidaDeTruco partida, Label etiqueta){
		this.partida=partida;
		this.etiqueta = etiqueta;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		try{
		this.partida.cantarEnvido();
		} catch (CantoInvalidoException envidoError){
			
		}
		finally{
			 etiqueta.setText("NO PUEDE CANTAR ENVIDO");
	         etiqueta.setTextFill(Color.web("#FF0000"));
		}
	}

}
