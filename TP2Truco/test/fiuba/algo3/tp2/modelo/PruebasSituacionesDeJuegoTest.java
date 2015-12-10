package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasSituacionesDeJuegoTest {

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
	public void pruebaSimulacionDePartidaDeTrucoSimpleUnoPorUno(){
		
		eq1.cargarJugadores(Arrays.asList("j1"));
		eq2.cargarJugadores(Arrays.asList("j2"));

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
		eq1.cargarJugadores(Arrays.asList("j1","j3"));
		eq2.cargarJugadores(Arrays.asList("j2","j4"));

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
		eq1.cargarJugadores(Arrays.asList("j1","j3","j5"));
		eq2.cargarJugadores(Arrays.asList("j2","j4","j6"));

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
	public void pruebaSimulacionDePartidaPicaPica(){
		eq1.cargarJugadores(Arrays.asList("j1","j3","j5"));
		eq2.cargarJugadores(Arrays.asList("j2","j4","j6"));

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
		eq1.cargarJugadores(Arrays.asList("j1"));
		eq2.cargarJugadores(Arrays.asList("j2"));
		
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
		eq1.cargarJugadores(Arrays.asList("j1"));
		eq2.cargarJugadores(Arrays.asList("j2"));

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
		actual.jugarCarta(cuatroDeCopa);
		
		actual = mesa.siguienteJugadorConTurno();
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
		
		Assert.assertEquals(1,mesa.puntosEquipo(eq1));
		Assert.assertEquals(0,mesa.puntosEquipo(eq2));
	}
	
	@Test
	public void pruebaIrseAlMazoPartidaDosxDos(){
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
		actual.irseAlMazo();
		
		Assert.assertEquals(eq1,mesa.ganadorDeLaRonda());
		
		Assert.assertEquals(1,mesa.puntosEquipo(eq1));
		Assert.assertEquals(0,mesa.puntosEquipo(eq2));
	}
	
}
