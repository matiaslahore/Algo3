package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Oro;
import fiuba.algo3.tp2.modelo.Palo;

public class CaballoDeOro extends Caballo{

	Palo palo;
	
	public CaballoDeOro(){
		
		palo = new Oro();
	}
}
