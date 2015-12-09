package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EstadoEnvidoEnvido extends EstadoCantoEnvido{

	public EstadoEnvidoEnvido(Equipo equipoQueCanta){
		super(equipoQueCanta);
	}
	
	@Override
	public EstadoCantoEnvido cantarEnvido(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}
	
	@Override
	public EstadoEnvidoEnvidoRealEnvido cantarRealEnvido(Equipo equipoQueCanta) {
		return(new EstadoEnvidoEnvidoRealEnvido(equipoQueCanta));
	}

	@Override
	public EstadoEnvidoEnvidoFaltaEnvido cantarFaltaEnvido(Equipo equipoQueCanta) {
		return(new EstadoEnvidoEnvidoFaltaEnvido(equipoQueCanta));
	}

	@Override
	public int noQuiso() {
		return 2;
	}

	@Override
	public int quiso(int puntajeEquipoGanador, int puntajeEquipoPerdedor) {
		return 4;
	}

}
