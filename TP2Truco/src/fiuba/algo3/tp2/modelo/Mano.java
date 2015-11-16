package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class Mano {

	TipoDeCartas cartaUno;
	TipoDeCartas cartaDos;
	TipoDeCartas cartaTres;
	
	public Mano(TipoDeCartas cartaUno,TipoDeCartas cartaDos,TipoDeCartas cartaTres){
		//VER SI ES MEJOR LA LISTA!!!!!!!!!!!!!!!!
		this.cartaUno = cartaUno;
		this.cartaDos = cartaDos;
		this.cartaTres = cartaTres;
	}
	
	public int calcularEnvido(){
		return Math.max(Math.max(cartaUno.sumarTanto(cartaDos), cartaUno.sumarTanto(cartaTres)), cartaTres.sumarTanto(cartaDos));
	}

	public TipoDeCartas returnPrimera() {
		return cartaUno;
	}

	public int calcularPuntosEnvidoConFlor() {
		// Una vez q nico suba lo q hizo el termino esto.. xq hay varias formas
		// de hacerlo.
		//int puntos = cartaUno.sumarTanto(cartaDos) + cartaTres.valorTanto();
		return 0;
	}
	
}
