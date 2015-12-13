package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.cantos.EstadoFlor;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaUno extends EstadoRondas{

	public EstadoRondaUno(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> listaDeJugadoresActual, int indiceJugadorManoDeLaRondaActual) {

		super(estadoRonda, juez, ganadoresRonda, listaDeJugadoresActual, indiceJugadorManoDeLaRondaActual);

		this.jugadores = this.juez.listaDeJugadores();

		this.indiceJugadorManoDeLaRondaActual = this.juez.indiceJugadorQueComienza();
	}

	public EstadoRondas siguienteRonda(){
		this.ganadoresRonda.clear();
		this.juez.terminoRondaUno();

		int indiceCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(this.juez.obtenerCartaGanadoraDeRonda());

		if (this.juez.hayParda()){
			this.juez.limpiarCartasEnJuegoDeRondaActual();
			System.out.println("RONDA UNO PARDA");

			return new EstadoRondaDosParda(refEstadoRonda, juez, ganadoresRonda, this.jugadores, this.indiceJugadorManoDeLaRondaActual);
		}

		Jugador ganador = this.jugadores.get(this.indiceJugadorManoDeLaRondaActual + indiceCartaGanadora);
		ganadoresRonda.add(ganador.obtenerEquipo());

		this.juez.limpiarCartasEnJuegoDeRondaActual();

		System.out.println("RONDA UNO la gana: " + this.ganadoresRonda.get(0).obtenerNombre() + "\n");

		return new EstadoRondaDos(refEstadoRonda, juez, ganadoresRonda, this.jugadores, this.indiceJugadorManoDeLaRondaActual + indiceCartaGanadora);
	}

	public EstadoRondas cantarEnvido(Jugador jugador) throws CantoInvalidoException {
		this.juez.seCantoEnvido(jugador.obtenerEquipo());

		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual - 1);
	}

	public EstadoRondas cantarRealEnvido(Jugador jugador)throws CantoInvalidoException {
		this.juez.seCantoRealEnvido(jugador.obtenerEquipo());

		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual - 1);
	}

	public EstadoRondas cantarFaltaEnvido(Jugador jugador)throws CantoInvalidoException {
		this.juez.seCantoFaltaEnvido(jugador.obtenerEquipo());

		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual - 1);
	}

	public EstadoRondas cantarFlor(Jugador jugador) throws CantoInvalidoException {
		if (!jugador.tieneFlor()) throw new CantoInvalidoException();

		if (this.juez.hayOtroEquipoConFlor(jugador.obtenerEquipo())) {
			EstadoFlor flor = new EstadoFlor(jugador.obtenerEquipo());
			this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
			this.refEstadoRonda = this; //guardo estado de la ronda actual
			return new EstadoRondaFlor(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual - 1, flor);
		}
		juez.puntosEnJuego(3);
		juez.anotarPuntos(jugador.obtenerEquipo());
		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual - 1;
		return this;
	}

}
