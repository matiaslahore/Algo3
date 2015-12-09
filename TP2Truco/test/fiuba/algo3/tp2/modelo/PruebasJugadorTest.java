package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloJugador.Humano;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasJugadorTest {
	
	private Jugador unJugador;
	public  Mesa mesa;
	
	@Before
	public void inicializado(){
		
		mesa = new Mesa();
		unJugador = new Humano("Nicolas", mesa, new Equipo("EquipoUno",mesa));
	}
	
	@Test
	public void pruebaCalcularEnvidoDeCartasSinFlor(){
		
		unJugador.recibirCartas(Arrays.asList(new Tres(new Oro()), new SieteDeOro(), new Sota(new Basto())));
		
		assertEquals(30,unJugador.obtenerPuntosEnvido());
	}
	
	@Test
	public void pruebaCalcularEnvidoConCartasDeDistintoPalo(){		
	
		unJugador.recibirCartas(Arrays.asList(new Tres(new Oro()), new SieteFalso(new Copa()), new Sota(new Basto())));
		
		assertEquals(7, unJugador.obtenerPuntosEnvido());
	}
	
	@Test
	public void pruebaCalcularEnvidoConTresCartasDelMismoPalo(){		
	
		unJugador.recibirCartas(Arrays.asList(new Tres(new Oro()), new SieteDeOro(), new Dos(new Oro())));
		
		assertEquals(30, unJugador.obtenerPuntosEnvido());
	}
	
	@Test
	public void pruebaCalcularEnvidoConTresCartasNegrasDelMismoPalo(){
		

		unJugador.recibirCartas(Arrays.asList(new Sota(new Oro()), new Caballo(new Oro()), new Rey(new Oro())));
		
		assertEquals(20, unJugador.obtenerPuntosEnvido());
		
	}
	
	@Test
	public void pruebaCalcularEnvidoConTresCartasNegrasDeDistintoPalo(){
		
		unJugador.recibirCartas(Arrays.asList(new Sota(new Oro()), new Caballo(new Espada()), new Rey(new Basto())));
		
		assertEquals(0, unJugador.obtenerPuntosEnvido());	
	}
	
	@Test
	public void pruebaCalcularEnvidoConFlorConTresCartasNegras(){
		
		unJugador.recibirCartas(Arrays.asList(new Sota(new Oro()), new Caballo(new Oro()), new Rey(new Oro())));
		
		assertEquals(20, unJugador.obtenerPuntosFlor());
	}
	
	@Test
	public void pruebaCalcularEnvidoConFlorConTresCartasComunes(){
		
		unJugador.recibirCartas(Arrays.asList(new Cinco(new Oro()), new Seis(new Oro()), new SieteDeOro()));
		
		assertEquals(38, unJugador.obtenerPuntosFlor());
	}
}
