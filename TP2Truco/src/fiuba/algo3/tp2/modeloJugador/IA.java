package fiuba.algo3.tp2.modeloJugador;

import java.util.List;

import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mano;
import fiuba.algo3.tp2.modelo.Maso;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modelo.Oyente;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;

public class IA extends Jugador implements Oyente{
	EstadoIA estadoIA;
	int truco;	
	
	public IA(String name, Mesa mesa, Equipo team) {
		super(name, mesa, team);
		estadoIA = new EstadoIARondaUnoInteligente();
	}
	
	public void hacerJugarIA(){
		this.estadoIA.manejador(this);
	}	

	public void jugarCartaAleatoria() {
		this.jugarCarta(this.manoDelJugador.obtenerCartaAleatoria());
	}
	
	@Override
	public void recibirCartas(List<Carta> listaDeCartas){
		manoDelJugador = new Mano(listaDeCartas);
		this.envido = this.manoDelJugador.calcularEnvido();
		this.truco = this.obtenerPuntosTruco();
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
		this.hacerJugarIA();
	}

	@Override
	public void seCantoReTruco() {
		this.setearEstado(new EstadoIACantaronReTruco());
		this.hacerJugarIA();		
	}

	@Override
	public void seCantoValeCuatro() {
		this.setearEstado(new EstadoIACantaronValeCuatro());
		this.hacerJugarIA();
	}

	@Override
	public void seCantoEnvido() {
		this.setearEstado(new EstadoIACantaronEnvido());
		this.hacerJugarIA();
	}

	@Override
	public void seCantoRealEnvido() {
		this.setearEstado(new EstadoIACantaronRealEnvido());
		this.hacerJugarIA();
	}

	@Override
	public void seCantoFaltaEnvido() {
		this.setearEstado(new EstadoIACantaronFaltaEnvido());
		this.hacerJugarIA();
	}

	@Override
	public void seCantoFlor() {
		this.setearEstado(new EstadoIACantaronFlor());
		this.hacerJugarIA();
	}

	@Override
	public void seCantoContraFlor() {
		this.setearEstado(new EstadoIACantaronContraFlor());
		this.hacerJugarIA();
	}

	@Override
	public void seCantoContraFlorAJuego() {
		this.setearEstado(new EstadoIACantaronContraFlorAJuego());
		this.hacerJugarIA();
	}

	@Override
	public void jugarCarta() {
		this.hacerJugarIA();
	}

	public int obtenerPuntosTruco() {
		//Escala max = 13+12+11= 36
		int escala = 0;
		Maso maso = new Maso();
		List<Carta> cartasJugador = this.obtenerCartasDelJugador();
		for(int i=1; i <= 3; i++){
			escala += maso.obtenerRankingDeLaCarta(cartasJugador.get(i).cartaComoString());
		}	
		return escala;
	}
	
	public boolean cantarTrucoIA(){
		return(this.truco >= 7);
	}
	
	public boolean quererTrucoIA(){
		return(this.truco >= 5);
	}
}
