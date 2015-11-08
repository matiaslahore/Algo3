package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Equipo {
	String nombreEquipo;
	ArrayList<Jugador> listJugadores;
	int cantidadJugadores;
	Mesa refMesa;
	
	public Equipo(Mesa mesa,int cantidadJugadores){
	//ESTO TIENE Q SER UNA LISTA CIRCULAR DSPS VER IMPLEMENTACION HAY MUCHAS, SINO LA HACEMOS ES UNA BOLUDES
	//SI ES CIRCULAR LA LISTA NO ME IMPORTA LA CANT DE JUGADORES TRATO A TODOS POR IGUAL
		this.listJugadores = new ArrayList<Jugador>();
		this.refMesa = mesa;
		this.cantidadJugadores = cantidadJugadores;
	}
	
	public void cargarJugadores(LinkedList<String> nombreJugadores) {
		for(int i=1; i<= this.cantidadJugadores;i++){
			Jugador newJugador = new Jugador(nombreJugadores.get(i-1),refMesa);
			listJugadores.add(newJugador);
		}
	}

	public void recibirCartas() {
		
		for (Jugador unJugador : listJugadores){
				
			unJugador.recibirCartas(refMesa.repartirCarta(),refMesa.repartirCarta(),refMesa.repartirCarta());
		}
	
	}

	public Jugador obtenerJugador(String nombreJugador) {
		
		return listJugadores.get(0);
	}


		
	
	
	
	
}
