package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;
import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.*;

public class Mesa {
    
	Juez juez;
	ArrayList<String> ganadoresRonda;
	// ganadoresRonda ME SIRVE PARA SABER X EJ CUANDO ES PARDA EN LA ULTIMA Y GANA EL Q HIZO PRIMERA
	// nose si conviene guardar el nombre o guardar el Equipo.
	ArrayList<TipoDeCartas> cartasEnJuego;
	List<Jugador> jugadores;
	int mano;
	
	public Mesa(){
		jugadores = new ListaCircular<Jugador>();
		juez = new Juez(this);
		ganadoresRonda = new ArrayList<String>();
		cartasEnJuego = new ArrayList<TipoDeCartas>();
		mano = 0; //indice de la lista circular
	}
	
	public void recibirCarta(TipoDeCartas c){
	// esta es la carta q pone cada Jugador.
		cartasEnJuego.add(c);
	}

	public TipoDeCartas repartirCarta() {
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
	
	public void sentarJugadores(Jugador jugador){
		//VER EL TEMA DE CARGAR JUGADORES EN ORDEN
		jugadores.add(jugador);
	}
	
}
