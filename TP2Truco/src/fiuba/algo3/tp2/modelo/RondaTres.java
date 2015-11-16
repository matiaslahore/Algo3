package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class RondaTres extends Rondas{

	public RondaTres(Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, int indexMano) {
		super(juez, ganadoresRonda, jugadores, indexMano);
	}

	public Rondas ganador(){
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		//JUGADOR GANADOR ES: indexCartaGanadora + indexMano
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.returnEquipo());
		this.cartasEnJuego.clear();
		
		this.juez.anotarPuntos(ganador.returnEquipo());
		this.jugadorMano = this.jugadorMano + 1;
		this.ganadoresRonda = new ArrayList<String>();
		this.cartasEnJuego.clear();
		
		System.out.println("RONDA TRES gana " + ganador.nombre);
		
		System.out.println("PTOS EQ1 " +juez.puntosEquipo("EquipoUno"));
		System.out.println("PTOS EQ2 " +juez.puntosEquipo("EquipoDos"));
		
		return new RondaUno(juez, ganadoresRonda, jugadores, this.jugadorMano + indexCartaGanadora);
	}

	@Override
	public void repartir() {
		//no hace nada
	}
	
	public void cantarEnvido(){
		//NO HACE NADA
	}
	
	public Rondas siguiente(Juez juez2, ArrayList<String> ganadoresRonda2, ListaCircular<Jugador> jugadores2, int indexMano) {
		return new RondaUno(juez, ganadoresRonda, jugadores, indexMano);
	}

}
