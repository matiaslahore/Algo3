package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.modeloJugador.Oyente;

public class EventosDeVista {

	private List<OyentesDeVista> listeners = new ArrayList<OyentesDeVista>();

    public void addListener(OyentesDeVista toAdd) {
        listeners.add(toAdd);
    }
  
    public void seCantoEnvidoEnvido() {
        // Notify everybody that may be interested.
        for (OyentesDeVista hl : listeners)
            hl.seCantoEnvidoEnvido();
    }
    
    public void seCantoRealEnvido() {
        for (OyentesDeVista hl : listeners)
            hl.seCantoRealEnvido();
    }
}    