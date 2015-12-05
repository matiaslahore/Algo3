package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronValeCuatro extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.obtenerPuntosTruco() >= 9){
			jugadorIA.cantarQuieroValeCuatro();
			return;
		}
		if(jugadorIA.obtenerPuntosTruco() >= 8){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}

}
