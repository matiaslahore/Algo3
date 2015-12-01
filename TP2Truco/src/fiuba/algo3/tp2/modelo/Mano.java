package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.tp2.excepciones.CartaInexistenteEnManoDeJugadorExeption;
import fiuba.algo3.tp2.modeloDeCartas.Carta;

public class Mano {

	List<Carta> cartas = new ArrayList();
	
	public Mano(List<Carta> listaDeCartas){
		this.cartas = listaDeCartas;
	}
	
	public void tirarCarta(Carta unaCarta) {
		try{
			this.cartas.remove(this.cartas.lastIndexOf(unaCarta));			
		}catch(ArrayIndexOutOfBoundsException e){
			throw new CartaInexistenteEnManoDeJugadorExeption();
		}
	}
		
	public int calcularEnvido(){
		Carta cartaUno = cartas.get(0);
		Carta cartaDos = cartas.get(1);
		Carta cartaTres = cartas.get(2);
		return Math.max(Math.max(cartaUno.sumarTanto(cartaDos), cartaUno.sumarTanto(cartaTres)), cartaTres.sumarTanto(cartaDos));
	}

	public Carta tirarCarta (int numero){//este seria el que hay q implementar
		Carta carta =cartas.get(numero);
		cartas.remove(numero);
		return carta;
	}

	public int calcularPuntosFlor() {
		if (tieneFlor()) {
			Carta cartaUno = cartas.get(0);
			Carta cartaDos = cartas.get(1);
			Carta cartaTres = cartas.get(2);
			return (cartaUno.sumarTantosConFlor(cartaDos, cartaTres));
		}
		else return 0;
	}

	public String verCartasEnManoComoString() {
		String cartasComoString = "| ";
		for (Carta unaCarta : cartas){
			cartasComoString += unaCarta.cartaComoString() + " | ";
		}
		return cartasComoString;
	}
	
	public List<Carta> obtenerCartas (){
		return this.cartas;
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

	public Carta obtenerCarta(Carta unaCarta) {
		try{
			return this.cartas.get(this.cartas.lastIndexOf(unaCarta));			
		}catch(ArrayIndexOutOfBoundsException e){
			throw new CartaInexistenteEnManoDeJugadorExeption();
		}
	}

	public boolean tieneFlor() {
		Carta cartaUno = cartas.get(0);
		Carta cartaDos = cartas.get(1);
		Carta cartaTres = cartas.get(2);
		
		if (cartaUno.sumarTanto(cartaDos) > 7) {
			if (cartaUno.sumarTanto(cartaTres) > 7) {
				if (cartaDos.sumarTanto(cartaTres) > 7)
					return true;
			}
		}
		return false;
	}
	
}
