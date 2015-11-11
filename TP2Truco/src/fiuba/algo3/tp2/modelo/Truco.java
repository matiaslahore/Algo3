package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Truco {
	private Equipo equipoCantor;
	private Equipo equipoAceptor;
	private Equipo ganador;
	private int puntosGanados;
	private int cantidadDetrucosCantados;
	
	public Truco(){
		this.equipoAceptor = this.equipoCantor = this.ganador = null;
		this.puntosGanados = 0;
		this.cantidadDetrucosCantados = 1;
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
	
	//Falta que Jugador sepa sumar los puntos del truco
		private void sumarCartasTruco(){
			ArrayList<Jugador> jugadoresEquipo1 = this.equipoCantor.obtenerJugadores(); //Una vez creada la clase juez, pedir a
			ArrayList<Jugador> jugadoresEquipo2 = this.equipoAceptor.obtenerJugadores();//juez quien es la mano y ponerlo como eq1
			int puntajeMaximo = 0;
			for(int i=1; i<= 3; i++){
				if(jugadoresEquipo1.get(i).obtenerPuntosTruco() > puntajeMaximo){
					puntajeMaximo = jugadoresEquipo1.get(i).obtenerPuntosTruco();
					this.ganador = this.equipoCantor;
				}
				if(jugadoresEquipo2.get(i).obtenerPuntosTruco() > puntajeMaximo){
					puntajeMaximo = jugadoresEquipo1.get(i).obtenerPuntosTruco();
					this.ganador = this.equipoAceptor;
				}
			}
			if(puntajeMaximo == 0){
				this.ganador = this.equipoCantor;
			}
		}
	
}
