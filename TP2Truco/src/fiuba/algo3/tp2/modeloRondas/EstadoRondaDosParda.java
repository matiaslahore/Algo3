package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaDosParda extends EstadoRondas{

	public EstadoRondaDosParda(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego,ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, indexManoAux, indexMano);
	}
	
	//SE CANTA EL TRUCO
	//SE JUEGAN CARTAS
	//SE EMPARDA
	//IRSE AL MAZO
	//SE GANA

	public EstadoRondas ganador(){
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);

		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);

		if (indexCartaGanadora == -1){ //es parda
			this.cartasEnJuego.clear();
			System.out.println("RONDA DOS PARDA");
			ganadoresRonda.add("Parda"); //esto se podria sacar..pero es para el test
			return new EstadoRondaTresParda(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.jugadorMano, this.indexMano);
		}
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.returnEquipo());

		this.juez.anotarPuntos(ganador.returnEquipo());
		
		System.out.println("RONDA DOS gana " + this.ganadoresRonda.get(1) + "\n");

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
