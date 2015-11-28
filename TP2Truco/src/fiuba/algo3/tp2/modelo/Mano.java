package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;
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

	public int calcularPuntosEnvidoConFlor() {
		Carta cartaUno = cartas.get(0);
		Carta cartaDos = cartas.get(1);
		Carta cartaTres = cartas.get(2);
		return (cartaUno.sumarTantosConFlor(cartaDos, cartaTres));
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
	
	public Carta obtenerCartaAleatoria() {
		int index = (int) (Math.random() * (cartas.size()));
		return cartas.get(index);
	}

	public Carta obtenerMejorCartaParaJugarContra(Carta cartaDelContrario) {
		
		List<Carta> cartasQueMatan = new ArrayList<Carta>();
		
		for (Carta unaCarta : cartas){	
			if (cartaDelContrario != unaCarta.vs(cartaDelContrario)){
				cartasQueMatan.add(unaCarta.vs(cartaDelContrario));
			}
		}
		switch (cartasQueMatan.size()){
			
			case 0:
				return this.obtenerCartaMasBaja();
			case 1:
				return cartasQueMatan.get(0);
			case 2: 
				cartasQueMatan.remove(cartasQueMatan.get(0).vs(cartasQueMatan.get(1)));
				return cartasQueMatan.get(0);
		}
		cartasQueMatan.remove(cartasQueMatan.get(0).vs(cartasQueMatan.get(1)));
		cartasQueMatan.remove(cartasQueMatan.get(0).vs(cartasQueMatan.get(1)));
		return cartasQueMatan.get(0);
	}

	private Carta obtenerCartaMasBaja() {
		List<Carta> copiaCartas = new ArrayList<Carta>();
		copiaCartas = this.cartas;
		copiaCartas.remove(copiaCartas.get(0).vs(copiaCartas.get(1)));
		copiaCartas.remove(copiaCartas.get(0).vs(copiaCartas.get(1)));
		return copiaCartas.get(0);
	}
}
