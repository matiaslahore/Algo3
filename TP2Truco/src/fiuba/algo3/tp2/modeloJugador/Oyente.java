package fiuba.algo3.tp2.modeloJugador;

public interface Oyente {

	public void seCantoTruco();

	public void seCantoReTruco();
	
	public void seCantoValeCuatro();
	
	public void seCantoEnvido();
	
	public void seCantoRealEnvido();
	
	public void seCantoFaltaEnvido();
	
	public void seCantoFlor();
	
	public void seCantoContraFlor();
	
	public void seCantoContraFlorAJuego();

	public void hacerJugarIA();
	
	public void seFueAlMazo();

	public void IACantoTruco();
}
