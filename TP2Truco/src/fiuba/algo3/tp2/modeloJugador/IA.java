package fiuba.algo3.tp2.modeloJugador;

import fiuba.algo3.tp2.excepciones.SeEstaJugandoSinFlorException;
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
		this.setearEstado(new EstadoIACantaronReTruco());
		this.juga();		
	}

	@Override
	public void seCantoValeCuatro() {
		this.setearEstado(new EstadoIACantaronValeCuatro());
		this.juga();
	}

	@Override
	public void seCantoEnvido() {
		this.setearEstado(new EstadoIACantaronEnvido());
		this.juga();
	}

	@Override
	public void seCantoRealEnvido() {
		this.setearEstado(new EstadoIACantaronRealEnvido());
		this.juga();
	}

	@Override
	public void seCantoFaltaEnvido() {
		this.setearEstado(new EstadoIACantaronFaltaEnvido());
		this.juga();
	}

	@Override
	public void seCantoFlor() {
		throw new SeEstaJugandoSinFlorException();
	}

	@Override
	public void seCantoContraFlor() {
		throw new SeEstaJugandoSinFlorException();
	}

	@Override
	public void seCantoContraFlorAJuego() {
		throw new SeEstaJugandoSinFlorException();
	}
}
