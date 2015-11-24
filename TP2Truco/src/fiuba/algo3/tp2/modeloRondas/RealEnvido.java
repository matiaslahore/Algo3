package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public class RealEnvido extends TiposDeCantoEnvido{
	
	public RealEnvido(String equipoQueCanta){
		super(equipoQueCanta);
	}
	
	@Override
	public EnvidoEnvido cantarEnvido(String equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	public EnvidoRealEnvido cantarRealEnvido(String equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta) {
		return(new RealEnvidoFaltaEnvido(equipoQueCanta));
	}

	@Override
	public int noQuiso() {
		return 1;
	}

	@Override
	public int quiso() {
		return 3;
	}
}