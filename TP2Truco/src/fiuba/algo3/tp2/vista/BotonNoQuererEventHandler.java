package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modeloJugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonNoQuererEventHandler implements EventHandler<ActionEvent>{
	
	private Jugador jugador;
	
	//constructor
	public BotonNoQuererEventHandler (Jugador jugador){
		this.jugador = jugador;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		this.jugador.noQuiero();
	}

}
