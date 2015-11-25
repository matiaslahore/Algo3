package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeNoQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class TiposDeCantoTruco {
	String equipoQueCanta;
	
	public TiposDeCantoTruco(String equipo){
		equipoQueCanta = equipo;
	}
	
	public abstract TiposDeCantoTruco cantar(String equipo) throws EquipoQueCantaNoPuedeVolverACantarException, CantoInvalidoException;
	
	public abstract int quiso();
	
	public abstract int noQuiso();
	
}