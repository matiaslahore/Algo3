package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.modeloRondas.EstadoRondaUno;
import fiuba.algo3.tp2.modeloRondas.EstadoRondas;

public class RondaTest {

	EstadoRondas ronda;
	
	@Before
	public void test() {
		Mesa mesa = new Mesa("eq1","eq2");
		Juez juez = new Juez(mesa, "eq1", "eq2");
		
		ArrayList<String> ganadores = new ArrayList<String>();
		
		ListaCircular<Jugador> listaCirc = new ListaCircular<Jugador>();
		listaCirc.add(new Jugador("pepe", mesa));
		listaCirc.add(new Jugador("juan", mesa));
		int index=0;
		ronda = new EstadoRondaUno(juez, ganadores, listaCirc, index);
		
		
		ronda.jugar();
		
	}

}
