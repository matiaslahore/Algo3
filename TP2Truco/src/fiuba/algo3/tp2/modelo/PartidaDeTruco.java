package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;

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
		
	public void cargarJugadoresEnEquipoUno(String jugadorUno, String jugadorDos, String jugadorTres){
		LinkedList<String> nombreJugadores = new LinkedList<String>();
		nombreJugadores.add(jugadorUno);
		nombreJugadores.add(jugadorDos);
		nombreJugadores.add(jugadorTres);
		this.equipoUno.cargarJugadores(nombreJugadores);
	}
	
	public void cargarJugadoresEnEquipoDos(String jugadorUno, String jugadorDos, String jugadorTres){
			LinkedList<String> nombreJugadores = new LinkedList<String>();
			nombreJugadores.add(jugadorUno);
			nombreJugadores.add(jugadorDos);
			nombreJugadores.add(jugadorTres);
			this.equipoDos.cargarJugadores(nombreJugadores);
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
