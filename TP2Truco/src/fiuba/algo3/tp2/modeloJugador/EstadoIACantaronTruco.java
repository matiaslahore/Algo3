package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronTruco extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		try{
			if(jugadorIA.cantarTrucoIA()){
				jugadorIA.setearEstado(new EstadoIACantaronReTruco());
				jugadorIA.cantarTruco();
				return;
			}
			if(jugadorIA.quererTrucoIA()){
				jugadorIA.quiero();
				return;
			}
			jugadorIA.noQuiero();
		}
		catch(RuntimeException e){}
	}
}
