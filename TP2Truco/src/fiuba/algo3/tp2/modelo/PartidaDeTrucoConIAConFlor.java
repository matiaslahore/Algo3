package fiuba.algo3.tp2.modelo;

public class PartidaDeTrucoConIAConFlor extends PartidaDeTrucoConIA {

	public PartidaDeTrucoConIAConFlor(String nombreEq1, String nombreEq2) {
		super(nombreEq1, nombreEq2);
	}

	@Override
	public void cantarFlor() {
		this.jugadorTurnoActual.cantarFlor();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre() != this.equipoUno.obtenerNombre()){
			this.eventosIA.seCantoFlor();
		}
	}

	@Override
	public void cantarContraFlor() {
		this.jugadorTurnoActual.cantarContraFlor();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre() != this.equipoUno.obtenerNombre()){
			this.eventosIA.seCantoContraFlor();
		}
	}

	@Override
	public void cantarContraFlorAJuego() {
		this.jugadorTurnoActual.cantarContraFlorAJuego();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre() != this.equipoUno.obtenerNombre()){
			this.eventosIA.seCantoContraFlorAJuego();
		}
	}
}
