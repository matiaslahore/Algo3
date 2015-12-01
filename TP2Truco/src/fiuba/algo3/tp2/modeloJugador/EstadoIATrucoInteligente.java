package fiuba.algo3.tp2.modeloJugador;

public class EstadoIATrucoInteligente extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		
		if (jugadorIA.seCantoTruco()){
			jugadorIA.quiero();
			return;
		}
		if (jugadorIA.esMano()){
			jugadorIA.jugarCartaAleatoria();
			return;
		}
		jugadorIA.jugarMejorCarta();
	}
}
