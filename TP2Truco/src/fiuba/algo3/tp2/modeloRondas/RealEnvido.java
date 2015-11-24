package fiuba.algo3.tp2.modeloRondas;

public class RealEnvido extends TiposDeCantoEnvido{
	
	public RealEnvido(String equipoQueCanta){
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
		return(new RealEnvidoFaltaEnvido(equipoQueCanta));
	}

	@Override
	public int noQuiso() {
		return 1;
	}

	@Override
	public int quiso() {
		return 3;
	}
}