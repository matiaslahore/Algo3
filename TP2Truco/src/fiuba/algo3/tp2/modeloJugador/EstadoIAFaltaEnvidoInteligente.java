package fiuba.algo3.tp2.modeloJugador;

public class EstadoIAFaltaEnvidoInteligente extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		
		if(jugadorIA.obtenerPuntosEnvido() > 30){
			jugadorIA.quiero();
			jugadorIA.setearEstado(new EstadoIATrucoInteligente());
			return;				
		}
		jugadorIA.noQuiero();
		jugadorIA.setearEstado(new EstadoIATrucoInteligente());
	}

}
