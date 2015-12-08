package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronReTruco extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		try{
			if(jugadorIA.cantarReTrucoIA()){
				jugadorIA.cantarQuieroReTruco();
				return;
			}
			if(jugadorIA.quererReTrucoIA()){
				jugadorIA.quiero();
				return;
			}
			jugadorIA.noQuiero();
		}
		catch(RuntimeException e){}
	}

}
