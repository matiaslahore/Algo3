package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;


public class PartidaDeTrucoConFlor extends PartidaDeTruco{

	public PartidaDeTrucoConFlor(String eq1, String eq2) {
		super(eq1, eq2);
	}

	Puntos puntos;

	@Override
	public void cargarJugadoresEnEquipoUno(String nombre) {
		this.equipoUno.cargarJugadores(nombre);
	}
	public void cargarJugadoresEnEquipoDos(String nombre) {
		this.equipoDos.cargarJugadores(nombre);
	}

	public void repartir(){
		equipoUno.recibirCartas();
		equipoDos.recibirCartas();
	}

	public void sentarJugadores() {
		this.mesa.sentarJugadores(equipoUno.obtenerJugadores(),equipoDos.obtenerJugadores());
	}

}