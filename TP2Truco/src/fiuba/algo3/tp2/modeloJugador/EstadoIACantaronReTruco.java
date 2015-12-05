package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronReTruco extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.obtenerPuntosTruco() >= 18){
			jugadorIA.cantarQuieroReTruco();
			return;
		}
		if(jugadorIA.obtenerPuntosTruco() >= 15){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}

}
