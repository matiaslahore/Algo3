package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public abstract class TiposDeCantoEnvido {
	Equipo equipoQueCanta;
	
	public TiposDeCantoEnvido(Equipo equipoQueCanta){
		this.equipoQueCanta = equipoQueCanta;
	}
	
	public abstract TiposDeCantoEnvido cantarEnvido(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract TiposDeCantoEnvido cantarRealEnvido(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract TiposDeCantoEnvido cantarFaltaEnvido(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract int noQuiso();
	
	public abstract int quiso();
}
