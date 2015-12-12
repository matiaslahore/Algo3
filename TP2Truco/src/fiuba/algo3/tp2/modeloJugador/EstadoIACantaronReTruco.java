package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronReTruco extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.quererReTrucoIA()){
			jugadorIA.quiero();
			System.out.println("IA acepta el RE TRUCO ");
			jugadorIA.setearEstado(new EstadoIATrucoQuerido());
			return;
		}
		jugadorIA.noQuiero();
		System.out.println("IA NO acepta el RE TRUCO ");
		jugadorIA.setearEstado(new EstadoIARondaUnoInteligente());
	}
}
