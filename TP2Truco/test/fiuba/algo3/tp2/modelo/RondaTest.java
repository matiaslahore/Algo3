package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloRondas.RondaUno;
import fiuba.algo3.tp2.modeloRondas.Rondas;
import modeloJugador.Jugador;

public class RondaTest {

	Rondas ronda;
	
	@Before
	public void test() {
		Mesa mesa = new Mesa("eq1","eq2");
		Juez juez = new Juez(mesa, "eq1", "eq2");
		
		ArrayList<String> ganadores = new ArrayList<String>();
		
		ListaCircular<Jugador> listaCirc = new ListaCircular<Jugador>();
		listaCirc.add(new Jugador("pepe", mesa));
		listaCirc.add(new Jugador("juan", mesa));
		int index=0;
		ronda = new RondaUno(juez, ganadores, listaCirc, index);
		
		
		ronda.jugar();
		
	}

}
