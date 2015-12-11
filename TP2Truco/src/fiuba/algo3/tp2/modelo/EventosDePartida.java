package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.modeloJugador.OyenteJugador;

public class EventosDePartida {

	private List<OyenteDePartida> listeners = new ArrayList<OyenteDePartida>();

    public void addListener(OyenteDePartida toAdd) {
        listeners.add(toAdd);
    }
  
    public void seCantoEnvidoEnvido() {
        // Notify everybody that may be interested.
        for (OyenteDePartida hl : listeners)
            hl.seCantoEnvidoEnvido();
    }
    
    public void seCantoRealEnvido() {
        for (OyenteDePartida hl : listeners)
            hl.seCantoRealEnvido();
    }
    
    public void seCantoTruco() {
        for (OyenteDePartida hl : listeners)
            hl.seCantoTruco();
    }
    
    public void seQuisoTruco() {
        for (OyenteDePartida hl : listeners)
            hl.seQuisoTruco();
    }
    
    public void noSeQuisoTruco() {
        for (OyenteDePartida hl : listeners)
            hl.noSeQuisoTruco();
    }
}    