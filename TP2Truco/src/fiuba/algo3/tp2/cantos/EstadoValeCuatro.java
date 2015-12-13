package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.EventosJuez;

public class EstadoValeCuatro extends EstadoCantoTruco{
	
	public EstadoValeCuatro(Equipo equipo) {
		super(equipo);
	}

	@Override
	public int quiso() {
		return 4;
	}

	@Override
	public int noQuiso() {
		return 3;
	}
	
	@Override
	public EstadoCantoTruco cantarTruco(Equipo equipo) {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoTruco cantarQuieroReTruco(Equipo equipo) {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoTruco cantarQuieroValeCuatro(Equipo equipo) {
		throw new CantoInvalidoException();
	}

	@Override
	public void avisarAPartida(EventosJuez eventosJuez) {
		eventosJuez.quisoValeCuatro();
	}

}
