package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.NoSePuedeJugarUnaCartaException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaTruco extends EstadoRondas{

	public EstadoRondaTruco(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> listaDeJugadoresActual, int indiceJugadorManoDeLaRondaActual) {

		super(estadoRonda, juez, ganadoresRonda, listaDeJugadoresActual, indiceJugadorManoDeLaRondaActual);
	}

	@Override
	public EstadoRondas siguienteRonda() {
		return this.refEstadoRonda;
	}

	public EstadoRondas acualizarRonda() {
		return this;
	}

	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.get(this.indiceJugadorManoDeLaRondaActual + 2); //2 es manejo de indices //aclarar
		return jugador;
	}

	public void jugarCarta() {
		throw new NoSePuedeJugarUnaCartaException();
	}

	@Override
	public EstadoRondas quiero(Jugador jugador) {
		this.juez.quisoTruco();
		
		return this.refEstadoRonda;
	}

	@Override
	public EstadoRondas noQuiero(Jugador jugador) {
		this.juez.noQuisoTruco();
		
		Equipo equipoGanador = (this.jugadores.get(this.jugadores.indexOf(jugador) + 1)).obtenerEquipo();
		
		this.juez.finalizoLaMano(equipoGanador);

		this.indiceJugadorMano = this.indiceJugadorMano + 1; //aumento quien empieza la prox mano

		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual);
	}

	public EstadoRondas cantarTruco(Jugador jugador) {
		throw new CantoInvalidoException(); //si accedio a este estado ya se canto truco
	}

	public EstadoRondas cantarQuieroReTruco(Jugador jugador) {
		this.juez.seCantoQuieroReTruco(jugador.obtenerEquipo());

		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual + 1; 
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual);
	}

	public EstadoRondas cantarQuieroValeCuatro(Jugador jugador) {
		this.juez.seCantoQuieroValeCuatro(jugador.obtenerEquipo());

		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual + 1; 
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual);
	}

}
