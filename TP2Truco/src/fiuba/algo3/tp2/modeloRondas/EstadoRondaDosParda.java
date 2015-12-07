package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaDosParda extends EstadoRondas{

	public EstadoRondaDosParda(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> listaDeJugadoresActual, int indiceJugadorManoDeLaRondaActual) {

		super(estadoRonda, juez, ganadoresRonda, listaDeJugadoresActual, indiceJugadorManoDeLaRondaActual);
	}

	public EstadoRondas siguienteRonda(){

		int indiceCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(this.juez.obtenerCartaGanadoraDeRonda());

		if (this.juez.hayParda()){
			this.juez.limpiarCartasEnJuegoDeRondaActual();
			
			System.out.println("RONDA DOS PARDA");

			return new EstadoRondaTresParda(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual);
		}

		Jugador jugadorGanador = this.jugadores.get(this.indiceJugadorManoDeLaRondaActual + indiceCartaGanadora);
		Equipo equipoGanador = jugadorGanador.obtenerEquipo();
		ganadoresRonda.add(equipoGanador);

		System.out.println("RONDA DOS gana " + this.ganadoresRonda.get(0).obtenerNombre() + "\n");

		this.juez.finalizoLaMano(equipoGanador);

		this.indiceJugadorMano = this.indiceJugadorMano + 1; //aumento quien empieza la prox mano

		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, this.jugadores, this.indiceJugadorMano);		
	}
}
