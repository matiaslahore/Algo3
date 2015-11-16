package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class RondaTres extends Rondas{

	public RondaTres(Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, Rondas ronda) {
		super(juez, ganadoresRonda, jugadores, ronda);
	}

	public void ganador(){
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		//JUGADOR GANADOR ES: indexCartaGanadora + indexMano
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.returnEquipo());
		this.cartasEnJuego.clear();

		this.juez.anotarPuntos(ganador.returnEquipo());
		this.jugadorMano = this.jugadorMano + 1;
		this.ganadoresRonda = new ArrayList<String>();
		this.cartasEnJuego = new ArrayList<TipoDeCartas>();
		this.refRonda = new RondaUno(juez, ganadoresRonda, jugadores, refRonda);
		System.out.println("RONDA TRES");
		//jugar(this.jugadorMano);
	}

	@Override
	public void repartir() {
		//no hace nada
	}

}
