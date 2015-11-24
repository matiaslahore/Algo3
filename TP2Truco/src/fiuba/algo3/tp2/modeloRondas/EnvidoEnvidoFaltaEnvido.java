package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.CantoInvalidoExcepcion;

public class EnvidoEnvidoFaltaEnvido extends TiposDeCantoEnvido {

	public EnvidoEnvidoFaltaEnvido(String equipoQueCanta) {
		super(equipoQueCanta);
	}

	@Override
	public TiposDeCantoEnvido cantarEnvido(String equipoQueCanta)throws CantoInvalidoExcepcion {
		throw new CantoInvalidoExcepcion();
	}

	@Override
	public TiposDeCantoEnvido cantarRealEnvido(String equipoQueCanta)throws CantoInvalidoExcepcion {
		throw new CantoInvalidoExcepcion();
	}
	
	@Override
	public TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta) throws CantoInvalidoExcepcion {
		throw new CantoInvalidoExcepcion();
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
