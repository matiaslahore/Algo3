package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.modeloJugador.Oyente;

public class EventosControladorDeVista {

	private List<ControladorDeVista> listeners = new ArrayList<ControladorDeVista>();

    public void addListener(ControladorDeVista toAdd) {
        listeners.add(toAdd);
    }
  
    public void seCantoEnvidoEnvido() {
        // Notify everybody that may be interested.
        for (ControladorDeVista hl : listeners)
            hl.seCantoEnvidoEnvido();
    }
    
    public void seCantoRealEnvido() {
        for (ControladorDeVista hl : listeners)
            hl.seCantoRealEnvido();
    }
}    