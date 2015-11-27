package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class ValeCuatro extends TiposDeCantoTruco{
	
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
	public TiposDeCantoTruco cantar(Equipo equipo) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

}
