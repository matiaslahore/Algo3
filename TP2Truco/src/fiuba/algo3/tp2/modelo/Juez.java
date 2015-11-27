package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloRondas.EstadoRondas;

public class Juez {

	Maso maso;
	Mesa mesa;
	EstadoRondas mano;
	Puntos puntos;
	int puntosEnJuego;
	
	boolean activadorPicaPica = false;
	int cantidadJugadas = 1;
	
	public Juez(Mesa mesa, Equipo equipoUno, Equipo equipoDos){
		this.maso = new Maso();
		this.mesa = mesa;
		this.puntosEnJuego = 1;
		this.puntos = new Puntos(equipoUno, equipoDos);
	}

	public List<TipoDeCartas> obtenerListaDeCartasEnJuego(){
		return this.mesa.obtenerListaDeCartasEnJuego();
	}
	
	public TipoDeCartas repartir(){
		return this.maso.dameCarta();
	}
	// solo el juez puede anotar puntos
	public void anotarPuntos(Equipo equipo){
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

	public int puntosEquipo(Equipo equipo) {
		return this.puntos.getPuntaje(equipo);
	}
	
	public int puntosEquipo(String equipo) {
		return this.puntos.getPuntaje(equipo);
	}

	public int puntosDeLaFalta() {
		return this.puntos.puntosDeLaFalta(null);
		//esta mal xq solo devuelve lo q faltan para 30 y no para las malas o las buenas!!!!
	}

	public boolean termino() {
		if (puntos.getPuntajeMaximo() >= 30) return true;
		else return false;
	}

	public void AumentarPuntosEnJuego(int puntos) {
		this.puntosEnJuego = this.puntosEnJuego + puntos;
	}

	public int obtenerPuntosFaltaEnvido(String Equipo){
		return 0;
		//Desarrollar este metodo
	}

	public void limpiarCartasEnJuegoDeRondaActual() {
		this.mesa.limpiarCartasEnJuegoDeRondaActual();
	}

	public int cantidadDeCartasEnJuego() {
		return this.mesa.cantidadDeCartasEnJuego();
	}

	public boolean rangoPicaPica() {
		return this.puntos.rangoPicaPica();
	}

	public void imprimirResultados() {
		this.puntos.imprimirResultados();
	}
	
	public void actualizarPicaPica(){
		this.activadorPicaPica = !this.activadorPicaPica;
	}
	
	public boolean esPicaPica(){
		if (this.mesa.cantidadDeJugadores()==6 && rangoPicaPica()){
			return this.activadorPicaPica;
		}
		else return false;
	}
	
	public void actualizarCantidadJugadas(){
		this.cantidadJugadas = this.cantidadJugadas + 1;
	}
	
	public int cantidadDeJugadas(){
		return this.cantidadJugadas;
	}

	public void resetearcantidadDeJugadas() {
		this.cantidadJugadas = 1;
	}
	
}
