package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class EstadoRondas{

	Juez juez;
	ArrayList<String> ganadoresRonda;
	ListaCircular<Jugador> jugadores;
	ArrayList<TipoDeCartas> cartasEnJuego;
	ArrayList<Integer> tantoEnJuego;
	int jugadorMano;
	int indexMano;
	boolean sigue;
	EstadoRondas refEstadoRonda;

	public EstadoRondas(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego,ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano){
		this.juez=juez;
		this.ganadoresRonda = ganadoresRonda;
		this.cartasEnJuego = cartasEnJuego;
		this.jugadores = jugadores;
		//cartasEnJuego = new ArrayList<TipoDeCartas>();
		tantoEnJuego = new ArrayList<Integer>();
		this.jugadorMano = new Integer(indexManoAux);
		this.indexMano = indexMano; //esto no se toca nunca salvo en la ronda 3 para indicar la mano sig.
		this.refEstadoRonda = estadoRonda;
	}
	
	public EstadoRondas acualizarRonda() {
		if (this.cartasEnJuego.size() == this.jugadores.size()){ //se jugaron todas las cartas
			return ganador();
		}
		else {
			return this;
		}
	}

	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.get(this.jugadorMano);
		this.jugadorMano = this.jugadorMano + 1;
		return jugador;
	}

	public abstract EstadoRondas ganador();

}
