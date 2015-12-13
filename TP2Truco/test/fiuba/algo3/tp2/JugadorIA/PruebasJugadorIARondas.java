package fiuba.algo3.tp2.JugadorIA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mesa;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloDeCartas.Basto;
import fiuba.algo3.tp2.modeloDeCartas.Caballo;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.Cinco;
import fiuba.algo3.tp2.modeloDeCartas.Copa;
import fiuba.algo3.tp2.modeloDeCartas.Dos;
import fiuba.algo3.tp2.modeloDeCartas.Espada;
import fiuba.algo3.tp2.modeloDeCartas.Oro;
import fiuba.algo3.tp2.modeloDeCartas.Rey;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.Sota;
import fiuba.algo3.tp2.modeloDeCartas.Tres;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasJugadorIARondas {
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
	public void pruebaHumanoTiraEl7DeOroIAel10DeBastoHumanoAtoraConEl2DeOroYGana(){
		
		Carta sieteDeOro = new SieteDeOro();
		Carta dosDeOro = new Dos(new Oro());
		List<Carta> otrasCartasHumano = new ArrayList<Carta>(Arrays.asList(sieteDeOro,dosDeOro,reyDeBasto));

		Carta diezDeBasto = new Sota(new Basto());
		Carta anchoDeOro = new AnchoFalso(new Oro());
		Carta caballoDeCopa = new Caballo(new Copa());
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(diezDeBasto,anchoDeOro,caballoDeCopa));
		
		//RONDA 1		
		mesa.siguienteJugadorConTurno();
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		Assert.assertEquals("Pepito", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(otrasCartasHumano);
		jugadorConTurno.jugarCarta(sieteDeOro);
	
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
		jugadorConTurno.recibirCartas(otrasCartasIA);
		jugadorConTurno.hacerJugarIA();
		
		jugadorConTurno = mesa.siguienteJugadorConTurno();//Humano
		jugadorConTurno.jugarCarta(dosDeOro);
		
		jugadorConTurno = mesa.siguienteJugadorConTurno();//IA
		Assert.assertEquals("Jarvis", jugadorConTurno.obtenerNombre());
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
