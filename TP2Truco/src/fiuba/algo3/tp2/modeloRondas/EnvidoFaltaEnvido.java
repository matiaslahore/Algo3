package fiuba.algo3.tp2.modeloRondas;

public class EnvidoFaltaEnvido extends TiposDeCantoEnvido {

	public EnvidoFaltaEnvido(String equipoQueCanta) {
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
		return 2;
	}

	@Override
	public int quiso() {
		return 0;
		//ver como saber los puntos cuando se canta la faltaEnvido
	}

}
