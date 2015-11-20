package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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

	public TipoDeCartas quienGana(ArrayList<TipoDeCartas> cartasEnJuego) {
		Iterator<TipoDeCartas> itr = cartasEnJuego.iterator();
		
		TipoDeCartas cartaUno = (TipoDeCartas) itr.next();
		TipoDeCartas cartaDos = (TipoDeCartas) itr.next();
		TipoDeCartas ganadora = ganador(cartaUno,cartaDos);
		
		while(itr.hasNext()) {
			TipoDeCartas otraCarta = (TipoDeCartas) itr.next();
			ganadora = ganador(ganadora,otraCarta);
		}
		
		return ganadora;
	}
	
	//public boolean hayParda(TipoDeCartas a , TipoDeCartas b){
	//	
	//}
	
	private TipoDeCartas ganador(TipoDeCartas a, TipoDeCartas b){
		return a.vs(b);
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

}
