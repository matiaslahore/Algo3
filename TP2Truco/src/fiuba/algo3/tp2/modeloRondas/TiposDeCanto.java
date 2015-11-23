package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;

public abstract class TiposDeCanto {

	String equipoQueCanta;
	
	public TiposDeCanto(){
		equipoQueCanta = "";
	}
	
	public void canto(String equipo)throws EquipoQueCantaNoPuedeQuererElCantoException{
		if(this.equipoQueCanta == equipo)
			throw new EquipoQueCantaNoPuedeQuererElCantoException();
		this.equipoQueCanta = equipo;
	}
	
	public abstract void quiero();
	
	public abstract void noQuiero();

	public String equipoQueCanta() {
		return this.equipoQueCanta;
	}
	
}