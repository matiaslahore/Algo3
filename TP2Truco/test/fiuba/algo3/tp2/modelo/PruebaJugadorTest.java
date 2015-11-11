package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PruebaJugadorTest {
	
	private Jugador unJugador;
	
	@Before
	public void inicializado(){
		
		unJugador = new Jugador("Nicolas");
	}
	
	@Test
	public void pruebaCalcularEnvidoDeCartasSinFlor(){
		
		unJugador.recibirCartas(new Carta(new Oro(), 3), new Carta(new Oro(), 7), new Carta(new Basto(),10));
		
		assertEquals(30,unJugador.obtenerPuntosEnvido());
	}
	
	@Test
	public void pruebaCalcularEnvidoConCartasDeDistintoPalo(){		
	
		unJugador.recibirCartas(new Carta(new Oro(), 3), new Carta(new Basto(), 7), new Carta(new Espada(),10));
		
		assertEquals(7, unJugador.obtenerPuntosEnvido());
	}
	
	@Test
	public void pruebaCalcularEnvidoConTresCartasDelMismoPalo(){		
	
		unJugador.recibirCartas(new Carta(new Oro(), 3), new Carta(new Oro(), 7), new Carta(new Oro(),2));
		
		assertEquals(30, unJugador.obtenerPuntosEnvido());
	}
	
	@Test
	public void pruebaCalcularEnvidoConTresCartasNegrasDelMismoPalo(){
		

		unJugador.recibirCartas(new Carta(new Oro(), 10), new Carta(new Oro(), 11), new Carta(new Oro(),12));
		
		assertEquals(20, unJugador.obtenerPuntosEnvido());
		
	}
	
	@Test
	public void pruebaCalcularEnvidoConTresCartasNegrasDeDistintoPalo(){
		
		unJugador.recibirCartas(new Carta(new Basto(), 10), new Carta(new Oro(), 11), new Carta(new Espada(),12));
		
		assertEquals(0, unJugador.obtenerPuntosEnvido());	
	}
	
	@Test
	public void pruebaCalcularEnvidoConFlorConTresCartasNegras(){
		
		unJugador.recibirCartas(new Carta(new Oro(), 10), new Carta(new Oro(), 11), new Carta(new Oro(),12));
		
		assertEquals(20, unJugador.obtenerPuntosEnvidoConFlor());
	}
	
	@Test
	public void pruebaCalcularEnvidoConFlorConTresCartasComunes(){
		
		unJugador.recibirCartas(new Carta(new Oro(), 5), new Carta(new Oro(), 6), new Carta(new Oro(),7));
		
		assertEquals(38, unJugador.obtenerPuntosEnvidoConFlor());
	}
}
