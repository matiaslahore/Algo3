package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class RondaUno extends Rondas{

	public RondaUno(Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
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
		//JUGADOR GANADOR ES: indexCartaGanadora + indexMano
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.returnEquipo());
		this.cartasEnJuego.clear();
		
		System.out.println("RONDA UNO gana " + ganador.nombre);
		
		return new RondaDos(juez, ganadoresRonda, jugadores, this.jugadorMano + indexCartaGanadora, this.indexMano);
	}
	
	public void interfaz(Jugador actual){
		/*aca es lo que hace el jugador para jugar al ser manual quedaria algo asi:
		* 1-Jugar carta
		* 2-Cantar truco
		* 3-Cantar envido
		*/
		Scanner leer = new Scanner(System.in);
		System.out.println("Seleccione una opcion: ");
		System.out.println(" 1-Jugar una carta\n 2-Cantar Truco\n 3-Cantar envido\n");
		int opcion = leer.nextInt();
		
		switch (opcion) {
			case 1:
				cartasEnJuego.add(actual.jugarCarta());
				break;
			case 2:
				cantarTruco();
				cartasEnJuego.add(actual.jugarCarta());
				break;
				//cantarQuieroReTruco();
				//cantarQuieroValeCuatro();
			case 3:
				casoEnvido();
				interfazV2(actual);
		}
		//si pone una opcion mal hacer q juege una carta o q se imprima todo de nuevo esto
	}
	
	public void interfazV2(Jugador actual){ //para dsps q se jugo el envido
		Scanner leer = new Scanner(System.in);
		System.out.println("Seleccione una opcion: ");
		System.out.println(" 1-Jugar una carta\n 2-Cantar Truco\n");
		int opcion = leer.nextInt();
		
		switch (opcion) {
			case 1:
				cartasEnJuego.add(actual.jugarCarta());
				break;
			case 2:
				cantarTruco();
				break;
				//cantarQuieroReTruco();
				//cantarQuieroValeCuatro();
		}
	}
	
	private void casoEnvido(){
		/*aca es lo que hace el jugador para jugar al ser manual quedaria algo asi:
		* 1-Cantar envido
		* 2-Cantar realEnvido
		* 3-Cantar faltaEnvido
		*/
		Scanner leer = new Scanner(System.in);
		System.out.println("Seleccione una opcion: ");
		System.out.println(" 1-Cantar envido\n 2-Cantar real envido\n 3-Cantar falta envido");
		int opcion = leer.nextInt();
		
		switch (opcion) {
			case 1:
				cantarEnvido();
				break;
			case 2:
				cantarRealEnvido();
				break;
			case 3:
				cantarFaltaEnvido();
				break;
		}
		//si elije algo mal q vuelva para atras.. nose como hacerlo dsps lo chequeo
	}
	
}
