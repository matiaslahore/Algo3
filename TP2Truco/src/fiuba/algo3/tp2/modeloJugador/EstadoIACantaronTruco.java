package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronTruco extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		/*if(jugadorIA.cantarTrucoIA()){
			jugadorIA.setearEstado(new EstadoIACantaronReTruco());
			jugadorIA.cantarTruco();
			return;
		}*/
		if(jugadorIA.quererTrucoIA()){
			jugadorIA.quiero();
			jugadorIA.setearEstado(new EstadoIATrucoQuerido());
			System.out.println("IA quiere el truco");
			return;
		}
		System.out.println("IA no quiere el truco");
		jugadorIA.noQuiero();
		jugadorIA.setearEstado(new EstadoIARondaUnoInteligente());
	}
}
