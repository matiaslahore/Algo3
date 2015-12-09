package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EstadoEnvidoEnvidoRealEnvido extends EstadoCantoEnvido {

	public EstadoEnvidoEnvidoRealEnvido(Equipo equipoQueCanta) {
		super(equipoQueCanta);
	}

	@Override
	public EstadoCantoEnvido cantarEnvido(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoEnvido cantarRealEnvido(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoEnvidoEnvidoRealEnvidoFaltaEnvido cantarFaltaEnvido(Equipo equipoQueCanta) {
		return(new EstadoEnvidoEnvidoRealEnvidoFaltaEnvido(equipoQueCanta));
	}

	@Override
	public int noQuiso() {
		return 5;
	}

	@Override
	public int quiso(int puntajeEquipoGanador, int puntajeEquipoPerdedor) {
		return 7;
	}

}
