package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.NoSePuedeSeguirJugandoExcepcion;
import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasSituacionesDeJuegoSinFlorTest {

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
		mesa.instanciarJuez(eq1, eq2, new SinFlor());
	}

	@Test
	public void pruebaSimulacionDePartidaDeTrucoSimpleUnoPorUno(){
		
		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//R1
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual.jugarCarta(sieteDeEspada);

		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual.jugarCarta(anchoDeEspada);

		//R2
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq2,mesa.ganadorDeLaRonda());

		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguienteJugadorConTurno();

		actual.jugarCarta(anchoDeBasto);
		//R3
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());

		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cincoDeOro);

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
	}

	@Test
	public void pruebaSimulacionDePartidaDeTrucoSimpleDosPorDos(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();
		//R1
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual.jugarCarta(anchoDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual.jugarCarta(cuatroDeOro);
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));
		actual.jugarCarta(tresDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("eq2",mesa.ganadorDeLaRonda().obtenerNombre());
		//R2
		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeBasto);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(anchoDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(anchoDeBasto);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("eq1",mesa.ganadorDeLaRonda().obtenerNombre());
		//R3
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("eq2",mesa.ganadorDeLaRonda().obtenerNombre());
	}

	@Test
	public void pruebaSimulacionDePartidaDeTrucoSimpleTresPorTres(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq1.cargarJugadores("j5");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");
		eq2.cargarJugadores("j6");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();
		//R1
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual.jugarCarta(anchoDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual.jugarCarta(cuatroDeOro);
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));
		actual.jugarCarta(tresDeOro);
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, anchoDeOro, sotaDeBasto)));
		actual.jugarCarta(dosDeOro);
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeCopa, cincoDeBasto, reyDeOro)));
		actual.jugarCarta(cuatroDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq2,mesa.ganadorDeLaRonda());
		//R2
		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeBasto);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(anchoDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(anchoDeOro);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cincoDeBasto);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(anchoDeBasto);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
		//R3
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(sotaDeBasto);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(reyDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq2,mesa.ganadorDeLaRonda());
	}

	@Test
	public void pruebaSimulacionDePartidaJ3QuiereTrucoCantadoPorJ2(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
	}

	@Test
	public void pruebaSimulacionDePartidaJ3NOQuiereTrucoCantadoPorJ2(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.noQuiero();
		Assert.assertEquals(1,mesa.puntosEquipo(eq2));
	}

	@Test
	public void pruebaSimulacionDePartidaJ3QuiereEnvidoCantadoPorJ2(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//doy la vuelta para repartir...
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		Assert.assertEquals(2,mesa.puntosEquipo(eq1)); //gano eq1, j1 tiene 33 de mano
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre()); //devuelve el turno al j2
	}

	@Test
	public void pruebaSimulacionDePartidaJ3NOQuiereEnvidoCantadoPorJ2(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.noQuiero();
		Assert.assertEquals(1,mesa.puntosEquipo(eq2));
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre()); //devuelve el turno al j2
	}

	@Test(expected = RuntimeException.class)
	public void testFallaCantoTrucoyQuieroReTrucoElMismoJugador() {
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarQuieroReTruco();
	}

	@Test(expected = RuntimeException.class)
	public void testFallaCantoTrucoyQuieroReTrucoElMismoEquipo() {
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.cantarQuieroReTruco();
	}

	@Test
	public void pruebaJ3CantaEnvidoEnvidoJ4Acepta(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//doy la vuelta para repartir...
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, tresDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, seisDeEspada)));
		actual = mesa.siguienteJugadorConTurno();

		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarEnvido(); //aca canto Envido Envido el J3

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.quiero(); //j4 quiere envido envido
		Assert.assertEquals(4,mesa.puntosEquipo(eq2)); //gana eq2 xq tiene 32 J2

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre()); //devuelve el turno al j2
		//turno al J2 xq el canto envido, j3 envido envido, j4 quiso, le toca tirar a J2
	}

	@Test
	public void pruebaJ3CantaEnvidoEnvidoJ4NoAcepta(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarEnvido(); //aca canto Envido Envido el J3

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.noQuiero(); //j4 quiere envido envido
		Assert.assertEquals(2,mesa.puntosEquipo(eq1)); //gana eq1, eq2 no quiere

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre()); //devuelve el turno al j2
	}

	@Test
	public void pruebaJ4CantaEnvidoEnvidoRealEnvidoJ1Acepta(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//doy la vuelta para repartir...
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, sieteDeCopa, seisDeCopa)));
		actual = mesa.siguienteJugadorConTurno();

		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();

		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido(); //Canta Envido
		actual = mesa.siguienteJugadorConTurno();

		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguienteJugadorConTurno();

		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.cantarRealEnvido();
		actual = mesa.siguienteJugadorConTurno();

		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.quiero(); //j1 quiere envido envido realenvido

		Assert.assertEquals(7,mesa.puntosEquipo(eq1)); //gana eq1, j1 tiene 33 de mano

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre()); //devuelve el turno al j2
	}

	@Test
	public void pruebaSimulacionDePartidaJ1QuiereValeCuatroCantadoPorJ4(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarTruco(); //j2 canta truco
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarQuieroReTruco(); //j3 canta quierretruco
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.cantarQuieroValeCuatro(); //j4 canta quiero vale cuatro
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.quiero(); //j1 quiere el vale cuatro

		actual = mesa.siguienteJugadorConTurno(); //vuelve el turno al J2
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
	}

	@Test
	public void pruebaEq1GanaValeCuatro(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//doy la vuelta para repartir...
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, sieteDeCopa, seisDeCopa)));
		//r1
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(anchoDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(tresDeOro);
		//r2
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(tresDeBasto);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(sieteDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(anchoDeBasto);
		//r3
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarQuieroReTruco();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarQuieroValeCuatro();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.quiero(); //j4 quiere vale cuatro

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(seisDeCopa);

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(4,mesa.puntosEquipo(eq1)); //gana eq1 vale 4

	}

	@Test
	public void pruebaEq1GanaValeCuatroSeCantaPorRondas(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//doy la vuelta para repartir...
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, sieteDeCopa, seisDeCopa)));

		//r1
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.quiero();

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(anchoDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(tresDeOro);
		//r2
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarQuieroReTruco();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(tresDeBasto);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(sieteDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(anchoDeBasto);
		//r3
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarQuieroReTruco();

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.quiero();

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(seisDeCopa);

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(4,mesa.puntosEquipo(eq1)); //gana eq1 vale 4
	}

	@Test
	public void pruebaSimulacionDePartidaDeTrucoSimpleTresPorTresCantaEnvioYValeCuatro(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq1.cargarJugadores("j5");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");
		eq2.cargarJugadores("j6");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, anchoDeOro, sotaDeBasto)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeCopa, cincoDeBasto, reyDeOro)));

		//R1
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido(); //j2
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarRealEnvido(); //j3
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.quiero(); //j4

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(anchoDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeOro);

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.cantarTruco(); //j4
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.quiero(); //j5

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(tresDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(dosDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq2,mesa.ganadorDeLaRonda());
		//R2
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(sieteDeOro); //j2
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(tresDeBasto); //j3
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(anchoDeCopa); //j4
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(anchoDeOro); //j5
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarCarta(cincoDeBasto); //j6
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarQuieroReTruco(); //j1
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.quiero(); //j2
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(anchoDeBasto); //j1
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
		//R3
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarQuieroValeCuatro();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(tresDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(sotaDeBasto);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarCarta(reyDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq2,mesa.ganadorDeLaRonda());

		Assert.assertEquals(7,mesa.puntosEquipo(eq1));
		Assert.assertEquals(4,mesa.puntosEquipo(eq2));
	}

	@Test
	public void pruebaSimulacionDePartidaPicaPica(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq1.cargarJugadores("j5");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");
		eq2.cargarJugadores("j6");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));//J1
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));//J2
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));//J3
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));//J4
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, anchoDeOro, sotaDeBasto)));//J5
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeCopa, cincoDeBasto, reyDeOro)));//J6

		actual = mesa.siguienteJugadorConTurno();
		actual.cantarEnvido();
		actual = mesa.siguienteJugadorConTurno();
		actual.cantarEnvido(); //j2
		actual = mesa.siguienteJugadorConTurno();
		actual.cantarRealEnvido(); //j3
		actual = mesa.siguienteJugadorConTurno();
		actual.quiero(); //j4

		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(sieteDeEspada); //j1
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(anchoDeEspada); //j2
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cuatroDeOro); //j3
		actual = mesa.siguienteJugadorConTurno();
		actual.cantarTruco(); //j4
		actual = mesa.siguienteJugadorConTurno();
		actual.quiero(); //j5

		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeOro); //j4
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(dosDeOro); //j5
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cuatroDeCopa); //j6
		actual = mesa.siguienteJugadorConTurno();
		//R2
		actual.jugarCarta(sieteDeOro); //j2
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeBasto); //j3
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(anchoDeCopa); //j4
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(anchoDeOro); //j5
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cincoDeBasto); //j6
		actual = mesa.siguienteJugadorConTurno();
		actual.cantarQuieroReTruco(); //j1
		actual = mesa.siguienteJugadorConTurno();
		actual.quiero(); //j2
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(anchoDeBasto); //j1
		actual = mesa.siguienteJugadorConTurno();
		//R3
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		actual.cantarQuieroValeCuatro();
		actual = mesa.siguienteJugadorConTurno();
		actual.quiero();
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(sotaDeBasto);
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(reyDeOro);
		actual = mesa.siguienteJugadorConTurno();

		Assert.assertEquals(7,mesa.puntosEquipo(eq1));
		Assert.assertEquals(4,mesa.puntosEquipo(eq2));

		mesa.imprimirResultados();
		//la proxima tiene que ser picapica

		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		Assert.assertEquals("j5",actual.obtenerNombre());
		//r1
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(anchoDeEspada);
		//r2
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(anchoDeBasto);
		//r3
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(cincoDeOro);

		// jugador 2 gana un punto
		// SEGUNDA RONDA DE PICA PICA

		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeCopa, cincoDeBasto, reyDeOro)));
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));//J4
		Assert.assertEquals("j6",actual.obtenerNombre());
		//r1
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarCarta(anchoDeCopa);
		//r2
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarCarta(tresDeCopa);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(cincoDeBasto);

		// termino la mano gano jugador 6 un punto

		// TERCERA RONDA DE PICA PICA
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, anchoDeOro, sotaDeBasto)));
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		Assert.assertEquals("j1",actual.obtenerNombre());
		//r1
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(sotaDeBasto);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(dosDeCopa);
		//r2
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(anchoDeOro);
		//r3
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(dosDeOro);
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(tresDeBasto);

		//jugador 1 gana un punto

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals("j2",actual.obtenerNombre());
		//demuestra que da la vuelta bien dsps del picapica
		mesa.imprimirResultados();

		Assert.assertEquals(8,mesa.puntosEquipo(eq1));
		Assert.assertEquals(6,mesa.puntosEquipo(eq2));
	}
	
	@Test
	public void pruebaPardasUnoPorUnoSeGanaEnSegunda(){
		
		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//R1
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeCopa, anchoDeBasto, seisDeEspada)));
		actual.jugarCarta(dosDeCopa);

		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, sieteDeOro, cincoDeOro)));
		actual.jugarCarta(dosDeOro);

		//R2
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(anchoDeBasto);

		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(sieteDeOro);

		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
		
		Assert.assertEquals(1,mesa.puntosEquipo(eq1));
		Assert.assertEquals(0,mesa.puntosEquipo(eq2));
	}
	
	@Test
	public void pruebaPardasUnoPorUnoSeGanaEnTercera(){
		
		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//R1
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeCopa, tresDeOro, seisDeEspada)));
		actual.jugarCarta(dosDeCopa);

		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, tresDeCopa, cincoDeOro)));
		actual.jugarCarta(dosDeOro);

		//R2
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeOro);

		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeCopa);
		//R3
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(seisDeEspada);

		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cincoDeOro);
		
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
		
		Assert.assertEquals(1,mesa.puntosEquipo(eq1));
		Assert.assertEquals(0,mesa.puntosEquipo(eq2));
	}
	
	@Test
	public void pruebaPardasUnoPorUnoSeGanaEnTerceraPorSerMano(){
		
		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//R1
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeCopa, tresDeOro, cuatroDeOro)));
		actual.jugarCarta(dosDeCopa);

		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, tresDeCopa, cuatroDeCopa)));
		actual.jugarCarta(dosDeOro);

		//R2
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeOro);

		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeCopa);
		//R3
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cuatroDeOro);

		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cuatroDeCopa);
		
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
		
		Assert.assertEquals(1,mesa.puntosEquipo(eq1));
		Assert.assertEquals(0,mesa.puntosEquipo(eq2));
	}
	
	@Test
	public void pruebaIrseAlMazoPartidaDosxDos(){
		
		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//R1
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeCopa, tresDeOro, cuatroDeOro)));
		actual.jugarCarta(dosDeCopa);

		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, tresDeCopa, cuatroDeCopa)));
		actual.jugarCarta(dosDeOro);

		//R2
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeOro);

		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeCopa);
		//R3
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cuatroDeOro);

		actual = mesa.siguienteJugadorConTurno();
		actual.irseAlMazo();
		
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
		
		Assert.assertEquals(1,mesa.puntosEquipo(eq1));
		Assert.assertEquals(0,mesa.puntosEquipo(eq2));
	}
	
	@Test(expected = CantoInvalidoException.class)
	public void pruebaFallaCantaEnvidoSegundaMano(){
		
		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//R1
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeCopa, tresDeOro, cuatroDeOro)));
		actual.jugarCarta(dosDeCopa);

		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, tresDeCopa, cuatroDeCopa)));
		actual.jugarCarta(dosDeOro);

		//R2
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeOro);

		actual = mesa.siguienteJugadorConTurno();
		actual.cantarEnvido();
		
		Assert.assertEquals(1,mesa.puntosEquipo(eq1));
		Assert.assertEquals(0,mesa.puntosEquipo(eq2));
	}
	
	@Test(expected = CantoInvalidoException.class)
	public void pruebaFallaCantaEnvidoTerceraMano(){
		
		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//R1
		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeCopa, tresDeOro, cuatroDeOro)));
		actual.jugarCarta(dosDeCopa);

		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, tresDeCopa, cuatroDeCopa)));
		actual.jugarCarta(dosDeOro);

		//R2
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeOro);

		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(tresDeCopa);
		//R3
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(cuatroDeOro);

		actual = mesa.siguienteJugadorConTurno();
		actual.cantarEnvido();
	}
	
	@Test(expected = CantoInvalidoException.class)
	public void pruebaFallaCantaEnvidoDosVecesEnUnaMano(){
		
		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeCopa, tresDeOro, cuatroDeOro)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, tresDeCopa, cuatroDeCopa)));
		
		//R1
		actual = mesa.siguienteJugadorConTurno();
		actual.cantarEnvido();

		actual = mesa.siguienteJugadorConTurno();
		actual.quiero();
		
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(dosDeCopa);

		actual = mesa.siguienteJugadorConTurno();
		actual.cantarEnvido();
	}
}
