package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeOro;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.ReyDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.TresDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.TresDeCopa;
import fiuba.algo3.tp2.modeloJugador.IA;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class JugadorIATest {

	public Jugador jugadorHumano;	
	public IA jugadorIA;
	public List<Carta> cartasHumano;
	public List<Carta> cartasIA;	

	@Before
	public void inicializarPruebas(){
		Mesa mesa = new Mesa();
		jugadorHumano = new Jugador("Nicolas", mesa, new Equipo("EquipoDos", mesa));
		jugadorIA = new IA("Martin", mesa, new Equipo("EquipoUno", mesa));
		
		cartasHumano = new ArrayList<Carta>();
		cartasIA = new ArrayList<Carta>();
		
		cartasHumano = Arrays.asList(new TresDeCopa(), new TresDeBasto(), new ReyDeBasto());
		cartasIA = Arrays.asList(new SieteDeOro(), new AnchoDeOro(), new CincoDeCopa());
	}
	
	@Test
	public void pruebasJugadorIaLeGanaAlSieteDeOroDeJugadorHumano(){
		
		//se verifica por consola, habria que pensar como probarlo
		jugadorIA.recibirCartas(cartasIA);
		
		jugadorHumano.recibirCartas(cartasHumano);
		
		jugadorHumano.jugarCarta(cartasHumano.get(0));
		
		jugadorIA.juga();
		
	}
}
