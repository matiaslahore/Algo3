package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaDos extends EstadoRondas{

	public EstadoRondaDos(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> listaDeJugadoresActual, int indiceJugadorManoDeLaRondaActual) {

		super(estadoRonda, juez, ganadoresRonda, listaDeJugadoresActual, indiceJugadorManoDeLaRondaActual);
	}

	public EstadoRondas siguienteRonda(){

		int indiceCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(this.juez.obtenerCartaGanadoraDeRonda());

		Equipo equipoGanador;

		if (this.juez.hayParda()){
			equipoGanador = ganadoresRonda.get(0);
			ganadoresRonda.add(equipoGanador); //gana el q gano primera
		}else{
			Jugador jugadorGanador = this.jugadores.get(this.indiceJugadorManoDeLaRondaActual + indiceCartaGanadora);
			equipoGanador = jugadorGanador.obtenerEquipo();
			ganadoresRonda.add(equipoGanador);
		}

		System.out.println("RONDA DOS gana " + equipoGanador.obtenerNombre() + "\n");

		this.juez.limpiarCartasEnJuegoDeRondaActual();

		if (this.ganadoresRonda.get(0) == equipoGanador){ //gano 1ra y 2da el mismo
			this.juez.finalizoLaMano(equipoGanador);
			this.ganadoresRonda.clear();

			this.indiceJugadorMano = this.indiceJugadorMano + 1;

			return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual);
		}

		return new EstadoRondaTres(refEstadoRonda, juez, ganadoresRonda, this.jugadores, this.indiceJugadorManoDeLaRondaActual + indiceCartaGanadora);
	}
}
