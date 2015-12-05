package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronTruco extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.obtenerPuntosTruco() >= 2){
			jugadorIA.cantarTruco();
			return;
		}
		if(jugadorIA.obtenerPuntosTruco() >= 2){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}
}
