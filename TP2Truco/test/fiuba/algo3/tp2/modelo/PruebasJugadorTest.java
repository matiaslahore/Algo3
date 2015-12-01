package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
		unJugador.recibirCartas(Arrays.asList(new TresDeOro(), new SieteDeOro(), new SotaDeBasto()));
		
		assertEquals(30,unJugador.obtenerPuntosEnvido());
	}
	
	@Test
	public void pruebaCalcularEnvidoConCartasDeDistintoPalo(){		
	
		unJugador.recibirCartas(Arrays.asList(new TresDeOro(), new SieteDeCopa(), new SotaDeBasto()));
		
		assertEquals(7, unJugador.obtenerPuntosEnvido());
	}
	
	@Test
	public void pruebaCalcularEnvidoConTresCartasDelMismoPalo(){		
	
		unJugador.recibirCartas(Arrays.asList(new TresDeOro(), new SieteDeOro(), new DosDeOro()));
		
		assertEquals(30, unJugador.obtenerPuntosEnvido());
	}
	
	@Test
	public void pruebaCalcularEnvidoConTresCartasNegrasDelMismoPalo(){
		

		unJugador.recibirCartas(Arrays.asList(new SotaDeOro(), new CaballoDeOro(), new ReyDeOro()));
		
		assertEquals(20, unJugador.obtenerPuntosEnvido());
		
	}
	
	@Test
	public void pruebaCalcularEnvidoConTresCartasNegrasDeDistintoPalo(){
		
		unJugador.recibirCartas(Arrays.asList(new SotaDeOro(), new CaballoDeEspada(), new ReyDeBasto()));
		
		assertEquals(0, unJugador.obtenerPuntosEnvido());	
	}
	
	@Test
	public void pruebaCalcularEnvidoConFlorConTresCartasNegras(){
		
		unJugador.recibirCartas(Arrays.asList(new SotaDeOro(), new CaballoDeOro(), new ReyDeOro()));
		
		assertEquals(20, unJugador.obtenerPuntosFlor());
	}
	
	@Test
	public void pruebaCalcularEnvidoConFlorConTresCartasComunes(){
		
		unJugador.recibirCartas(Arrays.asList(new CincoDeOro(), new SeisDeOro(), new SieteDeOro()));
		
		assertEquals(38, unJugador.obtenerPuntosFlor());
	}
}
