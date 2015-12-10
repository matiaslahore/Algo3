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

	public void seCantoReTruco(){
		for (Oyente hl : listeners)
            hl.seCantoReTruco();
	}
	
	public void seCantoValeCuatro(){
		for (Oyente hl : listeners)
            hl.seCantoValeCuatro();
	}
	
	public void seCantoEnvido(){
		for (Oyente hl : listeners)
            hl.seCantoEnvido();
	}
	
	public void seCantoRealEnvido(){
		for (Oyente hl : listeners)
            hl.seCantoRealEnvido();
	}
	
	public void seCantoFaltaEnvido(){
		for (Oyente hl : listeners)
            hl.seCantoFaltaEnvido();
	}
	
	public void seCantoFlor(){
		for (Oyente hl : listeners)
            hl.seCantoFlor();
	}
	
	public void seCantoContraFlor(){
		for (Oyente hl : listeners)
            hl.seCantoContraFlor();
	}
	
	public void seCantoContraFlorAJuego(){
		for (Oyente hl : listeners)
            hl.seCantoContraFlorAJuego();
	}

	public void seFueAlMazo() {
		for (Oyente hl : listeners)
            hl.seFueAlMazo();
	}    
}