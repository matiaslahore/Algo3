package fiuba.algo3.tp2.modeloJugador;
import fiuba.algo3.tp2.excepciones.JugadorYaNoTieneMasCartasException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modeloDeCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.Copa;
import fiuba.algo3.tp2.modeloDeCartas.Dos;
import fiuba.algo3.tp2.modeloDeCartas.Rey;
import fiuba.algo3.tp2.modeloDeCartas.Sota;
import fiuba.algo3.tp2.modeloDeCartas.Tres;


public class IA extends Jugador implements Oyente{

	EstadoIA estadoIA;
	EventosIA eventosIA;
	
	public IA(String name, Mesa mesa, Equipo team) {
		super(name, mesa, team);
		estadoIA = new EstadoIARondaUnoInteligente();
		this.eventosIA = new EventosIA();
	}
	
	public void agregarOyentesAEventosIA(OyenteIA oyente){
		this.eventosIA.addListener(oyente);
	}
	
	public void hacerJugarIA(){
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
		Carta ultimaCartaJugada = this.refMesa.obtenerUltimaCartaJugada();
		this.jugarCarta(this.manoDelJugador.obtenerMejorCartaParaJugarContra(ultimaCartaJugada));	
	}

	@Override
	public void seCantoTruco() {
		this.setearEstado(new EstadoIACantaronTruco());
	}

	@Override
	public void seCantoReTruco() {
		this.setearEstado(new EstadoIACantaronReTruco());
	}

	@Override
	public void seCantoValeCuatro() {
		this.setearEstado(new EstadoIACantaronValeCuatro());
	}

	@Override
	public void seCantoEnvido() {
		this.setearEstado(new EstadoIACantaronEnvido());
	}

	@Override
	public void seCantoRealEnvido() {
		this.setearEstado(new EstadoIACantaronRealEnvido());
	}

	@Override
	public void seCantoFaltaEnvido() {
		this.setearEstado(new EstadoIACantaronFaltaEnvido());
	}
	
	@Override
	public void seFueAlMazo() {
		this.setearEstado(new EstadoIARondaUnoInteligente());
	}

	@Override
	public void seCantoFlor() {
		this.setearEstado(new EstadoIACantaronFlor());
	}

	@Override
	public void seCantoContraFlor() {
		this.setearEstado(new EstadoIACantaronContraFlor());
	}

	@Override
	public void seCantoContraFlorAJuego() {
		this.setearEstado(new EstadoIACantaronContraFlorAJuego());
	}
	
	private Carta obtenerCartaMasAltaParaTruco() {
		return this.manoDelJugador.obtenerCartaMasAltaParaTruco();
	}
	
	public boolean quererTrucoIA(){
		try{
			//Acepta si tiene mas que un Dos
			return (this.obtenerCartaMasAltaParaTruco().getClass() == (new Dos(new Copa()).vs(this.obtenerCartaMasAltaParaTruco())).getClass());
		}catch(JugadorYaNoTieneMasCartasException e){
			//si la ultima carta que jugo IA es mas que un diez acepta el truco sino no
			return !(new Sota(new Copa()).equals((new Sota(new Copa()).vs(this.refMesa.obtenerUltimaCartaJugada()))));
		}
	}
	
	public boolean quererReTrucoIA(){
		try{
			//Acepta si tiene mas que un Tres
			return (this.obtenerCartaMasAltaParaTruco().getClass() == (new Tres(new Copa()).vs(this.obtenerCartaMasAltaParaTruco())).getClass());
		}catch(JugadorYaNoTieneMasCartasException e){
			//si la ultima carta que jugo IA es mas que un Rey acepta el truco sino no
			return !(new Rey(new Copa()).equals((new Rey(new Copa()).vs(this.refMesa.obtenerUltimaCartaJugada()))));
		}
	}
	
	public boolean quererValeCuatroIA(){
		try{
			//Acepta si tiene mas que un Tres
			return (this.obtenerCartaMasAltaParaTruco().getClass() == (new Tres(new Copa()).vs(this.obtenerCartaMasAltaParaTruco())).getClass());
		}catch(JugadorYaNoTieneMasCartasException e){
			//si la ultima carta que jugo IA es mas que un AnchoFalso acepta el truco sino no
			return !(new AnchoFalso(new Copa()).equals((new AnchoFalso(new Copa()).vs(this.refMesa.obtenerUltimaCartaJugada()))));
		}	}
	
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

	public boolean terminoLaMano() {
		return this.refMesa.terminoLaMano();
	}
	
	public void quiero(){
		this.eventosIA.cantaQuiero();
		this.refMesa.quiero(this);
	}
	
	public void noQuiero(){
		this.eventosIA.cantaNoQuiero();
		this.refMesa.noQuiero(this);
	}
	
}
