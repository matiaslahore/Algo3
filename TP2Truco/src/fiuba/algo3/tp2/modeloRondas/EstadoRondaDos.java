package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.tiposDeCanto.TiposDeCantoTruco;

public class EstadoRondaDos extends EstadoRondas{
	//SE CANTA EL TRUCO
	//SE JUEGAN CARTAS
	//SE EMPARDA
	//IRSE AL MAZO
	//SE GANA
	
	public EstadoRondaDos(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda,
			ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {

		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
	}

	public EstadoRondas ganador(){
		
		TipoDeCartas ganadora = this.juez.obtenerCartaGanadoraDeRonda();
		
		int indexCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(ganadora);
		
		if (this.juez.hayParda()){ //es parda
			ganadoresRonda.add(ganadoresRonda.get(0)); //gana el q gano primera
		}else{
			Jugador ganador = this.jugadores.get(this.jugadorManoDeLaRondaActual + indexCartaGanadora);
			ganadoresRonda.add(ganador.obtenerNombreEquipo());
		}
				
		System.out.println("RONDA DOS gana " + this.ganadoresRonda.get(1) + "\n");
		
		this.juez.limpiarCartasEnJuegoDeRondaActual();
		
		if (this.ganadoresRonda.get(0) == this.ganadoresRonda.get(1)){ //gano 1ra y 2da el mismo
			this.juez.anotarPuntos(this.ganadoresRonda.get(1));
			this.ganadoresRonda.clear();
			
			this.jugadorMano = this.jugadorMano + 1;
			return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano);
		}
		refEstadoRonda = new EstadoRondaTres(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorManoDeLaRondaActual + indexCartaGanadora, this.jugadorMano);
		refEstadoRonda.modificarCantoTruco(this.cantosTruco);
		return this.refEstadoRonda;
	}

}
