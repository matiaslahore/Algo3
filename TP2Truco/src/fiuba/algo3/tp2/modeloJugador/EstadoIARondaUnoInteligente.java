package fiuba.algo3.tp2.modeloJugador;

public class EstadoIARondaUnoInteligente extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		
		if(jugadorIA.obtenerPuntosEnvido() >= 27){
			jugadorIA.cantarEnvido();
			jugadorIA.setearEstado(new EstadoIAYaCantoEnvido());
			return;
		}
		jugadorIA.jugarCartaAleatoria();
		
	}

}
