package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeNoQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class TiposDeCanto {

	String equipoQueCanta;
	
	public TiposDeCanto(){
		equipoQueCanta = "";
	}
	
	public void canto(String equipo)throws EquipoQueCantaNoPuedeQuererElCantoException{
		if(this.equipoQueCanta == equipo){
			throw new EquipoQueCantaNoPuedeQuererElCantoException(); //aca es equipo q canta no puede cantar de nuevo
		}
		this.equipoQueCanta = equipo;
	}
	
	public void equipoQueCanta(String equipo) {
		this.equipoQueCanta = equipo;
	}
	
	public abstract int quiso();
	
	public abstract int noQuiso();
	
}