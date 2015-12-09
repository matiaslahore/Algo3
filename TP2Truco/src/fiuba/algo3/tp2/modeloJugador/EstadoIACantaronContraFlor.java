package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronContraFlor extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
	
		if(jugadorIA.cantarContraFlorIA()){
			jugadorIA.cantarContraFlor();
			jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
			return;
		}
		if(jugadorIA.quererContraFlorIA()){
			jugadorIA.quiero();
			jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
			return;
		}
		jugadorIA.noQuiero();
		jugadorIA.setearEstado(new EstadoIAYaSeJugoElEnvido());
	}

}
