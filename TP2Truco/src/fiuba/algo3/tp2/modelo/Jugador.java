package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.omg.CORBA.SystemException;

import fiuba.algo3.tp2.modeloDeCartas.*;

public class Jugador {

	String nombre;
	String equipo;
	Mano manoDelJugador;
	Mesa refMesa;
	int envido;

	public Jugador(String name, Mesa mesa){
		nombre = name;
		refMesa = mesa;
		envido = 0;
	}

	public void recibirCartas(TipoDeCartas c1, TipoDeCartas c2, TipoDeCartas c3){
		manoDelJugador = new Mano(c1,c2,c3);
		this.envido = this.manoDelJugador.calcularEnvido();
	}
	
	/* ESTA ES LA QUE VA A IR A LO ULTIMO
	 * public Carta jugarCarta(int n){
		Carta actual = cartas.get(n-1); //-1 xq sino no da el index
		cartas.remove(n-1);
		return actual;
	}*/
	
	public void cargarEquipo(String nombre){
		this.equipo = nombre;
	}
	
	public String returnEquipo(){
		return this.equipo;
	}
	
	public String obtenerNombre(){
		return nombre;
	}

	public int obtenerPuntosEnvido(){
		return this.envido;
	}
	
	public TipoDeCartas jugarPrimera(){
		return this.manoDelJugador.returnPrimera();
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
	
	public int obtenerPuntosEnvidoConFlor() {
		return this.manoDelJugador.calcularPuntosEnvidoConFlor();
	}

	/*public TipoDeCartas jugarCarta() {
		return this.manoDelJugador.returnPrimera();
	}*/
	public TipoDeCartas jugarCarta() { //////////////////////////////////////////////PRIVATE
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingerese numero de carta a jugar: ");
		verCartasEnManoComoString();
		int n = leer.nextInt();
		
		return this.manoDelJugador.tirar(n);
	}

	private void verCartasEnManoComoString() {
		System.out.println(this.manoDelJugador.verCartasEnManoComoString());
	}

	public int cantidadDeCartas() {
	    return this.manoDelJugador.returnCantidadDeCartas();	
	}
	
}
