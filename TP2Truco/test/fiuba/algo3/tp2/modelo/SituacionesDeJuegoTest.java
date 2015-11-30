package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.NoSePuedeSeguirJugandoExcepcion;
import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class SituacionesDeJuegoTest {

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
		mesa.instanciarJuez(eq1,eq2);
	}

	@Test
	public void pruebaSimulacionDePartidaDeTrucoSimpleUnoPorUno(){


		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//R1
		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual.jugarCarta(sieteDeEspada);

		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual.jugarCarta(anchoDeEspada);

		//R2
		actual = mesa.siguiente();
		Assert.assertEquals(eq2,mesa.ganadorDeLaRonda());

		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguiente();

		actual.jugarCarta(anchoDeBasto);
		//R3
		actual = mesa.siguiente();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());

		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguiente();
		actual.jugarCarta(cincoDeOro);

		actual = mesa.siguiente();
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
		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual.jugarCarta(anchoDeEspada);
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual.jugarCarta(cuatroDeOro);
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));
		actual.jugarCarta(tresDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("eq2",mesa.ganadorDeLaRonda().obtenerNombre());
		//R2
		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguiente();
		actual.jugarCarta(tresDeBasto);
		actual = mesa.siguiente();
		actual.jugarCarta(anchoDeCopa);
		actual = mesa.siguiente();
		actual.jugarCarta(anchoDeBasto);
		actual = mesa.siguiente();
		Assert.assertEquals("eq1",mesa.ganadorDeLaRonda().obtenerNombre());
		//R3
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguiente();
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguiente();
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguiente();
		actual.jugarCarta(tresDeCopa);
		actual = mesa.siguiente();
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
		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual.jugarCarta(anchoDeEspada);
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual.jugarCarta(cuatroDeOro);
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));
		actual.jugarCarta(tresDeOro);
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, anchoDeOro, sotaDeBasto)));
		actual.jugarCarta(dosDeOro);
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeCopa, cincoDeBasto, reyDeOro)));
		actual.jugarCarta(cuatroDeCopa);
		actual = mesa.siguiente();
		Assert.assertEquals(eq2,mesa.ganadorDeLaRonda());
		//R2
		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguiente();
		actual.jugarCarta(tresDeBasto);
		actual = mesa.siguiente();
		actual.jugarCarta(anchoDeCopa);
		actual = mesa.siguiente();
		actual.jugarCarta(anchoDeOro);
		actual = mesa.siguiente();
		actual.jugarCarta(cincoDeBasto);
		actual = mesa.siguiente();
		actual.jugarCarta(anchoDeBasto);
		actual = mesa.siguiente();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
		//R3
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguiente();
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguiente();
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguiente();
		actual.jugarCarta(tresDeCopa);
		actual = mesa.siguiente();
		actual.jugarCarta(sotaDeBasto);
		actual = mesa.siguiente();
		actual.jugarCarta(reyDeOro);
		actual = mesa.siguiente();
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

		Jugador actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual = mesa.siguiente();
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

		Jugador actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguiente();
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
		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));

		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		Assert.assertEquals(2,mesa.puntosEquipo(eq1)); //gano eq1, j1 tiene 33 de mano
		actual = mesa.siguiente();
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

		Jugador actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.noQuiero();
		Assert.assertEquals(1,mesa.puntosEquipo(eq2));
		actual = mesa.siguiente();
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

		Jugador actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		actual = mesa.siguiente();
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

		Jugador actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual = mesa.siguiente();
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
		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, tresDeCopa)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, seisDeEspada)));
		actual = mesa.siguiente();

		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarEnvido(); //aca canto Envido Envido el J3

		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.quiero(); //j4 quiere envido envido
		Assert.assertEquals(4,mesa.puntosEquipo(eq2)); //gana eq2 xq tiene 32 J2

		actual = mesa.siguiente();
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

		Jugador actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarEnvido(); //aca canto Envido Envido el J3

		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.noQuiero(); //j4 quiere envido envido
		Assert.assertEquals(2,mesa.puntosEquipo(eq1)); //gana eq1, eq2 no quiere

		actual = mesa.siguiente();
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
		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, sieteDeCopa, seisDeCopa)));
		actual = mesa.siguiente();

		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();

		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido(); //Canta Envido
		actual = mesa.siguiente();

		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguiente();

		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.cantarRealEnvido();
		actual = mesa.siguiente();

		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.quiero(); //j1 quiere envido envido realenvido

		Assert.assertEquals(7,mesa.puntosEquipo(eq1)); //gana eq1, j1 tiene 33 de mano

		actual = mesa.siguiente();
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

		Jugador actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarTruco(); //j2 canta truco
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarQuieroReTruco(); //j3 canta quierretruco
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.cantarQuieroValeCuatro(); //j4 canta quiero vale cuatro
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.quiero(); //j1 quiere el vale cuatro

		actual = mesa.siguiente(); //vuelve el turno al J2
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual = mesa.siguiente();
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
		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, sieteDeCopa, seisDeCopa)));
		//r1
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(anchoDeEspada);
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(tresDeOro);
		//r2
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(tresDeBasto);
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(sieteDeCopa);
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(anchoDeBasto);
		//r3
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarQuieroReTruco();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarQuieroValeCuatro();
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.quiero(); //j4 quiere vale cuatro

		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(seisDeCopa);

		actual = mesa.siguiente();
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
		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, sieteDeCopa, seisDeCopa)));

		//r1
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.quiero();

		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(anchoDeEspada);
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(tresDeOro);
		//r2
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarQuieroReTruco();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();

		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(tresDeBasto);
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(sieteDeCopa);
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(anchoDeBasto);
		//r3
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarQuieroReTruco();

		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.quiero();

		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(seisDeCopa);

		actual = mesa.siguiente();
		Assert.assertEquals(4,mesa.puntosEquipo(eq1)); //gana eq1 vale 4
	}

	@Test
	public void pruebaJ1CantaFlorJ2noQuiere(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//doy la vuelta para repartir...
		Jugador actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarFlor();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.noQuiero();
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());

		Assert.assertEquals(3,mesa.puntosEquipo(eq1)); //gana eq1 vale 4

	}

	@Test
	public void pruebaJ1CantaFlorJ2ContraFlorJ1Quiere(){
		eq1.cargarJugadores("j1");
		eq1.cargarJugadores("j3");
		eq2.cargarJugadores("j2");
		eq2.cargarJugadores("j4");

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		//doy la vuelta para repartir...
		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, sieteDeCopa, seisDeCopa)));

		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarFlor();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarContraFlor();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();

		Assert.assertEquals(6,mesa.puntosEquipo(eq1)); //gana eq1 vale 4

		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
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
		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, sieteDeCopa, seisDeCopa)));

		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarFlor();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarContraFlorAJuego();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();

		Assert.assertEquals(30,mesa.puntosEquipo(eq1)); //gana eq1

		actual = mesa.siguiente(); //esto produce excepcion xq termino la partida y quiero seguir jugando
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

		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, anchoDeOro, sotaDeBasto)));
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeCopa, cincoDeBasto, reyDeOro)));
		
		//R1
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido(); //j2
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.cantarRealEnvido(); //j3
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.quiero(); //j4

		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(anchoDeEspada);
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeOro);
		
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.cantarTruco(); //j4
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.quiero(); //j5

		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(tresDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(dosDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeCopa);
		actual = mesa.siguiente();
		Assert.assertEquals(eq2,mesa.ganadorDeLaRonda());
		//R2
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(sieteDeOro); //j2
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(tresDeBasto); //j3
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(anchoDeCopa); //j4
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(anchoDeOro); //j5
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarCarta(cincoDeBasto); //j6
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarQuieroReTruco(); //j1
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.quiero(); //j2
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(anchoDeBasto); //j1
		actual = mesa.siguiente();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
		//R3
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarQuieroValeCuatro();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(tresDeCopa);
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(sotaDeBasto);
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarCarta(reyDeOro);
		actual = mesa.siguiente();
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

		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));//J1
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));//J2
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));//J3
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));//J4
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, anchoDeOro, sotaDeBasto)));//J5
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeCopa, cincoDeBasto, reyDeOro)));//J6

		actual = mesa.siguiente();
		actual.cantarEnvido();
		actual = mesa.siguiente();
		actual.cantarEnvido(); //j2
		actual = mesa.siguiente();
		actual.cantarRealEnvido(); //j3
		actual = mesa.siguiente();
		actual.quiero(); //j4

		actual = mesa.siguiente();
		actual.jugarCarta(sieteDeEspada); //j1
		actual = mesa.siguiente();
		actual.jugarCarta(anchoDeEspada); //j2
		actual = mesa.siguiente();
		actual.jugarCarta(cuatroDeOro); //j3
		actual = mesa.siguiente();
		actual.cantarTruco(); //j4
		actual = mesa.siguiente();
		actual.quiero(); //j5

		actual = mesa.siguiente();
		actual.jugarCarta(tresDeOro); //j4
		actual = mesa.siguiente();
		actual.jugarCarta(dosDeOro); //j5
		actual = mesa.siguiente();
		actual.jugarCarta(cuatroDeCopa); //j6
		actual = mesa.siguiente();
		//R2
		actual.jugarCarta(sieteDeOro); //j2
		actual = mesa.siguiente();
		actual.jugarCarta(tresDeBasto); //j3
		actual = mesa.siguiente();
		actual.jugarCarta(anchoDeCopa); //j4
		actual = mesa.siguiente();
		actual.jugarCarta(anchoDeOro); //j5
		actual = mesa.siguiente();
		actual.jugarCarta(cincoDeBasto); //j6
		actual = mesa.siguiente();
		actual.cantarQuieroReTruco(); //j1
		actual = mesa.siguiente();
		actual.quiero(); //j2
		actual = mesa.siguiente();
		actual.jugarCarta(anchoDeBasto); //j1
		actual = mesa.siguiente();
		//R3
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguiente();
		actual.cantarQuieroValeCuatro();
		actual = mesa.siguiente();
		actual.quiero();
		actual = mesa.siguiente();
		actual.jugarCarta(cincoDeOro);
		actual = mesa.siguiente();
		actual.jugarCarta(dosDeCopa);
		actual = mesa.siguiente();
		actual.jugarCarta(tresDeCopa);
		actual = mesa.siguiente();
		actual.jugarCarta(sotaDeBasto);
		actual = mesa.siguiente();
		actual.jugarCarta(reyDeOro);
		actual = mesa.siguiente();

		Assert.assertEquals(7,mesa.puntosEquipo(eq1));
		Assert.assertEquals(4,mesa.puntosEquipo(eq2));

		mesa.imprimirResultados();
		//la proxima tiene que ser picapica

		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada)));
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro)));
		Assert.assertEquals("j5",actual.obtenerNombre());
		//r1
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(anchoDeEspada);
		//r2
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(sieteDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(anchoDeBasto);
		//r3
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarCarta(seisDeEspada);
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarCarta(cincoDeOro);
		
		// jugador 2 gana un punto
		// SEGUNDA RONDA DE PICA PICA
		
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeCopa, cincoDeBasto, reyDeOro)));
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeCopa, tresDeCopa)));//J4
		Assert.assertEquals("j6",actual.obtenerNombre());
		//r1
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeCopa);
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarCarta(anchoDeCopa);
		//r2
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarCarta(tresDeCopa);
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarCarta(cincoDeBasto);
	
		// termino la mano gano jugador 6 un punto
	
		// TERCERA RONDA DE PICA PICA
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, anchoDeOro, sotaDeBasto)));
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual = mesa.siguiente();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(cuatroDeOro, tresDeBasto, dosDeCopa)));
		Assert.assertEquals("j1",actual.obtenerNombre());
		//r1
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(sotaDeBasto);
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(dosDeCopa);
		//r2
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(cuatroDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(anchoDeOro);
		//r3
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarCarta(dosDeOro);
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarCarta(tresDeBasto);

		//jugador 1 gana un punto
		
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		//demuestra que da la vuelta bien dsps del picapica
		mesa.imprimirResultados();
		
		Assert.assertEquals(8,mesa.puntosEquipo(eq1));
		Assert.assertEquals(6,mesa.puntosEquipo(eq2));
	}

}
