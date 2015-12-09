package fiuba.algo3.tp2.modeloJugador;

public class EstadoIAYaSeJugoElEnvido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		
		if(jugadorIA.esMano()){			
			jugadorIA.jugarCartaAleatoria();
			jugadorIA.setearEstado(new EstadoIARondaDosInteligente());
			return;
		}
		jugadorIA.jugarMejorCarta();
		jugadorIA.setearEstado(new EstadoIARondaDosInteligente());
		return;
	}
}
