package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;

public class PartidaDeTrucoUnoContraUno extends PartidaDeTruco {

	public void cargarJugadoresEnEquipoUno(String JugadorUno) {
		
		LinkedList<String> nombreJugadores = new LinkedList<String>();
		nombreJugadores.add(JugadorUno);
		this.equipoUno.cargarJugadores(nombreJugadores);
	}

	public void cargarJugadoresEnEquipoDos(String jugadorDos) {
		
		LinkedList<String> nombreJugadores = new LinkedList<String>();
		nombreJugadores.add(jugadorDos);
		this.equipoDos.cargarJugadores(nombreJugadores);
	}

	@Override
	public void cantarEnvido(String jugador) {
		
		
	}
}
