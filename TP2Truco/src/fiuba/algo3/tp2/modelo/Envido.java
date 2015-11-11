package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Envido {
	private Equipo equipoCantor;
	private Equipo equipoAceptor;
	private int puntosGanados;
	private Equipo ganador;
	
	public Envido(){
		this.puntosGanados = 0;
		this.equipoAceptor = this.equipoCantor = this.ganador = null;
	}
	
	public void cantarEnvido(Equipo equipoQueCanta){
		this.equipoCantor = equipoQueCanta;
	}
	
	public void querer(Equipo equipoQueQuiere){
		if(equipoQueQuiere == this.equipoCantor)
			return;
		this.equipoAceptor = equipoQueQuiere;
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
		this.puntosGanados = 1;		
	}
	
	private void sumarCartasEnvido(){
		ArrayList<Jugador> jugadoresEquipo1 = this.equipoCantor.obtenerJugadores();
		ArrayList<Jugador> jugadoresEquipo2 = this.equipoAceptor.obtenerJugadores();
		int puntajeMaximo = 0;
		for(int i=1; i<= 3; i++){
			if(jugadoresEquipo1.get(i).obtenerPuntosEnvido() > puntajeMaximo){
				puntajeMaximo = jugadoresEquipo1.get(i).obtenerPuntosEnvido();
				this.ganador = this.equipoCantor;
			}
			if(jugadoresEquipo2.get(i).obtenerPuntosEnvido() > puntajeMaximo){
				puntajeMaximo = jugadoresEquipo1.get(i).obtenerPuntosEnvido();
				this.ganador = this.equipoAceptor;
			}
		}
		if(puntajeMaximo == 0){
			this.ganador = this.equipoCantor;
		}
	}
	
	
	
	
	
	
	
}

