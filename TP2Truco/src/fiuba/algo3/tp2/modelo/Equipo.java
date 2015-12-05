package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.tp2.excepciones.ErrorCargaDeJugadoresException;
import fiuba.algo3.tp2.modeloJugador.Humano;
import fiuba.algo3.tp2.modeloJugador.IA;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class Equipo {
	String nombreEquipo;
	ArrayList<Jugador> jugadores;
	int cantidadJugadores;
	Mesa refMesa;
	
	public Equipo(String nombreDelEquipo, Mesa mesa){
		this.jugadores = new ArrayList<Jugador>();
		this.refMesa = mesa;
		this.nombreEquipo = nombreDelEquipo;
	}
	
	public void cargarJugador(String nombre) {
		Jugador newJugador = new Humano(nombre,refMesa,this);
		jugadores.add(newJugador);
	}
	
	public void cargarJugadores(List<String> nombreJugadores) {
		if (!this.jugadores.isEmpty()) throw new ErrorCargaDeJugadoresException();

		Iterator<String> itr = nombreJugadores.iterator();

		while(itr.hasNext()) {
			Jugador newJugador = new Humano((String) itr.next(),refMesa,this);
			jugadores.add(newJugador);
		}
	}
	
	public void cargarJugadorIA() {
		Jugador nuevoJugador = new IA(this.nombreEquipo, refMesa, this);
		jugadores.add(nuevoJugador);
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