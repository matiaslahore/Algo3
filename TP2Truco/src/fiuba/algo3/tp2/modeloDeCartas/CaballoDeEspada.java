package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Espada;
import fiuba.algo3.tp2.modelo.Palo;

public class CaballoDeEspada extends Caballo{
	
	Palo palo;
	
	public CaballoDeEspada(){
		
		palo = new Espada();
	}
}
