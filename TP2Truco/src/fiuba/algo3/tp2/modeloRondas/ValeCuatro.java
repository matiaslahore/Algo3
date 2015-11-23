package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeNoQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;

public class ValeCuatro extends TiposDeCanto{
	
	@Override
	public int quiso() {
		return 4;
	}

	@Override
	public int noQuiso() {
		return 3;
	}

}
