package fiuba.algo3.tp2.modeloRondas;

public class EnvidoEnvido extends TiposDeCantoEnvido{

	public EnvidoEnvido(String equipoQueCanta){
		super(equipoQueCanta);
	}
	
	@Override
	public TiposDeCantoEnvido cantarEnvido(String equipoQueCanta) {
		return null;
	}
	
	@Override
	public TiposDeCantoEnvido cantarRealEnvido(String equipoQueCanta) {
		return(new EnvidoEnvidoRealEnvido(equipoQueCanta));
	}

	@Override
	public TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta) {
		return(new EnvidoEnvidoFaltaEnvido(equipoQueCanta));
	}

	@Override
	public int noQuiso() {
		return 2;
	}

	@Override
	public int quiso() {
		return 4;
	}

}
