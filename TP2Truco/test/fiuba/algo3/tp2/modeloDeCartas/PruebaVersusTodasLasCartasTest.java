package fiuba.algo3.tp2.modeloDeCartas;

import org.junit.Assert;
import org.junit.Test;

public class PruebaVersusTodasLasCartasTest {
	
	TipoDeCartas carta;
	TipoDeCartas cartaContra;
	
	@Test
	public void elAnchoDeEspadaLeGanaATodos(){
		
		carta = new AnchoDeEspada();
		cartaContra = new AnchoDeBasto();
		
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}
	
	@Test
	public void elAnchoDeCopaEmpataConElAnchoDeOro(){
		
		carta = new AnchoDeCopa();
		cartaContra = new AnchoDeOro();
		
		Assert.assertEquals(cartaContra, carta.vs(cartaContra));
	}
	
	@Test 
	public void sieteDeEspadaLeGanaAlSieteDeOro(){
		
		carta = new SieteDeEspada();
		cartaContra = new DosDeOro();
		
		Assert.assertEquals(carta, carta.vs(cartaContra));
	}

}

