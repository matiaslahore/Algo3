package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.Mano;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import javafx.event.Event;
import javafx.scene.image.ImageView;

public class TirarCartaEventHandler<MouseEvent> implements javafx.event.EventHandler {
    
	private Jugador jugador;
	private Carta carta;
	private double layoutX;
	private ImageView imagen;
	private PartidaDeTruco partida;
	
	public TirarCartaEventHandler (PartidaDeTruco partida, Jugador jugador, Carta carta, ImageView imagen, double layout){
	    this.partida= partida;
		this.imagen= imagen;
		this.layoutX = layout;
		this.jugador= jugador;
		this.carta = carta; 	
	}
	
	@Override
	public void handle(Event evento) {	
         this.imagen.setLayoutX(this.layoutX);
         this.jugador.jugarCarta(this.carta);
        
	}

}
