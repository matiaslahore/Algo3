package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mesa;
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
import fiuba.algo3.tp2.modeloDeCartas.Seis;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SieteFalso;
import fiuba.algo3.tp2.modeloDeCartas.Sota;
import fiuba.algo3.tp2.modeloDeCartas.Tres;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasCantoTrucoTest {
	
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
	
	@Test
	public void pruebaSimulacionDePartidaJ3QuiereTrucoCantadoPorJ2(){
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

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
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

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
	
	@Test(expected = RuntimeException.class)
	public void testFallaCantoTrucoyQuieroReTrucoElMismoJugador() {
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

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
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

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
	public void pruebaSimulacionDePartidaJ1QuiereValeCuatroCantadoPorJ4(){
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

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
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

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
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

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
		actual.cantarQuieroValeCuatro();

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
		eq1.cargarJugadores(Arrays.asList("j1","j3","j5"));
		eq2.cargarJugadores(Arrays.asList("j2","j4","j6"));

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
	
	@Test(expected = CantoInvalidoException.class)
	public void pruebaFallaCantaTrucoMuchasVeces(){
		eq1.cargarJugadores(Arrays.asList("j1"));
		eq2.cargarJugadores(Arrays.asList("j2"));

		mesa.sentarJugadores(eq1.obtenerJugadores(),eq2.obtenerJugadores());
		mesa.iniciarRonda();

		Jugador actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeCopa, tresDeOro, cuatroDeOro)));
		actual = mesa.siguienteJugadorConTurno();
		actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(dosDeOro, tresDeCopa, cuatroDeCopa)));
		
		//R1
		actual = mesa.siguienteJugadorConTurno();
		actual.cantarTruco();

		actual = mesa.siguienteJugadorConTurno();
		actual.quiero();
		
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(dosDeCopa);

		actual = mesa.siguienteJugadorConTurno();
		actual.cantarTruco();
	}

}
