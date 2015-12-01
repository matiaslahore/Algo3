package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.Equipo;

public abstract class CantosTruco {
	Equipo equipoQueCanta;
	
	public CantosTruco(Equipo equipo){
		equipoQueCanta = equipo;
	}
	
	public abstract CantosTruco cantar(Equipo equipo) throws EquipoQueCantaNoPuedeVolverACantarException, CantoInvalidoException;
	
	public abstract int quiso();
	
	public abstract int noQuiso();
	
}