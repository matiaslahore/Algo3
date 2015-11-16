package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class RondaUno extends Rondas{

	public RondaUno(Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, Rondas ronda) {
		super(juez, ganadoresRonda, jugadores, ronda);
	}
	
	//EN RONDA UNO SE REPARTE
	public void repartir(){
		this.juez.mezclar();
		Iterator<Jugador> itr = this.jugadores.iterator();
		while(itr.hasNext()) {
			Jugador unJugador = (Jugador) itr.next();
			unJugador.recibirCartas(juez.repartir(), juez.repartir(), juez.repartir());
		}
		System.out.println("REPARTEN");
	}
	
	public void ganador(){
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		//JUGADOR GANADOR ES: indexCartaGanadora + indexMano
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.returnEquipo());
		this.cartasEnJuego.clear();

		this.refRonda = new RondaDos(juez, ganadoresRonda, jugadores, refRonda);
		System.out.println("RONDA UNO");
		jugar(this.jugadorMano + indexCartaGanadora);
	}

}
