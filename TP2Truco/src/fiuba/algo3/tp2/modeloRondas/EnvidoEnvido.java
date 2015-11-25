package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public class EnvidoEnvido extends TiposDeCantoEnvido{

	public EnvidoEnvido(String equipoQueCanta){
		super(equipoQueCanta);
	}
	
	@Override
	public TiposDeCantoEnvido cantarEnvido(String equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	@Override
	public EnvidoEnvidoRealEnvido cantarRealEnvido(String equipoQueCanta) {
		return(new EnvidoEnvidoRealEnvido(equipoQueCanta));
	}

	@Override
	public EnvidoEnvidoFaltaEnvido cantarFaltaEnvido(String equipoQueCanta) {
		return(new EnvidoEnvidoFaltaEnvido(equipoQueCanta));
	}

	@Override
	public int noQuiso() {
		return 2;
	}

	@Override
	public int quiso() {
		return 4;
	}

}
