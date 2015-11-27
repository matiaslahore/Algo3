package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaDosPicaPica extends EstadoRondaPicaPica{

	public EstadoRondaDosPicaPica(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> jugadoresOriginal, int indexManoAux, int indexMano, ListaCircular<Jugador> jugadores) {

		super(estadoRonda, juez, ganadoresRonda, jugadoresOriginal, indexManoAux, indexMano, jugadores);

		nuevosJugadores = jugadores;
	}

	public EstadoRondas siguienteRonda(){

		Carta ganadora = this.juez.obtenerCartaGanadoraDeRonda();

		int indexCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(ganadora);

		if (this.juez.hayParda()){ //es parda
			ganadoresRonda.add(ganadoresRonda.get(0)); //gana el q gano primera
		}else{
			Jugador ganador = this.nuevosJugadores.get(this.jugadorManoDeLaRondaActual + indexCartaGanadora);
			ganadoresRonda.add(ganador.obtenerEquipo());
		}

		System.out.println("RONDA DOS gana " + this.ganadoresRonda.get(1).obtenerNombre() + "\n");

		this.juez.limpiarCartasEnJuegoDeRondaActual();

		if (this.ganadoresRonda.get(0) == this.ganadoresRonda.get(1)){ //gano 1ra y 2da el mismo
			this.juez.anotarPuntos(this.ganadoresRonda.get(1));
			this.ganadoresRonda.clear();

			this.jugadorMano = this.jugadorMano + 1;

			if (this.juez.cantidadDeJugadas() == 4){
				this.juez.resetearcantidadDeJugadas();
				return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano - 2, this.jugadorMano);
			}
			else {
				return new EstadoRondaUnoPicaPica(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano, nuevosJugadores);
			}

		}
		refEstadoRonda = new EstadoRondaTresPicaPica(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorManoDeLaRondaActual + indexCartaGanadora, this.jugadorMano, nuevosJugadores);
		refEstadoRonda.modificarCantoTruco(this.cantosTruco);
		return this.refEstadoRonda;
	}

}
