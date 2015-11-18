package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import modeloJugador.Jugador;

public class Truco {
	private String equipoCantor;
	private String equipoAceptor;
	private String equipoGanador;
	private int cantidadDetrucosCantados;
	
	public Truco(){
		this.equipoCantor = this.equipoAceptor = this.equipoGanador = "";
		this.cantidadDetrucosCantados = 1;
	}
	
	public void cantarTruco(Jugador jugadorQueCanta){
		if((equipoCantor != jugadorQueCanta.obtenerEquipoQuePertenece()) && (this.cantidadDetrucosCantados < 4)){ 
			this.equipoCantor = jugadorQueCanta.obtenerEquipoQuePertenece();
			this.cantidadDetrucosCantados++;
		}
	}
	
	public void querer(Jugador jugadorQueQuiere){
		if(jugadorQueQuiere.obtenerEquipoQuePertenece() == this.equipoCantor)
			return;
		this.equipoAceptor = jugadorQueQuiere.obtenerEquipoQuePertenece();
	}
	
	public void noQuerer(Jugador jugadorQueNoQuiere){
		if(jugadorQueNoQuiere.obtenerEquipoQuePertenece() == this.equipoCantor)
			return;
		this.equipoGanador = this.equipoCantor;	
	}	
	
	public int obtenerPuntajeGanador(){
		return this.cantidadDetrucosCantados;
	}
	
	
}
