package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.*;

public class Mesa {
    
	Juez juez;
	ArrayList<String> ganadoresRonda; //guarda el nombre del equipo q gano las rondas
	ArrayList<TipoDeCartas> cartasEnJuego;
	ListaCircular<Jugador> jugadores;
	Puntos puntos;
	Rondas ronda;
	
	public Mesa(String equipoUno, String equipoDos){
		jugadores = new ListaCircular<Jugador>();
		juez = new Juez(this);
		ganadoresRonda = new ArrayList<String>();
		cartasEnJuego = new ArrayList<TipoDeCartas>();
		puntos = new Puntos(equipoUno,equipoDos);
		ronda = new RondaUno(juez, ganadoresRonda, this.jugadores, this.ronda);
	}
	
	public void recibirCarta(TipoDeCartas carta){
		ronda.recibirCarta(carta);
	}

	public TipoDeCartas repartirCarta() {
		return juez.repartir();
	}
	
	public void repartirCartas() {
		juez.repartir();
	}
	
	public void anotarPuntos(String equipo, int cantidad){
		this.puntos.anotarPuntos(equipo, cantidad);
	}

	public int returnPuntosEquipoDos() {
		int numero=0;
		return numero;
	}

	/*public void sentarJugadores(ArrayList<Jugador> equipoUno, ArrayList<Jugador> equipoDos) {
		Iterator<Jugador> itrEqUno = equipoUno.iterator();
		Iterator<Jugador> itrEqDos = equipoUno.iterator();
		
		while(itrEqUno.hasNext()) {
			Jugador jugadorEqUno = (Jugador) itrEqUno.next();
			jugadores.add(jugadorEqUno);
			Jugador jugadorEqDos = (Jugador) itrEqDos.next();
			jugadores.add(jugadorEqDos);
			
			System.out.println(jugadorEqUno.nombre);
			System.out.println(jugadorEqDos.nombre);
		}
	}*/
	public void sentarJugadores(Jugador equipoUno, Jugador equipoDos) {
			jugadores.add(equipoUno);
			jugadores.add(equipoDos);
	}

	public void iniciar() {
		ronda.jugar(0); //0 para q juege el primero
	}
	
}
