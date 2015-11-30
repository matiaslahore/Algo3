package fiuba.algo3.tp2.modelo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.*;

public class PruebasManoTest {

	private Mano mano;
	
	@Test
	public void pruebaTantoEnMano(){
		mano = new Mano(Arrays.asList(new TresDeCopa(), new SieteDeEspada(), new CuatroDeCopa()));
		Assert.assertEquals(27,mano.calcularEnvido());
	}
}
