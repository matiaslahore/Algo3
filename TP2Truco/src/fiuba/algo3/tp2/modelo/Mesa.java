package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Mesa {
    
	Juez juez;
	ArrayList<String> ganadoresRonda;
	// ganadoresRonda ME SIRVE PARA SABER X EJ CUANDO ES PARDA EN LA ULTIMA Y GANA EL Q HIZO PRIMERA
	// nose si conviene guardar el nombre o guardar el Equipo.
	ArrayList<Carta> cartasEnJuego;
	
	public Mesa(){
		juez = new Juez(this);
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
	
	public void anotarPuntosEquipoUno(int cantidad) {
		
	}
	
	public void anotarPuntosEquipoDos (int cantidad) {
		
	}

	public Jugador ganadorDeMano() {
		return this.juez.quienGana(cartasEnJuego); //VER!
	}

	public int returnPuntosEquipoDos() {
		int numero=0;
		return numero;
	}
	
	public void iniciarMano(Equipo equipoUno,Equipo equipoDos){
		Mano mano = new Mano(equipoUno,equipoDos,juez);
		mano.rondaUno();
	}
	
}
