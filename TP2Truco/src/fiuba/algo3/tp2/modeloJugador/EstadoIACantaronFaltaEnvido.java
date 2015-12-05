package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronFaltaEnvido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.obtenerPuntosEnvido() >= 32){
			jugadorIA.cantarFaltaEnvido();
			return;
		}
		if(jugadorIA.obtenerPuntosEnvido() >= 31){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}

}
