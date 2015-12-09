package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronContraFlor extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		try{
			if(jugadorIA.cantarContraFlorIA()){
				jugadorIA.cantarContraFlor();
				return;
			}
			if(jugadorIA.quererContraFlorIA()){
				jugadorIA.quiero();
				return;
			}
			jugadorIA.noQuiero();
		}
		catch(RuntimeException e){}
	}

}
