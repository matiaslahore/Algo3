package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronFaltaEnvido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.cantarFaltaEnvidoIA()){
			jugadorIA.cantarFaltaEnvido();
			return;
		}
		if(jugadorIA.quererFaltaEnvidoIA()){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}

}
