package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

public class EventosJuez {
	private List<OyenteJuez> listeners = new ArrayList<OyenteJuez>();

	public void addListener(OyenteJuez toAdd) {
		listeners.add(toAdd);
	}

	public void quisoTruco() {
		// Notify everybody that may be interested.
		for (OyenteJuez hl : listeners)
			hl.jugadorQuisoTruco();
	}

	public void quisoReTruco() {
		for (OyenteJuez hl : listeners)
			hl.jugadorQuisoReTruco();
	}

	public void quisoValeCuatro() {
		for (OyenteJuez hl : listeners)
			hl.jugadorQuisoValeCuatro();
	}

	public void quisoEnvido() {
		for (OyenteJuez hl : listeners)
			hl.jugadorQuisoEnvido();
	}

	public void comenzoRondaUno() {
		for (OyenteJuez hl : listeners)
			hl.seComenzoRondaUno();
	}

	public void terminoRondaUno() {
		for (OyenteJuez hl : listeners)
			hl.seTerminoRondaUno();
	}

	public void cantoEnvido(Equipo equipoQueCanta) {
		System.out.println("canto");
		for (OyenteJuez hl : listeners)
			hl.jugadorCantoEnvido(equipoQueCanta);
	}

	public void cantoEnvidoEnvido(Equipo equipoQueCanta) {
		System.out.println("canto");
		for (OyenteJuez hl : listeners)
			hl.jugadorCantoEnvidoEnvido(equipoQueCanta);
	}
	
	public void cantoRealEnvido(Equipo equipoQueCanta) {
		System.out.println("canto");
		for (OyenteJuez hl : listeners)
			hl.jugadorCantoRealEnvido(equipoQueCanta);
	}
	
	public void cantoFaltaEnvido(Equipo equipoQueCanta) {
		System.out.println("canto");
		for (OyenteJuez hl : listeners)
			hl.jugadorCantoFaltaEnvido(equipoQueCanta);
	}


}