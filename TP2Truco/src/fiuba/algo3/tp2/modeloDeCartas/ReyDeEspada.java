package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Espada;
import fiuba.algo3.tp2.modelo.Palo;

public class ReyDeEspada extends Rey {
	
	Palo palo;
	
	public ReyDeEspada(){
		
		palo = new Espada();
	}
}
