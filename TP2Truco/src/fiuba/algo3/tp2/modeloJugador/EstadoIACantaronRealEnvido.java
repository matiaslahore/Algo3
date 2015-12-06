package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronRealEnvido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.cantarRealEnvidoIA()){
			jugadorIA.cantarRealEnvido();
			return;
		}
		if(jugadorIA.quererRealEnvidoIA()){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}

}
