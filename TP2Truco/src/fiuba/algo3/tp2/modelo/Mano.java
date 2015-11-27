package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.excepciones.CartaInexistenteEnManoDeJugador;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class Mano {

	List<TipoDeCartas> cartas;
	
	//este lo deje para que no rompa los test pero habria que sacarlo
	public Mano(TipoDeCartas cartaUno,TipoDeCartas cartaDos,TipoDeCartas cartaTres){
		this.cartas = new ArrayList<TipoDeCartas>();
		this.cartas.add(cartaUno);
		this.cartas.add(cartaDos);
		this.cartas.add(cartaTres);
	}
	
	public Mano(List<TipoDeCartas> listaDeCartas){
		this.cartas = new ArrayList<TipoDeCartas>();
		this.cartas = listaDeCartas;
	}
	
	public TipoDeCartas obtenerCarta(TipoDeCartas unaCarta) {
		try {
			return this.cartas.get(this.cartas.lastIndexOf(unaCarta));
		} catch (ArrayIndexOutOfBoundsException e){
			throw new CartaInexistenteEnManoDeJugador();
		}
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
	
	public TipoDeCartas returnSegunda() {
		TipoDeCartas carta = cartas.get(1);
		cartas.remove(1);
		return carta;
	}
	
	public TipoDeCartas returnTercera() {
		TipoDeCartas carta = cartas.get(2);
		cartas.remove(2);
		return carta;
	}
	
	public List<TipoDeCartas> returnCartas(){
		return this.cartas;
	}

	public int calcularPuntosEnvidoConFlor() {
		TipoDeCartas cartaUno = cartas.get(0);
		TipoDeCartas cartaDos = cartas.get(1);
		TipoDeCartas cartaTres = cartas.get(2);
		return (cartaUno.sumarTantosConFlor(cartaDos, cartaTres));
	}

	public TipoDeCartas tirar(int n) {
		TipoDeCartas carta = cartas.get(n-1);
		cartas.remove(n-1);
		return carta;
	}

	public String verCartasEnManoComoString() {
		String cartasComoString = "| ";
		for (TipoDeCartas unaCarta : cartas){
			cartasComoString += unaCarta.cartaComoString() + " | ";
		}
		return cartasComoString;
	}
	
	public int returnCantidadDeCartas(){
		return this.cartas.size();
	}	
}
