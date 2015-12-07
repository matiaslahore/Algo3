package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.modelo.Equipo;

public class EstadoInicialEnvido extends EstadoCantoEnvido{

	public EstadoInicialEnvido() {
		super(null);
	}

	@Override
	public EstadoCantoEnvido cantarEnvido(Equipo equipoQueCanta){
		return new EstadoEnvido(equipoQueCanta);
	}

	@Override
	public EstadoCantoEnvido cantarRealEnvido(Equipo equipoQueCanta){
		return new EstadoRealEnvido(equipoQueCanta);
	}

	@Override
	public EstadoCantoEnvido cantarFaltaEnvido(Equipo equipoQueCanta){
		return new EstadoFaltaEnvido(equipoQueCanta);
	}

	@Override
	public int noQuiso() {
		return 0;
	}

	@Override
	public int quiso() {
		return 0;
	}

}
