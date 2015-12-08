package fiuba.algo3.tp2.modeloJugador;

public class EstadoIACantaronFlor extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		try{
			if(jugadorIA.cantarFlorIA()){
				jugadorIA.cantarFlor();
				return;
			}
			if(jugadorIA.quererFlorIA()){
				jugadorIA.quiero();
				return;
			}
			jugadorIA.noQuiero();
		}
		catch(RuntimeException e){}
	}

}
