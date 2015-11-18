package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Envido {
	private Equipo equipoCantor;
	private Equipo equipoAceptor;
	private Equipo ganador;
	private int puntosGanados;
	private int cantidadDeEnvidosCantados;
	
	public Envido(){
		this.puntosGanados = cantidadDeEnvidosCantados = 0;
		this.equipoAceptor = this.equipoCantor = this.ganador = null;
	}
	
	public void cantarEnvido(Equipo equipoQueCanta){
		if((equipoQueCanta != this.equipoCantor) && (this.cantidadDeEnvidosCantados < 2)){ 
			this.equipoCantor = equipoQueCanta;
			this.cantidadDeEnvidosCantados++;
		}
	}
	
	public void querer(Equipo equipoQueQuiere){
		if(equipoQueQuiere == this.equipoCantor)
			return;
		this.equipoAceptor = equipoQueQuiere;
		this.sumarCartasEnvido();
		this.puntosGanados = (2 * this.cantidadDeEnvidosCantados);
	}
	
	public Equipo obtenerGanador(){
		return ganador;
	}
	
	public int obtenerPuntajeGanador(){
		return this.puntosGanados;
	}
	
	public void noQuerer(Equipo equipoQueNoQuiere){
		if(equipoQueNoQuiere == this.equipoCantor)
			return;
		this.ganador = this.equipoCantor;
		this.puntosGanados = this.cantidadDeEnvidosCantados;		
	}
	
}

