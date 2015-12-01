package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EnvidoEnvido extends CantosEnvido{

	public EnvidoEnvido(Equipo equipoQueCanta){
		super(equipoQueCanta);
	}
	
	@Override
	public CantosEnvido cantarEnvido(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	@Override
	public EnvidoEnvidoRealEnvido cantarRealEnvido(Equipo equipoQueCanta) {
		return(new EnvidoEnvidoRealEnvido(equipoQueCanta));
	}

	@Override
	public EnvidoEnvidoFaltaEnvido cantarFaltaEnvido(Equipo equipoQueCanta) {
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
