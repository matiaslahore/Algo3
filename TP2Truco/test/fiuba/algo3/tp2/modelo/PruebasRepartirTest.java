package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasRepartirTest {
	
	Mesa mesa;
	
	@Before
	public void Inicializar(){
		this.mesa = new Mesa();
	}
	
	@Test
	public void repartoAlEquipo(){
		Equipo equipo = new Equipo("Futbol",mesa);
		equipo.cargarJugadores(Arrays.asList("Pepito","pipi","julio"));
		
		ArrayList<Jugador> jugadores = equipo.obtenerJugadores();

		jugadores.get(0).recibirCartas(Arrays.asList(new SieteDeOro(), new Seis(new Oro()), new SieteFalso(new Copa())));
		jugadores.get(1).recibirCartas(Arrays.asList(new Dos(new Oro()), new Tres(new Oro()), new Sota(new Copa())));
		jugadores.get(2).recibirCartas(Arrays.asList(new Cinco(new Oro()), new Cuatro(new Oro()), new Rey(new Copa())));
		
		Assert.assertEquals(3,jugadores.get(0).cantidadDeCartas());
		Assert.assertEquals(3,jugadores.get(1).cantidadDeCartas());
		Assert.assertEquals(3,jugadores.get(2).cantidadDeCartas());
	}
}
