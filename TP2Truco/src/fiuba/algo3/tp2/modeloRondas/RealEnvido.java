package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.CantoInvalidoExcepcion;

public class RealEnvido extends TiposDeCantoEnvido{
	
	public RealEnvido(String equipoQueCanta){
		super(equipoQueCanta);
	}
	
	@Override
	public EnvidoEnvido cantarEnvido(String equipoQueCanta) throws CantoInvalidoExcepcion {
		throw new CantoInvalidoExcepcion();
	}
	
	public EnvidoRealEnvido cantarRealEnvido(String equipoQueCanta) throws CantoInvalidoExcepcion {
		throw new CantoInvalidoExcepcion();
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