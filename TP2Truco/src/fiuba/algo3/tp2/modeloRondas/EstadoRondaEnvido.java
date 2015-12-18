package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.NoSePuedeJugarUnaCartaException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaEnvido extends EstadoRondas{
	
	public EstadoRondaEnvido(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
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
	
	public EstadoRondas quiero(Jugador jugador) {
		for ( int i = indiceJugadorMano ; i <= ((this.jugadores.size() - 1) + this.indiceJugadorMano) ; i=i+1 ){
			Jugador actual = this.jugadores.get(i);
			tantoEnJuego.add(actual.obtenerPuntosEnvido());
		}
		
		int tantoGanador = this.juez.quienGanaElTanto(this.tantoEnJuego);
		int indexTantoGanador = this.tantoEnJuego.indexOf(tantoGanador); //gana el q es mano tmb
		
		Jugador jugadorGanador = this.jugadores.get(this.indiceJugadorMano + indexTantoGanador);
		Equipo equipoPerdedor = (this.jugadores.get(this.indiceJugadorMano + indexTantoGanador + 1)).obtenerEquipo();
		
		this.juez.anotarPuntosEnvido(jugadorGanador.obtenerEquipo(), equipoPerdedor);
		this.juez.ganadorDelTanto(jugadorGanador,tantoGanador);
		
		System.out.println("EL TANTO LO GANA: " + jugadorGanador.obtenerEquipo().obtenerNombre());
		System.out.println("CON: " + tantoGanador);
		
		this.tantoEnJuego.clear();
		
		return this.refEstadoRonda;
	}
	
	public EstadoRondas noQuiero(Jugador jugador) {
		this.juez.noQuisoEnvido();
		
		Equipo equipoGanador = (this.jugadores.get(this.jugadores.indexOf(jugador) + 1)).obtenerEquipo();
		this.juez.anotarPuntos(equipoGanador);
		
		this.indiceJugadorMano = this.indiceJugadorMano + 1; //aumento quien empieza la prox mano
		return this.refEstadoRonda;
	}
	
	public EstadoRondas cantarEnvido(Jugador jugador){
		this.juez.seCantoEnvido(jugador.obtenerEquipo());
		
		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual + 1;
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual);
	}
	
	public EstadoRondas cantarRealEnvido(Jugador jugador) {
		this.juez.seCantoRealEnvido(jugador.obtenerEquipo());
		
		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual + 1;
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual);
	}
	
	public EstadoRondas cantarFaltaEnvido(Jugador jugador) {
		this.juez.seCantoFaltaEnvido(jugador.obtenerEquipo());
		
		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual + 1;
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual);
	}
	
	public EstadoRondas cantarTruco(Jugador jugador) {
		throw new CantoInvalidoException();
	}

	public EstadoRondas cantarQuieroReTruco(Jugador jugador) {
		throw new CantoInvalidoException();
	}

	public EstadoRondas cantarQuieroValeCuatro(Jugador jugador) {
		throw new CantoInvalidoException();
	}

	public boolean seCantoEnvido() {
		return true;
	}

	public EstadoRondas cantarFlor(Jugador jugador){
		this.refEstadoRonda.indiceJugadorManoDeLaRondaActual += 1;
		return(this.refEstadoRonda.cantarFlor(jugador));
	}
}
