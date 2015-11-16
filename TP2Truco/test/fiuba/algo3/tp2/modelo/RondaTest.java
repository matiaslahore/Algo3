package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import fiuba.algo3.colecciones.ListaCircular;

public class RondaTest {

	Rondas ronda;
	
	@Test
	public void test() {
		Mesa mesa = new Mesa("eq1","eq2");
		Juez juez = new Juez(mesa);
		
		ArrayList<String> list = new ArrayList<String>();
		
		ListaCircular<Jugador> lista = new ListaCircular<Jugador>();
		lista.add(new Jugador("pepe", mesa));
		lista.add(new Jugador("juan", mesa));
		
		ronda = new RondaUno(juez, list, lista, ronda);
		
		ronda.jugar(0);
		
	}

}
