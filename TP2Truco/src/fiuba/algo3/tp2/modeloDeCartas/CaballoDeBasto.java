package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Basto;
import fiuba.algo3.tp2.modelo.Palo;

public class CaballoDeBasto extends Caballo{
	
	Palo palo;
	
	public CaballoDeBasto(){
		
		palo = new Basto();
	}
}
