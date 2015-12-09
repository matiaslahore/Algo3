package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloDeCartas.Basto;
import fiuba.algo3.tp2.modeloDeCartas.Caballo;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.Cinco;
import fiuba.algo3.tp2.modeloDeCartas.Copa;
import fiuba.algo3.tp2.modeloDeCartas.Dos;
import fiuba.algo3.tp2.modeloDeCartas.Oro;
import fiuba.algo3.tp2.modeloDeCartas.Rey;
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
}
