package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeNoQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;

public class Truco extends TiposDeCantoTruco{
	
	public Truco(String equipo) {
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
	public ReTruco cantar(String equipo) throws EquipoQueCantaNoPuedeVolverACantarException {
		if(this.equipoQueCanta == equipo){
			throw new EquipoQueCantaNoPuedeVolverACantarException();
		}
		return(new ReTruco(equipo));
	}

}
