package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modeloDeCartas.Carta;

public class PartidaDeTrucoSinFlor extends PartidaDeTruco{

	public PartidaDeTrucoSinFlor(String nombreEq1, String nombreEq2) {
		super(nombreEq1, nombreEq2);
		
		this.mesa.instanciarJuez(equipoUno,equipoDos, new EstadoSinFlor());
	}

}