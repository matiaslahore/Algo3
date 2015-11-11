package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {

	String nombre;
	ArrayList<Carta> cartas;
	String equipo;
	
	public Jugador(String name){
		nombre = name;
		cartas = new ArrayList<Carta>(); 
	}
	
	public void recibirCartas(Carta c1, Carta c2, Carta c3){
		cartas.add(c1);
		cartas.add(c2);
		cartas.add(c3);
	}

	public void recibirUnaCarta(Carta carta){
		
		cartas.add(carta);
	}
	
	public Carta jugarCarta(){
		//ACA ENTRA LA DECISION DEL JUGADOR.. PUSE LA PRIMERA POR PONER
		Carta actual = cartas.get(0);
		cartas.remove(0);
		return actual;
	}
	
	public String verCartasEnManoComoString() {
		
		String cartasComoString = "";
		for (Carta unaCarta : cartas){
			
			cartasComoString += unaCarta.obtenerCartaComoString();
		}
		return cartasComoString;
	}
	
	public String obtenerNombre(){
		return(this.nombre);
	}
	
	public int cantidadDeCartas(){
		return cartas.size();
	}
	
	public void cargarEquipo(String nombre){
		this.equipo = nombre;
	}
	
	public String returnEquipo(){
		return this.equipo;
	}

	public int obtenerPuntosEnvido() {
		Carta c1 = cartas.get(0);
		Carta c2 = cartas.get(1);
		Carta c3 = cartas.get(2);
		
		int puntos = 20;
		return puntos + c1.sumarMismoPalo(c2,c3);
	}
	
}
