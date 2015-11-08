package fiuba.algo3.tp2.modelo;

public class Envido {
	private Jugador EquipoCantor;
	private Jugador EquipoAceptor;
	
	public Envido(){
	}
	
	public void cantarEnvido(Jugador jugadorQueCanta){
		this.EquipoCantor = jugadorQueCanta;
	}
	
	public void querer(Jugador jugadorQueQuiere){
		this.EquipoAceptor = jugadorQueQuiere;
	}
	
	public String obtenerGanador(Jugador jugadorQueQuiere){
		return "";
	}
	
	
}

