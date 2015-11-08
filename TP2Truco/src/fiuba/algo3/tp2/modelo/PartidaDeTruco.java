package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

public class PartidaDeTruco {
	
	Mesa mesa;
	Equipo equipoUno;
	Equipo equipoDos;
	
	public static void main (String[] args){	
	}

	public PartidaDeTruco(int cantidadJugadores){
		mesa = new Mesa();
		equipoUno = new Equipo(mesa,cantidadJugadores);
		equipoDos = new Equipo(mesa,cantidadJugadores);
	}
		
	//SOLO PARA MANTENER UN ORDEN, EN EQUIPO LO EXPLICO.
	public void cargarJugadoresEnEquipoUno(String jugadorUno, String jugadorDos, String jugador3){
	//ESTO SE LLAMARIA DOS VECES UNA PARA CADA EQUIPO.
	//ES MEDIO LOCO PERO SI EXISTIESEN 3 EQUIPOS LO LLAMARIA 3 VECES Y ANDARIA TODO BIEN
		this.equipoUno.cargarJugadores(jugadorUno,jugadorDos,jugador3);
	}
	
	//SOLO PARA MANTENER UN ORDEN, EN EQUIPO LO EXPLICO.
		public void cargarJugadoresEnEquipoDos(String jugadorUno, String jugadorDos, String jugador3){
		//ESTO SE LLAMARIA DOS VECES UNA PARA CADA EQUIPO.
		//ES MEDIO LOCO PERO SI EXISTIESEN 3 EQUIPOS LO LLAMARIA 3 VECES Y ANDARIA TODO BIEN
			this.equipoDos.cargarJugadores(jugadorUno,jugadorDos,jugador3);
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
