package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.modelo.Equipo;

public abstract class EstadoCantoEnvido {
	Equipo equipoQueCanta;
	
	public EstadoCantoEnvido(Equipo equipoQueCanta){
		this.equipoQueCanta = equipoQueCanta;
	}
	
	public abstract EstadoCantoEnvido cantarEnvido(Equipo equipoQueCanta);
	
	public abstract EstadoCantoEnvido cantarRealEnvido(Equipo equipoQueCanta);
	
	public abstract EstadoCantoEnvido cantarFaltaEnvido(Equipo equipoQueCanta);
	
	public abstract int noQuiso();
	
	public abstract int quiso(int puntajeEquipoGanador, int puntajeEquipoPerdedor);

}
