package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.cantosPosibles.CantaronContraFlor;
import fiuba.algo3.tp2.cantosPosibles.CantaronFlor;

public interface OyenteJuez {

	public void jugadorQuisoTruco();
	
	public void jugadorQuisoReTruco();
	
	public void jugadorQuisoValeCuatro();
	
	public void jugadorQuisoEnvido();
	
	public void seComenzoRondaUno();
	
	public void seTerminoRondaUno();

	public void jugadorCantoEnvido(Equipo equipoQueCanta);
	
	public void jugadorCantoEnvidoEnvido(Equipo equipoQueCanta);
	
	public void jugadorCantoRealEnvido(Equipo equipoQueCanta);
	
	public void jugadorCantoFaltaEnvido(Equipo equipoQueCanta);

	public void jugadorCantoFlor(Equipo equipoQueCanta);
	
	public void jugadorCantoContraFlor(Equipo equipoQueCanta);
	
	public void jugadorCantoContraFlorAJuego(Equipo equipoQueCanta);

}
