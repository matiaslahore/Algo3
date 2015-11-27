package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaTresParda extends EstadoRondas{

	public EstadoRondaTresParda(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {

		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
	}

	public EstadoRondas siguienteRonda(){
		
		TipoDeCartas ganadora = this.juez.obtenerCartaGanadoraDeRonda();
		
		int indexCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(ganadora);
		
		if (this.juez.hayParda()){ //es parda
			ganadoresRonda.add(jugadores.get(jugadorMano).obtenerEquipo()); //gana el eq q es mano
			this.juez.anotarPuntos(jugadores.get(jugadorMano).obtenerEquipo());
		}else{
			Jugador ganador = this.jugadores.get(this.jugadorManoDeLaRondaActual + indexCartaGanadora);
			ganadoresRonda.add(ganador.obtenerEquipo());
			this.juez.anotarPuntos(ganador.obtenerEquipo());
		}
		
		System.out.println("RONDA TRES gana: " + ganadoresRonda.get(2) + "\n");
		
		this.juez.limpiarCartasEnJuegoDeRondaActual();
		
		this.jugadorMano = this.jugadorMano + 1; //aumento quien empieza la prox mano
		
		if (esPicaPica()){
			if (this.juez.cantidadDeJugadas() == 4){
				this.juez.resetearcantidadDeJugadas();
				return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano - 2, this.jugadorMano);
			}
			else {
				return new EstadoRondaUnoPicaPica(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano, jugadores);
			}
		}
		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano);
	}
	
}
