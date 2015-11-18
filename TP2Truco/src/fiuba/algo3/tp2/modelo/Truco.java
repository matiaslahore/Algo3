package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Truco {
	private String equipo1;
	private String equipo2;
	private String equipoGanador;
	private int puntosGanados;
	private int cantidadDetrucosCantados;
	
	public Truco(String equipo1,String equipo2){
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.equipoGanador = "";
		this.puntosGanados = 0;
		this.cantidadDetrucosCantados = 0;
	}
	
	public void cantarTruco(Equipo equipoQueCanta){
		if((equipoQueCanta != this.equipoCantor) && (this.cantidadDetrucosCantados < 4)){ 
			this.equipoCantor = equipoQueCanta;
			this.cantidadDetrucosCantados++;
		}
	}
	
	public void querer(Equipo equipoQueQuiere){
		if(equipoQueQuiere == this.equipoCantor)
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
