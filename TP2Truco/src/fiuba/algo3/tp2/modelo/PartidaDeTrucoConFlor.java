package fiuba.algo3.tp2.modelo;

public class PartidaDeTrucoConFlor extends PartidaDeTruco{

	public PartidaDeTrucoConFlor(String nombreEq1, String nombreEq2) {
		super(nombreEq1, nombreEq2);
		
		this.mesa.instanciarJuez(equipoUno, equipoDos, new EstadoSinFlor());
	}

}