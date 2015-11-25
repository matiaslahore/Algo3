package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaTres extends EstadoRondas{

	public EstadoRondaTres(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego,ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, indexManoAux, indexMano);
	}

	//SE CANTA EL TRUCO
	//SE JUEGAN CARTAS
	//SE EMPARDA
	//IRSE AL MAZO
	//SE GANA (SI O SI)

	public EstadoRondas ganador(){
		TipoDeCartas ganadora = this.juez.obtenerCartaGanadoraDeRonda();
		
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		
		if (indexCartaGanadora == -1){ //es parda
			ganadoresRonda.add(ganadoresRonda.get(1)); //gana el q gano segunda
		}else{
			Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
			ganadoresRonda.add(ganador.obtenerNombreEquipo());
		}
		
		this.juez.anotarPuntos(ganadoresRonda.get(2));
		
		System.out.println("RONDA TRES gana: " + this.ganadoresRonda.get(2) + "\n");
		
		this.cartasEnJuego.clear();
		
		this.indexMano = this.indexMano + 1; //aumento quien empieza la prox mano
		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.indexMano, this.indexMano);
	}

}
