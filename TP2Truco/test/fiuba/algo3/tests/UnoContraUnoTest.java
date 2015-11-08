package fiuba.algo3.tests;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.PartidaDeTruco;

public class UnoContraUnoTest {

	
	@Test
	public void pruebaCreoUnUnoContraUno(){
		
		PartidaDeTruco unPartidoDeTruco = new PartidaDeTruco();
		
		unPartidoDeTruco.cargarJugadoresEnEq(2, "nicolas", "", "");		
		unPartidoDeTruco.cargarJugadoresEnEq(2, "martin", "", "");
		
		unPartidoDeTruco.repartirCartas();
		
		System.out.println(unPartidoDeTruco.verCartasEnManoDeJugadorComoString("nicolas"));
	}
}
