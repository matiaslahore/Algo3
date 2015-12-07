package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.cantos.EstadoCantoFlor;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.NoSePuedeJugarUnaCartaException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaFlor extends EstadoRondas {
	
	private EstadoCantoFlor cantosFlor;

	public EstadoRondaFlor(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> listaDeJugadoresActual, int indiceJugadorManoDeLaRondaActual, EstadoCantoFlor tipoDeCanto) {
		
		super(estadoRonda, juez, ganadoresRonda, listaDeJugadoresActual, indiceJugadorManoDeLaRondaActual);
		this.cantosFlor = tipoDeCanto;
	}

	@Override
	public EstadoRondas siguienteRonda() {
		return this.refEstadoRonda;
	}
	
	public EstadoRondas acualizarRonda() {
		return this;
	}
	
	public Jugador turnoDe() {
		Jugador jugador = this.juez.otroJugadorConFlor(this.cantosFlor.equipoQueCanta());
		return jugador;
	}
	
	public void jugarCarta() {
		throw new NoSePuedeJugarUnaCartaException();
	}
	
	public EstadoRondas quiero(Jugador jugador) {
		for ( int i = 0 ; i <= (this.jugadores.size() - 1) ; i=i+1 ){
			Jugador actual = this.jugadores.get(i);
			tantoEnJuego.add(actual.obtenerPuntosFlor());
		}
		
		int tantoGanador = this.juez.quienGanaElTanto(this.tantoEnJuego);
		int indexTantoGanador = this.tantoEnJuego.indexOf(tantoGanador); //gana el q es mano tmb
		
		Jugador ganador = this.jugadores.get(this.indiceJugadorMano + indexTantoGanador);
		
		this.juez.puntosEnJuego(this.cantosFlor.quiso());
		
		this.juez.anotarPuntos(ganador.obtenerEquipo());
		
		this.tantoEnJuego.clear();
		
		return this.refEstadoRonda;
	}
	
	public EstadoRondas noQuiero(Jugador jugador) {
		this.juez.puntosEnJuego(this.cantosFlor.noQuiso());
		
		this.juez.anotarPuntos((this.jugadores.get(this.jugadores.indexOf(jugador) + 1)).obtenerEquipo());
		this.indiceJugadorMano = this.indiceJugadorMano + 1; //aumento quien empieza la prox mano
		return this.refEstadoRonda;
	}
	
	public EstadoRondas cantarContraFlor(Jugador jugador)throws CantoInvalidoException{
		EstadoCantoFlor unTipoDeFlor = null;
		unTipoDeFlor = this.cantosFlor.cantarContraFlor(jugador.obtenerEquipo());	
		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual + 1;
		return new EstadoRondaFlor(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual, unTipoDeFlor);
	}
	
	public EstadoRondas cantarContraFlorAJuego(Jugador jugador) throws CantoInvalidoException {
		EstadoCantoFlor unTipoDeFlor = null;
		unTipoDeFlor = this.cantosFlor.cantarContraFlorAJuego(jugador.obtenerEquipo());
		this.indiceJugadorManoDeLaRondaActual = this.indiceJugadorManoDeLaRondaActual + 1;
		return new EstadoRondaFlor(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual, unTipoDeFlor);
	}
	
	public boolean seCantoEnvido() {
		return true;
	}
}
