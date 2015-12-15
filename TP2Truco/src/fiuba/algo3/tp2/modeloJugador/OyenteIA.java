package fiuba.algo3.tp2.modeloJugador;

public interface OyenteIA {
	
	public void meCantaronEnvido();

	public void meCantaronRealEnvido();
	
	public void meCantaronFaltaEnvido();
	
	public void meCantaronTruco();
	
	public void meCantaronReTruco();

	public void meCantaronValeCuatro();

	public void meCantaronFlor();

	public void meCantaronContraFlor();

	public void meCantaronContraFlorAJuego();
	
	public void modificarMensajesIa(String mensaje);

}
