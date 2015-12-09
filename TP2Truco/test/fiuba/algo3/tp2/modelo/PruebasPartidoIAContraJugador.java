package fiuba.algo3.tp2.modelo;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.Carta;

import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasPartidoIAContraJugador {

	public Jugador jugadorConTurno;	
	public List<Carta> cartasHumano;
	public List<Carta> cartasIA;	
	PartidaDeTrucoConIASinFlor partida;

	@Before
	public void inicializarPruebas(){
		this.partida = new PartidaDeTrucoConIASinFlor("equipoIA","equipo2");
		this.partida.cargarJugadoresEnEquipoDos(Arrays.asList("Pepito"));
		/*
		cartasHumano = new ArrayList<Carta>();
		cartasIA = new ArrayList<Carta>();
		cartasHumano = new ArrayList<Carta>(Arrays.asList(new TresDeCopa(), new TresDeBasto(), new ReyDeBasto()));
		cartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new CincoDeEspada(), new AnchoDeCopa()));
		*/
	}

	@Test
	public void jugadorIAJuegaSolaConCartasAleatoriasParaAmbos(){
			this.partida.iniciar();
			try{
				this.partida.quiero();
			}
			catch(RuntimeException e){}
			this.partida.jugarCarta(this.partida.obtenerCartasDelJugadorConTurno().get(2));
			try{
				this.partida.cantarQuieroReTruco();
			}
			catch(RuntimeException e){}
			this.partida.jugarCarta(this.partida.obtenerCartasDelJugadorConTurno().get(1));
			this.partida.jugarCarta(this.partida.obtenerCartasDelJugadorConTurno().get(0));
		
		//El atrapar la excecpion es porque jugador no sabe cuando va a cantar truco o re truco la IA
		//Es casi imposible de comprobar el comportamiento al no poder comporbar las cartas que le llegan
	}

	
	
	
	
}

