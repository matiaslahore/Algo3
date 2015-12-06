package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.cantos.EmpezarTruco;
import fiuba.algo3.tp2.cantos.Envido;
import fiuba.algo3.tp2.cantos.FaltaEnvido;
import fiuba.algo3.tp2.cantos.Flor;
import fiuba.algo3.tp2.cantos.RealEnvido;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaUnoPicaPica extends EstadoRondaPicaPica{
	
	private boolean tantoCantado;
	
	public EstadoRondaUnoPicaPica(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> jugadoresOriginal, int indexManoAux, int indexMano, ListaCircular<Jugador> jugadores) {
		
		super(estadoRonda, juez, ganadoresRonda, jugadoresOriginal, indexManoAux, indexMano, jugadores);
		
		this.cantosTruco = new EmpezarTruco();
		
		nuevosJugadores = new ListaCircular<Jugador>();
		nuevosJugadores.add(jugadoresOriginal.get(indexManoAux));
		nuevosJugadores.add(jugadoresOriginal.get(indexManoAux + 3));
		
		jugadorManoDeLaRondaActual = 0;
		
		actualizarCantidadJugadas();
		
		juez.limpiarCartasJugadas();
		juez.puntosEnJuego(1);
	}

	public EstadoRondas siguienteRonda(){
		this.ganadoresRonda.clear();
		
		Carta ganadora = this.juez.obtenerCartaGanadoraDeRonda();
		int indexCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(ganadora);
		
		if (this.juez.hayParda()){
			this.juez.limpiarCartasEnJuegoDeRondaActual();
			System.out.println("RONDA UNO PARDA");
			
			refEstadoRonda = new EstadoRondaDosParda(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorManoDeLaRondaActual, this.jugadorMano);
			refEstadoRonda.modificarCantoTruco(this.cantosTruco);
			return this.refEstadoRonda;
		}
		Jugador ganador = this.nuevosJugadores.get(this.jugadorManoDeLaRondaActual + indexCartaGanadora);
		
		ganadoresRonda.add(ganador.obtenerEquipo());
		
		this.juez.limpiarCartasEnJuegoDeRondaActual();
		
		System.out.println("RONDA UNO la gana: " + this.ganadoresRonda.get(0).obtenerNombre() + "\n");
		
		refEstadoRonda = new EstadoRondaDosPicaPica(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorManoDeLaRondaActual + indexCartaGanadora, this.jugadorMano, nuevosJugadores);
		refEstadoRonda.modificarCantoTruco(this.cantosTruco);
		return this.refEstadoRonda;
	}
	
	public EstadoRondas cantarEnvido(Jugador jugador) throws CantoInvalidoException {
		if (this.tantoCantado) throw new CantoInvalidoException();

		Envido envido = new Envido(jugador.obtenerEquipo());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.tantoCantado = true;
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, nuevosJugadores, jugadorManoDeLaRondaActual - 1, jugadorMano,envido);
	}

	public EstadoRondas cantarRealEnvido(Jugador jugador)throws CantoInvalidoException {
		if (this.tantoCantado) throw new CantoInvalidoException();

		RealEnvido realEnvido = new RealEnvido(jugador.obtenerEquipo());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.tantoCantado = true;
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, nuevosJugadores, jugadorManoDeLaRondaActual - 1, jugadorMano,realEnvido);
	}

	public EstadoRondas cantarFaltaEnvido(Jugador jugador)throws CantoInvalidoException {
		if (this.tantoCantado) throw new CantoInvalidoException();

		FaltaEnvido faltaEnvido = new FaltaEnvido(jugador.obtenerEquipo());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.tantoCantado = true;
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, nuevosJugadores, jugadorMano, jugadorMano,faltaEnvido);
	}

	public EstadoRondas cantarFlor(Jugador jugador) throws CantoInvalidoException {
		if (!jugador.tieneFlor()) throw new CantoInvalidoException();

		if (this.juez.hayOtroEquipoConFlor(jugador.obtenerEquipo())) {
			Flor flor = new Flor(jugador.obtenerEquipo());
			this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
			this.refEstadoRonda = this; //guardo estado de la ronda actual
			return new EstadoRondaFlor(refEstadoRonda, juez, ganadoresRonda, nuevosJugadores, jugadorManoDeLaRondaActual - 1, jugadorMano,flor);
		} 
		juez.puntosEnJuego(3);
		juez.anotarPuntos(jugador.obtenerEquipo());
		juez.puntosEnJuego(1);
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1;
		return this;
	}
	
}
