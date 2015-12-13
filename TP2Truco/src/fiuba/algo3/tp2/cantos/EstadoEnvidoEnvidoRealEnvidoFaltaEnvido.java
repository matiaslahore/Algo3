package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.EventosJuez;

public class EstadoEnvidoEnvidoRealEnvidoFaltaEnvido extends EstadoCantoEnvido {

	public EstadoEnvidoEnvidoRealEnvidoFaltaEnvido(Equipo equipoQueCanta) {
		super(equipoQueCanta);
	}

	@Override
	public EstadoCantoEnvido cantarEnvido(Equipo equipoQueCanta)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	@Override
	public EstadoCantoEnvido cantarRealEnvido(Equipo equipoQueCanta)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoEnvido cantarFaltaEnvido(Equipo equipoQueCanta)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	@Override
	public int noQuiso() {
		return 8;
	}

	@Override
	public int quiso(int puntajeEquipoGanador, int puntajeEquipoPerdedor) {
		if (puntajeEquipoGanador<15) return 15-puntajeEquipoGanador;
		
		if (puntajeEquipoPerdedor<15 && puntajeEquipoGanador>=15) return 30-puntajeEquipoGanador;
		
		if (puntajeEquipoPerdedor>=15) return (30-puntajeEquipoPerdedor);
		else return (15-puntajeEquipoPerdedor);
	}
	
	@Override
	public void avisarAPartida(EventosJuez eventosJuez) {
		eventosJuez.cantoFaltaEnvido(this.equipoQueCanta);
	}
	
}
