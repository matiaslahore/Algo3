package fiuba.algo3.tp2.modelo;

public class Envido {
	private Equipo equipoCantor;
	private Equipo equipoAceptor;
	private int puntaje;
	private Equipo ganador;
	
	public Envido(){
	}
	
	public void cantarEnvido(Equipo equipoQueCanta){
		this.equipoCantor = equipoQueCanta;
	}
	
	public void querer(Equipo equipoQueQuiere){
		this.equipoAceptor = equipoQueQuiere;
	}
	
	public Equipo obtenerGanador(){
		return ganador;
	}
	
	public int obtenerPuntajeGanador(){
		return this.puntaje;
	}
	
	public void noQuerer(){
		this.ganador = this.equipoCantor;
	}

	public int obtenerPuntosGanados() {
		
		return 1;
	}

	public char[] obtenerGanadorEnvido() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

