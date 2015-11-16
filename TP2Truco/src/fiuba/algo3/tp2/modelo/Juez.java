package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import fiuba.algo3.tp2.modeloDeCartas.*;

public class Juez {

	Maso maso;
	Mesa mesa;
	Rondas mano;
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
	// solo el juez puede anotar puntos. PRIVATE
	public void anotarPuntos (String equipo){
		this.puntos.anotarPuntos(equipo, puntosEnJuego);
	}
	
	public void mezclar(){
		this.maso = new Maso();
	}

	public TipoDeCartas quienGana(ArrayList<TipoDeCartas> cartasEnJuego) {
		TipoDeCartas ganadora = null; // = cartasEnJuego.get(0); //me obliga a inicializar
		Iterator<TipoDeCartas> itr = cartasEnJuego.iterator();
		//Siempre van a ser cantidad de cartas pares (2,4,6)
		while(itr.hasNext()) {
			TipoDeCartas a = (TipoDeCartas) itr.next();
			TipoDeCartas b = (TipoDeCartas) itr.next();
			ganadora = ganador(a,b);
		}
		return ganadora;
	}
	
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
		return this.puntos.puntosDeLaFalta();
		//esta mal xq solo devuelve lo q faltan para 30 y no para las malas o las buenas!!!!
	}
}
