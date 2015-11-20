package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaUno extends EstadoRondas{

	public EstadoRondaUno(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego,ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, indexManoAux, indexMano);
	}
	
	//EN RONDA UNO SE REPARTE
	//SE CANTA EL ENVIDO
	//SE CANTA EL TRUCO
	//SE JUEGAN CARTAS
	//SE EMPARDA
	//IRSE AL MAZO
	
	public EstadoRondas ganador(){
		this.ganadoresRonda.clear();
		
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		
		if (indexCartaGanadora == -1){ //es parda
			this.cartasEnJuego.clear();
			System.out.println("RONDA UNO PARDA");
			ganadoresRonda.add("Parda"); //esto se podria sacar..pero es para el test
			return new EstadoRondaDosParda(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.jugadorMano, this.indexMano);
		}
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.returnEquipo());
		
		this.cartasEnJuego.clear();
		
		System.out.println("RONDA UNO la gana: " + this.ganadoresRonda.get(0) + "\n");
		
		return new EstadoRondaDos(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.jugadorMano + indexCartaGanadora, this.indexMano);
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
