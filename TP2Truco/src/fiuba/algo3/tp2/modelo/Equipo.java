package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Equipo {
	String nombreEquipo;
	ArrayList<Jugador> jugadores;
	int cantidadJugadores;
	Mesa refMesa; 
	
	public Equipo(String nombreDelEquipo, Mesa mesa){
	//ESTO TIENE Q SER UNA LISTA CIRCULAR DSPS VER IMPLEMENTACION HAY MUCHAS, SINO LA HACEMOS ES UNA BOLUDES
	//SI ES CIRCULAR LA LISTA NO ME IMPORTA LA CANT DE JUGADORES TRATO A TODOS POR IGUAL
		this.jugadores = new ArrayList<Jugador>();
		this.refMesa = mesa;
		//this.cantidadJugadores = cantidadJugadores;
		this.nombreEquipo = nombreDelEquipo;
	}
	
	public void cargarJugadores(LinkedList<String> nombreJugadores) {
		Iterator<String> itr = nombreJugadores.iterator();
		while(itr.hasNext()) {
			String nombre = (String) itr.next();
			Jugador newJugador = new Jugador(nombre);
			jugadores.add(newJugador);
		}
	}

	public void recibirCartas() {
		for (Jugador unJugador : jugadores){
			unJugador.recibirCartas(refMesa.repartirCarta(),refMesa.repartirCarta(),refMesa.repartirCarta());
		}
	}

	public Jugador obtenerJugador(String nombreJugador) {	
		Iterator<Jugador> itr = jugadores.iterator();
		while(itr.hasNext()) {
			Jugador actual = (Jugador) itr.next();
			if (nombreJugador == actual.obtenerNombre()) return actual;
		}
		return new Jugador("ERROR"); //aca hay q tirar una excepcion xq no encontro al jugador
		//puse eso para q no me joda eclipse
	}

	public ArrayList<Jugador> obtenerJugadores(){
		return(this.jugadores);
	}

	public String obtenerNombre(){
		return(this.nombreEquipo);
	}
	
}
