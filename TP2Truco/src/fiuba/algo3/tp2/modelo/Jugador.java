package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fiuba.algo3.tp2.modeloDeCartas.*;

public class Jugador {

	String nombre;
	String equipo;
	Mano manoDelJugador;
	Mesa refMesa;

	public Jugador(String name, Mesa mesa){
		nombre = name;
		refMesa = mesa;
	}

	public void recibirCartas(TipoDeCartas c1, TipoDeCartas c2, TipoDeCartas c3){
		manoDelJugador = new Mano(c1,c2,c3);
	}
	
	/* ESTA ES LA QUE VA A IR A LO ULTIMO
	 * public Carta jugarCarta(int n){
		Carta actual = cartas.get(n-1); //-1 xq sino no da el index
		cartas.remove(n-1);
		return actual;
	}*/
	
	//NO SIRVE MAS.. O HABRIA Q CAMBIARLA CON LO Q DICE ABAJO
	/*public String verCartasEnManoComoString() {
		///////////////////////////////////////////////////////////////////
		AHORA ESTA NO SIRVE.. XQ HABRIA Q HACER PARA CADA CARTA ESTO
		Ejemplo AnchoDeEspada
		public String verCartaComoString(){
			return "Ancho de espada";
		}
		///////////////////////////////////////////////////////////////////
		
		String cartasComoString = "";
		for (Carta unaCarta : cartas){
			
			cartasComoString += unaCarta.obtenerCartaComoString();
		}
		return cartasComoString;
	}
	
	public String obtenerNombre(){
		return nombre;
	}
	
	public int cantidadDeCartas(){
		return cartas.size();
	}*/
	
	public void cargarEquipo(String nombre){
		this.equipo = nombre;
	}
	
	public String returnEquipo(){
		return this.equipo;
	}

	public int obtenerPuntosEnvido(){
		return this.manoDelJugador.calcularEnvido();
	}
	
	/* NO SIRVE MAS CREO
	 private int dameValorDeCartaMayor(ArrayList<Carta> cartas) {
		
		List<Carta> cartasNoNegras = new ArrayList<Carta>();
		
		for (Carta unaCarta : cartas){
			
			if (unaCarta.obtenerValor() <= 7){
				
				cartasNoNegras.add(unaCarta);
			}
		}
		switch (cartasNoNegras.size()){
		
		case 0:
			return 0;
		case 1:
			return cartasNoNegras.get(0).obtenerValor();
		case 2:
			if (cartasNoNegras.get(0).obtenerValor() < cartasNoNegras.get(1).obtenerValor()){
				return cartasNoNegras.get(1).obtenerValor();
			}
			else{
				return cartasNoNegras.get(0).obtenerValor();
			}
		}
		int maximo = cartasNoNegras.get(0).obtenerValor();
		
		if (maximo < cartasNoNegras.get(1).obtenerValor()){
			maximo = cartasNoNegras.get(1).obtenerValor();
		}
		else{
			if (maximo < cartasNoNegras.get(2).obtenerValor()){
				maximo = cartasNoNegras.get(2).obtenerValor();
			}
		}
		return maximo;
	}*/

	public TipoDeCartas jugarPrimera(){
		return this.manoDelJugador.returnPrimera();
	}

	/*public int obtenerPuntosTruco() {
		return 0;
	}*/

	/*public int obtenerPuntosEnvidoConFlor() {
		int envidoConFlor = 0;
		
		for (Carta unaCarta : cartas){
			if (unaCarta.obtenerValor()<= 7){
				envidoConFlor += unaCarta.obtenerValor();
			}
		}
		return envidoConFlor + 20;
	}*/
	
	public int obtenerPuntosEnvidoConFlor() {
		return this.manoDelJugador.calcularPuntosEnvidoConFlor();
	}

	public TipoDeCartas jugarCarta() {
		return this.manoDelJugador.returnPrimera();
	}
	/* CUANDO SOLUCIONEMOS SI USAMOS LISTA EN LA MANO....
	public void jugarCarta() {
		verCartasEnManoComoString();
		
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingerese numero de carta a jugar: ");
		int n = leer.nextInt();
		
		return this.manoDelJugador.tirar(n);
	}
	//*/
	
	
	
}
