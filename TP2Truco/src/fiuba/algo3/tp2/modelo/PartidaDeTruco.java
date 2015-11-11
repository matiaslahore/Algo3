package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;

public abstract class PartidaDeTruco {
	
	//faltaria una objeto Turno que maneje el turno de la ronda.
	Equipo equipoUno;
	Equipo equipoDos;
	Mesa mesa;
	
	public abstract void cargarJugadoresEnEquipoUno(String jugadorUno);
	
	public abstract void cargarJugadoresEnEquipoDos(String jugadorUno);
	
	public abstract void cantarEnvido(String jugador);
	
	public abstract void asignarMesa();
	/*public void cargarJugadoresEnEquipoUno(String jugadorUno, String jugadorDos, String jugadorTres){
		
		LinkedList<String> nombreJugadores = new LinkedList<String>();
		nombreJugadores.add(jugadorUno);
		nombreJugadores.add(jugadorDos);
		nombreJugadores.add(jugadorTres);
		this.equipoUno.cargarJugadores(nombreJugadores);
	}/*
	
	public void cargarJugadoresEnEquipoDos(String jugadorUno, String jugadorDos, String jugadorTres){
			
		LinkedList<String> nombreJugadores = new LinkedList<String>();
		nombreJugadores.add(jugadorUno);
		nombreJugadores.add(jugadorDos);
		nombreJugadores.add(jugadorTres);
		this.equipoDos.cargarJugadores(nombreJugadores);
	}

	public void repartirCartas() {
	
	}

	/*public String verCartasEnManoDeJugadorComoString(String nombreJugador){
		
		return ""; 
	}*/
}
