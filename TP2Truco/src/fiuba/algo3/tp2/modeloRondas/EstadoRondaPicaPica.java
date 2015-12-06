package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaPicaPica extends EstadoRondas{
	
	ListaCircular<Jugador> nuevosJugadores;
	
	public EstadoRondaPicaPica(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> jugadoresOriginal, int indexManoAux, int indexMano, ListaCircular<Jugador> jugadores) {
		
		super(estadoRonda, juez, ganadoresRonda, jugadoresOriginal, indexManoAux, indexMano);
	}
	
	public void actualizarCantidadJugadas(){
		this.juez.actualizarCantidadJugadas();
	}
	
	public int cantidadDeJugadas(){
		return this.juez.cantidadDeJugadas();
	}

	public EstadoRondas acualizarRonda() {
		if (this.juez.termino()){
			return new EstadoPartidaFinalizada(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano);
		}
		
		if (this.juez.cantidadDeCartasEnJuego() == 2){ //2 jugadores
			return siguienteRonda();
		}
		return this;
	}

	public Jugador turnoDe() {
		Jugador jugador = this.nuevosJugadores.get(this.jugadorManoDeLaRondaActual);
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
		return jugador;
	}

	@Override
	public EstadoRondas siguienteRonda(){
		return null;
	}
	
	public EstadoRondas cantarTruco(Jugador jugador)throws CantoInvalidoException, EquipoQueCantaNoPuedeVolverACantarException {
		this.cantosTruco = this.cantosTruco.cantarTruco(jugador.obtenerEquipo());
		
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, nuevosJugadores, jugadorManoDeLaRondaActual - 1, jugadorMano, this.cantosTruco);
	}

	public EstadoRondas cantarQuieroReTruco(Jugador jugador) {
		this.cantosTruco = this.cantosTruco.cantarQuieroReTruco(jugador.obtenerEquipo());
		
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, nuevosJugadores, jugadorManoDeLaRondaActual - 1, jugadorMano, this.cantosTruco);
	}

	public EstadoRondas cantarQuieroValeCuatro(Jugador jugador) {
		this.cantosTruco = this.cantosTruco.cantarQuieroValeCuatro(jugador.obtenerEquipo());
		
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, nuevosJugadores, jugadorManoDeLaRondaActual - 1, jugadorMano, this.cantosTruco);
	}

}
