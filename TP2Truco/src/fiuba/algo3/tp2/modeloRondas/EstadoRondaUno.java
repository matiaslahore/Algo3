package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoExcepcion;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaUno extends EstadoRondas{

	public EstadoRondaUno(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego,ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, indexManoAux, indexMano);
	}
	//OPCIONES EN ESTA RONDA:
	//EN RONDA UNO SE REPARTE
	//SE CANTA EL ENVIDO
	//SE CANTA EL TRUCO
	//SE JUEGAN CARTAS
	//SE EMPARDA
	//IRSE AL MAZO
	
	public EstadoRondas ganador(){
		this.ganadoresRonda.clear();
		
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		
		if (indexCartaGanadora == -1){ //es parda
			this.cartasEnJuego.clear();
			System.out.println("RONDA UNO PARDA");
			ganadoresRonda.add("Parda"); //esto se podria sacar..pero es para el test
			return new EstadoRondaDosParda(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.jugadorMano, this.indexMano);
		}
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.obtenerNombreEquipo());
		
		this.cartasEnJuego.clear();
		
		System.out.println("RONDA UNO la gana: " + this.ganadoresRonda.get(0) + "\n");
		
		return new EstadoRondaDos(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.jugadorMano + indexCartaGanadora, this.indexMano);
	}
	
	public EstadoRondas cantarEnvido(Jugador jugador) {
		Envido envido = new Envido(jugador.obtenerEquipoQuePertenece());
		this.jugadorMano = this.jugadorMano - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexMano, indexMano,envido);
	}
	
	public EstadoRondas cantarRealEnvido(Jugador jugador) {
		RealEnvido realEnvido = new RealEnvido(jugador.obtenerEquipoQuePertenece());
		this.jugadorMano = this.jugadorMano - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexMano, indexMano,realEnvido);
	}
	
	public EstadoRondas cantarFaltaEnvido(Jugador jugador) {
		FaltaEnvido faltaEnvido = new FaltaEnvido(jugador.obtenerEquipoQuePertenece());
		this.jugadorMano = this.jugadorMano - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexMano, indexMano,faltaEnvido);
	}

}
