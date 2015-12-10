package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.modeloJugador.Oyente;

public class EventosControladorDeBotones {

	private List<ControladorDeBotonesOyentes> listeners = new ArrayList<ControladorDeBotonesOyentes>();

    public void addListener(ControladorDeBotonesOyentes toAdd) {
        listeners.add(toAdd);
    }
  
    public void seCantoEnvidoEnvido() {
        // Notify everybody that may be interested.
        for (ControladorDeBotonesOyentes hl : listeners)
            hl.seCantoEnvidoEnvido();
    }
    
    public void seCantoRealEnvido() {
        for (ControladorDeBotonesOyentes hl : listeners)
            hl.seCantoRealEnvido();
    }
}    