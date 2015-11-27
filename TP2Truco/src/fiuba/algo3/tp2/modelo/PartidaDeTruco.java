package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class PartidaDeTruco {
	
	//faltaria una objeto Turno que maneje el turno de la ronda.
	Equipo equipoUno;
	Equipo equipoDos;
	Mesa mesa;
	
	public PartidaDeTruco(String nombreEq1, String nombreEq2){
		this.mesa = new Mesa();
		this.equipoUno = new Equipo(nombreEq1, mesa);
		this.equipoDos = new Equipo(nombreEq2, mesa);
		this.mesa.instanciarJuez(equipoUno,equipoDos);
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
		return this.mesa.ultimoGanador().obtenerNombre();
	}
	
	public void repartir(){
		this.mesa.repartirCartas();
	}
	
	public int obtenerPuntajeDeEquipo(String equipo) {
		return this.mesa.puntosEquipo(equipo);
	}
}
