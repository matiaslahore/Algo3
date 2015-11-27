package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EnvidoEnvidoFaltaEnvido extends TiposDeCantoEnvido {

	public EnvidoEnvidoFaltaEnvido(Equipo equipoQueCanta) {
		super(equipoQueCanta);
	}

	@Override
	public TiposDeCantoEnvido cantarEnvido(Equipo equipoQueCanta)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public TiposDeCantoEnvido cantarRealEnvido(Equipo equipoQueCanta)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	@Override
	public TiposDeCantoEnvido cantarFaltaEnvido(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public int noQuiso() {
		return 5;
	}

	@Override
	public int quiso() {
		return -1;
	}
}
