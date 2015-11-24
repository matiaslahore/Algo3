package fiuba.algo3.tp2.modeloRondas;

public class Envido extends TiposDeCantoEnvido{
	
	public Envido(String equipoQueCanta){
		super(equipoQueCanta);
	}
	
	@Override
	public EnvidoEnvido cantarEnvido(String equipoQueCanta){
		return(new EnvidoEnvido(equipoQueCanta));
	}
	
	public EnvidoRealEnvido cantarRealEnvido(String equipoQueCanta){
		return(new EnvidoRealEnvido(equipoQueCanta));
	}

	@Override
	public TiposDeCantoEnvido cantarFaltaEnvido(String equipoQueCanta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int noQuiso() {
		return 1;
	}

	@Override
	public int quiso() {
		return 2;
	}
}