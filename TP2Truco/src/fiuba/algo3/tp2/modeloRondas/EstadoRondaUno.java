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

public class EstadoRondaUno extends EstadoRondas{
	//OPCIONES EN ESTA RONDA:
	//EN RONDA UNO SE REPARTE
	//SE CANTA EL ENVIDO
	//SE CANTA EL TRUCO
	//SE JUEGAN CARTAS
	//SE EMPARDA
	//IRSE AL MAZO
	
	private boolean tantoCantado;
	
	public EstadoRondaUno(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {

		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
		this.cantosTruco = new EmpezarTruco(); //ronda uno empiezo desde cero
		
		actualizarPicaPica();
		
		juez.puntosEnJuego(1);
		
		tantoCantado = false;
	}
	
	public EstadoRondas siguienteRonda(){
		this.ganadoresRonda.clear();
		
		Carta ganadora = this.juez.obtenerCartaGanadoraDeRonda();
		int indexCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(ganadora);
		
		if (this.juez.hayParda()){ //es parda
			this.juez.limpiarCartasEnJuegoDeRondaActual();
			System.out.println("RONDA UNO PARDA");
			
			refEstadoRonda = new EstadoRondaDosParda(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorManoDeLaRondaActual, this.jugadorMano);
			refEstadoRonda.modificarCantoTruco(this.cantosTruco);
			return this.refEstadoRonda;
		}
		Jugador ganador = this.jugadores.get(this.jugadorManoDeLaRondaActual + indexCartaGanadora);
		ganadoresRonda.add(ganador.obtenerEquipo());
		
		this.juez.limpiarCartasEnJuegoDeRondaActual();
		
		System.out.println("RONDA UNO la gana: " + this.ganadoresRonda.get(0).obtenerNombre() + "\n");
		
		refEstadoRonda = new EstadoRondaDos(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorManoDeLaRondaActual + indexCartaGanadora, this.jugadorMano);
		refEstadoRonda.modificarCantoTruco(this.cantosTruco);
		return this.refEstadoRonda;
	}
	
	public EstadoRondas cantarEnvido(Jugador jugador) throws CantoInvalidoException {
		if (this.tantoCantado) throw new CantoInvalidoException();
		
		Envido envido = new Envido(jugador.obtenerEquipo());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.tantoCantado = true;
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual - 1, jugadorMano,envido);
	}

	public EstadoRondas cantarRealEnvido(Jugador jugador)throws CantoInvalidoException {
		if (this.tantoCantado) throw new CantoInvalidoException();
		
		RealEnvido realEnvido = new RealEnvido(jugador.obtenerEquipo());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.tantoCantado = true;
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual - 1, jugadorMano,realEnvido);
	}

	public EstadoRondas cantarFaltaEnvido(Jugador jugador)throws CantoInvalidoException {
		if (this.tantoCantado) throw new CantoInvalidoException();
		
		FaltaEnvido faltaEnvido = new FaltaEnvido(jugador.obtenerEquipo());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.tantoCantado = true;
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorMano, jugadorMano,faltaEnvido);
	}

	public EstadoRondas cantarFlor(Jugador jugador) throws CantoInvalidoException {
		if (this.tantoCantado) throw new CantoInvalidoException();
		
		Flor envido = new Flor(jugador.obtenerEquipo());
		this.jugadorManoDeLaRondaActual = this.jugadorManoDeLaRondaActual - 1; //asi dsps vuelve al q canto la mano
		this.tantoCantado = true;
		this.refEstadoRonda = this; //guardo estado de la ronda actual
		return new EstadoRondaFlor(refEstadoRonda, juez, ganadoresRonda, jugadores, jugadorManoDeLaRondaActual - 1, jugadorMano,envido);
	}

}
