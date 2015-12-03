package fiuba.algo3.tp2.modeloJugador;

public class EstadoIARealEnvidoInteligente extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		
		if(jugadorIA.obtenerPuntosEnvido() > 31){
			jugadorIA.cantarFaltaEnvido();
			jugadorIA.setearEstado(new EstadoIAFaltaEnvidoInteligente());
			return;				
		}
		if(jugadorIA.obtenerPuntosEnvido() >= 30){
			jugadorIA.quiero();
			jugadorIA.setearEstado(new EstadoIATrucoInteligente());
			return;				
		}
		jugadorIA.noQuiero();
		jugadorIA.setearEstado(new EstadoIATrucoInteligente());
	}

}
