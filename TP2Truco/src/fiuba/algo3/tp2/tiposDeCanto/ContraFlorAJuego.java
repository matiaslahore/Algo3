package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class ContraFlorAJuego extends TiposDeCantoFlor{

	public ContraFlorAJuego(Equipo equipoQueCanta) {
		super(equipoQueCanta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TiposDeCantoFlor cantarFlor(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public TiposDeCantoFlor cantarContraFlor(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public TiposDeCantoFlor cantarContraFlorAJuego(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public int noQuiso() {
		return 3;
	}

	@Override
	public int quiso() {
		return 30;
	}

}
