package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.ReyDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.TresDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.TresDeCopa;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import junit.framework.Assert;

public class PruebasPartidoIAContraJugador {

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
		equipoIA = new Equipo("equipoIA", mesa);
		mesa.instanciarJuez(equipoUno, equipoIA);

		equipoIA.cargarJugadorIA();
		equipoUno.cargarJugadores(Arrays.asList("Pepito"));

		mesa.sentarJugadores(equipoIA.obtenerJugadores(), equipoUno.obtenerJugadores());
		mesa.iniciarRonda();

		cartasHumano = new ArrayList<Carta>();
		cartasIA = new ArrayList<Carta>();

		cartasHumano = new ArrayList<Carta>(Arrays.asList(new TresDeCopa(), new TresDeBasto(), new ReyDeBasto()));
		cartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new CincoDeEspada(), new AnchoDeCopa()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void jugadorIAJuegaSoloCantandoReTrucoYGanandoLaMano(){
		//1
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.recibirCartas(cartasIA); //IA
		jugadorConTurno.hacerJugarIA(); //IA

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.recibirCartas(cartasHumano); //HUMANO
		jugadorConTurno.quiero(); //HUMANO
		jugadorConTurno.jugarCarta(cartasHumano.get(2));
		
		//System.out.println(mesa.ronda);		
		
		//2
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.hacerJugarIA(); //IA

		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.quiero(); //HUMANO
		jugadorConTurno.jugarCarta(cartasHumano.get(1));
		
		//3
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //HUMANO
		jugadorConTurno.jugarCarta(cartasHumano.get(0));
		
		jugadorConTurno = mesa.siguienteJugadorConTurno(); //IA
		jugadorConTurno.hacerJugarIA(); //IA
		
		Equipo ganador = this.mesa.ganadorDeLaRonda();
		System.out.println(ganador.obtenerNombre());	
		Assert.assertTrue(ganador.obtenerNombre() == this.equipoIA.obtenerNombre());
	}

	
	
	
	
	
	
	
}

