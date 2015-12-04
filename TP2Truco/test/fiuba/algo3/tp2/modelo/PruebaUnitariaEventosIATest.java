package fiuba.algo3.tp2.modelo;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloJugador.IA;

public class PruebaUnitariaEventosIATest {
	IA IA;
	
	@Before
	public void inicializar(){
		Mesa mesa = new Mesa();
		this.IA = new IA("soy inteligente", mesa, new Equipo("equipo inteligente",mesa));
	}
	
	@Test
	public void alguienCantaTrucoYJugadorIAImprimePorPantallaTruco(){
	}
	
}
