package fiuba.algo3.tp2.modeloJugador;

import java.util.ArrayList;
import java.util.List;

public class EventosJugador {
    private List<OyenteJugador> listeners = new ArrayList<OyenteJugador>();

    public void addListener(OyenteJugador toAdd) {
        listeners.add(toAdd);
    }
  
    public void seCantoTruco() {
        // Notify everybody that may be interested.
        for (OyenteJugador hl : listeners)
            hl.jugadorCantoTruco();
    }

	public void seCantoReTruco(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoReTruco();
	}
	
	public void seCantoValeCuatro(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoValeCuatro();
	}
	
	public void seCantoEnvido(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoEnvido();
	}
	
	public void seCantoRealEnvido(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoRealEnvido();
	}
	
	public void seCantoFaltaEnvido(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoFaltaEnvido();
	}
	
	public void seCantoFlor(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoFlor();
	}
	
	public void seCantoContraFlor(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoContraFlor();
	}
	
	public void seCantoContraFlorAJuego(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoContraFlorAJuego();
	}

	public void seFueAlMazo() {
		for (OyenteJugador hl : listeners)
            hl.jugadorSeFueAlMazo();
	}    
	
	public void IACantoTruco(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoTruco();
	}

	public void IAQuisoTruco() {
		for (OyenteJugador hl : listeners)
            hl.jugadorNoQuisoTruco();
	}
	
	public void IANoQuisoTruco() {
		for (OyenteJugador hl : listeners)
            hl.jugadorNoQuisoTruco();
	}

}