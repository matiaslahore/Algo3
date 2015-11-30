package fiuba.algo3.tp2.modeloJugador;

import java.util.List;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mano;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modeloDeCartas.*;

public class Jugador {

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
		return this.envido;
	}
	
	public int obtenerPuntosEnvidoConFlor() {
		return this.manoDelJugador.calcularPuntosEnvidoConFlor();
	}

	/*public int obtenerPuntosEnvidoConFlor() {
		int envidoConFlor = 0;
		
		for (Carta unaCarta : cartas){
			if (unaCarta.obtenerValor()<= 7){
				envidoConFlor += unaCarta.obtenerValor();
			}
		}
		return envidoConFlor + 20;
	}*/
	

	/*public void jugarCarta() { //////////////////////////////////////////////PRIVATE
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingerese numero de carta a jugar: ");
		verCartasEnManoComoString();
		int n = leer.nextInt();
		this.refMesa.recibirCarta(this.manoDelJugador.tirar(n));
	}*/

	public String verCartasEnManoComoString() {
		return this.manoDelJugador.verCartasEnManoComoString();
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
		try {
			this.refMesa.cantarEnvido(this);
		} catch (CantoInvalidoException e) {
			throw e;
		}
	}
	
	public void cantarRealEnvido () throws CantoInvalidoException{
		try {
			this.refMesa.cantarRealEnvido(this);
		} catch (CantoInvalidoException e) {
			throw e;
		}
	}
	
	public void cantarFaltaEnvido() throws CantoInvalidoException{
		try {
			this.refMesa.cantarFaltaEnvido(this);
		} catch (CantoInvalidoException e) {
			throw e;
		}
	}
	
	public void cantarFlor() {
		try {
			this.refMesa.cantarFlor(this);
		} catch (CantoInvalidoException e) {
			throw e;
		}
	}
	
	public void cantarContraFlor() {
		try {
			this.refMesa.cantarContraFlor(this);
		} catch (CantoInvalidoException e) {
			throw e;
		}
	}
	
	public void cantarContraFlorAJuego() {
		try {
			this.refMesa.cantarContraFlorAJuego(this);
		} catch (CantoInvalidoException e) {
			throw e;
		}
	}
	
	public void quiero(){
		this.refMesa.quiero(this);
	}

	public void noQuiero(){
		this.refMesa.noQuiero(this);
	}
}
