package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

class EventosIA {
    private List<Oyente> listeners = new ArrayList<Oyente>();

    public void addListener(Oyente toAdd) {
        listeners.add(toAdd);
    }

    public void seCantoTruco() {
        // Notify everybody that may be interested.
        for (Oyente hl : listeners)
            hl.seCantoTruco();
    }
/*
	public void seCantoReTruco(){
		for (Oyente hl : listeners)
            hl.seCantoTruco();
	}
	
	public void seCantoValeCuatro(){
		for (Oyente hl : listeners)
            hl.seCantoTruco();
	}
	
	public void seCantoEnvido(){
		for (Oyente hl : listeners)
            hl.seCantoTruco();
	}
	
	public void seCantoRealEnvido(){
		for (Oyente hl : listeners)
            hl.seCantoTruco();
	}
	
	public void seCantoFaltaEnvido(){
		for (Oyente hl : listeners)
            hl.seCantoTruco();
	}
	
	public void seCantoFlor()
	
	public void seCantoContraFlor();
	
	public void seCantoContraFlorAJuego();
    */
    
}