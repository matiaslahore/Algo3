package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.modeloRondas.*;

public class Mesa {
    
	Juez juez;
	ArrayList<String> ganadoresRonda; //guarda el nombre del equipo q gano las rondas
	ArrayList<TipoDeCartas> cartasEnJuego;
	ListaCircular<Jugador> jugadores;
	Puntos puntos;
	EstadoRondas ronda;
	int indexMano;
	Truco truco;
	Envido envido;
	
	
	public Mesa(String equipoUno, String equipoDos){
		jugadores = new ListaCircular<Jugador>();
		juez = new Juez(this, equipoUno, equipoDos);
		ganadoresRonda = new ArrayList<String>();
		cartasEnJuego = new ArrayList<TipoDeCartas>();
		puntos = new Puntos(equipoUno,equipoDos);
		indexMano = 0;
		this.truco= new Truco();
		this.envido = new Envido();
		//this.ronda = new EstadoRondaUno(ronda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexMano, indexMano);
	}
	
	public void iniciarRonda(){
		this.ronda = new EstadoRondaUno(this.ronda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexMano, indexMano);
	}
	
	public void recibirCarta(TipoDeCartas carta){
		System.out.println("Mesa recibe: " + carta.cartaComoString());
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

	public void sentarJugadores(ArrayList<Jugador> equipoUno, ArrayList<Jugador> equipoDos) {
		Iterator<Jugador> itrEqUno = equipoUno.iterator();
		Iterator<Jugador> itrEqDos = equipoDos.iterator();
				
		while(itrEqUno.hasNext() && itrEqDos.hasNext()) {
			Jugador jugadorEqUno = (Jugador) itrEqUno.next();
			jugadores.add(jugadorEqUno);
			Jugador jugadorEqDos = (Jugador) itrEqDos.next();
			jugadores.add(jugadorEqDos);
			
			System.out.println("SENTE A:" + jugadorEqUno.obtenerNombre());
			System.out.println("SENTE A:" + jugadorEqDos.obtenerNombre());
		}
		System.out.println("\n");
	}
	
	public void iniciar() {
		
		/*ronda = new EstadoRondaUno(ronda,juez, ganadoresRonda, cartasEnJuego, this.jugadores, this.indexMano, this.indexMano);
		
		do{
			ronda = ronda.jugar();
		}while(juez.termina());
		
		
		Jugador actual = ronda.siguiente();
		actual.jugarPrimera();
		actual = ronda.siguiente();
		actual.jugarSegunda();*/
		
		System.out.println("JUEGO TERMINADO\nPUNTAJE FINAL");
		System.out.println("PTOS EQ1 " +juez.puntosEquipo("EquipoUno"));
		System.out.println("PTOS EQ2 " +juez.puntosEquipo("EquipoDos") + "\n");
		
	}
	
	public Jugador siguiente(){
		this.ronda = this.ronda.acualizarRonda();
		return this.ronda.turnoDe();
	}
	
	/*public Jugador ganadorDeMano (){
		return ronda.getGanadores().get(this.indexMano);
	}*/
    
	public void cantarTruco(Jugador jugadorQueCanta){
		this.truco.cantarTruco(jugadorQueCanta);
	}
	
	public void cantarEnvido( Jugador jugadorQueCanta){
		this.envido.cantarEnvido(jugadorQueCanta);
	}
	
	public void cantarFaltaEnvido( Jugador jugadorQueCanta){
		
	}

	public boolean puedeCantarEnvido(Jugador jugador) {
		return(this.envido.puedeCantar(jugador));
	}

	public String ultimoGanador() {
		return this.ganadoresRonda.get(this.ganadoresRonda.size()-1);
	}
}
