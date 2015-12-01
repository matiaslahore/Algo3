package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.cantos.CantosTruco;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
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
		//Termina las Rondas, y se vuelve a tirar las cartas, para una nueva mano
		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano);
	}
	
	public EstadoRondas cantarQuieroReTruco(Jugador jugador) {
		try{
			this.cantosTruco = this.cantosTruco.cantar(jugador.obtenerEquipo());
		}catch(EquipoQueCantaNoPuedeQuererElCantoException e){
			throw new RuntimeException(); //lo mismo q arriba.. nose si conviene
		}
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1; //asi dsps vuelve al q canto la mano
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual, jugadorMano, this.cantosTruco);
	}
	
	public EstadoRondas cantarQuieroValeCuatro(Jugador jugador) {
		try{
			this.cantosTruco = this.cantosTruco.cantar(jugador.obtenerEquipo());
		}catch(EquipoQueCantaNoPuedeQuererElCantoException e){
			throw new RuntimeException(); //lo mismo q arriba.. nose si conviene
		}
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual + 1; //asi dsps vuelve al q canto la mano
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual, jugadorMano, this.cantosTruco);
	}
	
	public boolean seCantoTruco(){
		return true;
	}
}
