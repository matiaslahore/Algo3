package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloRondas.EstadoRondas;

public class Juez {

	Maso maso;
	Mesa mesa;
	EstadoRondas mano;
	Puntos puntos;
	int puntosEnJuego;
	
	
	public Juez(Mesa mesa, String equipoUno, String equipoDos){
		this.maso = new Maso();
		this.mesa = mesa;
		this.puntosEnJuego = 0;
		this.puntos = new Puntos(equipoUno, equipoDos);
	}

	public List<TipoDeCartas> obtenerListaDeCartasEnJuego(){
		return this.mesa.obtenerListaDeCartasEnJuego();
	}
	
	public TipoDeCartas repartir(){
		return this.maso.dameCarta();
	}
	// solo el juez puede anotar puntos
	public void anotarPuntos(String equipo){
		this.puntos.anotarPuntos(equipo, puntosEnJuego);
	}
	
	public void mezclar(){
		this.maso = new Maso();
	}

	public TipoDeCartas obtenerCartaGanadoraDeRonda() {
		
		return this.mesa.obtenerCartaGanadoraDeRonda();
	}
	
	public boolean hayParda(){
		
		return this.mesa.hayParda();
	}
	
	public void puntosEnJuego(int puntos) {
		this.puntosEnJuego = puntos;
	}

	public int quienGanaElTanto(ArrayList<Integer> tantoEnJuego) {
		return Collections.max(tantoEnJuego);
	}

	public int puntosEquipo(String equipo) {
		return this.puntos.getPuntaje(equipo);
	}

	public int puntosDeLaFalta() {
		return this.puntos.puntosDeLaFalta(null);
		//esta mal xq solo devuelve lo q faltan para 30 y no para las malas o las buenas!!!!
	}

	public boolean termina() {
		if (puntos.getPuntajeMaximo() >= 30) return false;
		else return true;
	}

	public void AumentarPuntosEnJuego(int puntos) {
		this.puntosEnJuego = this.puntosEnJuego + puntos;
	}

	public int obtenerPuntosFaltaEnvido(String Equipo){
		return 0;
		//Desarrollar este metodo
	}

	public void limpiarCartasEnJuegoDeRondaAnterior() {
		this.mesa.limpiarCartasEnJuegoDeRondaAnterior();
	}
}
