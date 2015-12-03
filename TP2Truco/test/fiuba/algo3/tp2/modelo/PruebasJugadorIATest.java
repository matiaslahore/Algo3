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
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.TresDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.TresDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.TresDeOro;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasJugadorIATest {

	public Jugador jugadorHumano;	
	public Jugador jugadorIA;
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
		
		mesa.instanciarJuez(equipoUno, equipoIA, new EstadoSinFlor());
		
		equipoUno.cargarJugadores("Nicolas");
		equipoIA.cargarJugadorIA("Martin");
		
		mesa.sentarJugadores(equipoUno.obtenerJugadores(),equipoIA.obtenerJugadores());
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
		
		Assert.assertEquals(2, mesa.puntosEquipo(equipoIA));
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
		
		Assert.assertEquals(equipoIA, mesa.ganadorDeLaRonda());
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
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.quiero();
		
		Assert.assertEquals(4, mesa.puntosEquipo(equipoIA));
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
		
		Assert.assertEquals(equipoIA, mesa.ganadorDeLaRonda());
	
		mesa.siguienteJugadorConTurno();
			
		Assert.assertEquals(2, mesa.puntosEquipo(equipoIA));
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
		
		Assert.assertEquals(equipoIA, mesa.ganadorDeLaRonda());
	
		mesa.siguienteJugadorConTurno();
			
		Assert.assertEquals(1, mesa.puntosEquipo(equipoIA));
	}
	
	@Test
	public void pruebaJugadorHumanoCantaEnvidoIARespondeEnvido(){
		
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new TresDeOro(), new AnchoDeEspada()));
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.recibirCartas(cartasHumano);
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.recibirCartas(otrasCartasIA);		
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.cantarEnvido();
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		 
		jugadorIA.juga();
		
		jugadorHumano  = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.quiero();
		
		Assert.assertEquals(5, mesa.puntosEquipo(equipoIA));
	}
	
	@Test
	public void pruebaJugadorIACantaLaFaltaCon33(){
		
		List<Carta> otrasCartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new DosDeOro(), new AnchoDeEspada()));
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.recibirCartas(cartasHumano);
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		jugadorIA.recibirCartas(otrasCartasIA);		
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.cantarEnvido();
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		//canta envido envido por que tiene 32 o mas de envido 
		jugadorIA.juga();
		
		jugadorHumano  = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.cantarRealEnvido();
		
		jugadorIA = mesa.siguienteJugadorConTurno();
		
		//canta la falta envido
		jugadorIA.juga();
		
		jugadorHumano = mesa.siguienteJugadorConTurno();
		
		jugadorHumano.quiero();
		
		Assert.assertEquals(30, mesa.puntosEquipo(equipoIA));
	}
}

