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
	public CantosTruco cantar(Equipo equipo) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

}
