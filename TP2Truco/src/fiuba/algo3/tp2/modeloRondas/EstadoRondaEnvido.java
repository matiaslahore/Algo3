package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.tiposDeCanto.TiposDeCantoEnvido;

public class EstadoRondaEnvido extends EstadoRondas{
	
	private TiposDeCantoEnvido cantosEnvido;
	
	public EstadoRondaEnvido(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano, TiposDeCantoEnvido tipoDeCanto) {
		
		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
		this.cantosEnvido = tipoDeCanto;
	}
	
	@Override
	public EstadoRondas siguienteRonda() {
		return this.refEstadoRonda;
	}
	
	public EstadoRondas acualizarRonda() {
		return this;
	}
	
	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.get(this.jugadorManoDeLaRondaActual + 2); //2 es manejo de indices //aclarar
		return jugador;
	}
	
	public EstadoRondas quiero(Jugador jugador) {
		for ( int i = 0 ; i <= (this.jugadores.size() - 1) ; i=i+1 ){
			Jugador actual = this.jugadores.get(i);
			tantoEnJuego.add(actual.obtenerPuntosEnvido());
		}
		
		int tantoGanador = this.juez.quienGanaElTanto(this.tantoEnJuego);
		int indexTantoGanador = this.tantoEnJuego.indexOf(tantoGanador); //gana el q es mano tmb
		
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexTantoGanador);
		Equipo eqPerdedor = (this.jugadores.get(this.jugadorMano + indexTantoGanador + 1)).obtenerEquipo();
		
		if(this.cantosEnvido.quiso() == -1){
			this.juez.obtenerPuntosFaltaEnvido(eqPerdedor);
		}
		else{
			this.juez.puntosEnJuego(this.cantosEnvido.quiso());
		}
		
		this.juez.anotarPuntos(ganador.obtenerEquipo());
		
		this.juez.puntosEnJuego(1);
		
		this.tantoEnJuego.clear();
		
		return this.refEstadoRonda;
	}
	
	public EstadoRondas noQuiero(Jugador jugador) {
		this.juez.puntosEnJuego(this.cantosEnvido.noQuiso());
		//ESTO ES FEO PERO NO SE ME OCURRE JUSTO AHORA OTRA MANERA
		this.juez.anotarPuntos((this.jugadores.get(this.jugadores.indexOf(jugador) + 1)).obtenerEquipo());
		this.jugadorMano = this.jugadorMano + 1; //aumento quien empieza la prox mano
		return this.refEstadoRonda;
	}
	
	public EstadoRondas cantarEnvido(Jugador jugador)throws CantoInvalidoException{
		TiposDeCantoEnvido unTipoDeEnvido = null;
		try{
			unTipoDeEnvido = this.cantosEnvido.cantarEnvido(jugador.obtenerEquipo());
		}catch(CantoInvalidoException e){
			throw e;
		}
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual, jugadorMano,unTipoDeEnvido);
	}
	
	public EstadoRondas cantarRealEnvido(Jugador jugador) throws CantoInvalidoException {
		TiposDeCantoEnvido unTipoDeRealEnvido = null;
		try{
			unTipoDeRealEnvido = this.cantosEnvido.cantarRealEnvido(jugador.obtenerEquipo());
		}catch(CantoInvalidoException e){
			throw e;
		}
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual, jugadorMano,unTipoDeRealEnvido);
	}
	
	public EstadoRondas cantarFaltaEnvido(Jugador jugador) throws CantoInvalidoException {
		TiposDeCantoEnvido unTipoDeFaltaEnvido = null;
		try{
			unTipoDeFaltaEnvido = this.cantosEnvido.cantarFaltaEnvido(jugador.obtenerEquipo());
		}catch(CantoInvalidoException e){
			throw e;
		}
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual, jugadorMano,unTipoDeFaltaEnvido);
	}
	
}
