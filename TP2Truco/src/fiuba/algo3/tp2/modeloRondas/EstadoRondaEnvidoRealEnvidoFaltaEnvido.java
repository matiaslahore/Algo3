package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaEnvidoRealEnvidoFaltaEnvido extends EstadoRondaEnvido {

	public EstadoRondaEnvidoRealEnvidoFaltaEnvido(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda,ArrayList<TipoDeCartas> cartasEnJuego, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano,TiposDeCantoEnvido tipoDeCanto) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexManoAux, indexMano, tipoDeCanto);
	}

	public EstadoRondas cantarEnvido(Jugador jugador) {
		throw new RuntimeException(); //no se puede cantar envido realenvido faltaenvido envido
	}
	
	public EstadoRondas cantarRealEnvido(Jugador jugador) {
		throw new RuntimeException(); //no se puede cantar envido realenvido faltaenvido realenvido
	}
	
	public EstadoRondas cantarFaltaEnvido(Jugador jugador) {
		throw new RuntimeException(); //no se puede cantar envido realenvido faltaenvido faltaenvido
	}

}
