package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaPicaPica extends EstadoRondas{
	
	ListaCircular<Jugador> nuevosJugadores;
	
	public EstadoRondaPicaPica(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda,
			ListaCircular<Jugador> jugadoresOriginal, int indexManoAux, int indexMano, ListaCircular<Jugador> jugadores) {
		
		super(estadoRonda, juez, ganadoresRonda, jugadoresOriginal, indexManoAux, indexMano);
	}

	public EstadoRondas acualizarRonda() {
		
		if (this.juez.termino()){
			return new EstadoPartidaFinalizada(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano);
		}
		
		if (this.juez.cantidadDeCartasEnJuego() == 2){ //2 jugadores
			return ganador();
		}
		return this;
	}

	public Jugador turnoDe() {
		Jugador jugador = this.nuevosJugadores.get(this.jugadorManoDeLaRondaActual);
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1;
		return jugador;
	}

	@Override
	public EstadoRondas ganador(){
		return null;
	}

}
