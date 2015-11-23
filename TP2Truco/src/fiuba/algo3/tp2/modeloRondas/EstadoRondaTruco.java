package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaTruco extends EstadoRondas{

	public EstadoRondaTruco(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexManoAux, indexMano);
	}

	@Override
	public EstadoRondas ganador() {
		return this.refEstadoRonda;
	}
	
	public EstadoRondas acualizarRonda() {
		return this;
	}

	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.get(this.jugadorMano + 2); //2 es manejo de indices //aclarar
		return jugador;
	}
	
	@Override
	public EstadoRondas quiero(Jugador jugador) {
		refEstadoRonda.juez.puntosEnJuego(this.cantosTruco.quiso());
		return this.refEstadoRonda;
	}
	
	@Override
	public EstadoRondas noQuiero(Jugador jugador) {
		this.juez.puntosEnJuego(this.cantosTruco.noQuiso());
		this.juez.anotarPuntos((this.jugadores.get(this.jugadores.indexOf(jugador) + 1)).obtenerNombreEquipo());
		this.indexMano = this.indexMano + 1; //aumento quien empieza la prox mano
		//Termina las Rondas, y se vuelve a tirar las cartas, para una nueva mano
		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.indexMano, this.indexMano);
	}
	
}
