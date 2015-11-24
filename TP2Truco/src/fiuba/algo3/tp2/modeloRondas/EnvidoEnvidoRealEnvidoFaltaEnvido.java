package fiuba.algo3.tp2.modeloRondas;

public class EnvidoEnvidoRealEnvidoFaltaEnvido extends TiposDeCantoEnvido {

	public EnvidoEnvidoRealEnvidoFaltaEnvido(String equipoQueCanta) {
		super(equipoQueCanta);
	}

	@Override
	public TiposDeCantoEnvido cantarEnvido(String equipoQueCanta) {
		return null;
	}

	@Override
	public TiposDeCantoEnvido cantarRealEnvido(String equipoQueCanta) {
		return null;
	}

	@Override
	public TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta) {
		return null;
	}

	@Override
	public int noQuiso() {
		return 8;
	}

	@Override
	public int quiso() {
		return 0;
		//ver como saber los puntos cuando se canta la faltaEnvido
	}

}
