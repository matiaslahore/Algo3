package fiuba.algo3.tp2.modeloRondas;

import fiuba.algo3.tp2.excepciones.CantoInvalidoExcepcion;

public abstract class TiposDeCantoEnvido {
	String equipoQueCanta;
	
	public TiposDeCantoEnvido(String equipoQueCanta){
		this.equipoQueCanta = equipoQueCanta;
	}
	
	public abstract TiposDeCantoEnvido cantarEnvido(String equipoQueCanta) throws CantoInvalidoExcepcion;
	
	public abstract TiposDeCantoEnvido cantarRealEnvido(String equipoQueCanta) throws CantoInvalidoExcepcion;
	
	public abstract TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta) throws CantoInvalidoExcepcion;
	
	public abstract int noQuiso();
	
	public abstract int quiso();
}
