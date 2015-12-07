package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EstadoFaltaEnvido extends EstadoCantoEnvido{
	
	public EstadoFaltaEnvido(Equipo equipoQueCanta){
		super(equipoQueCanta);
	}
	
	@Override
	public EstadoEnvidoEnvido cantarEnvido(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	public EstadoEnvidoRealEnvido cantarRealEnvido(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoEnvido cantarFaltaEnvido(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public int noQuiso() {
		return 1;
	}

	@Override
	public int quiso() {
		return -1;
	}
}