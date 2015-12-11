package fiuba.algo3.tp2.modeloJugador;

import java.util.ArrayList;
import java.util.List;

public class EventosJugador {
    private List<OyenteJugador> listeners = new ArrayList<OyenteJugador>();

    public void addListener(OyenteJugador toAdd) {
        listeners.add(toAdd);
    }
  
    public void jugadorCantoTruco() {
        // Notify everybody that may be interested.
        for (OyenteJugador hl : listeners)
            hl.jugadorCantoTruco();
    }

	public void jugadorCantoReTruco(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoReTruco();
	}
	
	public void jugadorCantoValeCuatro(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoValeCuatro();
	}
	
	public void jugadorCantoEnvido(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoEnvido();
	}
	
	public void jugadorCantoRealEnvido(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoRealEnvido();
	}
	
	public void jugadorCantoFaltaEnvido(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoFaltaEnvido();
	}
	
	public void jugadorCantoFlor(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoFlor();
	}
	
	public void jugadorCantoContraFlor(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoContraFlor();
	}
	
	public void jugadorCantoContraFlorAJuego(){
		for (OyenteJugador hl : listeners)
            hl.jugadorCantoContraFlorAJuego();
	}

	public void jugadorSeFueAlMazo() {
		for (OyenteJugador hl : listeners)
            hl.jugadorSeFueAlMazo();
	}    
	
	public void jugadorQuiso() {
		for (OyenteJugador hl : listeners)
            hl.jugadorQuiso();
	}
	
	public void jugadorNoQuiso() {
		for (OyenteJugador hl : listeners)
            hl.jugadorNoQuiso();
	}

}