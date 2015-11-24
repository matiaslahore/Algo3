package fiuba.algo3.tp2.modeloRondas;

public abstract class TiposDeCantoEnvido {
	String equipoQueCanta;
	
	public TiposDeCantoEnvido(String equipoQueCanta){
		this.equipoQueCanta = equipoQueCanta;
	}
	
	public abstract TiposDeCantoEnvido cantarEnvido(String equipoQueCanta); //hacer que devuelva excepcion.
	// por si canta algo indevido en alguna clase hija, si llega a esta altura el canto no era valido y tira cantoNoValidoException
	
	public abstract TiposDeCantoEnvido cantarRealEnvido(String equipoQueCanta);
	
	public abstract TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta);
	
	public abstract int noQuiso();
	
	public abstract int quiso();
}
