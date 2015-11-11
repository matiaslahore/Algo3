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
		if((equipoQueCanta != this.equipoCantor) && (this.cantidadDeFloresCantadas < 1)){ 
			this.equipoCantor = equipoQueCanta;
			this.cantidadDeFloresCantadas++;
		}
	}
	
	public void querer(Equipo equipoQueQuiere){
		if(equipoQueQuiere == this.equipoCantor)
			return;
		this.equipoAceptor = equipoQueQuiere;
		this.sumarCartasFlor();
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
		this.puntosGanados = (this.cantidadDeFloresCantadas * 3);		
	}
	
	//Falta que Jugador sepa sumar los puntos de la flor
	private void sumarCartasFlor(){
		ArrayList<Jugador> jugadoresEquipo1 = this.equipoCantor.obtenerJugadores(); //Una vez creada la clase juez, pedir a
		ArrayList<Jugador> jugadoresEquipo2 = this.equipoAceptor.obtenerJugadores();//juez quien es la mano y ponerlo como eq1
		int puntajeMaximo = 0;
		for(int i=1; i<= 3; i++){
			if(jugadoresEquipo1.get(i).obtenerPuntosEnvidoConFlor() > puntajeMaximo){
				puntajeMaximo = jugadoresEquipo1.get(i).obtenerPuntosEnvidoConFlor();
				this.ganador = this.equipoCantor;
			}
			if(jugadoresEquipo2.get(i).obtenerPuntosEnvidoConFlor() > puntajeMaximo){
				puntajeMaximo = jugadoresEquipo1.get(i).obtenerPuntosEnvidoConFlor();
				this.ganador = this.equipoAceptor;
			}
		}
		if(puntajeMaximo == 0){
			this.ganador = this.equipoCantor;
		}
	}
	
}
