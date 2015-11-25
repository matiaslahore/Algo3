package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class SituacionesDeJuegoTest {

	@Test
	public void pruebaSimulacionDePartidaDeTrucoSimpleUnoPorUno(){
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
		eq1.cargarJugadores("j1");
		eq2.cargarJugadores("j2");
		
		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();
		//R1
		Jugador actual = mesa.siguiente();
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerNombreEquipo());
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeEspada());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerNombreEquipo());
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("eq2",mesa.ultimoGanador());
		//R2
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerNombreEquipo());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerNombreEquipo());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("eq1",mesa.ultimoGanador());
		//R3
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerNombreEquipo());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.obtenerNombreEquipo());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("eq1",mesa.ultimoGanador());
	}
	
	@Test
	public void pruebaSimulacionDePartidaDeTrucoSimpleDosPorDos(){
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Assert.assertEquals("eq2",mesa.ultimoGanador());
		//R2
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("eq1",mesa.ultimoGanador());
		//R3
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("eq2",mesa.ultimoGanador());
	}
	
	@Test
	public void pruebaSimulacionDePartidaDeTrucoSimpleTresPorTres(){
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Assert.assertEquals("eq2",mesa.ultimoGanador());
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
		Assert.assertEquals("eq1",mesa.ultimoGanador());
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
		Assert.assertEquals("eq2",mesa.ultimoGanador());
	}
	
	@Test
	public void pruebaSimulacionDePartidaJ3QuiereTrucoCantadoPorJ2(){
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Assert.assertEquals(1,mesa.puntosEquipo("eq2"));
	}
	
	@Test
	public void pruebaSimulacionDePartidaJ3QuiereEnvidoCantadoPorJ2(){
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Assert.assertEquals(2,mesa.puntosEquipo("eq2"));
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre()); //devuelve el turno al j2
	}
	
	@Test
	public void pruebaSimulacionDePartidaJ3NOQuiereEnvidoCantadoPorJ2(){
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Assert.assertEquals(1,mesa.puntosEquipo("eq2"));
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre()); //devuelve el turno al j2
	}
	
	@Test(expected = RuntimeException.class)
	public void testFallaCantoTrucoyQuieroReTrucoElMismoJugador() {
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Assert.assertEquals(4,mesa.puntosEquipo("eq2")); //gana eq2 xq tiene 33 J4
		
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre()); //devuelve el turno al j2
		//turno al J2 xq el canto envido, j3 envido envido, j4 quiso, le toca tirar a J2
	}
	
	@Test
	public void pruebaJ3CantaEnvidoEnvidoJ4NoAcepta(){
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Assert.assertEquals(2,mesa.puntosEquipo("eq1")); //gana eq1, eq2 no quiere
		
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre()); //devuelve el turno al j2
	}
	
	@Test
	public void pruebaJ4CantaEnvidoEnvidoRealEnvidoJ1Acepta(){
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		try {
			actual.cantarEnvido(); //Canta Envido
		} catch (CantoInvalidoException e) {}
		actual = mesa.siguiente();
		
		Assert.assertEquals("j3",actual.obtenerNombre());
		try {
			actual.cantarEnvido();
		} catch (CantoInvalidoException e) {} //aca canto Envido Envido el J3
		actual = mesa.siguiente();
		
		Assert.assertEquals("j4",actual.obtenerNombre());
		try {
			actual.cantarRealEnvido();
		} catch (CantoInvalidoException e) {} //j4 canto envido envido realenvido
		actual = mesa.siguiente();
		
		Assert.assertEquals("j1",actual.obtenerNombre());
		actual.quiero(); //j1 quiere envido envido realenvido
		
		Assert.assertEquals(7,mesa.puntosEquipo("eq2")); //gana eq2
		
		actual = mesa.siguiente();
		Assert.assertEquals("j2",actual.obtenerNombre()); //devuelve el turno al j2
	}
	
	@Test
	public void pruebaSimulacionDePartidaJ1QuiereValeCuatroCantadoPorJ4(){
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Assert.assertEquals(4,mesa.puntosEquipo("eq1")); //gana eq1 vale 4
		
	}
	
	@Test
	public void pruebaEq1GanaValeCuatroSeCantaPorRondas(){
		Mesa mesa = new Mesa("eq1", "eq2");
		Equipo eq1 = new Equipo("eq1", mesa);
		Equipo eq2 = new Equipo("eq2", mesa);
		
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
		Assert.assertEquals(4,mesa.puntosEquipo("eq1")); //gana eq1 vale 4
		
	}
	
}
