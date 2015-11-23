package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;

public abstract class TipoDeCantos {

	String equipoQueCanta;
	
	public TipoDeCantos(){
		equipoQueCanta = "";
	}
	
	public abstract void canto(String equipo)throws EquipoQueCantaNoPuedeQuererElCantoException;
	
	public abstract void quiero();
	
	public abstract void noQuiero();

	public String equipoQueCanta() {
		return this.equipoQueCanta;
	}
	
}
