package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public class EnvidoEnvidoRealEnvido extends TiposDeCantoEnvido {

	public EnvidoEnvidoRealEnvido(String equipoQueCanta) {
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
	public EnvidoEnvidoRealEnvidoFaltaEnvido cantarFaltaEnvido(String equipoQueCanta) {
		return(new EnvidoEnvidoRealEnvidoFaltaEnvido(equipoQueCanta));
	}

	@Override
	public int noQuiso() {
		return 5;
	}

	@Override
	public int quiso() {
		return 7;
	}

}
