package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.tp2.modeloJugador.Jugador;

public class Envido {
	private String equipoCantor;
	private String equipoAceptor;
	private String equipoGanador;
	private int puntosGanados;
	private int cantidadDeEnvidosCantados;
	
	public Envido(){
		this.cantidadDeEnvidosCantados = this.puntosGanados = 0;
		this.equipoAceptor = this.equipoCantor = this.equipoGanador = "";
	}
	
	public void cantarEnvido(Jugador jugadorQueCanta){
		if((equipoCantor != jugadorQueCanta.obtenerEquipoQuePertenece()) && (this.cantidadDeEnvidosCantados < 2)){ 
			this.equipoCantor = jugadorQueCanta.obtenerEquipoQuePertenece();
			this.cantidadDeEnvidosCantados++;
		}
	}
	
	public void querer(Jugador jugadorQueQuiere){
		if(jugadorQueQuiere.obtenerEquipoQuePertenece() == this.equipoCantor)
			return;
		this.equipoAceptor = jugadorQueQuiere.obtenerEquipoQuePertenece();
		this.puntosGanados = (2 * this.cantidadDeEnvidosCantados);
	}

	public void noQuerer(Jugador jugadorQueNoQuiere){
		if(jugadorQueNoQuiere.obtenerEquipoQuePertenece() == this.equipoCantor)
			return;
		this.equipoGanador = this.equipoCantor;
		this.puntosGanados = this.cantidadDeEnvidosCantados;		
	}
	
	public int obtenerPuntajeGanador(){
		return this.puntosGanados;
	}

	public boolean puedeCantar(Jugador jugador) {
		return(!(this.equipoCantor == jugador.obtenerEquipoQuePertenece()));
	}
	
}

