package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeNoQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeQuererElCantoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.excepciones.NoSePuedeCantarMasDeDosEnvidosException;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class Envido {
	private String equipoCantor;
	private String equipoAceptor;
	private String equipoGanador;
	private int puntosGanados;
	private int cantidadDeEnvidosCantados;
	private static final int cantidadDeEnvidosPosibles = 2;
	
	public Envido(){
		this.cantidadDeEnvidosCantados = this.puntosGanados = 0;
		this.equipoAceptor = this.equipoCantor = this.equipoGanador = "";
	}

	public void cantarEnvido(Jugador jugadorQueCanta) throws NoSePuedeCantarMasDeDosEnvidosException, EquipoQueCantaNoPuedeVolverACantarException{
		if(equipoCantor == jugadorQueCanta.obtenerEquipoQuePertenece())
			throw new EquipoQueCantaNoPuedeVolverACantarException();
	    if(this.cantidadDeEnvidosCantados < cantidadDeEnvidosPosibles)
			throw new NoSePuedeCantarMasDeDosEnvidosException();
		this.equipoCantor = jugadorQueCanta.obtenerEquipoQuePertenece();
		this.cantidadDeEnvidosCantados++;
	
	}

	public void querer(Jugador jugadorQueQuiere)throws EquipoQueCantaNoPuedeQuererElCantoException{
		if(jugadorQueQuiere.obtenerEquipoQuePertenece() == this.equipoCantor)
			throw new EquipoQueCantaNoPuedeQuererElCantoException();
		this.equipoAceptor = jugadorQueQuiere.obtenerEquipoQuePertenece();
		this.puntosGanados = (2 * this.cantidadDeEnvidosCantados);
	}

	public void noQuerer(Jugador jugadorQueNoQuiere)throws EquipoQueCantaNoPuedeNoQuererElCantoException{
		if(jugadorQueNoQuiere.obtenerEquipoQuePertenece() == this.equipoCantor)
			throw new EquipoQueCantaNoPuedeNoQuererElCantoException();
		this.equipoGanador = this.equipoCantor;
		this.puntosGanados = this.cantidadDeEnvidosCantados;		
	}

	public int obtenerPuntajeGanador(){
		return this.puntosGanados;
	}

	public boolean puedeCantar(Jugador jugador) {
		return(!(this.equipoCantor == jugador.obtenerEquipoQuePertenece()));
	}

	public String obtenerGanador(){
		return(this.equipoGanador);
	}

}

