package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloDeCartas.Basto;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.Cinco;
import fiuba.algo3.tp2.modeloDeCartas.Copa;
import fiuba.algo3.tp2.modeloDeCartas.Dos;
import fiuba.algo3.tp2.modeloDeCartas.Espada;
import fiuba.algo3.tp2.modeloDeCartas.Oro;
import fiuba.algo3.tp2.modeloDeCartas.Rey;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.Tres;
import fiuba.algo3.tp2.modeloJugador.EstadoIACantaronEnvido;
import fiuba.algo3.tp2.modeloJugador.EstadoIACantaronRealEnvido;
import fiuba.algo3.tp2.modeloJugador.EstadoIACantaronTruco;
import fiuba.algo3.tp2.modeloJugador.IA;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasJugadorIAConEnvidoTest {

	public Jugador jugadorConTurno;	
	public Mesa mesa;	
	public Equipo equipoUno;
	public Equipo equipoIA;
		
	Carta tresDeCopa = new Tres(new Copa());
	Carta tresDeBasto = new Tres(new Basto());
	Carta reyDeBasto = new Rey(new Basto());
	List<Carta> cartasHumano = new ArrayList<Carta>(Arrays.asList(tresDeCopa,tresDeBasto,reyDeBasto));

	Carta sieteDeOro = new SieteDeOro();
	Carta anchoDeOro = new AnchoFalso(new Oro());
	Carta cincoDeCopa = new Cinco(new Copa());
	List<Carta> cartasIA = new ArrayList<Carta>(Arrays.asList(sieteDeOro,anchoDeOro,cincoDeCopa));


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
	}

	@Test
	public void pruebasJugadorIAGanaElEnvidoCon28(){

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.recibirCartas(cartasIA); //IA
		jugadorConTurno.hacerJugarIA(); //IA

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.recibirCartas(cartasHumano); //HUMANO
		jugadorConTurno.quiero(); //HUMANO

		Assert.assertEquals(2, mesa.puntosEquipo(equipoIA));
	}

	@Test
	public void pruebaJugadorIAGanaPrimera(){

		Carta anchoDeBasto = new AnchoDeBasto();
		Carta anchoDeEspada = new AnchoDeEspada();
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(sieteDeOro, anchoDeBasto, anchoDeEspada));

		//RONDA 1
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(otrasCartasIA);
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(cartasHumano);
		
		jugadorConTurno.jugarCarta(reyDeBasto);

		//RONDA 2
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.jugarCarta(tresDeCopa);

		//FINALIZO LA MANO, IA GANO, EMPEZARIA HUMANO
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());

		Assert.assertEquals(1, mesa.puntosEquipo(equipoIA));
	}

	@Test
	public void pruebaJugadorIALeCantanEnvidoRespondeEnvidoHumanoAceptaYGanaIA(){

		//RONDA 1
		jugadorConTurno = mesa.siguienteJugadorConTurno();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.recibirCartas(cartasHumano);
		jugadorConTurno.cantarEnvido();

		jugadorConTurno = mesa.siguienteJugadorConTurno();
		jugadorConTurno.recibirCartas(cartasIA);
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronEnvido());
		jugadorConTurno.hacerJugarIA();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno();//Humano
		jugadorConTurno.quiero();
		
		Assert.assertEquals(4, mesa.puntosEquipo(equipoIA));
	}

	@Test
	public void pruebaJugadorIALeCantanTrucoYGana(){
		
		Carta anchoDeBasto = new AnchoDeBasto();
		Carta anchoDeEspada = new AnchoDeEspada();
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(sieteDeOro, anchoDeBasto, anchoDeEspada));

		//RONDA 1
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(cartasHumano);
		jugadorConTurno.cantarTruco();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		// la partida de truco con el lanzador de enventos setean los estados 
		// automaticamente
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronTruco());
		jugadorConTurno.recibirCartas(otrasCartasIA);
		jugadorConTurno.hacerJugarIA();
				
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.jugarCarta(tresDeBasto);
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.hacerJugarIA();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.jugarCarta(reyDeBasto);
		
		//FINALIZO LA MANO, IA GANO, EMPEZARIA HUMANO
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());

		Assert.assertEquals(2, mesa.puntosEquipo(equipoIA));
	}

	@Test
	public void pruebaJugadorHumanoCantaEnvidoIARespondeEnvidoYLoGana(){

		jugadorConTurno  = mesa.siguienteJugadorConTurno();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.recibirCartas(cartasHumano);
		jugadorConTurno.cantarEnvido();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.recibirCartas(cartasIA);
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronEnvido());
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno();
		jugadorConTurno.quiero();
		
		Assert.assertEquals(4, mesa.puntosEquipo(equipoIA));
	} 

	
	@Test
	public void pruebaJugadorHumanoCantaEnvidoIARespondeEnvidoHumanoCantaRealEnvidoEIANoAceptaCon28(){

		jugadorConTurno  = mesa.siguienteJugadorConTurno();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.recibirCartas(cartasHumano);
		jugadorConTurno.cantarEnvido();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.recibirCartas(cartasIA);
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronEnvido());
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno();
		jugadorConTurno.cantarRealEnvido();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.recibirCartas(cartasIA);
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronRealEnvido());
		jugadorConTurno.hacerJugarIA();
		
		Assert.assertEquals(5, mesa.puntosEquipo(equipoUno));
	} 
	
	@Test
	public void pruebaGanaHumanoEnLaRondaTresNoSeCantaNada(){
		
		Carta dosDeBasto = new Dos(new Basto());
		Carta dosDeEspada = new Dos(new Espada());
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(dosDeEspada, dosDeBasto, cincoDeCopa));

		Carta sieteDeEspada = new SieteDeEspada();
		List<Carta> otrasCartasHumano =  new ArrayList<Carta>(Arrays.asList(sieteDeEspada , tresDeBasto, reyDeBasto));
		
		//RONDA 1
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(otrasCartasHumano);
		jugadorConTurno.jugarCarta(reyDeBasto);
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		// la partida de truco con el lanzador de enventos setean los estados 
		// automaticamente
		jugadorConTurno.recibirCartas(otrasCartasIA);
		jugadorConTurno.hacerJugarIA();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.jugarCarta(sieteDeEspada);
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.jugarCarta(tresDeBasto);
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		jugadorConTurno.hacerJugarIA();
		
		mesa.siguienteJugadorConTurno();
		
		Assert.assertEquals(1, mesa.puntosEquipo(equipoUno));
	}
	
	@Test
	public void pruebaHumanoCantaTrucoEnRondaTresIANoAcepta(){
		
		Carta reyDeEspada = new Rey(new Espada());
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(reyDeEspada, anchoDeOro, cincoDeCopa));

		Carta sieteDeEspada = new SieteDeEspada();
		List<Carta> otrasCartasHumano =  new ArrayList<Carta>(Arrays.asList(sieteDeEspada , tresDeBasto, reyDeBasto));
		
		//RONDA 1
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(otrasCartasHumano);
		jugadorConTurno.jugarCarta(reyDeBasto);
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		// la partida de truco con el lanzador de enventos setean los estados 
		// automaticamente
		jugadorConTurno.recibirCartas(otrasCartasIA);
		jugadorConTurno.hacerJugarIA();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.hacerJugarIA();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.jugarCarta(sieteDeEspada);
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.cantarTruco();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronTruco());
		jugadorConTurno.hacerJugarIA();
		
		mesa.siguienteJugadorConTurno();
		
		Assert.assertEquals(1, mesa.puntosEquipo(equipoUno));
	}
	
	@Test
	public void pruebaIANoMataEnRondaDosYJuegaLaMasBaja(){
		
		Carta reyDeEspada = new Rey(new Espada());
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(reyDeEspada, anchoDeOro, cincoDeCopa));

		Carta sieteDeEspada = new SieteDeEspada();
		List<Carta> otrasCartasHumano =  new ArrayList<Carta>(Arrays.asList(sieteDeEspada , tresDeBasto, reyDeBasto));
		
		//RONDA 1
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(otrasCartasIA);
		jugadorConTurno.hacerJugarIA();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(otrasCartasHumano);
		jugadorConTurno.jugarCarta(tresDeBasto);
	
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.jugarCarta(sieteDeEspada);
		
		jugadorConTurno = mesa.siguienteJugadorConTurno();
		jugadorConTurno.hacerJugarIA();
		
		mesa.siguienteJugadorConTurno();
		
		Assert.assertEquals(1, mesa.puntosEquipo(equipoUno));
	}
}