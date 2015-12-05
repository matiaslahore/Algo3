package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.cantos.CantosTruco;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaTruco extends EstadoRondas{

	public EstadoRondaTruco(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano,CantosTruco estadoTruco) {
		
		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
		this.cantosTruco = estadoTruco;
	}

	@Override
	public EstadoRondas siguienteRonda() {
		return this.refEstadoRonda;
	}
	
	public EstadoRondas acualizarRonda() {
		return this;
	}

	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.get(this.jugadorManoDeLaRondaActual + 2); //2 es manejo de indices //aclarar
		return jugador;
	}
	
	@Override
	public EstadoRondas quiero(Jugador jugador) {
		refEstadoRonda.juez.puntosEnJuego(this.cantosTruco.quiso());
		refEstadoRonda.modificarCantoTruco(this.cantosTruco); //actualizo el canto de la ronda que se este jugando
		return this.refEstadoRonda;
	}
	
	@Override
	public EstadoRondas noQuiero(Jugador jugador) {
		this.juez.puntosEnJuego(this.cantosTruco.noQuiso());
		this.juez.anotarPuntos((this.jugadores.get(this.jugadores.indexOf(jugador) + 1)).obtenerEquipo());
		this.jugadorMano = this.jugadorMano + 1; //aumento quien empieza la prox mano
		
		this.juez.mezclar(); //renuevo el mazo
		repartir();
		
		if (esPicaPica()){
			return new EstadoRondaUnoPicaPica(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano, jugadores);
		}
		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano);
	}
	
	public EstadoRondas cantarTruco(Jugador jugador) {
		throw new CantoInvalidoException(); //se canta truco, truco
	}
	
	public EstadoRondas cantarQuieroReTruco(Jugador jugador) {
		
		this.cantosTruco = this.cantosTruco.cantarQuieroReTruco(jugador.obtenerEquipo());	
		//asi dsps vuelve al q canto la mano
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1; 
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual, jugadorMano, this.cantosTruco);
	}
	
	public EstadoRondas cantarQuieroValeCuatro(Jugador jugador) {
		this.cantosTruco = this.cantosTruco.cantarQuieroValeCuatro(jugador.obtenerEquipo());	
		//asi dsps vuelve al q canto la mano
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1; 
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual, jugadorMano, this.cantosTruco);
	}

}
