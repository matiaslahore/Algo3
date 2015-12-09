package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronEnvido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {

		if(jugadorIA.cantarEnvidoIA()){
			System.out.println("IA canta EnvidoEnvido");
			jugadorIA.cantarEnvido();
			jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
			return;
		}
		if(jugadorIA.quererEnvidoIA()){
			System.out.println("IA quiere el envido");
			jugadorIA.quiero();
			jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
			return;
		}
		System.out.println("IA no quiere el envido");
		jugadorIA.noQuiero();
		jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
	}
}
