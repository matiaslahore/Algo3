package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronFlor extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		try{
			if(jugadorIA.obtenerPuntosFlor() >= 30){
				jugadorIA.cantarFlor();
				return;
			}
			if(jugadorIA.obtenerPuntosFlor() >= 27){
				jugadorIA.quiero();
				return;
			}
			jugadorIA.noQuiero();
		}
		catch(RuntimeException e){}
	}

}
