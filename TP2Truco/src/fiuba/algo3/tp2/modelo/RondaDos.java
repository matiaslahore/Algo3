package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class RondaDos extends Rondas{

	public RondaDos(Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
	}
	
	public Rondas ganador(){
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		//JUGADOR GANADOR ES: indexCartaGanadora + indexMano
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.returnEquipo());
		this.cartasEnJuego.clear();
		
		System.out.println("RONDA DOS gana " + ganador.nombre);
		
		if (this.ganadoresRonda.get(0) == this.ganadoresRonda.get(1)){
			System.out.println("TERMINOOOOOOOOO gano 1ra y 2da el mismo");
			
			this.juez.anotarPuntos(ganador.returnEquipo());
			this.ganadoresRonda = new ArrayList<String>();
			
			System.out.println("PTOS EQ1 " +juez.puntosEquipo("EquipoUno"));
			System.out.println("PTOS EQ2 " +juez.puntosEquipo("EquipoDos") + "\n");
			
			this.indexMano = this.indexMano + 1;
			return new RondaUno(juez, ganadoresRonda, jugadores, this.indexMano, this.indexMano);
		}
		
		return new RondaTres(juez, ganadoresRonda, jugadores, this.jugadorMano + indexCartaGanadora, this.indexMano);
	}

	@Override
	public void repartir() {
		//no hace nada
	}
	
	public void cantarEnvido(){
		//NO HACE NADA
	}
	public void cantarRealEnvido(){
		//NO HACE NADA
	}
	public void cantarFaltaEnvido(){
		//NO HACE NADA
	}

	public void interfaz(Jugador actual){
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
				cartasEnJuego.add(actual.jugarCarta());
				break;
				//cantarQuieroReTruco();
				//cantarQuieroValeCuatro();
		}
	}
	
}
