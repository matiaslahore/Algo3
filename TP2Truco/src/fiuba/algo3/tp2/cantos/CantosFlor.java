package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public abstract class CantosFlor {
	Equipo equipoQueCanta;
	
	public CantosFlor(Equipo equipoQueCanta){
		this.equipoQueCanta = equipoQueCanta;
	}
	
	public abstract CantosFlor cantarFlor(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract CantosFlor cantarContraFlor(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract CantosFlor cantarContraFlorAJuego(Equipo equipoQueCanta) throws CantoInvalidoException;
	
	public abstract int noQuiso();
	
	public abstract int quiso();
}
