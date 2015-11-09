package fiuba.algo3.tp2.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.tp2.modelo.Carta;
import fiuba.algo3.tp2.modelo.Maso;

public class MasoTests {

	@Test
	public void prueboQueMasoNoRepitaCartas(){
		
		Maso unMaso = new Maso();
		
		List<Carta> listaDeCartas = new ArrayList<Carta>();
		Carta unaCarta ;
		
		for (int i=0; i<40; i=i+1){
			
			unaCarta = unMaso.dameCarta();
			if (listaDeCartas.contains(unaCarta)){
				
				break;
			}
			listaDeCartas.add(unaCarta);
		}
		Assert.assertEquals(40, listaDeCartas.size());
	}
}
