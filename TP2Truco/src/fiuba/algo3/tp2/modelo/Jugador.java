package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Jugador {

	String nombre;
	ArrayList<Carta> cartas;
	Mesa mesa;

	public Jugador(String name, Mesa refMesa){
		this.nombre = name;
		mesa = refMesa;
		cartas = new ArrayList<Carta>(); 
	}
	
	public void recibirCartas(Carta c1, Carta c2, Carta c3){
		cartas.add(c1);
		cartas.add(c2);
		cartas.add(c3);
	}
	
	public void jugarCarta(){
		//
	}
	
}
