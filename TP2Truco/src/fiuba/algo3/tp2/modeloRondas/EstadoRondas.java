package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoExcepcion;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeNoQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class EstadoRondas{

	Juez juez;
	ArrayList<String> ganadoresRonda;
	ListaCircular<Jugador> jugadores;
	ArrayList<TipoDeCartas> cartasEnJuego;
	ArrayList<Integer> tantoEnJuego;
	int jugadorMano;
	int indexMano;
	boolean sigue;
	EstadoRondas refEstadoRonda;
	TiposDeCanto cantosTruco;

	public EstadoRondas(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego,ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano){
		this.juez=juez;
		this.ganadoresRonda = ganadoresRonda;
		this.cartasEnJuego = cartasEnJuego;
		this.jugadores = jugadores;
		//cartasEnJuego = new ArrayList<TipoDeCartas>();
		this.jugadorMano = new Integer(indexManoAux);
		this.indexMano = indexMano; //esto no se toca nunca salvo en la ronda 3 para indicar la mano sig.
		this.refEstadoRonda = estadoRonda;
		this.cantosTruco = new Truco();

		tantoEnJuego = new ArrayList<Integer>();
		//this.cantosEnvido = new Envido();
	}
	
	public EstadoRondas acualizarRonda() {
		if (this.cartasEnJuego.size() == this.jugadores.size()){ //se jugaron todas las cartas
			return ganador();
		}
		else {
			return this;
		}
	}

	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.get(this.jugadorMano);
		this.jugadorMano = this.jugadorMano + 1;
		return jugador;
	}

	public abstract EstadoRondas ganador();

	public EstadoRondas quiero(Jugador jugador){
		throw new RuntimeException();
	}

	public EstadoRondas noQuiero(Jugador jugador){
		throw new RuntimeException();
	}
	
	public EstadoRondas cantarTruco(Jugador jugador) {
		try{
			this.cantosTruco.canto(jugador.obtenerNombreEquipo());
		}catch(EquipoQueCantaNoPuedeQuererElCantoException e){
			throw new RuntimeException(); //nose si conviene agarrar aca esa excepcion...
		}
		this.cantosTruco = new ReTruco();
		this.cantosTruco.equipoQueCanta(jugador.obtenerEquipoQuePertenece());
		this.jugadorMano = (this.jugadorMano - 1); //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexMano, indexMano);
	}
	
	public EstadoRondas cantarQuieroReTruco(Jugador jugador) {
		try{
			this.cantosTruco.canto(jugador.obtenerNombreEquipo());
		}catch(EquipoQueCantaNoPuedeQuererElCantoException e){
			throw new RuntimeException(); //lo mismo q arriba.. nose si conviene
		}
		this.cantosTruco = new ValeCuatro();
		this.jugadorMano = this.jugadorMano - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexMano, indexMano);
	}
	
	public EstadoRondas cantarQuieroValeCuatro(Jugador jugador) {
		try{
			this.cantosTruco.canto(jugador.obtenerNombreEquipo());
		}catch(EquipoQueCantaNoPuedeQuererElCantoException e){
			throw new RuntimeException(); //aca tmb..
		}
		this.cantosTruco = null;
		this.jugadorMano = this.jugadorMano - 1; //asi dsps vuelve al q canto la mano
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaTruco(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexMano, indexMano);
	}

}
