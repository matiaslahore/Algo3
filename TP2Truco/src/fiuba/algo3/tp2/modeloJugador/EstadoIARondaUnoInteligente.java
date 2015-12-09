package fiuba.algo3.tp2.modeloJugador;

public class EstadoIARondaUnoInteligente extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
	
		if(jugadorIA.cantarEnvidoIA()){
			jugadorIA.cantarEnvido();
			jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
			return;
		}
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
