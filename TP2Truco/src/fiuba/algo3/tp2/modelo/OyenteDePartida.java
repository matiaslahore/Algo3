package fiuba.algo3.tp2.modelo;

public interface OyenteDePartida {
	
	public void seCantoEnvidoEnvido();
	
	public void seCantoRealEnvido();

	public void seCantoTruco();

	public void seQuisoTruco();

	public void noSeQuisoTruco();

	public void seCantoFlor();

	void seCantoContraFlorAJuego();

	void seCantoContraFlor();

	void seCantoFaltaEnvido();

	void seCantoEnvido();

	void seCantoValeCuatro();

	void seCantoReTruco();
	
}
