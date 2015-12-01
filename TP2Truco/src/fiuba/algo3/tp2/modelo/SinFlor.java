package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.excepciones.SeEstaJugandoSinFlorException;

public class SinFlor implements EstadoFlor{

	public void seCantoFlor() {
		throw new SeEstaJugandoSinFlorException();
	}
}
