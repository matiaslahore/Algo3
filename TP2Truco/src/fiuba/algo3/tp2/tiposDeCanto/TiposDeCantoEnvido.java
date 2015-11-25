package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public abstract class TiposDeCantoEnvido {
	String equipoQueCanta;
	
	public TiposDeCantoEnvido(String equipoQueCanta){
		this.equipoQueCanta = equipoQueCanta;
	}
	
	public abstract TiposDeCantoEnvido cantarEnvido(String equipoQueCanta) throws CantoInvalidoException;
	
	public abstract TiposDeCantoEnvido cantarRealEnvido(String equipoQueCanta) throws CantoInvalidoException;
	
	public abstract TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta) throws CantoInvalidoException;
	
	public abstract int noQuiso();
	
	public abstract int quiso();
}
