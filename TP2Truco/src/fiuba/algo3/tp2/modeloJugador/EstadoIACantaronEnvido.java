package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronEnvido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.cantarEnvidoIA()){
			jugadorIA.cantarEnvido();
			return;
		}
		if(jugadorIA.quererEnvidoIA()){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}

}
