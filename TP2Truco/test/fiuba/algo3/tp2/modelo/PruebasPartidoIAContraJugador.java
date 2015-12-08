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

public class PruebasPartidoIAContraJugador {

	public Jugador jugadorConTurno;	
	public List<Carta> cartasHumano;
	public List<Carta> cartasIA;	
	PartidaDeTrucoConIASinFlor partida;

	@Before
	public void inicializarPruebas(){
		this.partida = new PartidaDeTrucoConIASinFlor("equipoIA","equipo2");
		this.partida.cargarJugadoresEnEquipoDos(Arrays.asList("Pepito"));
		
		cartasHumano = new ArrayList<Carta>();
		cartasIA = new ArrayList<Carta>();
		cartasHumano = new ArrayList<Carta>(Arrays.asList(new TresDeCopa(), new TresDeBasto(), new ReyDeBasto()));
		cartasIA = new ArrayList<Carta>(Arrays.asList(new SieteDeOro(), new CincoDeEspada(), new AnchoDeCopa()));
	}

	@Test
	public void jugadorIAJuegaSoloCantandoReTrucoYGanandoLaMano(){
		this.partida.iniciar();
		this.partida.quiero();
		
	}

	
	
	
	
	
	
	
}

