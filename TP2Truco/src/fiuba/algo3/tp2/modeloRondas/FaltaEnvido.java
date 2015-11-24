package fiuba.algo3.tp2.modeloRondas;

public class FaltaEnvido extends TiposDeCantoEnvido{
	
	public FaltaEnvido(String equipoQueCanta){
		super(equipoQueCanta);
	}
	
	@Override
	public EnvidoEnvido cantarEnvido(String equipoQueCanta){
		return null;
	}
	
	public EnvidoRealEnvido cantarRealEnvido(String equipoQueCanta){
		return null;
	}

	@Override
	public TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta) {
		return null;
	}

	@Override
	public int noQuiso() {
		return 1;
	}

	@Override
	public int quiso() {
		return 0;
		//ver como contabilizar los puntos
	}
}