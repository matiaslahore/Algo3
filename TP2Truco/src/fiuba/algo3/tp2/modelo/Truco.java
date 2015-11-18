package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Truco {
	private String equipoCantor;
	private String equipoAceptor;
	private String equipoGanador;
	private int puntosGanados;
	private int cantidadDetrucosCantados;
	
	public Truco(){
		this.equipoCantor = this.equipoAceptor = this.equipoGanador = "";
		this.puntosGanados = 0;
		this.cantidadDetrucosCantados = 0;
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
		this.equipoAceptor = equipoQueQuiere;
		this.sumarCartasTruco();
		this.puntosGanados = (this.cantidadDetrucosCantados);
	}
	
	public Equipo obtenerGanador(){
		return(this.ganador);
	}
	
	public int obtenerPuntajeGanador(){
		return this.puntosGanados;
	}
	
	public void noQuerer(Equipo equipoQueNoQuiere){
		if(equipoQueNoQuiere == this.equipoCantor)
			return;
		this.ganador = this.equipoCantor;
		this.puntosGanados = this.cantidadDetrucosCantados;		
	}
}
