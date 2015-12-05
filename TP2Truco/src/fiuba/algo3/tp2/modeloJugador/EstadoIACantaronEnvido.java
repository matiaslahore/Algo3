package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronEnvido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.obtenerPuntosEnvido() >= 27){
			jugadorIA.cantarEnvido();
			return;
		}
		if(jugadorIA.obtenerPuntosEnvido() >= 25){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}

}
