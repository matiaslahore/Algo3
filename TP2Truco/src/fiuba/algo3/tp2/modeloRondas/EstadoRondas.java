package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.cantos.CantosTruco;
import fiuba.algo3.tp2.cantos.Envido;
import fiuba.algo3.tp2.cantos.FaltaEnvido;
import fiuba.algo3.tp2.cantos.Flor;
import fiuba.algo3.tp2.cantos.RealEnvido;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.cantos.*;

public abstract class EstadoRondas{

	Juez juez;
	ArrayList<Equipo> ganadoresRonda;
	ListaCircular<Jugador> jugadores;
	ArrayList<Integer> tantoEnJuego;
	int jugadorManoDeLaRondaActual;
	int jugadorMano;
	boolean sigue;
	EstadoRondas refEstadoRonda;
	CantosTruco cantosTruco;

	public EstadoRondas(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano){
		this.juez=juez;
		this.ganadoresRonda = ganadoresRonda;
		this.jugadores = jugadores;
		this.jugadorManoDeLaRondaActual = new Integer(indexManoAux);
		this.jugadorMano = indexMano; //esto no se toca nunca salvo en la ronda 3 para indicar la mano sig.
		this.refEstadoRonda = estadoRonda;
		this.tantoEnJuego = new ArrayList<Integer>();
	}

	private int cantidadDeJugadores() {
		return this.jugadores.size();
	}

	public EstadoRondas acualizarRonda() {

		if (this.juez.termino()){
			return new EstadoPartidaFinalizada(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano);
		}
		if (this.juez.seJugaronTodasLasCartas()){
			return siguienteRonda();
		}
		return this;
	}

	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.get(this.jugadorManoDeLaRondaActual);
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
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
		try{
			this.cantosTruco = this.cantosTruco.cantar(jugador.obtenerEquipo());
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
		this.cantosTruco = this.cantosTruco.cantar(jugador.obtenerEquipo());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual - 1, jugadorMano, this.cantosTruco);
	}

	public EstadoRondas cantarQuieroValeCuatro(Jugador jugador) {
		this.cantosTruco = this.cantosTruco.cantar(jugador.obtenerEquipo());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual - 1, jugadorMano, this.cantosTruco);

		//this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
		//return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual, jugadorMano, this.cantosTruco);
	}
	
	public void modificarCantoTruco(CantosTruco estadoTruco) {
		this.cantosTruco = estadoTruco;
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

	public void actualizarPicaPica(){
		this.juez.actualizarPicaPica();
	}

	public boolean esPicaPica(){
		return this.juez.esPicaPica();
	}

	public EstadoRondas irseAlMazo(Jugador jugador) {
		Equipo ganador = this.jugadores.get(this.jugadores.indexOf(jugador) + 1).obtenerEquipo();

		ganadoresRonda.add(ganador);
		
		this.juez.anotarPuntos(ganador);

		System.out.println("Gano: " + ganador.obtenerNombre() + "\n");

		this.juez.limpiarCartasEnJuegoDeRondaActual();

		this.jugadorMano = this.jugadorMano + 1; //aumento quien empieza la prox mano
		if (esPicaPica()){
			return new EstadoRondaUnoPicaPica(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano, jugadores);
		}
		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano);
	}

	public boolean seCantoEnvido(){
		return false;
	}

	public boolean seCantoTruco() {
		return false;
	}
}
