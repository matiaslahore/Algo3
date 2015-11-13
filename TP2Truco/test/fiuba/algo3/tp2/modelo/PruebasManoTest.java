package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.*;

public class PruebasManoTest {

	private Mano mano;
	
	@Test
	public void pruebaTantoEnMano(){
		//mano = new Mano(new AnchoDeCopa(), new SieteDeEspada(), new SeisDeEspada());
		//Assert.assertEquals(33,mano.calcularEnvido());
		mano = new Mano(new CuatroDeEspada(), new AnchoDeCopa(), new CuatroDeCopa());
		Assert.assertEquals(25,mano.calcularEnvido());
	}
}
