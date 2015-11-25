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
		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
	}
	
	//SE CANTA EL TRUCO
	//SE JUEGAN CARTAS
	//SE EMPARDA
	//IRSE AL MAZO
	//SE GANA

	public EstadoRondas ganador(){
	
		if (this.juez.hayParda()){ //es parda
			this.juez.limpiarCartasEnJuegoDeRondaAnterior();
			System.out.println("RONDA DOS PARDA");
			ganadoresRonda.add("Parda"); //esto se podria sacar..pero es para el test
			return new EstadoRondaTresParda(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.jugadorMano, this.indexMano);
		}
		
		TipoDeCartas ganadora = this.juez.obtenerCartaGanadoraDeRonda();
		//int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		int indexCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(ganadora);
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.obtenerNombreEquipo());

		this.juez.anotarPuntos(ganador.obtenerNombreEquipo());
		
		System.out.println("RONDA DOS gana " + this.ganadoresRonda.get(1) + "\n");

		this.juez.limpiarCartasEnJuegoDeRondaAnterior();

		this.indexMano = this.indexMano + 1; //aumento quien empieza la prox mano
		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.indexMano, this.indexMano);		
	}
	
}
