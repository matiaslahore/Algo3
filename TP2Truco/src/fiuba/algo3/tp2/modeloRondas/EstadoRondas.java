package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.EventosJuez;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modelo.OyenteJuez;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class EstadoRondas{
	
	Juez juez;
	ArrayList<Equipo> ganadoresRonda;
	ListaCircular<Jugador> jugadores;
	ArrayList<Integer> tantoEnJuego;
	int indiceJugadorManoDeLaRondaActual;
	int indiceJugadorMano;
	boolean sigue;
	EstadoRondas refEstadoRonda;

	public EstadoRondas(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda, ListaCircular<Jugador> listaDeJugadoresActual,int indiceJugadorManoDeLaRondaActual){
		this.juez = juez;
		this.ganadoresRonda = ganadoresRonda;
		this.indiceJugadorMano = this.juez.indiceJugadorMano();
		this.indiceJugadorManoDeLaRondaActual = indiceJugadorManoDeLaRondaActual;
		this.jugadores = listaDeJugadoresActual;
		this.refEstadoRonda = estadoRonda;
		this.tantoEnJuego = new ArrayList<Integer>();
	}
	
	public EstadoRondas acualizarRonda() {
		if (this.juez.termino()){
			return new EstadoPartidaFinalizada(refEstadoRonda, juez, ganadoresRonda,this.jugadores ,this.indiceJugadorManoDeLaRondaActual);
		}
		if (this.juez.cantidadDeCartasEnJuego() == jugadores.size()){
			return siguienteRonda();
		}
		return this;
	}

	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.get(this.indiceJugadorManoDeLaRondaActual);
		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual + 1;
		return jugador;
	}

	public abstract EstadoRondas siguienteRonda();

	public EstadoRondas quiero(Jugador jugador){
		throw new CantoInvalidoException();
	}

	public EstadoRondas noQuiero(Jugador jugador){
		throw new CantoInvalidoException();
	}

	public EstadoRondas cantarTruco(Jugador jugador)throws CantoInvalidoException, EquipoQueCantaNoPuedeVolverACantarException {
		this.juez.seCantoTruco(jugador.obtenerEquipo());
		
		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual - 1);
	}

	public EstadoRondas cantarQuieroReTruco(Jugador jugador) {
		this.juez.seCantoQuieroReTruco(jugador.obtenerEquipo());
		
		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual - 1);
	}

	public EstadoRondas cantarQuieroValeCuatro(Jugador jugador) {
		this.juez.seCantoQuieroValeCuatro(jugador.obtenerEquipo());

		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual - 1);
	}

	public EstadoRondas cantarEnvido(Jugador jugador) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	public EstadoRondas cantarRealEnvido(Jugador jugador)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	public EstadoRondas cantarFaltaEnvido(Jugador jugador)throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	public EstadoRondas cantarFlor(Jugador jugador) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	public EstadoRondas cantarContraFlor(Jugador jugador) {
		throw new CantoInvalidoException();
	}

	public EstadoRondas cantarContraFlorAJuego(Jugador jugador) {
		throw new CantoInvalidoException();
	}

	public EstadoRondas irseAlMazo(Jugador jugador) {
		Equipo equipoGanador = this.jugadores.get(this.jugadores.indexOf(jugador) + 1).obtenerEquipo();
		ganadoresRonda.add(equipoGanador);
		this.juez.finalizoLaMano(equipoGanador);

		System.out.println("Gano: " + equipoGanador.obtenerNombre() + "\n");

		this.indiceJugadorMano = this.indiceJugadorMano + 1;

		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual);
	}

	public boolean seCantoEnvido(){
		return false;
	}

	public boolean seCantoTruco() {
		return false;
	}

	public void jugarCarta(){
	}

}
