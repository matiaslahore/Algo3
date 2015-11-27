package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.tiposDeCanto.TiposDeCantoFlor;

public class EstadoRondaFlor extends EstadoRondas {
	
	private TiposDeCantoFlor cantosFlor;

	public EstadoRondaFlor(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda,
			ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano, TiposDeCantoFlor tipoDeCanto) {
		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
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
		Jugador jugador = this.jugadores.get(this.jugadorManoDeLaRondaActual + 2); //2 es manejo de indices //aclarar
		return jugador;
	}
	
	public EstadoRondas quiero(Jugador jugador) {
		for ( int i = jugadorManoDeLaRondaActual ; i <= (this.jugadores.size() - 1 + jugadorManoDeLaRondaActual) ; i=i+1 ){
			Jugador actual = this.jugadores.get(i);
			tantoEnJuego.add(actual.obtenerPuntosFlor()); ///////////////VER ESTOOOOOOOOOOOOOOOOOOOOOOOOOOO!!
		}
		
		int tantoGanador = this.juez.quienGanaElTanto(this.tantoEnJuego);
		int indexTantoGanador = this.tantoEnJuego.indexOf(tantoGanador); //gana el q es mano tmb
		
		Jugador ganador = this.jugadores.get(this.jugadorManoDeLaRondaActual + indexTantoGanador);
		
		this.juez.puntosEnJuego(this.cantosFlor.quiso());
		
		this.juez.anotarPuntos(ganador.obtenerNombreEquipo());
		
		this.tantoEnJuego.clear();
		
		return this.refEstadoRonda;
	}
	
	public EstadoRondas noQuiero(Jugador jugador) {
		this.juez.puntosEnJuego(this.cantosFlor.noQuiso());
		
		this.juez.anotarPuntos((this.jugadores.get(this.jugadores.indexOf(jugador) + 1)).obtenerNombreEquipo());
		this.jugadorMano = this.jugadorMano + 1; //aumento quien empieza la prox mano
		return this.refEstadoRonda;
	}
	
	public EstadoRondas cantarContraFlor(Jugador jugador)throws CantoInvalidoException{
		TiposDeCantoFlor unTipoDeFlor = null;
		try{
			unTipoDeFlor = this.cantosFlor.cantarContraFlor(jugador.obtenerEquipoQuePertenece());
		}catch(CantoInvalidoException e){
			throw e;
		}
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
		return new EstadoRondaFlor(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual, jugadorMano,unTipoDeFlor);
	}
	
	public EstadoRondas cantarContraFlorAJuego(Jugador jugador) throws CantoInvalidoException {
		TiposDeCantoFlor unTipoDeFlor = null;
		try{
			unTipoDeFlor = this.cantosFlor.cantarContraFlorAJuego(jugador.obtenerEquipoQuePertenece());
		}catch(CantoInvalidoException e){
			throw e;
		}
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
		return new EstadoRondaFlor(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual, jugadorMano,unTipoDeFlor);
	}

}
