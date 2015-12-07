package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EstadoReTruco extends EstadoCantoTruco{

	public EstadoReTruco(Equipo equipo) {
		super(equipo);
	}

	@Override
	public int quiso() {
		return 3;
	}

	@Override
	public int noQuiso() {
		return 2;
	}

	@Override
	public EstadoCantoTruco cantarTruco(Equipo equipo) {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoTruco cantarQuieroReTruco(Equipo equipo) {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoTruco cantarQuieroValeCuatro(Equipo equipo) {
		if(this.equipoQueCanta == equipo){
			throw new EquipoQueCantaNoPuedeVolverACantarException();
		}
		return(new EstadoValeCuatro(equipo));
	}

}
