package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EstadoEnvidoFinalizado extends EstadoCantoEnvido{

	public EstadoEnvidoFinalizado() {
		super(null);
	}

	@Override
	public EstadoCantoEnvido cantarEnvido(Equipo equipoQueCanta) {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoEnvido cantarRealEnvido(Equipo equipoQueCanta) {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoEnvido cantarFaltaEnvido(Equipo equipoQueCanta) {
		throw new CantoInvalidoException();
	}

	@Override
	public int noQuiso() {
		throw new CantoInvalidoException();
	}

	@Override
	public int quiso() {
		throw new CantoInvalidoException();
	}

}
