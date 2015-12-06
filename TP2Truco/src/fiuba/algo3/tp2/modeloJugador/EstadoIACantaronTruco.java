package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronTruco extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.cantarTrucoIA()){
			jugadorIA.cantarTruco();
			return;
		}
		if(jugadorIA.quererTrucoIA()){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}
}
