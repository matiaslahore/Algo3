package fiuba.algo3.tp2.modeloJugador;

import java.util.List;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
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

	public Jugador(String name, Mesa mesa, Equipo team){
		nombre = name;
		refMesa = mesa;
		equipo = team;
		envido = 0;
	}
	
	public void recibirCartas(List<Carta> listaDeCartas){
		manoDelJugador = new Mano(listaDeCartas);
		this.envido = this.manoDelJugador.calcularEnvido();
	}
	
	/* ESTA ES LA QUE VA A IR A LO ULTIMO
	 * public Carta jugarCarta(int n){
		Carta actual = cartas.get(n-1); //-1 xq sino no da el index
		cartas.remove(n-1);
		return actual;
	}*/
	
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
		return this.manoDelJugador.calcularPuntosEnvidoConFlor();
	}

	public String verCartasEnManoComoString() {
		return this.manoDelJugador.verCartasEnManoComoString();
	}
	
	public Mano obtenerCartasDelJugador(){
		return this.manoDelJugador;
	}
	
	public int cantidadDeCartas() {
	    return this.manoDelJugador.returnCantidadDeCartas();	
	}
	
	public void jugarCarta(Carta unaCarta) {
		
		this.manoDelJugador.tirarCarta(unaCarta);
		this.refMesa.recibirCarta(unaCarta);
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

	public abstract void juga();

	public void irseAlMazo(){
		this.refMesa.irseAlMazo(this);
	}

	public boolean tieneFlor() {
		return this.manoDelJugador.tieneFlor();
	}
	
}
