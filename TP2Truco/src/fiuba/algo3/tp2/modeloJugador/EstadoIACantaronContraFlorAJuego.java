package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronContraFlorAJuego extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.cantarContraFlorAJuegoIA()){
			jugadorIA.cantarContraFlorAJuego();
			jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
			return;
		}
		if(jugadorIA.quererContraFlorAJuegoIA()){
			jugadorIA.quiero();
			jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
			return;
		}
		jugadorIA.noQuiero();
		jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
	}
}
