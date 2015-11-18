package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;

public abstract class PartidaDeTruco {
	
	//faltaria una objeto Turno que maneje el turno de la ronda.
	Equipo equipoUno;
	Equipo equipoDos;
	Mesa mesa;
	
	public abstract void cargarJugadoresEnEquipoUno(String jugadorUno);
	
	public abstract void cargarJugadoresEnEquipoDos(String jugadorUno);
	
	public void asignarQuienReparte() {
		
		float random =  (float) Math.random();
		
		if (random > 0.5) {
				equipoDos.asignarQuienReparte();
				return;
		}
		equipoDos.asignarQuienReparte();	
	}
}
