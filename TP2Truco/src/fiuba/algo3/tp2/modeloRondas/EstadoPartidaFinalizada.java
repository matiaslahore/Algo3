package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.excepciones.NoSePuedeSeguirJugandoExcepcion;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.tiposDeCanto.TiposDeCantoTruco;

public class EstadoPartidaFinalizada extends EstadoRondas{

	public EstadoPartidaFinalizada(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda,
			ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
	
		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
	}

	public EstadoRondas siguienteRonda() {
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}
	
	public EstadoRondas acualizarRonda() {
		return this;
	}

	public Jugador turnoDe() {
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}

	public EstadoRondas quiero(Jugador jugador){
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}

	public EstadoRondas noQuiero(Jugador jugador){
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}
	
	public EstadoRondas cantarTruco(Jugador jugador)throws CantoInvalidoException, EquipoQueCantaNoPuedeVolverACantarException {
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}
	
	public EstadoRondas cantarQuieroReTruco(Jugador jugador) {
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}
	
	public EstadoRondas cantarQuieroValeCuatro(Jugador jugador) {
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}
	
	public EstadoRondas cantarEnvido(Jugador jugador) throws CantoInvalidoException {
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}
	
	public EstadoRondas cantarRealEnvido(Jugador jugador)throws CantoInvalidoException {
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}
	
	public EstadoRondas cantarFaltaEnvido(Jugador jugador)throws CantoInvalidoException {
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}

	public void modificarCantoTruco(TiposDeCantoTruco estadoTruco) {
		finalizo();
	}
	
	public EstadoRondas cantarFlor(Jugador jugador) throws CantoInvalidoException {
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}

	public EstadoRondas cantarContraFlor(Jugador jugador) {
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}

	public EstadoRondas cantarContraFlorAJuego(Jugador jugador) {
		finalizo();
		throw new NoSePuedeSeguirJugandoExcepcion();
	}
	
	private void finalizo(){
		System.out.println("PARTIDA FINALIZADA");
		this.juez.imprimirResultados();
	}

}
