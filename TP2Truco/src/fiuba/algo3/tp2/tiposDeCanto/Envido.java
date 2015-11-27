package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.modelo.Equipo;

public class Envido extends TiposDeCantoEnvido{
	
	public Envido(Equipo equipoQueCanta){
		super(equipoQueCanta);
	}
	
	@Override
	public EnvidoEnvido cantarEnvido(Equipo equipoQueCanta){
		return(new EnvidoEnvido(equipoQueCanta));
	}
	
	public EnvidoRealEnvido cantarRealEnvido(Equipo equipoQueCanta){
		return(new EnvidoRealEnvido(equipoQueCanta));
	}

	@Override
	public EnvidoFaltaEnvido cantarFaltaEnvido(Equipo equipoQueCanta) {
		return(new EnvidoFaltaEnvido(equipoQueCanta));
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