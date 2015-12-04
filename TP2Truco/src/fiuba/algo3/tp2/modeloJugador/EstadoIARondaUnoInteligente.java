package fiuba.algo3.tp2.modeloJugador;

public class EstadoIARondaUnoInteligente extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		
		jugadorIA.jugarCartaAleatoria();
	}

}
