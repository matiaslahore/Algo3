package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
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

public class PruebasCantoEnvidoTest {
	
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
	public void pruebaSimulacionDePartidaJ3QuiereEnvidoCantadoPorJ2(){
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
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

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
	
	@Test
	public void pruebaJ3CantaEnvidoEnvidoJ4Acepta(){
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

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
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

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
	
	@Test(expected = CantoInvalidoException.class)
	public void pruebaFallaCantaEnvidoSegundaMano(){
		eq1.cargarJugadores(Arrays.asList("j1"));
		eq2.cargarJugadores(Arrays.asList("j2"));

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
		eq1.cargarJugadores(Arrays.asList("j1"));
		eq2.cargarJugadores(Arrays.asList("j2"));

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
		actual.cantarEnvido();

		actual = mesa.siguienteJugadorConTurno();
		actual.quiero();
		
		actual = mesa.siguienteJugadorConTurno();
		actual.jugarCarta(dosDeCopa);

		actual = mesa.siguienteJugadorConTurno();
		actual.cantarEnvido();
	}

}
