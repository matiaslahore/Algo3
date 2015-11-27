package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.Equipo;

public class ReTruco extends TiposDeCantoTruco{

	public ReTruco(Equipo equipo) {
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
	public TiposDeCantoTruco cantar(Equipo equipo) throws EquipoQueCantaNoPuedeVolverACantarException {
		if(this.equipoQueCanta == equipo){
			throw new EquipoQueCantaNoPuedeVolverACantarException();
		}
		return(new ValeCuatro(equipo));
	}

}
