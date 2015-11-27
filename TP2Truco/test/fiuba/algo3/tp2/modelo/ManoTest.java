package fiuba.algo3.tp2.modelo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CartaInexistenteEnManoDeJugador;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class ManoTest {

	@Test
	public void pruebaObtenerCarta(){
		
		TipoDeCartas sieteDeCopa = new SieteDeCopa();
		TipoDeCartas sieteDeBasto = new SieteDeBasto();
		TipoDeCartas cuatroDeBasto = new CuatroDeBasto();
		
		Mano mano = new Mano(Arrays.asList(sieteDeCopa, sieteDeBasto, cuatroDeBasto));
		
		Assert.assertEquals(sieteDeBasto, mano.obtenerCarta(sieteDeBasto));
		Assert.assertEquals(sieteDeCopa, mano.obtenerCarta(sieteDeCopa));
		Assert.assertEquals(cuatroDeBasto, mano.obtenerCarta(cuatroDeBasto));
	}
	
	@Test
	(expected = CartaInexistenteEnManoDeJugador.class)
	public void pruebaConCartaInexistenteEnMano(){
		
		TipoDeCartas sieteDeCopa = new SieteDeCopa();
		TipoDeCartas sieteDeBasto = new SieteDeBasto();
		TipoDeCartas cuatroDeBasto = new CuatroDeBasto();
		
		Mano mano = new Mano(Arrays.asList(sieteDeCopa, sieteDeBasto, cuatroDeBasto));
		
		mano.obtenerCarta(new SieteDeOro());
	}
}
