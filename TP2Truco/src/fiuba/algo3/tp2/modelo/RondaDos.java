package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

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
			System.out.println("TERMINOOOOOOOOOOOOOOOOOOOOOOOOOO");
			//esto es xq hace primera y segunda el jugador
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
	
}
