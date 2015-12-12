package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronFaltaEnvido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.quererFaltaEnvidoIA()){
			System.out.println("IA quiere la Falta Envido");
			jugadorIA.quiero();
			jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
			return;
		}
		jugadorIA.noQuiero();
		System.out.println("IA quiere la Falta Envido");
		jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
	}
}


