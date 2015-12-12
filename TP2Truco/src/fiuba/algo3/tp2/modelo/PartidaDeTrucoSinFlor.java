package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.excepciones.SeEstaJugandoSinFlorException;

public class PartidaDeTrucoSinFlor extends PartidaDeTruco{

	public PartidaDeTrucoSinFlor(String nombreEq1, String nombreEq2) {
		super(nombreEq1, nombreEq2);
		
		this.mesa.instanciarJuez(equipoUno,equipoDos);
	}

	@Override
	public void cantarFlor() {
		throw new SeEstaJugandoSinFlorException();
	}

	@Override
	public void cantarContraFlor() {
		throw new SeEstaJugandoSinFlorException();
	}

	@Override
	public void cantarContraFlorAJuego() {
		throw new SeEstaJugandoSinFlorException();
	}

}