package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronValeCuatro extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.quererValeCuatroIA()){
			System.out.println("IA quiere el vale cuatro");
			jugadorIA.quiero();
			jugadorIA.setearEstado(new EstadoIATrucoQuerido());
			return;
		}
		jugadorIA.noQuiero();
		System.out.println("IA NO quiere el vale cuatro");
		jugadorIA.setearEstado(new EstadoIARondaUnoInteligente());
	}
}
