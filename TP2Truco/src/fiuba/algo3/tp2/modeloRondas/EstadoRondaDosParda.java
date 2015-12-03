package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaDosParda extends EstadoRondas{
	//SE CANTA EL TRUCO
	//SE JUEGAN CARTAS
	//SE EMPARDA
	//IRSE AL MAZO
	//SE GANA

	public EstadoRondaDosParda(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {

		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
	}

	public EstadoRondas siguienteRonda(){

		Carta ganadora = this.juez.obtenerCartaGanadoraDeRonda();

		int indexCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(ganadora);

		if (this.juez.hayParda()){
			this.juez.limpiarCartasEnJuegoDeRondaActual();
			System.out.println("RONDA DOS PARDA");

			refEstadoRonda = new EstadoRondaTresParda(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorManoDeLaRondaActual, this.jugadorMano);
			refEstadoRonda.modificarCantoTruco(this.cantosTruco);
			return this.refEstadoRonda;
		}

		Jugador ganador = this.jugadores.get(this.jugadorManoDeLaRondaActual + indexCartaGanadora);
		ganadoresRonda.add(ganador.obtenerEquipo());

		this.juez.anotarPuntos(ganador.obtenerEquipo());

		System.out.println("RONDA DOS gana " + this.ganadoresRonda.get(0).obtenerNombre() + "\n");

		this.juez.limpiarCartasEnJuegoDeRondaActual();

		this.jugadorMano = this.jugadorMano + 1; //aumento quien empieza la prox mano

		this.juez.mezclar(); //renuevo el mazo
		repartir();
		
		if (esPicaPica()){
			if (this.juez.cantidadDeJugadas() == 4){
				this.juez.resetearcantidadDeJugadas();
				
				this.juez.mezclar(); //renuevo el mazo
				repartir();
				
				return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano - 2, this.jugadorMano);
			}
			else {
				return new EstadoRondaUnoPicaPica(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano, jugadores);
			}
		}

		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano);		
	}
}
