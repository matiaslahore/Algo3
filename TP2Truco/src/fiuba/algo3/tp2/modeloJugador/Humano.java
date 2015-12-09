package fiuba.algo3.tp2.modeloJugador;

import fiuba.algo3.tp2.excepciones.JugadorHumanoNoPuedeUsarIA;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mesa;

public class Humano extends Jugador{

	public Humano(String name, Mesa mesa, Equipo team) {
		super(name, mesa, team);
	}

	public void hacerJugarIA() {
	}
}
