package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class RondaUno extends Rondas{

	public RondaUno(Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, Rondas ronda) {
		super(juez, ganadoresRonda, jugadores, ronda);
	}
	
	//EN RONDA UNO SE REPARTE
	public void repartir(){
		for (Jugador unJugador : this.jugadores){
			TipoDeCartas c1 = this.juez.repartir();
			TipoDeCartas c2 = this.juez.repartir();
			TipoDeCartas c3 = this.juez.repartir();
			
			unJugador.recibirCartas(c1,c2,c3);
		}
	}
	
	@Override
	public void completarGanador() {
		this.refRonda = new RondaDos(juez, ganadoresRonda, jugadores, refRonda);
	}

}
