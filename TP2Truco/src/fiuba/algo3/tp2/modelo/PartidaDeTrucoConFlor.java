package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.cantosPosibles.*;

public class PartidaDeTrucoConFlor extends PartidaDeTruco{

	public PartidaDeTrucoConFlor(String nombreEq1, String nombreEq2) {
		super(nombreEq1, nombreEq2);
	}

	@Override
	public void cantarFlor() {
		this.jugadorTurnoActual.cantarFlor();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteFlor());
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