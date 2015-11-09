package fiuba.algo3.tp2.test;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.AlgoTruco;

public class EnvidoTest {
	Envido envido;
	
	@Test
	public void equipo1CantaEnvidoYEquipo2NoQuiereEntoncesEquipo1GanaUnPunto(){
		this.envido.cantarEnvido("Nico");
		this.envido.noQuerer("Matias");
		Assert.assertEquals("Nico",System.out.println(this.envido.obtenerGanadorEnvido()));
		Assert.assertEquals(1,this.envido.obtenerPuntosGanados()));
	}
	
}
