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
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantaronFlor());
	}

	@Override
	public void cantarContraFlor() {
		this.jugadorTurnoActual.cantarContraFlor();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteContraFlor());
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantaronContraFlor());
	}

	@Override
	public void cantarContraFlorAJuego() {
		this.jugadorTurnoActual.cantarContraFlorAJuego();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteContraFlorxResto());
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantaronContraFlorxResto());
	}

}