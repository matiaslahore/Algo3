package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Basto;
import fiuba.algo3.tp2.modelo.Palo;

public class ReyDeBasto extends Rey {
	
	Palo palo;
	
	public ReyDeBasto(){
		
		palo = new Basto();
	}
}
