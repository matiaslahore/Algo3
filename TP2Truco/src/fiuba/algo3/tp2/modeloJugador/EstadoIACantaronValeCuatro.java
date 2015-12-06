package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronValeCuatro extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.cantarValeCuatroIA()){
			jugadorIA.cantarQuieroValeCuatro();
			return;
		}
		if(jugadorIA.quererValeCuatroIA()){
			jugadorIA.quiero();
			return;
		}
		jugadorIA.noQuiero();
	}

}
