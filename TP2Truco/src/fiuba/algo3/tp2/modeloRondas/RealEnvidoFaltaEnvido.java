package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public class RealEnvidoFaltaEnvido extends TiposDeCantoEnvido {

	public RealEnvidoFaltaEnvido(String equipoQueCanta) {
		super(equipoQueCanta);
	}

	@Override
	public TiposDeCantoEnvido cantarEnvido(String equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public TiposDeCantoEnvido cantarRealEnvido(String equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	@Override
	public int noQuiso() {
		return 4;
	}

	@Override
	public int quiso() {
		return -1;
	}
}
