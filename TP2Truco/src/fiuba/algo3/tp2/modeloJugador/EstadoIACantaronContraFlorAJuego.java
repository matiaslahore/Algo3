package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronContraFlorAJuego extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		try{
			if(jugadorIA.cantarContraFlorAJuegoIA()){
				jugadorIA.cantarContraFlorAJuego();
				return;
			}
			if(jugadorIA.quererContraFlorAJuegoIA()){
				jugadorIA.quiero();
				return;
			}
			jugadorIA.noQuiero();
		}
		catch(RuntimeException e){}
	}

}
