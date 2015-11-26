package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.tiposDeCanto.TiposDeCantoTruco;

public class EstadoRondaDosParda extends EstadoRondas{
	//SE CANTA EL TRUCO
	//SE JUEGAN CARTAS
	//SE EMPARDA
	//IRSE AL MAZO
	//SE GANA

	public EstadoRondaDosParda(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda,
			ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {

		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
	}

	public EstadoRondas ganador(){
	
		TipoDeCartas ganadora = this.juez.obtenerCartaGanadoraDeRonda();

		int indexCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(ganadora);

		if (this.juez.hayParda()){ //es parda
			this.juez.limpiarCartasEnJuegoDeRondaActual();
			System.out.println("RONDA DOS PARDA");
			ganadoresRonda.add("Parda"); //esto se podria sacar..pero es para el test
		
			refEstadoRonda = new EstadoRondaTresParda(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorManoDeLaRondaActual, this.jugadorMano);
			refEstadoRonda.modificarCantoTruco(this.cantosTruco);
			return this.refEstadoRonda;
		}

		Jugador ganador = this.jugadores.get(this.jugadorManoDeLaRondaActual + indexCartaGanadora);
		ganadoresRonda.add(ganador.obtenerNombreEquipo());

		this.juez.anotarPuntos(ganador.obtenerNombreEquipo());
		
		System.out.println("RONDA DOS gana " + this.ganadoresRonda.get(1) + "\n");
		
		this.juez.limpiarCartasEnJuegoDeRondaActual();
		
		this.jugadorMano = this.jugadorMano + 1; //aumento quien empieza la prox mano
		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano);		
	}
	
}
