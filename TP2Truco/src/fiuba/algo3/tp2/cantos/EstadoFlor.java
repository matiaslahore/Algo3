package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EstadoFlor extends EstadoCantoFlor {

	public EstadoFlor(Equipo equipoQueCanta) {
		super(equipoQueCanta);
	}

	@Override
	public EstadoCantoFlor cantarFlor(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoContraFlor cantarContraFlor(Equipo equipoQueCanta) throws CantoInvalidoException {
		return(new EstadoContraFlor(equipoQueCanta));
	}

	@Override
	public EstadoContraFlorAJuego cantarContraFlorAJuego(Equipo equipoQueCanta) throws CantoInvalidoException {
		return(new EstadoContraFlorAJuego(equipoQueCanta));
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
