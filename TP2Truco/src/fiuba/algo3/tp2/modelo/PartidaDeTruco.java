package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;

import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class PartidaDeTruco {
	
	//faltaria una objeto Turno que maneje el turno de la ronda.
	Equipo equipoUno;
	Equipo equipoDos;
	Mesa mesa;
	
	public PartidaDeTruco(String eq1, String eq2){
		this.mesa = new Mesa(eq1, eq2);
		this.equipoUno = new Equipo(eq1,mesa);
		this.equipoDos = new Equipo(eq2,mesa);
	}
	
	public abstract void cargarJugadoresEnEquipoUno(String jugadorUno);
	
	public abstract void cargarJugadoresEnEquipoDos(String jugadorUno);
	
	public Equipo obtenerEquipo(String nombreDelEquipo){
		
		if (equipoUno.tieneEsteNombre(nombreDelEquipo)){
			return equipoUno;
		}
		return equipoDos;
	}

	public void iniciarRonda() {
		this.mesa.sentarJugadores(equipoUno.obtenerJugadores(), equipoDos.obtenerJugadores());
		this.mesa.iniciarRonda();
	}

	public Jugador siguiente() {
		return this.mesa.siguiente();
	}

	public String ultimoGanador() {
		return this.mesa.ultimoGanador();
	}
	

	public int obtenerPuntajeDeEquipo(String nombreEquipo) {
		return this.mesa.puntosEquipo(nombreEquipo);
	}
}
