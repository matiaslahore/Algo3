package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeOro;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.DosDeOro;
import fiuba.algo3.tp2.modeloDeCartas.ReyDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SeisDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.TresDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.TresDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.TresDeOro;
import fiuba.algo3.tp2.modeloJugador.EstadoIACantaronEnvido;
import fiuba.algo3.tp2.modeloJugador.EstadoIACantaronTruco;
import fiuba.algo3.tp2.modeloJugador.IA;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasJugadorIAConEnvidoTest {

	public Jugador jugadorConTurno;	
	public Mesa mesa;
	public List<Carta> cartasHumano;
	public List<Carta> cartasIA;	
	public Equipo equipoUno;
	public Equipo equipoIA;

	@Before
	public void inicializarPruebas(){
		mesa = new Mesa();

		equipoUno = new Equipo("equipoUno", mesa);
		equipoIA = new Equipo("equipoDos", mesa);

		mesa.instanciarJuez(equipoUno, equipoIA);

		equipoIA.cargarJugadorIA();
		equipoUno.cargarJugadores(Arrays.asList("Pepito"));

		mesa.sentarJugadores(equipoIA.obtenerJugadores(), equipoUno.obtenerJugadores());
		mesa.iniciarRonda();

		cartasHumano = new ArrayList<Carta>();
		cartasIA = new ArrayList<Carta>();

		cartasHumano = new ArrayList<Carta>(Arrays.asList(new TresDeCopa(), new TresDeBasto(), new ReyDeBasto()));
		cartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new AnchoDeOro(), new CincoDeCopa()));
	}

	@Test
	public void pruebasJugadorIAGanaElEnvidoCon28(){

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.recibirCartas(cartasIA); //IA
		jugadorConTurno.hacerJugarIA(); //IA

		System.out.println(mesa.ronda);

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.recibirCartas(cartasHumano); //HUMANO
		jugadorConTurno.quiero(); //HUMANO

		Assert.assertEquals(2, mesa.puntosEquipo(equipoIA));
	}

	@Test
	public void pruebaJugadorIAGanaPrimera(){

		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new AnchoDeBasto(), new AnchoDeEspada()));

		//RONDA 1
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(otrasCartasIA);
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(cartasHumano);
		jugadorConTurno.jugarCarta(cartasHumano.get(2));

		//RONDA 2
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.jugarCarta(cartasHumano.get(0));

		//FINALIZO LA MANO, IA GANO, EMPEZARIA HUMANO
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());

		Assert.assertEquals(1, mesa.puntosEquipo(equipoIA));
	}

	@Test
	public void pruebaJugadorIALeCantanEnvidoYGana(){

		//RONDA 1
		jugadorConTurno = mesa.siguienteJugadorConTurno();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.recibirCartas(cartasHumano);
		jugadorConTurno.cantarEnvido();

		jugadorConTurno = mesa.siguienteJugadorConTurno();
		jugadorConTurno.recibirCartas(cartasIA);
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronEnvido());
		jugadorConTurno.hacerJugarIA();

		Assert.assertEquals(2, mesa.puntosEquipo(equipoIA));
	}

	@Test
	public void pruebaJugadorIALeCantanTrucoYGana(){
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new AnchoDeBasto(), new AnchoDeEspada()));

		//RONDA 1
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(cartasHumano);
		jugadorConTurno.jugarCarta(cartasHumano.get(1));

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(otrasCartasIA);
		jugadorConTurno.hacerJugarIA();

		//RONDA 2
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.cantarTruco();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronTruco());
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.jugarCarta(cartasHumano.get(0));

		//FINALIZO LA MANO, IA GANO, EMPEZARIA HUMANO
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());

		Assert.assertEquals(2, mesa.puntosEquipo(equipoIA));
	}

	@Test
	public void pruebaJugadorHumanoCantaEnvidoIARespondeEnvido(){

		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new TresDeOro(), new AnchoDeEspada()));

		jugadorConTurno  = mesa.siguienteJugadorConTurno();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.recibirCartas(cartasHumano);
		jugadorConTurno.cantarEnvido();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.recibirCartas(otrasCartasIA);
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronEnvido());
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno();
		jugadorConTurno.quiero();

		Assert.assertEquals(4, mesa.puntosEquipo(equipoIA));
	} 

}

