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
import fiuba.algo3.tp2.modeloDeCartas.ReyDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.TresDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.TresDeCopa;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasJugadorIATest {

	public Jugador jugadorHumano;	
	public Jugador jugadorIA;
	public Mesa mesa;
	public List<Carta> cartasHumano;
	public List<Carta> cartasIA;	
	public Equipo equipoUno;
	public Equipo equipoDos;

	@Before
	public void inicializarPruebas(){
		mesa = new Mesa();
	
		equipoUno = new Equipo("equipoUno", mesa);
		equipoDos = new Equipo("equipoDos", mesa);
		
		mesa.instanciarJuez(equipoUno, equipoDos, new EstadoSinFlor());
		
		equipoUno.cargarJugadores("Nicolas");
		equipoDos.cargarJugadorIA("Martin");
		
		mesa.sentarJugadores(equipoUno.obtenerJugadores(),equipoDos.obtenerJugadores());
		mesa.iniciarRonda();
			
		cartasHumano = new ArrayList<Carta>();
		cartasIA = new ArrayList<Carta>();

		cartasHumano = new ArrayList<Carta>(Arrays.asList(new TresDeCopa(), new TresDeBasto(), new ReyDeBasto()));
		cartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new AnchoDeOro(), new CincoDeCopa()));
	}
	
	@Test
	public void pruebasJugadorIAGanaElEnvidoCon28(){

		jugadorHumano = mesa.siguienteJugadorConTurno();
				
		jugadorHumano.recibirCartas(cartasHumano);
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.recibirCartas(cartasIA);
		
		jugadorIA.juga();
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.quiero();
		
		Assert.assertEquals(2, mesa.puntosEquipo(equipoDos));
	}
	
	@Test
	public void pruebaJugadorIAGanaPrimera(){
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.recibirCartas(cartasHumano);
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.recibirCartas(cartasIA);
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.jugarCarta(cartasHumano.get(1));
		
		jugadorIA = mesa.siguienteJugadorConTurno();
			
		jugadorIA.juga();
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.noQuiero();
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.juga();
		
		mesa.siguienteJugadorConTurno();
		
		Assert.assertEquals(equipoDos, mesa.ganadorDeLaRonda());
	}
	
	@Test
	public void pruebaJugadorIALeCantanEnvidoYGana(){
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.recibirCartas(cartasHumano);
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.recibirCartas(cartasIA);
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.cantarEnvido();
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.juga();
		
		Assert.assertEquals(2, mesa.puntosEquipo(equipoDos));
	}
	
	@Test
	public void pruebaJugadorIALeCantanTrucoYGana(){
		
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new AnchoDeBasto(), new AnchoDeEspada()));
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.recibirCartas(cartasHumano);
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.recibirCartas(otrasCartasIA);
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.jugarCarta(cartasHumano.get(1));
		
		jugadorIA = mesa.siguienteJugadorConTurno();
	
		jugadorIA.juga();	
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.juga();
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.cantarTruco();
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.juga();
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.jugarCarta(cartasHumano.get(0));
		
		Assert.assertEquals(equipoDos, mesa.ganadorDeLaRonda());
	
		mesa.siguienteJugadorConTurno();
			
		Assert.assertEquals(2, mesa.puntosEquipo(equipoDos));
	}
	
	@Test
	public void pruebaJugadorIAGanaLaMano(){
		
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new AnchoDeBasto(), new AnchoDeEspada()));
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.recibirCartas(cartasHumano);
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.recibirCartas(otrasCartasIA);
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.jugarCarta(cartasHumano.get(1));
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.juga();
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.juga();
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
	
		jugadorHumano.jugarCarta(cartasHumano.get(0));
		
		Assert.assertEquals(equipoDos, mesa.ganadorDeLaRonda());
	
		mesa.siguienteJugadorConTurno();
			
		Assert.assertEquals(1, mesa.puntosEquipo(equipoDos));
	}
}

