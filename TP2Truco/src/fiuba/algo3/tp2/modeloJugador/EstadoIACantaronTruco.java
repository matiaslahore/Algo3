package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronTruco extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.quererTrucoIA()){
			jugadorIA.quiero();
			jugadorIA.setearEstado(new EstadoIATrucoQuerido());
			return;
		}
		jugadorIA.noQuiero();
		jugadorIA.setearEstado(new EstadoIARondaUnoInteligente());
	}
}
