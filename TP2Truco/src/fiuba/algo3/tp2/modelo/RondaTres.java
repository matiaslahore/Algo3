package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class RondaTres extends Rondas{

	public RondaTres(Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		super(juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
	}

	public Rondas ganador(){
		TipoDeCartas ganadora = this.juez.quienGana(this.cartasEnJuego);
		int indexCartaGanadora = this.cartasEnJuego.lastIndexOf(ganadora);
		//JUGADOR GANADOR ES: indexCartaGanadora + indexMano
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		ganadoresRonda.add(ganador.returnEquipo());
		this.cartasEnJuego.clear();
		
		this.juez.anotarPuntos(ganador.returnEquipo());
		this.ganadoresRonda = new ArrayList<String>();
		this.cartasEnJuego.clear();
		
		System.out.println("RONDA TRES gana " + ganador.nombre);
		
		System.out.println("PTOS EQ1 " +juez.puntosEquipo("EquipoUno"));
		System.out.println("PTOS EQ2 " +juez.puntosEquipo("EquipoDos"));
		//return null;
		this.indexMano = this.indexMano + 1;
		return new RondaUno(juez, ganadoresRonda, jugadores, this.indexMano, this.indexMano);
		//como ultimo parametro hay que pasarle indexMano de la mesa + 1 si se quiere hacer
		// que juege solo!. O sea de manera automatica cortando cuando uno equipo llege a 30.
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

}
