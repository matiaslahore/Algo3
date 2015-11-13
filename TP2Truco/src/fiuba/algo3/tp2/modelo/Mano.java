package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class Mano {

	TipoDeCartas cartaUno;
	TipoDeCartas cartaDos;
	TipoDeCartas cartaTres;
	
	public Mano(TipoDeCartas cartaUno,TipoDeCartas cartaDos,TipoDeCartas cartaTres){
		
		this.cartaUno = cartaUno;
		this.cartaDos = cartaDos;
		this.cartaTres = cartaTres;
	}
	
}
