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
		for (OyenteIA hl : listeners){
			hl.modificarMensajesIa("IA CANTA: ENVIDO!");
			hl.meCantaronEnvido();
		}
	}

	public void canteRealEnvido() {
		for (OyenteIA hl : listeners){
			hl.modificarMensajesIa("IA CANTA: REAL ENVIDO");
			hl.meCantaronRealEnvido();
		}
	}

	public void canteFaltaEnvido() {
		for (OyenteIA hl : listeners){
			hl.modificarMensajesIa("IA CANTA: FALTA ENVIDO");
			hl.meCantaronFaltaEnvido();
		}
	}

	public void canteTruco() {
		for (OyenteIA hl : listeners){
			hl.modificarMensajesIa("IA CANTA: TRUCO!");
			hl.meCantaronTruco();
		}
	}

	public void canteReTruco() {
		for (OyenteIA hl : listeners){
			hl.modificarMensajesIa("IA CANTA: QUIERO RE TRUCO");
			hl.meCantaronReTruco();
		}
	}

	public void canteValeCuatro() {
		for (OyenteIA hl : listeners){
			hl.modificarMensajesIa("IA CANTA: QUIERO VALE CUATRO");
			hl.meCantaronValeCuatro();
		}
	}

	public void canteFlor() {
		for (OyenteIA hl : listeners){
			hl.modificarMensajesIa("IA CANTA: FLOR");
			hl.meCantaronFlor();
		}
	}

	public void canteContraFlor() {
		for (OyenteIA hl : listeners){
			hl.modificarMensajesIa("IA CANTA: CONTRA FLOR");
			hl.meCantaronContraFlor();
		}
	}

	public void canteContraFlorAJuego() {
		for (OyenteIA hl : listeners){
			hl.modificarMensajesIa("IA CANTA: CONTRA FLOR A JUEGO!");
			hl.meCantaronContraFlorAJuego();
		}
	}
	
	public void cantaQuiero() {
		for (OyenteIA hl : listeners){
			hl.modificarMensajesIa("IA DICE: QUIERO!");
		}
	}
	
	public void cantaNoQuiero() {
		for (OyenteIA hl : listeners){
			hl.modificarMensajesIa("IA DICE: NO, NO QUIERO!");
		}
	}
	
}
