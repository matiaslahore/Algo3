package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public class EnvidoEnvidoFaltaEnvido extends TiposDeCantoEnvido {

	public EnvidoEnvidoFaltaEnvido(String equipoQueCanta) {
		super(equipoQueCanta);
	}

	@Override
	public TiposDeCantoEnvido cantarEnvido(String equipoQueCanta)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public TiposDeCantoEnvido cantarRealEnvido(String equipoQueCanta)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	@Override
	public TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta) throws CantoInvalidoException {
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
