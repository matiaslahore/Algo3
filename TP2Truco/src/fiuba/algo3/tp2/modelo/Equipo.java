package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Equipo {
	String nombreEquipo;
	ArrayList<Jugador> Jugadores;
	int cantidadJugadores;
	Mesa refMesa; 
	
	public Equipo(String nombreDelEquipo){
	//ESTO TIENE Q SER UNA LISTA CIRCULAR DSPS VER IMPLEMENTACION HAY MUCHAS, SINO LA HACEMOS ES UNA BOLUDES
	//SI ES CIRCULAR LA LISTA NO ME IMPORTA LA CANT DE JUGADORES TRATO A TODOS POR IGUAL
		this.Jugadores = new ArrayList<Jugador>();
		//this.refMesa = mesa;
		//this.cantidadJugadores = cantidadJugadores;
		this.nombreEquipo = nombreDelEquipo;
	}
	
	public void cargarJugadores(LinkedList<String> nombreJugadores) {
		for(int i=1; i<= this.cantidadJugadores;i++){
			Jugador newJugador = new Jugador(nombreJugadores.get(i-1));
			Jugadores.add(newJugador);
		}
	}

	public void recibirCartas() {
		
		for (Jugador unJugador : Jugadores){
				
			unJugador.recibirCartas(refMesa.repartirCarta(),refMesa.repartirCarta(),refMesa.repartirCarta());
		}
	
	}

	public Jugador obtenerJugador(String nombreJugador) {
		
		return Jugadores.get(0);
	}

	public ArrayList<Jugador> obtenerJugadores(){
		return(this.Jugadores);
	}

	public String obtenerNombre(){
		return(this.nombreEquipo);
	}
	
	
	
	
}
