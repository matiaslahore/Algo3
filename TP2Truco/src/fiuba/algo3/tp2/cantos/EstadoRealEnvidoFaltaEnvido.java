package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EstadoRealEnvidoFaltaEnvido extends EstadoCantoEnvido {

	public EstadoRealEnvidoFaltaEnvido(Equipo equipoQueCanta) {
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
	public EstadoCantoEnvido cantarFaltaEnvido(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	@Override
	public int noQuiso() {
		return 4;
	}

	@Override
	public int quiso(int puntajeEquipoGanador, int puntajeEquipoPerdedor) {
		if (puntajeEquipoGanador<15) return 15-puntajeEquipoGanador;
		
		if (puntajeEquipoPerdedor>=15) return (30-puntajeEquipoPerdedor);
		else return (15-puntajeEquipoPerdedor);
	}
}
