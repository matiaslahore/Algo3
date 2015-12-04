package fiuba.algo3.tp2.modeloJugador;

import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modelo.Oyente;

public class IA extends Jugador implements Oyente{

	EstadoIA estadoIA;
	
	public IA(String name, Mesa mesa, Equipo team) {
		super(name, mesa, team);
		estadoIA = new EstadoIARondaUnoInteligente();
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

	@Override
	public void seCantoTruco() {
		this.setearEstado(new EstadoIACantaronTruco());
		this.juga();
	}

	@Override
	public void seCantoReTruco() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoValeCuatro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoEnvido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoRealEnvido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoFaltaEnvido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoFlor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoContraFlor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoContraFlorAJuego() {
		// TODO Auto-generated method stub
		
	}
}
