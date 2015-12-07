package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaTres extends EstadoRondas{

	public EstadoRondaTres(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> listaDeJugadoresActual, int indiceJugadorManoDeLaRondaActual) {

		super(estadoRonda, juez, ganadoresRonda, listaDeJugadoresActual, indiceJugadorManoDeLaRondaActual);
	}

	public EstadoRondas siguienteRonda(){

		int indiceCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(this.juez.obtenerCartaGanadoraDeRonda());

		Equipo equipoGanador;
		
		if (this.juez.hayParda()){
			equipoGanador = ganadoresRonda.get(1);
			ganadoresRonda.add(equipoGanador); //gana el q gano segunda
		}else{
			Jugador jugadorGanador = this.jugadores.get(this.indiceJugadorManoDeLaRondaActual + indiceCartaGanadora);
			equipoGanador = jugadorGanador.obtenerEquipo();
			ganadoresRonda.add(equipoGanador);
		}
		
		System.out.println("RONDA TRES gana: " + equipoGanador + "\n");
				
		this.juez.finalizoLaMano(equipoGanador);
		
		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, this.jugadores, indiceJugadorManoDeLaRondaActual);
	}

}
