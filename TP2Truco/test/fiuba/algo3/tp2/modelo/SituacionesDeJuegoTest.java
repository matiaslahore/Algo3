package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

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
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.returnEquipo());
		actual.recibirCartas(new SieteDeEspada(), new AnchoDeBasto(), new SeisDeEspada());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.returnEquipo());
		actual.recibirCartas(new AnchoDeEspada(), new SieteDeOro(), new CincoDeOro());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("eq2",mesa.ultimoGanador());
		//R2
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.returnEquipo());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.returnEquipo());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		Assert.assertEquals("eq1",mesa.ultimoGanador());
		//R3
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.returnEquipo());
		actual.jugarPrimera();
		actual = mesa.siguiente();
		System.out.println("Turno de: " + actual.obtenerNombre() + ", " + actual.returnEquipo());
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
	
}
