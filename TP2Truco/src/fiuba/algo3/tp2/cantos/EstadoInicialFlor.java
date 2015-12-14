package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.EventosJuez;

public class EstadoInicialFlor extends EstadoCantoFlor{

	public EstadoInicialFlor() {
		super(null);
	}

	@Override
	public EstadoCantoFlor cantarFlor(Equipo equipoQueCanta) throws CantoInvalidoException {
		return new EstadoFlor(equipoQueCanta);
	}

	@Override
	public EstadoCantoFlor cantarContraFlor(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoFlor cantarContraFlorAJuego(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public int noQuiso() {
		return 0;
	}

	@Override
	public int quiso() {
		return 0;
	}

	@Override
	public void avisarAPartida(EventosJuez eventosJuez) {
	}

}
