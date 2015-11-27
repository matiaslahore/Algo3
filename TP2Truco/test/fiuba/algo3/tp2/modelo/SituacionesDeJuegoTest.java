package fiuba.algo3.tp2.modelo;

import java.util.Arrays;

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
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerEquipo());
		TipoDeCartas sieteDeEspada = new SieteDeEspada();
		TipoDeCartas anchoDeBasto = new AnchoDeBasto();
		TipoDeCartas seisDeEspada = new SeisDeEspada();
		actual.recibirCartas(Arrays.asList(sieteDeEspada, anchoDeBasto, seisDeEspada));
		actual.jugarCarta(sieteDeEspada);
		actual = mesa.siguiente();
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerEquipo());
		TipoDeCartas anchoDeEspada = new AnchoDeEspada();
		TipoDeCartas sieteDeOro = new SieteDeOro();
		TipoDeCartas cincoDeOro = new CincoDeOro();
		actual.recibirCartas(Arrays.asList(anchoDeEspada, sieteDeOro, cincoDeOro));
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals(eq2,mesa.ultimoGanador());
		//R2
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerEquipo());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerEquipo());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals(eq1,mesa.ultimoGanador());
		//R3
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerEquipo());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerEquipo());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals(eq1,mesa.ultimoGanador());
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
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeEspada());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new AnchoDeCopa(), new TresDeCopa());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("eq2",mesa.ultimoGanador().obtenerNombre());
		//R2
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("eq1",mesa.ultimoGanador().obtenerNombre());
		//R3
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("eq2",mesa.ultimoGanador().obtenerNombre());
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
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeEspada());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new AnchoDeCopa(), new TresDeCopa());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.recibirCartas(new DosDeOro(), new AnchoDeOro(), new SotaDeBasto());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeCopa(), new CincoDeBasto(), new ReyDeOro());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals(eq2,mesa.ultimoGanador());
		//R2
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals(eq1,mesa.ultimoGanador());
		//R3
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals(eq2,mesa.ultimoGanador());
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
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
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
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
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
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new SieteDeCopa(), new SeisDeCopa());
		actual = mesa.siguiente();

		Assert.assertEquals("j1",actual.obtenerNombre());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarEnvido();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		Assert.assertEquals(2,mesa.puntosEquipo(eq2));
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
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new SieteDeCopa(), new SeisDeCopa());
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
		Assert.assertEquals(4,mesa.puntosEquipo(eq2)); //gana eq2 xq tiene 33 J4
		
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
		
		//doy la vuelta para repartir...
		Jugador actual = mesa.siguiente();
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new SieteDeCopa(), new SeisDeCopa());
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
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new SieteDeCopa(), new SeisDeCopa());
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
		
		Assert.assertEquals(7,mesa.puntosEquipo(eq2)); //gana eq2
		
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
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
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
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new SieteDeCopa(), new SeisDeCopa());
		
		//r1
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera();
		//r2
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarPrimera();
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
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera();
		
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
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new SieteDeCopa(), new SeisDeCopa());
		
		//r1
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarTruco();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.quiero();
		
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera();
		//r2
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarQuieroReTruco();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarPrimera();
		//r3
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarQuieroReTruco();
		
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.quiero();
		
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera();
		
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
		actual.recibirCartas(new SieteDeEspada(), new SeisDeEspada(), new CincoDeEspada());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new SeisDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new SieteDeCopa(), new SeisDeCopa());
		
		actual = mesa.siguiente();
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
		actual.recibirCartas(new SieteDeEspada(), new SeisDeEspada(), new CincoDeEspada());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new SeisDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new SieteDeCopa(), new SeisDeCopa());
		
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
		actual.recibirCartas(new SieteDeEspada(), new SeisDeEspada(), new CincoDeEspada());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new SeisDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new SieteDeCopa(), new SeisDeCopa());
		
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
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeEspada());
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.recibirCartas(new TresDeOro(), new AnchoDeCopa(), new TresDeCopa());
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.recibirCartas(new DosDeOro(), new AnchoDeOro(), new SotaDeBasto());
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.recibirCartas(new CuatroDeCopa(), new CincoDeBasto(), new ReyDeOro());
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
		actual.jugarPrimera(); //j1
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera(); //j2
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera(); //j3
		
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.cantarTruco(); //j4
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.quiero(); //j5
		
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera(); //j4
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarPrimera(); //j5
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarPrimera(); //j6
		actual = mesa.siguiente();
		Assert.assertEquals(eq2,mesa.ultimoGanador());
		//R2
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera(); //j2
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera(); //j3
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera(); //j4
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarPrimera(); //j5
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarPrimera(); //j6
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.cantarQuieroReTruco(); //j1
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.quiero(); //j2
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarPrimera(); //j1
		actual = mesa.siguiente();
		Assert.assertEquals(eq1,mesa.ultimoGanador());
		//R3
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.cantarQuieroValeCuatro();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.quiero();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals(eq2,mesa.ultimoGanador());
		
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
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeEspada());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeOro(), new TresDeBasto(), new DosDeCopa());
		actual = mesa.siguiente();
		actual.recibirCartas(new TresDeOro(), new AnchoDeCopa(), new TresDeCopa());
		actual = mesa.siguiente();
		actual.recibirCartas(new DosDeOro(), new AnchoDeOro(), new SotaDeBasto());
		actual = mesa.siguiente();
		actual.recibirCartas(new CuatroDeCopa(), new CincoDeBasto(), new ReyDeOro());
		
		//R1
		actual = mesa.siguiente();
		actual.cantarEnvido();
		actual = mesa.siguiente();
		actual.cantarEnvido(); //j2
		actual = mesa.siguiente();
		actual.cantarRealEnvido(); //j3
		actual = mesa.siguiente();
		actual.quiero(); //j4
		
		actual = mesa.siguiente();
		actual.jugarPrimera(); //j1
		actual = mesa.siguiente();
		actual.jugarPrimera(); //j2
		actual = mesa.siguiente();
		actual.jugarPrimera(); //j3
		actual = mesa.siguiente();
		actual.cantarTruco(); //j4
		actual = mesa.siguiente();
		actual.quiero(); //j5
		
		actual = mesa.siguiente();
		actual.jugarPrimera(); //j4
		actual = mesa.siguiente();
		actual.jugarPrimera(); //j5
		actual = mesa.siguiente();
		actual.jugarPrimera(); //j6
		actual = mesa.siguiente();
		//R2
		actual.jugarPrimera(); //j2
		actual = mesa.siguiente();
		actual.jugarPrimera(); //j3
		actual = mesa.siguiente();
		actual.jugarPrimera(); //j4
		actual = mesa.siguiente();
		actual.jugarPrimera(); //j5
		actual = mesa.siguiente();
		actual.jugarPrimera(); //j6
		actual = mesa.siguiente();
		actual.cantarQuieroReTruco(); //j1
		actual = mesa.siguiente();
		actual.quiero(); //j2
		actual = mesa.siguiente();
		actual.jugarPrimera(); //j1
		actual = mesa.siguiente();
		//R3
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.cantarQuieroValeCuatro();
		actual = mesa.siguiente();
		actual.quiero();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		
		Assert.assertEquals(7,mesa.puntosEquipo(eq1));
		Assert.assertEquals(4,mesa.puntosEquipo(eq2));
		
		mesa.imprimirResultados();
		//la proxima tiene que ser picapica
		
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeEspada());
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		Assert.assertEquals("j5",actual.obtenerNombre());
		//r1
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarPrimera();
		//r2
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera();
		//r3
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j5",actual.obtenerNombre());
		actual.jugarPrimera();
		// SEGUNDA RONDA DE PICA PICA
		actual = mesa.siguiente();
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeEspada());
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		Assert.assertEquals("j6",actual.obtenerNombre());
		//r1
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarPrimera();
		//r2
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera();
		//r3
		actual = mesa.siguiente();
		Assert.assertEquals("j3",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j6",actual.obtenerNombre());
		actual.jugarPrimera();
		
		// TERCERA RONDA DE PICA PICA
		actual = mesa.siguiente();
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeEspada());
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual = mesa.siguiente();
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		Assert.assertEquals("j1",actual.obtenerNombre());
		//r1
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarPrimera();
		//r2
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera();
		//r3
		actual = mesa.siguiente();
		Assert.assertEquals("j4",actual.obtenerNombre());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.jugarPrimera();
		
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
	}
	
}
