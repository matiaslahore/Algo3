package fiuba.algo3.tp2.modeloJugador;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
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
		/*System.out.println("Juga");
		
		if(this.envido >= 27 && !yaCantoEnvido){
			this.cantarEnvido();
			yaCantoEnvido = true;
			System.out.println("CantoEnvido");
			return;
		}
		
		if (this.refMesa.soyMano()){
			System.out.println("JugoPrimera");
			this.jugarCartaAleatoria();
			return;
		}
		this.jugarCarta(this.manoDelJugador.obtenerMejorCartaParaJugarContra(this.refMesa.obtenerUltimaCartaJugada()));*/
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
}
