package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.EventosJuez;

public abstract class EstadoCantoFlor {
	Equipo equipoQueCanta;
	
	public EstadoCantoFlor(Equipo equipoQueCanta){
		this.equipoQueCanta = equipoQueCanta;
	}
	
	public abstract EstadoCantoFlor cantarFlor(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract EstadoCantoFlor cantarContraFlor(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract EstadoCantoFlor cantarContraFlorAJuego(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract int noQuiso();
	
	public abstract int quiso();
	
	public Equipo equipoQueCanta(){
		return this.equipoQueCanta;
	}

	public abstract void avisarAPartida(EventosJuez eventosJuez);
	
}
