package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;

public class RondaDos extends Rondas{

	public RondaDos(Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, Rondas ronda) {
		super(juez, ganadoresRonda, jugadores, ronda);
	}

	@Override
	public void completarGanador() {
		this.refRonda = new RondaTres(juez, ganadoresRonda, jugadores, refRonda);
	}

	@Override
	public void cantarEnvido() {
		//AGREGAR ALGO QUE NO DEJE CANTAR ENVIDO
	}

	@Override
	public void cantarFlor() {
		//AGREGAR ALGO QUE NO DEJE CANTAR LA FLOR
	}

}
