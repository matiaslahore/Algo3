package fiuba.algo3.tp2.modeloJugador;

public class EstadoIARondaTresInteligente extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.esMano()){
			jugadorIA.jugarCartaAleatoria();
			return;
		}
		jugadorIA.jugarMejorCarta();
		jugadorIA.setearEstado(new EstadoIARondaUnoInteligente());
	}
}
