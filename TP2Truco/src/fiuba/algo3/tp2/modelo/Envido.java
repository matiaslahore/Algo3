package fiuba.algo3.tp2.modelo;

public class Envido {
	private Equipo EquipoCantor;
	private Equipo EquipoAceptor;
	private int puntaje;
	
	public Envido(){
	}
	
	public void cantarEnvido(Equipo equipoQueCanta){
		this.EquipoCantor = equipoQueCanta;
	}
	
	public void querer(Equipo equipoQueQuiere){
		this.EquipoAceptor = equipoQueQuiere;
	}
	
	public String obtenerGanador(){
		return "";
	}
	
	public int obtenerPuntajeGanador(){
		return this.puntaje;
	}
	
}

