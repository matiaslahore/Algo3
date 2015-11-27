package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;


public class PartidaDeTrucoConFlor extends PartidaDeTruco{

	public PartidaDeTrucoConFlor(Equipo eq1, Equipo eq2) {
		super(eq1, eq2);
	}

	@Override
	public void cargarJugadoresEnEquipoUno(String nombre) {
		this.equipoUno.cargarJugadores(nombre);
	}
	public void cargarJugadoresEnEquipoDos(String nombre) {
		this.equipoDos.cargarJugadores(nombre);
	}

	public void sentarJugadores() {
		this.mesa.sentarJugadores(equipoUno.obtenerJugadores(),equipoDos.obtenerJugadores());
	}

}