package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

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
		//this.cantidadJugadores = cantidadJugadores;
		this.nombreEquipo = nombreDelEquipo;
	}
	
	public void cargarJugadores(String nombre) {
		Jugador newJugador = new Humano(nombre,refMesa,this);
		jugadores.add(newJugador);
	}
	
	public void cargarJugadorIA(String nombre) {
		
		Jugador nuevoJugador = new IA(nombre, refMesa, this);
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