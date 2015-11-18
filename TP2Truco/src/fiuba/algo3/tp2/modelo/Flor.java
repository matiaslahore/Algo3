package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Flor {
	private Equipo equipoCantor;
	private Equipo equipoAceptor;
	private Equipo ganador;
	private int puntosGanados;
	private int cantidadDeFloresCantadas;
	
	public Flor(){
		this.puntosGanados = cantidadDeFloresCantadas = 0;
		this.equipoAceptor = this.equipoCantor = this.ganador = null;
	}
	
	public void cantarFlor(Equipo equipoQueCanta){
		if((equipoQueCanta != this.equipoCantor) && (this.cantidadDeFloresCantadas < 2)){ 
			this.equipoCantor = equipoQueCanta;
			this.cantidadDeFloresCantadas++;
		}
	}
	
	public void querer(Equipo equipoQueQuiere){
		if(equipoQueQuiere == this.equipoCantor)
			return;
		this.equipoAceptor = equipoQueQuiere;
		this.puntosGanados = (3 * this.cantidadDeFloresCantadas);
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
		this.puntosGanados = 3;
		if(this.cantidadDeFloresCantadas == 2)
			this.puntosGanados++;		
	}
}
