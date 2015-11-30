package fiuba.algo3.tp2.modeloJugador;

public class EstadoIAEnvidoInteligente extends EstadoIA {
	
	public void manejador(IA jugadorIA){
		
		if(jugadorIA.obtenerPuntosEnvido() >= 27){
			jugadorIA.cantarEnvido();
			jugadorIA.setearEstado(new EstadoIATrucoInteligente());
		}
	}
}
