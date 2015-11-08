package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

public class PartidaDeTruco {
	
	Mesa mesa;
	Equipo equipoUno;
	Equipo equipoDos;
	
	public static void main (String[] args){	
	}

	public PartidaDeTruco(){
		
		mesa = new Mesa();
	}
		
	//SOLO PARA MANTENER UN ORDEN, EN EQUIPO LO EXPLICO.
	public void cargarJugadoresEnEquipo(String jugadorUno, String jugadorDos, String jugador3){
	//ESTO SE LLAMARIA DOS VECES UNA PARA CADA EQUIPO.
	//ES MEDIO LOCO PERO SI EXISTIESEN 3 EQUIPOS LO LLAMARIA 3 VECES Y ANDARIA TODO BIEN
		Equipo newEq = new Equipo(mesa);
		newEq.cargarJugadores(jugadorUno,jugadorDos,jugador3);
		//listaDeEquipo.add(newEq);
	}

	public void repartirCartas() {
		
		/*for (Equipo unEquipo : listaDeEquipo){
			
			unEquipo.recibirCartas();
		}*/
	}

	public String verCartasEnManoDeJugadorComoString(String nombreJugador){
				
		//Jugador unJugador = listaDeEquipo.get(0).obtenerJugador(nombreJugador);
		
		return ""; //unJugador.verCartasEnMano();
	}
	
}
