package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaTresParda extends EstadoRondas{

	public EstadoRondaTresParda(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexManoAux, indexMano);
	}
	
	public EstadoRondas ganador(){
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);
		
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		
		if (indexCartaGanadora == -1){ //es parda
			ganadoresRonda.add(jugadores.get(indexMano).obtenerNombreEquipo()); //gana el eq q es mano
			this.juez.anotarPuntos(jugadores.get(indexMano).obtenerNombreEquipo());
		}else{
			Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
			ganadoresRonda.add(ganador.obtenerNombreEquipo());
			this.juez.anotarPuntos(ganador.obtenerNombreEquipo());
		}
		
		System.out.println("RONDA TRES gana: " + ganadoresRonda.get(2) + "\n");
		
		this.cartasEnJuego.clear();
		
		this.indexMano = this.indexMano + 1; //aumento quien empieza la prox mano
		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.indexMano, this.indexMano);
	}
	
	@Override
	public EstadoRondas quiero(Jugador jugador) {
		throw new RuntimeException();
	}
	
	@Override
	public EstadoRondas noQuiero(Jugador jugador) {
		throw new RuntimeException();
	}
	
}
