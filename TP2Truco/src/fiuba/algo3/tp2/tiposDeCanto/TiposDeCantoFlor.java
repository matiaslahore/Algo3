package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public abstract class TiposDeCantoFlor {
	Equipo equipoQueCanta;
	
	public TiposDeCantoFlor(Equipo equipoQueCanta){
		this.equipoQueCanta = equipoQueCanta;
	}
	
	public abstract TiposDeCantoFlor cantarFlor(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract TiposDeCantoFlor cantarContraFlor(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract TiposDeCantoFlor cantarContraFlorAJuego(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract int noQuiso();
	
	public abstract int quiso();
}
