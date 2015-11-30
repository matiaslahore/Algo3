package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.Mano;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import javafx.event.Event;

public class TirarCartaEventHandler<MouseEvent> implements javafx.event.EventHandler {
    
	private Mesa mesa;
	private Mano mano;
	private Carta carta;
	
	public TirarCartaEventHandler (){
		
	}
	
	@Override
	public void handle(Event evento) {
         System.out.println("la carta fue clikeada");		

	}

}
