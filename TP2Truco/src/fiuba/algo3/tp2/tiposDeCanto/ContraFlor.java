package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class ContraFlor extends TiposDeCantoFlor{

	public ContraFlor(Equipo equipoQueCanta) {
		super(equipoQueCanta);
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
	public ContraFlorAJuego cantarContraFlorAJuego(Equipo equipoQueCanta) throws CantoInvalidoException {
		return(new ContraFlorAJuego(equipoQueCanta));
	}

	@Override
	public int noQuiso() {
		return 3;
	}

	@Override
	public int quiso() {
		return 6;
	}

}
