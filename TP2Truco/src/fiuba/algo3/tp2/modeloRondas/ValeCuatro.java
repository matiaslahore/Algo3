package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeNoQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;

public class ValeCuatro extends TiposDeCanto{
	
	@Override
	public int noQuiero(String equipo)throws EquipoQueCantaNoPuedeNoQuererElCantoException{
		if(equipoQueCanta == equipo)
			throw new EquipoQueCantaNoPuedeNoQuererElCantoException();
		return 3;
	}

}
