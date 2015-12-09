package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronRealEnvido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		
		if(jugadorIA.quererRealEnvidoIA()){
			System.out.println("IA quiere Real Envido");
			jugadorIA.quiero();
			return;
		}
		System.out.println("IA no quiere Real Envido");
		jugadorIA.noQuiero();
	}
}
