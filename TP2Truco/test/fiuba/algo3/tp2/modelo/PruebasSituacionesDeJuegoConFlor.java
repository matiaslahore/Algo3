package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.NoSePuedeSeguirJugandoExcepcion;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeOro;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeOro;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeOro;
import fiuba.algo3.tp2.modeloDeCartas.DosDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.DosDeOro;
import fiuba.algo3.tp2.modeloDeCartas.ReyDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SeisDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.SeisDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SotaDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.TresDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.TresDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.TresDeOro;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasSituacionesDeJuegoConFlor {

	private Mesa mesa;
	private Equipo eq1;
	private Equipo eq2;
	Carta sieteDeEspada = new SieteDeEspada();
	Carta anchoDeBasto = new AnchoDeBasto();
	Carta seisDeEspada = new SeisDeEspada();
	Carta anchoDeEspada = new AnchoDeEspada();
	Carta sieteDeOro = new SieteDeOro();
	Carta cincoDeOro = new CincoDeOro();
	Carta cuatroDeOro = new CuatroDeOro();
	Carta tresDeBasto = new TresDeBasto();
	Carta dosDeCopa = new DosDeCopa();
	Carta tresDeOro = new TresDeOro();
	Carta anchoDeCopa = new AnchoDeCopa();
	Carta tresDeCopa = new TresDeCopa();
	Carta dosDeOro = new DosDeOro();
	Carta anchoDeOro = new AnchoDeOro();
	Carta sotaDeBasto = new SotaDeBasto();
	Carta cuatroDeCopa = new CuatroDeCopa();
	Carta cincoDeBasto = new CincoDeBasto();
	Carta reyDeOro = new ReyDeOro();
	Carta sieteDeCopa = new SieteDeCopa();
	Carta seisDeCopa = new SeisDeCopa();

	@Before
	public void setup() {
		mesa = new Mesa();
		eq1 = new Equipo("eq1", mesa);
		eq2 = new Equipo("eq2", mesa);
		mesa.instanciarJuez(eq1, eq2, new EstadoConFlor());
	}
	
	
	@Test(expected = CantoInvalidoException.class)
	public void pruebaFallaCantaFlorJugadorSinFlor(){
		
		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");

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
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

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
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

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
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

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
