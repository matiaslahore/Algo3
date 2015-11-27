package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.tp2.modeloJugador.Jugador;

public class Equipo {
	String nombreEquipo;
	ArrayList<Jugador> jugadores;
	int cantidadJugadores;
	Mesa refMesa;
	
	public Equipo(String nombreDelEquipo, Mesa mesa){
		this.jugadores = new ArrayList<Jugador>();
		this.refMesa = mesa;
		//this.cantidadJugadores = cantidadJugadores;
		this.nombreEquipo = nombreDelEquipo;
	}
	
	/*public void cargarJugadores(LinkedList<String> nombreJugadores) {
		Iterator<String> itr = nombreJugadores.iterator();
		while(itr.hasNext()) {
			String nombre = (String) itr.next();
			Jugador newJugador = new Jugador(nombre,refMesa);
			newJugador.cargarEquipo(nombreEquipo);
			jugadores.add(newJugador);
		}
	}*/
	public void cargarJugadores(String nombre) {
		Jugador newJugador = new Jugador(nombre,refMesa,this);
		jugadores.add(newJugador);
	}

	/*public void recibirCartas() {
		for (Jugador unJugador : jugadores){
			TipoDeCartas c1 = refMesa.repartirCarta();
			TipoDeCartas c2 = refMesa.repartirCarta();
			TipoDeCartas c3 = refMesa.repartirCarta();
			
		 	unJugador.recibirCartas(c1,c2,c3);
		}
	}*/

	public Jugador obtenerJugador(String nombreJugador) {	
		Iterator<Jugador> itr = jugadores.iterator();
		while(itr.hasNext()) {
			Jugador actual = (Jugador) itr.next();
			if (nombreJugador == actual.obtenerNombre()) return actual;
		}
		return new Jugador("ERROR",refMesa,this); //aca hay q tirar una excepcion xq no encontro al jugador
		//puse eso para q no me joda eclipse
	}

	public ArrayList<Jugador> obtenerJugadores(){
		return(this.jugadores);
	}
	
	public String obtenerNombre(){
		return(this.nombreEquipo);
	}

	public boolean tieneEsteNombre(String nombreDelEquipo) {
		
		return (this.nombreEquipo == nombreDelEquipo);
	}
	
}