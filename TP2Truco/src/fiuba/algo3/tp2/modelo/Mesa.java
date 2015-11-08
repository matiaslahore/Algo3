package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Mesa {

	Juez juez;
	Jugada jugada;
	ArrayList<String> ganadoresRonda;
	// ganadoresRonda ME SIRVE PARA SABER X EJ CUANDO ES PARDA EN LA ULTIMA Y GANA EL Q HIZO PRIMERA
	// nose si conviene guardar el nombre o guardar el Equipo.
	ArrayList<Carta> cartasEnJuego;
	
	public Mesa(){
		
		juez = new Juez();
		jugada = new Jugada();
		ganadoresRonda = new ArrayList<String>();
		cartasEnJuego = new ArrayList<Carta>();
	}
	
	public void recibirCarta(Carta c){
	// esta es la carta q pone cada Jugador.
		cartasEnJuego.add(c);
	}

	public Carta repartirCarta() {
		
		return juez.repartir();
	}
	
	public void repartirCartas() {
		
		juez.repartir();
	}
	
}
