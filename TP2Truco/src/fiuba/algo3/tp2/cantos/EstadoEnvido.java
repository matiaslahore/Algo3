package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.modelo.Equipo;

public class EstadoEnvido extends EstadoCantoEnvido{
	
	public EstadoEnvido(Equipo equipoQueCanta){
		super(equipoQueCanta);
	}
	
	@Override
	public EstadoEnvidoEnvido cantarEnvido(Equipo equipoQueCanta){
		return(new EstadoEnvidoEnvido(equipoQueCanta));
	}
	
	public EstadoEnvidoRealEnvido cantarRealEnvido(Equipo equipoQueCanta){
		return(new EstadoEnvidoRealEnvido(equipoQueCanta));
	}

	@Override
	public EstadoEnvidoFaltaEnvido cantarFaltaEnvido(Equipo equipoQueCanta) {
		return(new EstadoEnvidoFaltaEnvido(equipoQueCanta));
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