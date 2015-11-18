package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import modeloJugador.Jugador;

public class RondaUno extends Rondas{

	public RondaUno(Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego,ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(juez, ganadoresRonda, cartasEnJuego,jugadores, indexManoAux, indexMano);
	}
	
	//EN RONDA UNO SE REPARTE
	public void repartir(){
		this.juez.mezclar();
		Iterator<Jugador> itr = this.jugadores.iterator();
		while(itr.hasNext()) {
			Jugador unJugador = (Jugador) itr.next();
			unJugador.recibirCartas(juez.repartir(), juez.repartir(), juez.repartir());
		}
		System.out.println("REPARTEN");
	}
	
	public Rondas ganador(){
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);
		
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		//int indexCartaGanadora = this.cartasEnJuego.indexOf(new AnchoDeEspada());
		if (indexCartaGanadora == -1){ //es parda
			return new RondaUnoParda(juez, ganadoresRonda, cartasEnJuego,jugadores, this.jugadorMano, this.indexMano);
		}
		//JUGADOR GANADOR ES: indexCartaGanadora + indexMano
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.returnEquipo());
		this.cartasEnJuego.clear();
		
		System.out.println("RONDA UNO gana " + ganador.obtenerNombre());
		
		return new RondaDos(juez, ganadoresRonda, cartasEnJuego,jugadores, this.jugadorMano + indexCartaGanadora, this.indexMano);
	}
	
	public void interfaz(Jugador actual){
		Scanner leer = new Scanner(System.in);
		System.out.println("Seleccione una opcion: ");
		System.out.println(" 1-Jugar una carta\n 2-Cantar Truco\n 3-Cantar envido\n");
		int opcion = leer.nextInt();
		
		switch (opcion) {
			case 1:
				actual.jugarCarta();
				break;
			case 2:
				actual.cantarTruco();
				actual.jugarCarta();
				break;
			case 3:
				casoEnvido(actual);
				interfazV2(actual);
		}
	
	}
	
	public void interfazV2(Jugador actual){ //para dsps q se jugo el envido
		Scanner leer = new Scanner(System.in);
		System.out.println("Seleccione una opcion: ");
		System.out.println(" 1-Jugar una carta\n 2-Cantar Truco\n");
		int opcion = leer.nextInt();
		
		switch (opcion) {
			case 1:
				actual.jugarCarta();
				break;
			case 2:
				actual.cantarTruco();
				break;
		}
	}
	
	private void casoEnvido(Jugador actual){
		
		if(!actual.puedeCantarEnvido())
			return;
		
		Scanner leer = new Scanner(System.in);
		System.out.println("Seleccione una opcion: ");
		System.out.println(" 1-Cantar envido\n 2-Cantar real envido\n 3-Cantar falta envido");
		int opcion = leer.nextInt();
		
		switch (opcion) {
			case 1:
				interfazTanto(actual);
				//actual.cantarEnvido();
				break;
			case 2:
				actual.cantarRealEnvido();
				break;
			case 3:
				actual.cantarFaltaEnvido();
				break;
		}
	}
	
}
