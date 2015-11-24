package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeNoQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class TiposDeCantoTruco {
	String equipoQueCanta;
	
	public TiposDeCantoTruco(String equipo){
		equipoQueCanta = equipo;
	}
	
	public void cantar(String equipo)throws EquipoQueCantaNoPuedeVolverACantarException{
		if(this.equipoQueCanta == equipo)
			throw new EquipoQueCantaNoPuedeVolverACantarException();
		this.equipoQueCanta = equipo;
	}
	
	public abstract int quiso();
	
	public abstract int noQuiso();
	
}