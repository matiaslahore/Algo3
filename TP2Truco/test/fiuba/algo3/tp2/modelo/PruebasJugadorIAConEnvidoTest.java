package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import fiuba.algo3.tp2.modeloDeCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloDeCartas.Basto;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.Cinco;
import fiuba.algo3.tp2.modeloDeCartas.Copa;
import fiuba.algo3.tp2.modeloDeCartas.Espada;
import fiuba.algo3.tp2.modeloDeCartas.Oro;
import fiuba.algo3.tp2.modeloDeCartas.Rey;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.Tres;
import fiuba.algo3.tp2.modeloJugador.EstadoIACantaronEnvido;
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
	public void pruebaJugadorIALeCantanEnvidoAceptaYGanaIA(){

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
	public void pruebaJugadorHumanoCantaEnvidoIANoAceptaCon24(){

		Carta tresDeOro = new Tres(new Oro());
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(tresDeOro, anchoDeOro, cincoDeCopa));
		
		jugadorConTurno  = mesa.siguienteJugadorConTurno();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.recibirCartas(cartasHumano);
		jugadorConTurno.cantarEnvido();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.recibirCartas(otrasCartasIA);
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronEnvido());
		jugadorConTurno.hacerJugarIA();
		
		Assert.assertEquals(2, mesa.puntosEquipo(equipoIA));
	} 

	
	@Test
	public void pruebaJugadorHumanoCantaEnvidoIAAceptaCon28(){

		jugadorConTurno  = mesa.siguienteJugadorConTurno();

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.recibirCartas(cartasHumano);
		jugadorConTurno.cantarEnvido();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.recibirCartas(cartasIA);
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronEnvido());
		jugadorConTurno.hacerJugarIA();
		
		mesa.siguienteJugadorConTurno();
		
		Assert.assertEquals(2, mesa.puntosEquipo(equipoIA));
	} 	
	
	@Test
	public void pruebaHumanoCantaEnvidoIAAceptaYPierdeCon26(){
		
		Carta anchoDeCopa = new AnchoFalso(new Copa());
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(anchoDeCopa , anchoDeOro, cincoDeCopa));

		Carta sieteDeEspada = new SieteDeEspada();
		Carta cincoDeEspada = new Cinco(new Espada());
		List<Carta> otrasCartasHumano =  new ArrayList<Carta>(Arrays.asList(sieteDeEspada , cincoDeEspada, reyDeBasto));
		
		//RONDA 1
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(otrasCartasIA);
		jugadorConTurno.hacerJugarIA();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(otrasCartasHumano);
		jugadorConTurno.cantarEnvido();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno();
		((IA) jugadorConTurno).setearEstado(new EstadoIACantaronEnvido());
		jugadorConTurno.hacerJugarIA();
		
		mesa.siguienteJugadorConTurno();
		
		Assert.assertEquals(2, mesa.puntosEquipo(equipoUno));
	}	
}