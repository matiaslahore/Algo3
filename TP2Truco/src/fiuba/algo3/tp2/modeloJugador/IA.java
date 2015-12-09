package fiuba.algo3.tp2.modeloJugador;

import java.util.List;

import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mano;
import fiuba.algo3.tp2.modelo.Maso;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modelo.Oyente;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.Copa;
import fiuba.algo3.tp2.modeloDeCartas.Tres;

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
		for(int i=0; i <= 2; i++){
			escala += maso.obtenerRankingDeLaCarta(cartasJugador.get(i).cartaComoString());
		}	
		return escala;
	}
	//Inteligencia cantos Truco
	public boolean cantarTrucoIA(){
		return(this.truco >= 7);
	}
	
	public boolean quererTrucoIA(){
		
		//Acepta si tiene mas que un Tres
		return (this.obtenerCartaMasAltaParaTruco().getClass() == (new Tres(new Copa()).vs(this.obtenerCartaMasAltaParaTruco())).getClass());
		//return(this.truco >= 5);
	}
	
	private Carta obtenerCartaMasAltaParaTruco() {
		
		return this.manoDelJugador.obtenerCartaMasAltaParaTruco();
	}

	public boolean cantarReTrucoIA(){
		return(this.truco >= 18);
	}
	
	public boolean quererReTrucoIA(){
		return(this.truco >= 15);
	}
	
	public boolean cantarValeCuatroIA(){
		return(this.truco >= 31);
	}
	
	public boolean quererValeCuatroIA(){
		return(this.truco >= 28);
	}
	
	//Inteligencia cantos Envido
	public boolean cantarEnvidoIA(){
		return(this.envido >= 27);
	}
	
	public boolean quererEnvidoIA(){
		return(this.envido >= 25);
	}

	public boolean cantarRealEnvidoIA(){
		return(this.envido >= 31);
	}
	
	public boolean quererRealEnvidoIA(){
		return(this.envido >= 29);
	}

	public boolean cantarFaltaEnvidoIA(){
		return(this.envido  >= 32);
	}
	
	public boolean quererFaltaEnvidoIA(){
		return(this.envido >= 31);
	}
	
	//Inteligencia cantos Flor
	public boolean cantarFlorIA(){
		return(this.obtenerPuntosFlor() >= 30);
	}
	
	public boolean quererFlorIA(){
		return(this.obtenerPuntosFlor() >= 27);
	}
	
	public boolean cantarContraFlorIA(){
		return(this.obtenerPuntosFlor() >= 33);
	}
	
	public boolean quererContraFlorIA(){
		return(this.obtenerPuntosFlor() >= 30);
	}
	
	public boolean cantarContraFlorAJuegoIA(){
		return(this.obtenerPuntosFlor() >= 37);
	}
	
	public boolean quererContraFlorAJuegoIA(){
		return(this.obtenerPuntosFlor() >= 35);
	}
}
