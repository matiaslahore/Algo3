package fiuba.algo3.tp2.modeloDeCartas;

import org.junit.Assert;
import org.junit.Test;

public class PruebaVersusTodasLasCartasTest {
	
	TipoDeCartas carta;
	TipoDeCartas cartaContra;
	
	@Test
	public void elAnchoDeEspadaLeGanaATodos(){
		
		carta = new AnchoDeEspada(null);
		cartaContra = new AnchoDeBasto(null);
		
		Assert.assertEquals(carta,carta.vs(cartaContra));
			/*
			new AnchoDeBasto(null)
			new SieteDeEspada(null)
			new SieteDeOro(null)
			new Tres(null)
			new Dos(null)
			new AnchoFalso(null)
			new Rey(null)
			new Caballo(null)
			new Sota(null)
			new Seis(null)
			new SieteFalso(null)
			new Cinco(null)
			new Cuatro(null)
			*/
	}
}
