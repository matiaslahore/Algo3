package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.modelo.Equipo;

public abstract class EstadoCantoTruco {
	Equipo equipoQueCanta;
	
	public EstadoCantoTruco(Equipo equipo){
		equipoQueCanta = equipo;
	}
		
	public abstract int quiso();
	
	public abstract int noQuiso();

	public abstract EstadoCantoTruco cantarTruco(Equipo equipo);
	
	public abstract EstadoCantoTruco cantarQuieroReTruco(Equipo equipo);
	
	public abstract EstadoCantoTruco cantarQuieroValeCuatro(Equipo equipo);
	
}