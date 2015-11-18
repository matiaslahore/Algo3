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
	int indexMano;
	
	public Mesa(String equipoUno, String equipoDos){
		jugadores = new ListaCircular<Jugador>();
		juez = new Juez(this, equipoUno, equipoDos);
		ganadoresRonda = new ArrayList<String>();
		cartasEnJuego = new ArrayList<TipoDeCartas>();
		puntos = new Puntos(equipoUno,equipoDos);
		indexMano = 0;
	}
	
	public void recibirCarta(TipoDeCartas carta){
		this.cartasEnJuego.add(carta);
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
		
		ronda = new RondaUno(juez, ganadoresRonda, this.jugadores, this.indexMano, this.indexMano);
		
		do{
			ronda = ronda.jugar();
		}while(juez.termina());
		
		System.out.println("JUEGO TERMINADO\nPUNTAJE FINAL");
		System.out.println("PTOS EQ1 " +juez.puntosEquipo("EquipoUno"));
		System.out.println("PTOS EQ2 " +juez.puntosEquipo("EquipoDos") + "\n");
		
	}
	
	/*public Jugador ganadorDeMano (){
		return ronda.getGanadores().get(this.indexMano);
	}*/

}
