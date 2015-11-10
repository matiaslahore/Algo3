package fiuba.algo3.tp2.modelo;

public class Envido {
	private Equipo equipoCantor;
	private Equipo equipoAceptor;
	private int puntaje;
	private Equipo ganador;
	
	public Envido(){
		this.puntaje = 0;
		this.equipoAceptor = this.equipoCantor = this.ganador = null;
	}
	
	public void cantarEnvido(Equipo equipoQueCanta){
		this.equipoCantor = equipoQueCanta;
	}
	
	public void querer(Equipo equipoQueQuiere){
		if(equipoQueQuiere == this.equipoCantor){
			return;
		}
		this.equipoAceptor = equipoQueQuiere;
	}
	
	public Equipo obtenerGanador(){
		return ganador;
	}
	
	public int obtenerPuntajeGanador(){
		return this.puntaje;
	}
	
	public void noQuerer(Equipo equipoQueNoQuiere){
		if(equipoQueNoQuiere == this.equipoCantor){
			return;
		}
		this.ganador = this.equipoCantor;
		this.puntaje = 1;		
	}
	
}

