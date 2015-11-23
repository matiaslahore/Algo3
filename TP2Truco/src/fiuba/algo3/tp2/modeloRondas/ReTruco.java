package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeNoQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;

public class ReTruco extends TiposDeCanto{

	@Override
	public int quiso() {
		return 3;
	}

	@Override
	public int noQuiso() {
		return 2;
	}

}
