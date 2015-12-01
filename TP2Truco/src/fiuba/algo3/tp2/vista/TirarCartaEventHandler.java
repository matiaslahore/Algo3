package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.Mano;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import javafx.event.Event;
import javafx.scene.image.ImageView;

public class TirarCartaEventHandler<MouseEvent> implements javafx.event.EventHandler {
    
	private Mesa mesa;
	private Jugador jugador;
	private Carta carta;
	private double layoutX;
	
	public TirarCartaEventHandler (Mesa mesa, Jugador jugador, Carta carta, double layoutX, ImageView imagen){
		this.mesa= mesa;
		this.jugador= jugador;
		this.carta = carta; 	
	}
	
	@Override
	public void handle(Event evento) {
         System.out.println("la carta fue clikeada");		
         
        
	}

}
