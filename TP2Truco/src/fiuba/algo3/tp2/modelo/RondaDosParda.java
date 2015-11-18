package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class RondaDosParda extends Rondas{

	public RondaDosParda(Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(juez, ganadoresRonda, cartasEnJuego, jugadores, indexManoAux, indexMano);
	}

	public Rondas ganador(){
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);
		Jugador ganador = null;
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		//int indexCartaGanadora = this.cartasEnJuego.indexOf(new AnchoDeEspada());
		if (indexCartaGanadora == -1){ //es parda
			this.juez.anotarPuntos(jugadores.get(indexMano).returnEquipo());
		}else{
			ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
			ganadoresRonda.add(ganador.returnEquipo());
			System.out.println("RONDA DOS gana " + ganador.nombre);
			this.juez.anotarPuntos(ganador.returnEquipo());
			System.out.println("RONDA TRES gana " + ganador.nombre);
		}
		
		this.cartasEnJuego.clear();
		this.ganadoresRonda = new ArrayList<String>();
		
		System.out.println("PTOS EQ1 " +juez.puntosEquipo("EquipoUno"));
		System.out.println("PTOS EQ2 " +juez.puntosEquipo("EquipoDos") + "\n");
		
		this.indexMano = this.indexMano + 1;
		return new RondaUno(juez, ganadoresRonda, cartasEnJuego,jugadores, this.indexMano, this.indexMano);
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
				actual.jugarCarta();
				break;
			case 2:
				actual.cantarTruco();
				actual.jugarCarta();
				break;
		}
	}
	
}
