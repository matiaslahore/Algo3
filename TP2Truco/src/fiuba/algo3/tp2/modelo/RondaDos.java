package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class RondaDos extends Rondas{

	public RondaDos(Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, int indexMano) {
		super(juez, ganadoresRonda, jugadores, indexMano);
	}
	
	public void ganador(){
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		//JUGADOR GANADOR ES: indexCartaGanadora + indexMano
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.returnEquipo());
		this.cartasEnJuego.clear();
		
		System.out.println(ganador.nombre);
		System.out.println("RONDA DOS");
		
		if (ganadoresRonda.get(0) == ganador.returnEquipo()) System.out.println("TERMINOOOOOOOOOOOOOOOOOOOOOOOOOO");
		//jugar(this.jugadorMano + indexCartaGanadora);
	}

	@Override
	public void repartir() {
		//no hace nada
	}

}
