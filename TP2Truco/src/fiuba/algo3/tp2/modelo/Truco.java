package fiuba.algo3.tp2.modelo;

public class Truco {
	private Jugador EquipoCantor;
	private Jugador EquipoAceptor;
	
	public Truco(){
	}
	
	public void cantarTruco(Jugador jugadorQueCanta){
		this.EquipoCantor = jugadorQueCanta;
	}
	
	public void querer(Jugador jugadorQueQuiere){
		this.EquipoAceptor = jugadorQueQuiere;
	}
	
	public String obtenerGanador(Jugador jugadorQueQuiere){
		return "";
	}
	
}
