package fiuba.algo3.tp2.modelo;

public class PartidaDeTrucoConFlor extends PartidaDeTruco{

	public PartidaDeTrucoConFlor(String nombreEq1, String nombreEq2) {
		super(nombreEq1, nombreEq2);
	}

	@Override
	public void cantarFlor() {
		this.jugadorTurnoActual.cantarFlor();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}

	@Override
	public void cantarContraFlor() {
		this.jugadorTurnoActual.cantarContraFlor();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}

	@Override
	public void cantarContraFlorAJuego() {
		this.jugadorTurnoActual.cantarContraFlorAJuego();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}

}