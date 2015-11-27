package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.Equipo;

public abstract class TiposDeCantoTruco {
	Equipo equipoQueCanta;
	
	public TiposDeCantoTruco(Equipo equipo){
		equipoQueCanta = equipo;
	}
	
	public abstract TiposDeCantoTruco cantar(Equipo equipo) throws EquipoQueCantaNoPuedeVolverACantarException, CantoInvalidoException;
	
	public abstract int quiso();
	
	public abstract int noQuiso();
	
}