package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaDos extends EstadoRondas{

	public EstadoRondaDos(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego,ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(estadoRonda,juez, ganadoresRonda, cartasEnJuego,jugadores, indexManoAux, indexMano);
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
			ganadoresRonda.add(ganadoresRonda.get(0)); //gana el q gano primera
		}else{
			Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
			ganadoresRonda.add(ganador.obtenerNombreEquipo());
		}
		System.out.println("RONDA DOS gana " + this.ganadoresRonda.get(1) + "\n");
		
		this.cartasEnJuego.clear();
		
		if (this.ganadoresRonda.get(0) == this.ganadoresRonda.get(1)){ //gano 1ra y 2da el mismo
			this.juez.anotarPuntos(this.ganadoresRonda.get(1));
			this.ganadoresRonda.clear();
			
			this.indexMano = this.indexMano + 1;
			return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.indexMano, this.indexMano);
		}
		
		return new EstadoRondaTres(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.jugadorMano + indexCartaGanadora, this.indexMano);
	}

}
