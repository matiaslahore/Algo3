package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;

public class Truco extends TipoDeCantos{

	@Override
	public void canto(String equipo)throws EquipoQueCantaNoPuedeQuererElCantoException{
		if(this.equipoQueCanta == equipo)
			throw new EquipoQueCantaNoPuedeQuererElCantoException();
		this.equipoQueCanta = equipo;
	}

	@Override
	public void quiero() {
		//ver
	}

	@Override
	public void noQuiero() {
		//se va al mazo
	}

}
