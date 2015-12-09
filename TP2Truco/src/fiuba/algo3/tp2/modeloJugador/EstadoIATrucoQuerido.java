package fiuba.algo3.tp2.modeloJugador;

public class EstadoIATrucoQuerido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		
		if(jugadorIA.esMano()){			
			jugadorIA.jugarCartaAleatoria();
			return;
		}
		jugadorIA.jugarMejorCarta();
		return;
	}

}
