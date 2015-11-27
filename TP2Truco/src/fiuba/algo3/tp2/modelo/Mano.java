package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.excepciones.CartaInexistenteEnManoDeJugador;
import fiuba.algo3.tp2.modeloDeCartas.Carta;

public class Mano {

	List<Carta> cartas;
	
	//este lo deje para que no rompa los test pero habria que sacarlo
	public Mano(Carta cartaUno,Carta cartaDos,Carta cartaTres){
		this.cartas = new ArrayList<Carta>();
		this.cartas.add(cartaUno);
		this.cartas.add(cartaDos);
		this.cartas.add(cartaTres);
	}
	
	public Mano(List<Carta> listaDeCartas){
		this.cartas = new ArrayList<Carta>();
		this.cartas = listaDeCartas;
	}
	
	public Carta obtenerCarta(Carta unaCarta) {
		try {
			return this.cartas.get(this.cartas.lastIndexOf(unaCarta));
		} catch (ArrayIndexOutOfBoundsException e){
			throw new CartaInexistenteEnManoDeJugador();
		}
	}
	
	public int calcularEnvido(){
		Carta cartaUno = cartas.get(0);
		Carta cartaDos = cartas.get(1);
		Carta cartaTres = cartas.get(2);
		return Math.max(Math.max(cartaUno.sumarTanto(cartaDos), cartaUno.sumarTanto(cartaTres)), cartaTres.sumarTanto(cartaDos));
	}

	public Carta returnPrimera() {
		Carta carta = cartas.get(0);
		cartas.remove(0);
		return carta;
	}
	
	public Carta returnSegunda() {
		Carta carta = cartas.get(1);
		cartas.remove(1);
		return carta;
	}
	
	public Carta returnTercera() {
		Carta carta = cartas.get(2);
		cartas.remove(2);
		return carta;
	}
	
	public List<Carta> returnCartas(){
		return this.cartas;
	}

	public int calcularPuntosEnvidoConFlor() {
		Carta cartaUno = cartas.get(0);
		Carta cartaDos = cartas.get(1);
		Carta cartaTres = cartas.get(2);
		return (cartaUno.sumarTantosConFlor(cartaDos, cartaTres));
	}

	public Carta tirar(int n) {
		Carta carta = cartas.get(n-1);
		cartas.remove(n-1);
		return carta;
	}

	public String verCartasEnManoComoString() {
		String cartasComoString = "| ";
		for (Carta unaCarta : cartas){
			cartasComoString += unaCarta.cartaComoString() + " | ";
		}
		return cartasComoString;
	}
	
	public int returnCantidadDeCartas(){
		return this.cartas.size();
	}	
}
