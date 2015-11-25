package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public abstract class TiposDeCantoFlor {
	String equipoQueCanta;
	
	public TiposDeCantoFlor(String equipoQueCanta){
		this.equipoQueCanta = equipoQueCanta;
	}
	
	public abstract TiposDeCantoFlor cantarFlor(String equipoQueCanta) throws CantoInvalidoException;
	
	public abstract TiposDeCantoFlor cantarContraFlor(String equipoQueCanta) throws CantoInvalidoException;
	
	public abstract TiposDeCantoFlor cantarContraFlorAJuego(String equipoQueCanta) throws CantoInvalidoException;
	
	public abstract int noQuiso();
	
	public abstract int quiso();
}
