package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeNoQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;

public class Truco extends TiposDeCanto{
	
	@Override
	public int quiso() {
		return 2;
	}

	@Override
	public int noQuiso() {
		return 1;
	}

}
