package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class Flor extends CantosFlor {

	public Flor(Equipo equipoQueCanta) {
		super(equipoQueCanta);
	}

	@Override
	public CantosFlor cantarFlor(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public ContraFlor cantarContraFlor(Equipo equipoQueCanta) throws CantoInvalidoException {
		return(new ContraFlor(equipoQueCanta));
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
		return 3;
	}

}
