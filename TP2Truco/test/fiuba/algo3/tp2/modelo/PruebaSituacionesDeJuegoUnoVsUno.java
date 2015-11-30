package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SeisDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebaSituacionesDeJuegoUnoVsUno {

	
	private Mesa mesa;
	private Equipo eq1;
	private Equipo eq2;
	
	@Before
	public void setup() {
		mesa = new Mesa();
		eq1 = new Equipo("eq1", mesa);
		eq2 = new Equipo("eq2", mesa);
		mesa.instanciarJuez(eq1,eq2);
	}	
	
	@Test
	public void pruebaSimulacionDePartidaDeTrucoSimpleUnoPorUno(){
		
		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");
		
		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();
		//R1
		Jugador jugadorUno = mesa.siguiente();
		
		System.out.println("Turno de: " + jugadorUno.obtenerNombre());
		
		List<Carta> cartasJugadorUno = new ArrayList<Carta>();
		
		Carta sieteDeEspada = new SieteDeEspada();
		Carta anchoDeBasto = new AnchoDeBasto();
		Carta seisDeEspada = new SeisDeEspada();
		
		cartasJugadorUno.addAll(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada));
		
		jugadorUno.recibirCartas(cartasJugadorUno);
		jugadorUno.jugarCarta(seisDeEspada);
		
		// turno jugador dos
		Jugador jugadorDos = mesa.siguiente();
		
		System.out.println("Turno de: " + jugadorDos.obtenerNombre());
		
		Carta anchoDeEspada = new AnchoDeEspada();
		Carta sieteDeOro = new SieteDeOro();
		Carta cincoDeOro = new CincoDeOro();
		
		List<Carta> cartasJugadorDos = new ArrayList<Carta>();
		
		cartasJugadorDos.addAll(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro));
		
		jugadorDos.recibirCartas(cartasJugadorDos);
		
		jugadorDos.jugarCarta(sieteDeOro);
		
		// turno jugador uno
		jugadorDos = mesa.siguiente();
		Assert.assertEquals(eq2,mesa.ganadorDeLaRonda());
		//R2
		System.out.println("Turno de: " + jugadorUno.obtenerNombre());
		jugadorDos.jugarCarta(cincoDeOro);
		
		// turno jugador dos
		jugadorUno = mesa.siguiente();
		System.out.println("Turno de: " + jugadorDos.obtenerNombre());
		jugadorUno.jugarCarta(sieteDeEspada);
		
		// turno jugador uno
		jugadorUno = mesa.siguiente();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
		//R3
		System.out.println("Turno de: " + jugadorDos.obtenerNombre());
		jugadorUno.jugarCarta(anchoDeBasto);
		
		// turno jugador dos
		jugadorDos = mesa.siguiente();
		System.out.println("Turno de: " + jugadorDos.obtenerNombre());
		jugadorDos.jugarCarta(anchoDeEspada);
		
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
	}
}
