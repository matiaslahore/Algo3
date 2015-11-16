package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class Mano {

	ArrayList<TipoDeCartas> cartas;
	
	public Mano(TipoDeCartas cartaUno,TipoDeCartas cartaDos,TipoDeCartas cartaTres){
		this.cartas = new ArrayList<TipoDeCartas>();
		this.cartas.add(cartaUno);
		this.cartas.add(cartaDos);
		this.cartas.add(cartaTres);
	}
	
	public int calcularEnvido(){
		TipoDeCartas cartaUno = cartas.get(0);
		TipoDeCartas cartaDos = cartas.get(1);
		TipoDeCartas cartaTres = cartas.get(2);
		return Math.max(Math.max(cartaUno.sumarTanto(cartaDos), cartaUno.sumarTanto(cartaTres)), cartaTres.sumarTanto(cartaDos));
	}

	public TipoDeCartas returnPrimera() {
		TipoDeCartas carta = cartas.get(0);
		cartas.remove(0);
		return carta;
	}

	public int calcularPuntosEnvidoConFlor() {
		// Una vez q nico suba lo q hizo el termino esto.. xq hay varias formas
		// de hacerlo.
		//int puntos = cartaUno.sumarTanto(cartaDos) + cartaTres.valorTanto();
		return 0;
	}
	
}
