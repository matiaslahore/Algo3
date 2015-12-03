package fiuba.algo3.tp2.vista;

import java.util.List;

import fiuba.algo3.tp2.modelo.Mano;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import javafx.event.Event;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TirarCartaEventHandler<MouseEvent> implements javafx.event.EventHandler {
    
	private Carta carta;
	private double layoutX;
	private ImageView imagen;
	private PartidaDeTruco partida;
	private ConjuntoCartas<ImageView> conjuntoCartas;
	
	public TirarCartaEventHandler (PartidaDeTruco partida,ConjuntoCartas<ImageView> conjuntoCartas, Carta carta, ImageView imagen, double layout){
	    this.partida= partida;
		this.imagen= imagen;
		this.layoutX = layout;
		this.carta = carta; 
		this.conjuntoCartas = conjuntoCartas; 
	}
	
	@Override
	public void handle(Event evento) {	
         this.imagen.setLayoutX(this.layoutX);
         this.esconderCartas();
       
	}
	
	public void esconderCartas (){
		String direccionReverso= "/fiuba/algo3/tp2/vista/imagenes/reverso.jpg";
		Image reverso = new Image(direccionReverso);
		for (int i=0; i<this.conjuntoCartas.size(); i++){
			if (this.conjuntoCartas.get(i)!= this.imagen)
				this.conjuntoCartas.get(i).setImage(reverso);
		}
			
	}

}
