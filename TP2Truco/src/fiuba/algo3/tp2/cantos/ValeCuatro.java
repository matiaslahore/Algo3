package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class ValeCuatro extends CantosTruco{
	
	public ValeCuatro(Equipo equipo) {
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
	public CantosTruco cantarTruco(Equipo equipo) {
		throw new CantoInvalidoException();
	}

	@Override
	public CantosTruco cantarQuieroReTruco(Equipo equipo) {
		throw new CantoInvalidoException();
	}

	@Override
	public CantosTruco cantarQuieroValeCuatro(Equipo equipo) {
		throw new CantoInvalidoException();
	}

}
