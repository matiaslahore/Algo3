package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;


public class PartidaDeTrucoSinFlor extends PartidaDeTruco{

	public PartidaDeTrucoSinFlor(String eq1, String eq2) {
		super(eq1, eq2);
	}

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
	
	public int obtenerPuntajeDeEquipo(String nombreEquipo) {
		return this.mesa.obtenerPuntajeDeEquipo(nombreEquipo);
	}

}