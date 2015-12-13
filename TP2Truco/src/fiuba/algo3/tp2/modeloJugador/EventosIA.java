package fiuba.algo3.tp2.modeloJugador;

import java.util.ArrayList;
import java.util.List;

public class EventosIA {
	 private List<OyenteIA> listeners = new ArrayList<OyenteIA>();
	
	    public void addListener(OyenteIA toAdd) {
	        listeners.add(toAdd);
	    }
	  
	    public void canteEnvido() {
	        // Notify everybody that may be interested.
		    for (OyenteIA hl : listeners)
		        hl.meCantaronEnvido();
	    }
	    
	    public void canteRealEnvido() {
		    for (OyenteIA hl : listeners)
		        hl.meCantaronRealEnvido();
	    }
	    
	    public void canteFaltaEnvido() {
		    for (OyenteIA hl : listeners)
		        hl.meCantaronFaltaEnvido();
	    }
	    
	    public void canteTruco() {
		    for (OyenteIA hl : listeners)
		        hl.meCantaronTruco();
	    }
	    
	    public void canteReTruco() {
		    for (OyenteIA hl : listeners)
		        hl.meCantaronReTruco();
	    }
	    
	    public void canteValeCuatro() {
		    for (OyenteIA hl : listeners)
		        hl.meCantaronValeCuatro();
	    }
	    
	    public void canteFlor() {
		    for (OyenteIA hl : listeners)
		        hl.meCantaronFlor();
	    }
	    
	    public void canteContraFlor() {
		    for (OyenteIA hl : listeners)
		        hl.meCantaronContraFlor();
	    }
	    
	    public void canteContraFlorAJuego() {
		    for (OyenteIA hl : listeners)
		        hl.meCantaronContraFlorAJuego();
	    }
}
