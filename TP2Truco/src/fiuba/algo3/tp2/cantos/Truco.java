package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.Equipo;

public class Truco extends CantosTruco{
	
	public Truco(Equipo equipo) {
		super(equipo);
	}
	
	@Override
	public int quiso() {
		return 2;
	}

	@Override
	public int noQuiso() {
		return 1;
	}

	@Override
	public ReTruco cantar(Equipo equipo) throws EquipoQueCantaNoPuedeVolverACantarException {
		if(this.equipoQueCanta == equipo){
			throw new EquipoQueCantaNoPuedeVolverACantarException();
		}
		return(new ReTruco(equipo));
	}

}
