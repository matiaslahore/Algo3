package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.NoSePuedeSeguirJugandoExcepcion;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloDeCartas.Basto;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.Cinco;
import fiuba.algo3.tp2.modeloDeCartas.Copa;
import fiuba.algo3.tp2.modeloDeCartas.Cuatro;
import fiuba.algo3.tp2.modeloDeCartas.Dos;
import fiuba.algo3.tp2.modeloDeCartas.Espada;
import fiuba.algo3.tp2.modeloDeCartas.Oro;
import fiuba.algo3.tp2.modeloDeCartas.Rey;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SieteFalso;
import fiuba.algo3.tp2.modeloDeCartas.Sota;
import fiuba.algo3.tp2.modeloDeCartas.Tres;
import fiuba.algo3.tp2.modeloDeCartas.Seis;

import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasSituacionesDeJuegoConFlor {

	private Mesa mesa;
	private Equipo eq1;
	private Equipo eq2;
	Carta sieteDeEspada = new SieteDeEspada();
	Carta anchoDeBasto = new AnchoDeBasto();
	Carta seisDeEspada = new Seis(new Espada());
	Carta anchoDeEspada = new AnchoDeEspada();
	Carta sieteDeOro = new SieteDeOro();
	Carta cincoDeOro = new Cinco(new Oro());
	Carta cuatroDeOro = new Cuatro(new Oro());
	Carta tresDeBasto = new Tres(new Basto());
	Carta dosDeCopa = new Dos(new Copa());
	Carta tresDeOro = new Tres(new Oro());
	Carta anchoDeCopa = new AnchoFalso(new Copa());
	Carta tresDeCopa = new Tres(new Copa());
	Carta dosDeOro = new Dos(new Oro());
	Carta anchoDeOro = new AnchoFalso(new Oro());
	Carta sotaDeBasto = new Sota(new Basto());
	Carta cuatroDeCopa = new Cuatro(new Copa());
	Carta cincoDeBasto = new Cinco(new Basto());
	Carta reyDeOro = new Rey(new Oro());
	Carta sieteDeCopa = new SieteFalso(new Copa());
	Carta seisDeCopa = new Seis(new Copa());

	@Before
	public void setup() {
		mesa = new Mesa();
		eq1 = new Equipo("eq1", mesa);
		eq2 = new Equipo("eq2", mesa);
		mesa.instanciarJuez(eq1, eq2);
	}
	
	
	@Test(expected = CantoInvalidoException.class)
	public void pruebaFallaCantaFlorJugadorSinFlor(){
		
		eq1.cargarJugadores(Arrays.asList("j1"));
		eq2.cargarJugadores(Arrays.asList("j2"));

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeCopa, tresDeOro, anchoDeEspada)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, tresDeCopa, cuatroDeCopa)));
		
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarFlor();
	}
	

	@Test
	public void pruebaJ1CantaFlorJ4ContraFlorJ1Quiere(){
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//doy la vuelta para repartir...
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeEspada, seisDeEspada)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeBasto, tresDeBasto, dosDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, sieteDeCopa, seisDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, sieteDeOro, cincoDeOro)));

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarFlor();
		System.out.println(mesa.ronda);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		System.out.println(mesa.ronda);
		actual.cantarContraFlor();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.quiero();

		Assert.assertEquals(6,mesa.puntosEquipo(eq2)); //gana eq2 la contraFlor

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
	}
	

	@Test
	public void pruebaJ1CantaFlorGana3PtosNadieTieneFlor(){
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();
		
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeEspada, seisDeEspada)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeBasto, cincoDeOro, dosDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, sieteDeCopa, seisDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, sieteDeOro, tresDeBasto)));

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarFlor();
		
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		Assert.assertEquals(3,mesa.puntosEquipo(eq1)); //eq1 suma 3 x la flor
		
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
	}
	

	@Test(expected = NoSePuedeSeguirJugandoExcepcion.class)
	public void pruebaJ1CantaFlorJ2ContraFlorAlRestoJ1QuiereSeTerminaLaPartida(){
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//doy la vuelta para repartir...
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeEspada, seisDeEspada)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeBasto, tresDeBasto, dosDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, sieteDeCopa, seisDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, sieteDeOro, cincoDeOro)));

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarFlor();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.cantarContraFlorAJuego();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.quiero();

		Assert.assertEquals(30,mesa.puntosEquipo(eq2)); //gana eq2 xq j4 tiene 36

		actual = mesa.siguienteJugadorConTurno(); //esto produce excepcion xq termino la partida y quiero seguir jugando
		
	}
}
