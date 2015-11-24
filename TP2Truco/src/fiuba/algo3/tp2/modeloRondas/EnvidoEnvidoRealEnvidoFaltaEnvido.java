package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public class EnvidoEnvidoRealEnvidoFaltaEnvido extends TiposDeCantoEnvido {

	public EnvidoEnvidoRealEnvidoFaltaEnvido(String equipoQueCanta) {
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
	public TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	@Override
	public int noQuiso() {
		return 8;
	}

	@Override
	public int quiso() {
		return -1;
	}
}
