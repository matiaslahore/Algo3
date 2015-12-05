package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronContraFlorAJuego extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.obtenerPuntosFlor() >= 37){
			jugadorIA.cantarContraFlorAJuego();
			return;
		}
		if(jugadorIA.obtenerPuntosFlor() >= 35){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}

}
