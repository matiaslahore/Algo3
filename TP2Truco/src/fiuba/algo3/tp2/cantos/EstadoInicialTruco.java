package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EstadoInicialTruco extends EstadoCantoTruco {

	public EstadoInicialTruco() {
		super(null);
	}

	@Override
	public EstadoCantoTruco cantarTruco(Equipo equipo) {
		return(new EstadoTruco(equipo));
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
	public int quiso() {
		return 0;
	}

	@Override
	public int noQuiso() {
		return 0;
	}

}
