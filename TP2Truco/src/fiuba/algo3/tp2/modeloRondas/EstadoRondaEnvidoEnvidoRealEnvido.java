package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaEnvidoEnvidoRealEnvido extends EstadoRondaEnvido {

	public EstadoRondaEnvidoEnvidoRealEnvido(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda,ArrayList<TipoDeCartas> cartasEnJuego, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano,TiposDeCantoEnvido tipoDeCanto) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexManoAux, indexMano, tipoDeCanto);
	}
	
	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.get(this.jugadorMano + 2); //2 es manejo de indices //aclarar
		return jugador;
	}

	public EstadoRondas cantarEnvido(Jugador jugador) {
		throw new RuntimeException(); //no se puede cantar envido envido realenvido envido
	}
	
	public EstadoRondas cantarRealEnvido(Jugador jugador) {
		throw new RuntimeException(); //no se puede cantar envido envido realenvido realenvido
	}
	
	public EstadoRondas cantarFaltaEnvido(Jugador jugador) {
		TiposDeCantoEnvido tanto = new EnvidoEnvidoRealEnvidoFaltaEnvido(jugador.obtenerEquipoQuePertenece());
		this.jugadorMano = this.jugadorMano + 1;
		return new EstadoRondaEnvidoEnvidoRealEnvidoFaltaEnvido(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, jugadorMano, indexMano,tanto);
	}

}
