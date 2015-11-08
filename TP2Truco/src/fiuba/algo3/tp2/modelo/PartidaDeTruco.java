package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

public class PartidaDeTruco {
	
	Mesa mesa;
	//conviene hacer un array de Equipo asi no me importa el numero de equipos
	ArrayList<Equipo> arrayEq;
	
	public static void main (String[] args){	
	}

	public PartidaDeTruco(){
		mesa = new Mesa();
		arrayEq = new ArrayList<Equipo>();
	}
	
	//SE TOMA EN CUENTA QUE EN LA IGRAFICA SE SELECCIONA LA CANT DE JUGADORES
	//SOLO PARA MANTENER UN ORDEN, EN EQUIPO LO EXPLICO.
	public void cargarJugadoresEnEq(int numEq, String j1, String j2, String j3){
	//ESTO SE LLAMARIA DOS VECES UNA PARA CADA EQUIPO.
	//ES MEDIO LOCO PERO SI EXISTIESEN 3 EQUIPOS LO LLAMARIA 3 VECES Y ANDARIA TODO BIEN
		Equipo newEq = new Equipo(mesa);
		newEq.cargarJugadores(j1,j2,j3);
		arrayEq.add(newEq);
	}

	public void repartirCartas() {
		
		for (Equipo unEquipo : arrayEq){
			
			unEquipo.recibirCartas();
		}
	}

	public String verCartasEnManoDeJugadorComoString(String nombreJugador){
		
					
		Jugador unJugador = arrayEq.get(0).obtenerJugador(nombreJugador);
		
		return unJugador.verCartasEnMano();
	}
	
}
