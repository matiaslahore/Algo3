package fiuba.algo3.tp2.modelo;

public interface OyenteJuez {

	public void jugadorQuisoTruco();
	
	public void jugadorQuisoReTruco();
	
	public void jugadorQuisoValeCuatro();
	
	public void jugadorQuisoEnvido();
	
	public void seComenzoRondaUno();
	
	public void seTerminoRondaUno();

	public abstract void jugadorCantoEnvido(Equipo equipoQueCanta);
	
	public abstract void jugadorCantoEnvidoEnvido(Equipo equipoQueCanta);
	
	public abstract void jugadorCantoRealEnvido(Equipo equipoQueCanta);
	
	public abstract void jugadorCantoFaltaEnvido(Equipo equipoQueCanta);

}
