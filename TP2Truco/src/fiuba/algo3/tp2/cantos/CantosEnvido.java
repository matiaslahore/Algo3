package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public abstract class CantosEnvido {
	Equipo equipoQueCanta;
	
	public CantosEnvido(Equipo equipoQueCanta){
		this.equipoQueCanta = equipoQueCanta;
	}
	
	public abstract CantosEnvido cantarEnvido(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract CantosEnvido cantarRealEnvido(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract CantosEnvido cantarFaltaEnvido(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract int noQuiso();
	
	public abstract int quiso();
}
