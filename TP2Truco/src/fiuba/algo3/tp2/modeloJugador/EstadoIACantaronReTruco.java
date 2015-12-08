package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronReTruco extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		if(jugadorIA.cantarReTrucoIA()){
			try{
				jugadorIA.cantarQuieroReTruco();
			}
			catch(RuntimeException e){}
			return;
		}
		if(jugadorIA.quererReTrucoIA()){
			try{
				jugadorIA.quiero();
			}
			catch(RuntimeException e2){}
			return;
		}
		try{
			jugadorIA.noQuiero();
		}
		catch(RuntimeException e3){}
	}

}
