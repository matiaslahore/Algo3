package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronTruco extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.obtenerPuntosTruco() >= 7){
			jugadorIA.cantarTruco();
			return;
		}
		if(jugadorIA.obtenerPuntosTruco() >= 5){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}
}
