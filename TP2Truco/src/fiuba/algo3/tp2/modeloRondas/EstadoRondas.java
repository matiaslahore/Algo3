package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeNoQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.tiposDeCanto.*;

public abstract class EstadoRondas{

	Juez juez;
	ArrayList<String> ganadoresRonda;
	ListaCircular<Jugador> jugadores;
	ArrayList<Integer> tantoEnJuego;
	int jugadorManoDeLaRondaActual;
	int jugadorMano;
	boolean sigue;
	EstadoRondas refEstadoRonda;
	TiposDeCantoTruco cantosTruco;

	public EstadoRondas(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano){
		this.juez=juez;
		this.ganadoresRonda = ganadoresRonda;
		this.jugadores = jugadores;
		this.jugadorManoDeLaRondaActual = new Integer(indexManoAux);
		this.jugadorMano = indexMano; //esto no se toca nunca salvo en la ronda 3 para indicar la mano sig.
		this.refEstadoRonda = estadoRonda;
		this.tantoEnJuego = new ArrayList<Integer>();
	}
	
	public EstadoRondas acualizarRonda() {
		if (this.juez.cantidadDeCartasEnJuego() == this.cantidadDeJugadores()){ //se jugaron todas las cartas
			return ganador();
		}
		return this;		
	}

	private int cantidadDeJugadores() {
		return this.jugadores.size();
	}

	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.get(this.jugadorManoDeLaRondaActual);
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
		return jugador;
	}

	public abstract EstadoRondas ganador();

	public EstadoRondas quiero(Jugador jugador){
		throw new RuntimeException();
	}

	public EstadoRondas noQuiero(Jugador jugador){
		throw new RuntimeException();
	}
	
	public EstadoRondas cantarTruco(Jugador jugador)throws CantoInvalidoException, EquipoQueCantaNoPuedeVolverACantarException {
		try{
			this.cantosTruco = this.cantosTruco.cantar(jugador.obtenerNombreEquipo());
		}catch(CantoInvalidoException e){
			throw e;
		}
		 catch(EquipoQueCantaNoPuedeVolverACantarException e2){
			throw e2;
		}
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual - 1, jugadorMano, this.cantosTruco);
	}
	
	public EstadoRondas cantarQuieroReTruco(Jugador jugador) {
		try{
			this.cantosTruco = this.cantosTruco.cantar(jugador.obtenerNombreEquipo());
		}catch(EquipoQueCantaNoPuedeQuererElCantoException e){
			throw new RuntimeException(); //lo mismo q arriba.. nose si conviene
		}
		//this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
		/*agrege*/
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		/**/
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual - 1, jugadorMano, this.cantosTruco);
	}
	
	public EstadoRondas cantarQuieroValeCuatro(Jugador jugador) {
		try{
			this.cantosTruco = this.cantosTruco.cantar(jugador.obtenerNombreEquipo());
		}catch(EquipoQueCantaNoPuedeQuererElCantoException e){
			throw new RuntimeException(); //lo mismo q arriba.. nose si conviene
		}
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual, jugadorMano, this.cantosTruco);
	}
	
	public EstadoRondas cantarEnvido(Jugador jugador) throws CantoInvalidoException {
		Envido envido = new Envido(jugador.obtenerEquipoQuePertenece());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual - 1, jugadorMano,envido);
	}
	
	public EstadoRondas cantarRealEnvido(Jugador jugador)throws CantoInvalidoException {
		RealEnvido realEnvido = new RealEnvido(jugador.obtenerEquipoQuePertenece());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual - 1, jugadorMano,realEnvido);
	}
	
	public EstadoRondas cantarFaltaEnvido(Jugador jugador)throws CantoInvalidoException {
		FaltaEnvido faltaEnvido = new FaltaEnvido(jugador.obtenerEquipoQuePertenece());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorMano, jugadorMano,faltaEnvido);
	}

	public void modificarCantoTruco(TiposDeCantoTruco estadoTruco) {
		this.cantosTruco = estadoTruco;
	}
	
	public EstadoRondas cantarFlor(Jugador jugador) throws CantoInvalidoException {
		Flor envido = new Flor(jugador.obtenerEquipoQuePertenece());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaFlor(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual - 1, jugadorMano,envido);
	}

	public EstadoRondas cantarContraFlor(Jugador jugador) {
		throw new RuntimeException();
	}

	public EstadoRondas cantarContraFlorAJuego(Jugador jugador) {
		throw new RuntimeException();
	}
	
}
