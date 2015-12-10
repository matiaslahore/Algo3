package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronFlor extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.quererFlorIA()){
			jugadorIA.quiero();
			jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
			return;
		}
		jugadorIA.noQuiero();
		jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
	}
}
