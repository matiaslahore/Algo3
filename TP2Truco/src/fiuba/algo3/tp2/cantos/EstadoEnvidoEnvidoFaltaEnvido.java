package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EstadoEnvidoEnvidoFaltaEnvido extends EstadoCantoEnvido {

	public EstadoEnvidoEnvidoFaltaEnvido(Equipo equipoQueCanta) {
		super(equipoQueCanta);
	}

	@Override
	public EstadoCantoEnvido cantarEnvido(Equipo equipoQueCanta)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoEnvido cantarRealEnvido(Equipo equipoQueCanta)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	@Override
	public EstadoCantoEnvido cantarFaltaEnvido(Equipo equipoQueCanta) throws CantoInvalidoException {
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
