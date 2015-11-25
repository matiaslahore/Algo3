package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public class ValeCuatro extends TiposDeCantoTruco{
	
	public ValeCuatro(String equipo) {
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
	public TiposDeCantoTruco cantar(String equipo) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

}
