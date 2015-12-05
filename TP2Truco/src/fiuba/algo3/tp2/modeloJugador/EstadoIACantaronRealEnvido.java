package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronRealEnvido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.obtenerPuntosEnvido() >= 31){
			jugadorIA.cantarRealEnvido();
			return;
		}
		if(jugadorIA.obtenerPuntosEnvido() >= 29){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}

}
