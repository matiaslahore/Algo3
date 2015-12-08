package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronContraFlor extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		try{
			if(jugadorIA.obtenerPuntosFlor() >= 33){
				jugadorIA.cantarContraFlor();
				return;
			}
			if(jugadorIA.obtenerPuntosFlor() >= 30){
				jugadorIA.quiero();
				return;
			}
			jugadorIA.noQuiero();
		}
		catch(RuntimeException e){}
	}

}
