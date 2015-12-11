package fiuba.algo3.tp2.modeloJugador;

import java.util.List;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.CartaInexistenteEnManoDeJugadorExeption;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mano;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modeloDeCartas.Carta;

public abstract class Jugador {
	String nombre;
	Equipo equipo;
	Mano manoDelJugador;
	Mesa refMesa;
	int envido;
	boolean tieneFlor;
	EventosJugador eventosJugador;

	public Jugador(String name, Mesa mesa, Equipo team){
		nombre = name;
		refMesa = mesa;
		equipo = team;
		envido = 0;
		tieneFlor = false;
		this.eventosJugador = new EventosJugador();
	}
	
	public void cargarOyente(OyenteJugador oyente){
		this.eventosJugador.addListener(oyente);
	}
	
	public void recibirCartas(List<Carta> listaDeCartas){
		manoDelJugador = new Mano(listaDeCartas);
		this.envido = this.manoDelJugador.calcularEnvido();
		this.tieneFlor = this.manoDelJugador.tieneFlor();
	}

	public Equipo obtenerEquipo(){
		return this.equipo;
	}
	
	public String obtenerNombre(){
		return nombre;
	}

	public int obtenerPuntosEnvido(){
		return this.envido;
	}
	
	public int obtenerPuntosFlor(){
		return this.manoDelJugador.calcularPuntosFlor();
	}

	public String verCartasEnManoComoString() {
		return this.manoDelJugador.verCartasEnManoComoString();
	}
	
	public List<Carta> obtenerCartasDelJugador(){
		return this.manoDelJugador.obtenerCartas();
	}
	
	public int cantidadDeCartas() {
	    return this.manoDelJugador.returnCantidadDeCartas();	
	}
	
	public void jugarCarta(Carta unaCarta) {
		if (this.manoDelJugador.contieneCarta(unaCarta)){
			this.refMesa.recibirCarta(unaCarta);
			this.manoDelJugador.borrarCarta(unaCarta);
		} else throw new CartaInexistenteEnManoDeJugadorExeption();
	}
	
	public int jugarPuntosEnvido(){
		return this.envido;
	}
	
	//Inicio de Metodos de cantos
	
	public void cantarTruco (){
		this.refMesa.cantarTruco(this);
		this.eventosJugador.jugadorCantoTruco();
	}
	
	public void cantarQuieroReTruco() {
		this.refMesa.cantarQuieroReTruco(this);
		this.eventosJugador.jugadorCantoReTruco();
	}
	
	public void cantarQuieroValeCuatro() {
		this.refMesa.cantarQuieroValeCuatro(this);
		this.eventosJugador.jugadorCantoValeCuatro();
	}
	
	public void cantarEnvido() throws CantoInvalidoException{
		this.refMesa.cantarEnvido(this);
		this.eventosJugador.jugadorCantoEnvido();
	}
	
	public void cantarRealEnvido () throws CantoInvalidoException{
		this.refMesa.cantarRealEnvido(this);
		this.eventosJugador.jugadorCantoRealEnvido();
	}
	
	public void cantarFaltaEnvido() throws CantoInvalidoException{
		this.refMesa.cantarFaltaEnvido(this);
		this.eventosJugador.jugadorCantoFaltaEnvido();
	}
	
	public void cantarFlor() {
		this.refMesa.cantarFlor(this);
		this.eventosJugador.jugadorCantoFlor();
	}
	
	public void cantarContraFlor() {
		this.refMesa.cantarContraFlor(this);
		this.eventosJugador.jugadorCantoContraFlor();
	}
	
	public void cantarContraFlorAJuego() {
		this.refMesa.cantarContraFlorAJuego(this);
		this.eventosJugador.jugadorCantoContraFlorAJuego();
	}
	
	public void quiero(){
		this.refMesa.quiero(this);
		this.eventosJugador.jugadorQuiso();
	}

	public void noQuiero(){
		this.refMesa.noQuiero(this);
		this.eventosJugador.jugadorNoQuiso();
	}

	public void irseAlMazo(){
		this.refMesa.irseAlMazo(this);
		this.eventosJugador.jugadorSeFueAlMazo();
	}

	//Fin de Metodos de cantos
	
	public boolean tieneFlor() {
		return this.tieneFlor;
	}

	public void mostrarCartas() {
		System.out.println(this.manoDelJugador.verCartasEnManoComoString());
	}
	
	public abstract void hacerJugarIA();
}
