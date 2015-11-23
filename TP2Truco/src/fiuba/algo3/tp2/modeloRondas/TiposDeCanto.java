package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
import fiuba.algo3.tp2.modeloJugador.Jugador;

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
	
	public void quiero(String equipo)throws EquipoQueCantaNoPuedeQuererElCantoException{
		if(equipo == this.equipoQueCanta)
			throw new EquipoQueCantaNoPuedeQuererElCantoException();
	}

	public abstract void noQuiero();

	public String equipoQueCanta() {
		return this.equipoQueCanta;
	}
	
}