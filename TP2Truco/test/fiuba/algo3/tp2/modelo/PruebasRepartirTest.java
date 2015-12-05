package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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

		//podria ser un metodo equipo.recibirCartas()
		jugadores.get(0).recibirCartas(Arrays.asList(new SieteDeOro(), new SeisDeOro(), new SieteDeCopa()));
		jugadores.get(1).recibirCartas(Arrays.asList(new DosDeOro(), new TresDeOro(), new SotaDeCopa()));
		jugadores.get(2).recibirCartas(Arrays.asList(new CincoDeOro(), new CuatroDeOro(), new ReyDeCopa()));
		
		Assert.assertEquals(3,jugadores.get(0).cantidadDeCartas());
		Assert.assertEquals(3,jugadores.get(1).cantidadDeCartas());
		Assert.assertEquals(3,jugadores.get(2).cantidadDeCartas());
	}
}
