package fiuba.algo3.tp2.modeloJugador;

import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mesa;

public class IA extends Jugador{

	EstadoIA estadoIA;
	
	public IA(String name, Mesa mesa, Equipo team) {
		super(name, mesa, team);
		
		estadoIA = new EstadoIAEnvidoInteligente();
	}
	
	public void juga(){
		
		this.estadoIA.manejador(this);
	}	

	public void jugarCartaAleatoria() {
		this.jugarCarta(this.manoDelJugador.obtenerCartaAleatoria());
	}
	
	public void setearEstado(EstadoIA estadoIA){
		this.estadoIA = estadoIA;
	}
	
	public EstadoIA obtenerEstado(){
		return this.estadoIA;
	}

	public boolean esMano() {
		return this.refMesa.esMano();
	}

	public void jugarMejorCarta() {
		this.jugarCarta(this.manoDelJugador.obtenerMejorCartaParaJugarContra(this.refMesa.obtenerUltimaCartaJugada()));
	}

	public boolean seCantoEnvido() {
		return refMesa.seCantoEnvido();
	}

	public boolean seCantoTruco() {
		return refMesa.seCantoTruco();
	}
}
