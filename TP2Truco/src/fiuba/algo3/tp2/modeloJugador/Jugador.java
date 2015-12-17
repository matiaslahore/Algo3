package fiuba.algo3.tp2.modeloJugador;

import java.util.List;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.CartaInexistenteEnManoDeJugadorExeption;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mano;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modeloDeCartas.*;

public abstract class Jugador {

	String nombre;
	Equipo equipo;
	Mano manoDelJugador;
	Mesa refMesa;
	int envido;
	int tantoFlor;

	public Jugador(String name, Mesa mesa, Equipo team){
		nombre = name;
		refMesa = mesa;
		equipo = team;
		envido = 0;
		tantoFlor = 0;
	}
	
	public void recibirCartas(List<Carta> listaDeCartas){
		manoDelJugador = new Mano(listaDeCartas);
		this.envido = this.manoDelJugador.calcularEnvido();
		this.tantoFlor = this.manoDelJugador.calcularPuntosFlor();
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
		return(this.tantoFlor);
		//return this.manoDelJugador.calcularPuntosFlor();
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
	
	public void cantarTruco (){
		this.refMesa.cantarTruco(this);
	}
	
	public void cantarQuieroReTruco() {
		this.refMesa.cantarQuieroReTruco(this);
	}
	
	public void cantarQuieroValeCuatro() {
		this.refMesa.cantarQuieroValeCuatro(this);
	}
	
	public void cantarEnvido() throws CantoInvalidoException{
		this.refMesa.cantarEnvido(this);
	}
	
	public void cantarRealEnvido () throws CantoInvalidoException{
		this.refMesa.cantarRealEnvido(this);
	}
	
	public void cantarFaltaEnvido() throws CantoInvalidoException{
		this.refMesa.cantarFaltaEnvido(this);
	}
	
	public void cantarFlor() {
		this.refMesa.cantarFlor(this);
	}
	
	public void cantarContraFlor() {
		this.refMesa.cantarContraFlor(this);
	}
	
	public void cantarContraFlorAJuego() {
		this.refMesa.cantarContraFlorAJuego(this);
	}
	
	public void quiero(){
		this.refMesa.quiero(this);
	}

	public void noQuiero(){
		this.refMesa.noQuiero(this);
	}

	public void irseAlMazo(){
		this.refMesa.irseAlMazo(this);
	}

	public boolean tieneFlor() {
		return(this.tantoFlor != 0);
	}

	public void mostrarCartas() {
		System.out.println(this.manoDelJugador.verCartasEnManoComoString());
	}
	public abstract void hacerJugarIA();
	
	public boolean tengoFlor(){
		if (tantoFlor == 0) return false;
		else return true;
	}
	
}
