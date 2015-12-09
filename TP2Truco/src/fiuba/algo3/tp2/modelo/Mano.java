package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.excepciones.CartaInexistenteEnManoDeJugadorExeption;
import fiuba.algo3.tp2.excepciones.JugadorNoTieneMasCartasParaJugarException;
import fiuba.algo3.tp2.excepciones.JugadorYaNoTieneMasCartasException;
import fiuba.algo3.tp2.modeloDeCartas.Carta;

public class Mano {

	List<Carta> cartas;
	
	public Mano(List<Carta> listaDeCartas){
		this.cartas = new ArrayList<Carta>();
		this.cartas = listaDeCartas;
	}
	
	public boolean contieneCarta(Carta unaCarta) {
		try{
			return this.cartas.contains(unaCarta);
		}catch(ArrayIndexOutOfBoundsException e){
			throw new CartaInexistenteEnManoDeJugadorExeption();
		}
	}
	
	public void borrarCarta(Carta unaCarta) {

		this.cartas.remove(this.cartas.lastIndexOf(unaCarta));
	}	
		
	public int calcularEnvido(){
		Carta cartaUno = cartas.get(0);
		Carta cartaDos = cartas.get(1);
		Carta cartaTres = cartas.get(2);
		return Math.max(Math.max(cartaUno.sumarEnvido(cartaDos), cartaUno.sumarEnvido(cartaTres)), cartaTres.sumarEnvido(cartaDos));
	}

	public int calcularPuntosFlor() {
		if (this.tieneFlor()) {
			Carta cartaUno = cartas.get(0);
			Carta cartaDos = cartas.get(1);
			Carta cartaTres = cartas.get(2);
			return cartaUno.sumarFlor(cartaDos, cartaTres);
		}
		return 0;
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
		switch (copiaCartas.size()){
			case 1:
				return copiaCartas.get(0);
			case 2:
				copiaCartas.remove(copiaCartas.get(0).vs(copiaCartas.get(1)));
				return copiaCartas.get(0);
			case 3:
				copiaCartas.remove(copiaCartas.get(0).vs(copiaCartas.get(1)));
				copiaCartas.remove(copiaCartas.get(0).vs(copiaCartas.get(1)));
				return copiaCartas.get(0);
		}	
		throw new JugadorNoTieneMasCartasParaJugarException();
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
		return (cartaUno.sumarEnvido(cartaDos)>= 20 && cartaDos.sumarEnvido(cartaTres)>= 20);		
	}

	public Carta obtenerCartaMasAltaParaTruco() {
		
		try{
			Carta mejorCarta = this.cartas.get(0);
			for(Carta unaCarta : this.cartas){
				mejorCarta = unaCarta.vs(mejorCarta);
			}
			return mejorCarta;
		}catch(IndexOutOfBoundsException e){
			throw new JugadorYaNoTieneMasCartasException();
		}
	}
	
}
